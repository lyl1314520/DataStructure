package Graph;

import java.util.Scanner;

/**
 * 深度优先搜索的原理:从某个顶v0出发，访问所有与v0相同的顶点，假设v0有两个邻接点v1和v2，v1无邻接点。则搜索重新返回v0，对v2搜索其他顶点
 * Title:深度优先搜索
 * Description:深度优先搜索的原理:从某个顶v0出发，访问所有与v0相同的顶点，假设v0有两个邻接点v1和v2，v1无邻接点。则搜索重新返回v0，
 * 对v2搜索其他顶点 
 * @author lyl
 * @date 2018年9月22日
 */
public class DepthFirstSearch<Item> {

    private final int Max_Size = 1000;

    private Item[] V;// 存储顶点

    private Item[][] E;// 存储边

    private boolean[] isVisited;// 标记某个顶点是否已经被访问过

    private int Vcount, Ecount;

    private int[][] adj;// 无向图的连接矩阵

    public DepthFirstSearch(Item[] V, Item[][] E) {

        this.V = V;
        this.E = E;
        this.Vcount = V.length;
        this.Ecount = E.length;
    }

    // 根据下标获取顶点
    Item getItem(int w) {

        return V[w];
    }

    int getV() {

        return Vcount;
    }

    int getE() {

        return Ecount;
    }

    // 初始化邻接矩阵adj;
    void init() {

        adj = new int[Vcount][Vcount];

        for (int i = 0; i < adj.length; i++)
            for (int j = 0; j < adj[i].length; j++)
                if (i == j)
                    adj[i][j] = 0;
                else
                    adj[i][j] = Max_Size;

        isVisited = new boolean[Vcount];
    }

    // 获得顶点的下标
    int getPosition(Item item) {

        for (int i = 0; i < V.length; i++)
            if (V[i].equals(item))
                return i;

        return -1;
    }

    // 获取某个顶点的第一个邻接点的下标
    int getFirstNeighbor(Item item) {

        int index = this.getPosition(item);

        for (int i = 0; i < adj[index].length; i++)
             if (adj[index][i] == 1)
                 return i;

        return -1;
    }

    // 获取某个顶点的第二个邻接点的下标
    int getNextNeighbor(Item item, int v) {

        int w = this.getPosition(item);

        for (int i = v + 1; i < adj[w].length; i++)
             if (adj[w][i] == 1)
                 return i;

        return -1;

    }

    // 完善邻接矩阵
    void setADJ() {

        int index1, index2;

        int j = 0;

        for (int i = 0; i < E.length; i++) {

            index1 = this.getPosition(E[i][j++]);
            index2 = this.getPosition(E[i][j]);
            adj[index1][index2] = 1;
            adj[index2][index1] = 1;
            j = 0;
        }

    }

    // 从item顶点进行深度优先搜索
    void dfs(Item item) {

        int index1 = this.getPosition(item);
        isVisited[index1] = true;

        int w = this.getFirstNeighbor(item);

        // int count =0;
        while (w != -1) {

            if (!isVisited[w]) {
                // count++;
                // System.out.println("count="+count);
                System.out.println("访问到了" + this.getItem(w) + "顶点");
                dfs(this.getItem(w));

            }
            // V[w]已经被访问过，从相对于第一个w的邻接点开始访问。相当于从item的第二个邻接点开始搜索
            // System.out.println("count="+count);
            w = this.getNextNeighbor(item, w);
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] V = { "A", "B", "C", "D", "E", "F" };
        String[][] E = { { "A", "B" }, { "A", "D" }, { "A", "F" }, { "B", "C" }, { "D", "E" }, { "E", "F" } };

        DepthFirstSearch graph = new DepthFirstSearch<>(V, E);

        graph.init();
        graph.setADJ();

        System.out.println("请输入要搜索的起点");
        String start = in.next();

        System.out.println("深度优先搜索结果如下");

        graph.dfs(new String(start));

    }
}
package Graph;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Title:广度优先搜索，邻接表实现
 * Description:从起始点开始，找出一条能遍历图中所有顶点的最短路径。若不为加权图，则这条最短路径所遍历到的顶点数最少
 * @author lyl
 * @date 2018年9月24日
 */
public class BreadthFirstSearch<Item> {

    private final int Max_Size = 1000;

    private Item[] V;// 存储顶点

    private Item[][] E;// 存储边

    private boolean[] isVisited;// 标记某个顶点是否已经被访问过

    private int Vcount, Ecount;// 顶点数和边数

    private int[][] adj;// 无向图的连接矩阵

    public BreadthFirstSearch(Item[] V, Item[][] E) {

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

    // 实现广度优先搜素
    public void broadFirstSearch() {

        isVisited = new boolean[V.length];
        for (int i = 0; i < Vcount; i++)
            if (!isVisited[i])
                broadFirstSearch(i);

    }

    private void broadFirstSearch(int i) {

        Item u;
        int w;
        LinkedList<Item> queue = new LinkedList<Item>();

        Item item1 = this.getItem(i);

        System.out.println("访问到了" + item1 + "顶点");
        isVisited[i] = true;
        queue.add(item1);// 第一次把v0加到队列

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            System.out.println("u="+u);
            if(queue.isEmpty())
                System.out.println("队列已空");
            w = this.getFirstNeighbor(item1);
            System.out.println("w1="+w);
            while (w != -1) {

                if (!isVisited[w]) {
                    Item item2 = this.getItem(w);
                    System.out.println("访问到了" + item2 + "顶点");
                    isVisited[w] = true;
                    queue.add(item2);
                }

                w = getNextNeighbor(u, w);
                System.out.println("w2="+w);

            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] V = { "A", "B", "C", "D", "E", "F" };
        String[][] E = { { "A", "B" }, { "A", "D" }, { "A", "F" },
                       { "B", "C" }, { "D", "E" }, { "E", "F" } };

        BreadthFirstSearch graph = new BreadthFirstSearch(V, E);

        graph.init();
        graph.setADJ();

        System.out.println("广度优先搜素如下");
        graph.broadFirstSearch();
        
    }
}

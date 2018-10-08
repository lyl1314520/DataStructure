package Graph;

import java.util.Scanner;

/**
 * �������������ԭ��:��ĳ����v0����������������v0��ͬ�Ķ��㣬����v0�������ڽӵ�v1��v2��v1���ڽӵ㡣���������·���v0����v2������������
 * Title:�����������
 * Description:�������������ԭ��:��ĳ����v0����������������v0��ͬ�Ķ��㣬����v0�������ڽӵ�v1��v2��v1���ڽӵ㡣���������·���v0��
 * ��v2������������ 
 * @author lyl
 * @date 2018��9��22��
 */
public class DepthFirstSearch<Item> {

    private final int Max_Size = 1000;

    private Item[] V;// �洢����

    private Item[][] E;// �洢��

    private boolean[] isVisited;// ���ĳ�������Ƿ��Ѿ������ʹ�

    private int Vcount, Ecount;

    private int[][] adj;// ����ͼ�����Ӿ���

    public DepthFirstSearch(Item[] V, Item[][] E) {

        this.V = V;
        this.E = E;
        this.Vcount = V.length;
        this.Ecount = E.length;
    }

    // �����±��ȡ����
    Item getItem(int w) {

        return V[w];
    }

    int getV() {

        return Vcount;
    }

    int getE() {

        return Ecount;
    }

    // ��ʼ���ڽӾ���adj;
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

    // ��ö�����±�
    int getPosition(Item item) {

        for (int i = 0; i < V.length; i++)
            if (V[i].equals(item))
                return i;

        return -1;
    }

    // ��ȡĳ������ĵ�һ���ڽӵ���±�
    int getFirstNeighbor(Item item) {

        int index = this.getPosition(item);

        for (int i = 0; i < adj[index].length; i++)
             if (adj[index][i] == 1)
                 return i;

        return -1;
    }

    // ��ȡĳ������ĵڶ����ڽӵ���±�
    int getNextNeighbor(Item item, int v) {

        int w = this.getPosition(item);

        for (int i = v + 1; i < adj[w].length; i++)
             if (adj[w][i] == 1)
                 return i;

        return -1;

    }

    // �����ڽӾ���
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

    // ��item������������������
    void dfs(Item item) {

        int index1 = this.getPosition(item);
        isVisited[index1] = true;

        int w = this.getFirstNeighbor(item);

        // int count =0;
        while (w != -1) {

            if (!isVisited[w]) {
                // count++;
                // System.out.println("count="+count);
                System.out.println("���ʵ���" + this.getItem(w) + "����");
                dfs(this.getItem(w));

            }
            // V[w]�Ѿ������ʹ���������ڵ�һ��w���ڽӵ㿪ʼ���ʡ��൱�ڴ�item�ĵڶ����ڽӵ㿪ʼ����
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

        System.out.println("������Ҫ���������");
        String start = in.next();

        System.out.println("������������������");

        graph.dfs(new String(start));

    }
}
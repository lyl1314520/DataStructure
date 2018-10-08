package Graph;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * Title:��������������ڽӱ�ʵ��
 * Description:����ʼ�㿪ʼ���ҳ�һ���ܱ���ͼ�����ж�������·��������Ϊ��Ȩͼ�����������·�����������Ķ���������
 * @author lyl
 * @date 2018��9��24��
 */
public class BreadthFirstSearch<Item> {

    private final int Max_Size = 1000;

    private Item[] V;// �洢����

    private Item[][] E;// �洢��

    private boolean[] isVisited;// ���ĳ�������Ƿ��Ѿ������ʹ�

    private int Vcount, Ecount;// �������ͱ���

    private int[][] adj;// ����ͼ�����Ӿ���

    public BreadthFirstSearch(Item[] V, Item[][] E) {

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

    // ʵ�ֹ����������
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

        System.out.println("���ʵ���" + item1 + "����");
        isVisited[i] = true;
        queue.add(item1);// ��һ�ΰ�v0�ӵ�����

        while (!queue.isEmpty()) {

            u = queue.removeFirst();
            System.out.println("u="+u);
            if(queue.isEmpty())
                System.out.println("�����ѿ�");
            w = this.getFirstNeighbor(item1);
            System.out.println("w1="+w);
            while (w != -1) {

                if (!isVisited[w]) {

                    Item item2 = this.getItem(w);
                    System.out.println("���ʵ���" + item2 + "����");
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

        System.out.println("���������������");
        graph.broadFirstSearch();
        
    }
}
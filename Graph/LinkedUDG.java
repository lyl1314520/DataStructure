package Graph;

import java.util.Scanner;

/**
 * Title ����ͼ���ڽӱ��ʾ
 * @author lyl
 * @date 2018��9��22��
 */
public class LinkedUDG<Item> {

    private int Vcount;// ������

    private int Ecount;// ����

    private Item[] V;// ����洢����

    private Item[][] E;// ����洢��

    // ������ṹ��Ĺ���
    private class Enode {

        int invex;// �����λ��
        Item data;// ������
        Enode next;
    }

    // ���õ�������������ʾ�ڽӱ� xxs
    Enode[] Edge;

    public LinkedUDG(Item[] V, Item[][] E) {

        this.V = V;
        this.E = E;
        this.Vcount = V.length;
        this.Ecount = E.length;
    }

    // ��ʼ������������
    void init() {

        Edge = new LinkedUDG.Enode[Vcount];

        for (int i = 0; i < Edge.length; i++) {

            Edge[i] = new Enode();
            Edge[i].data = V[i];
            Edge[i].invex = i;
            Edge[i].next = null;
        }
    }

    int getV() {

        return Vcount;
    }

    int getE() {

        return Ecount;
    }

    int getIndex(Item item) {

        for (int i = 0; i < V.length; i++)
            if (V[i].equals(item))
                return i;

        return -1;
    }

    /*
     * ��item��ӵ�������node��
     */
    Enode updateList(Enode node, Item item) {

        Enode p = new Enode();
        p.data = item;
        p.invex = this.getIndex(item);

        Enode q = node;

        while (q.next != null)
            q = q.next;

        q.next = p;
        q = q.next;
        q.next = null;

        return node;
    }

    /*
     * �����ڽӱ�
     */
    void createADJ() {

        int j = 0;
        Item data1, data2;

        for (int i = 0; i < E.length; i++) {

            data1 = E[i][j++];
            data2 = E[i][j];

            int index1 = this.getIndex(data1);
            int index2 = this.getIndex(data2);

            Edge[index1] = this.updateList(Edge[index1], data2);
            Edge[index2] = this.updateList(Edge[index2], data1);

            j = 0;
        }
    }

    /*
     * ����ڽӱ�
     */

    void printADJ() {

        int index;

        for (int i = 0; i < Edge.length; i++) {

            System.out.print(Edge[i].invex + " " + Edge[i].data + "\t");
            Enode p = Edge[i].next;

            while (p.next != null) {

                System.out.print(p.invex + " ");
                p = p.next;

            }

            System.out.println(p.invex);
        }
    }

    public static void main(String[] args) {

        String[] V = { "A", "B", "C", "D", "E", "F" };
        String[][] E = { { "A", "B" }, { "A", "D" }, { "A", "F" },{ "B", "C" },{"B","D"},
                       {"C","D"},{"C","F"},{ "D", "E" }, { "E", "F" } };

        LinkedUDG graph = new LinkedUDG(V, E);

        graph.init();
        graph.createADJ();
        graph.printADJ();
    }

}

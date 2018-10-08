package Graph;

/**
 * Title:����ͼ Description:����ͼ��˳��ṹ
 * @author lyl
 * @date 2018��9��22��
 */
public class ArrayUDG<Item> {

    int Max_Size = 10000;// ��ʾĳ����������·��

    Item[] V;// �洢����

    Item[][] E;// �洢��

    private int[] Weight;// �洢�ߵ�Ȩֵ

    private int Vcount, Ecount;

    public int[][] adj;// ����ͼ�����Ӿ���

    public ArrayUDG(Item[] V, Item[][] E, int[] Weight) {

        this.V = V;
        this.E = E;
        this.Weight = Weight;
        this.Vcount = V.length;
        this.Ecount = E.length;
    }

    int getV() {

        return Vcount;
    }

    public int[][] getAdj() {
        return adj;
    }

    public void setAdj(int[][] adj) {
        this.adj = adj;
    }

    int getE() {

        return Ecount;
    }

    // ��ʼ���ڽӾ���adj;
    ArrayUDG init() {

        adj = new int[Vcount][Vcount];

        for (int i = 0; i < adj.length; i++)
            for (int j = 0; j < adj[i].length; j++)
                if (i == j)
                    adj[i][j] = 0;
                else
                    adj[i][j] = (int) Max_Size;
        return this;
    }

    // ��ö�����±�
    int getPosition(Item item) {

        for (int i = 0; i < V.length; i++)
            if (V[i].equals(item))
                return i;

        return -1;
    }

    // �����ڽӾ���
    public ArrayUDG CreateADJ() {

        int index1, index2;

        int j = 0;

        for (int i = 0; i < E.length; i++) {

            index1 = this.getPosition(E[i][j++]);
            index2 = this.getPosition(E[i][j]);
            adj[index1][index2] = adj[index2][index1] = Weight[i];
            j = 0;
        }

        return this;
    }

    void printfADJ() {

        for (int i = 0; i < adj.length; i++) {

            for (int j = 0; j < adj[i].length; j++)
                System.out.print(adj[i][j] + "\t ");

            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] V = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        Integer[][] E = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 6 },
                { 4, 5 }, { 4, 6 }, { 4, 7 }, { 5, 7 }, { 6, 7 }, { 6, 8 }, { 7, 8 } };

        int[] Weight = { 1, 5, 3, 7, 5, 1, 7, 2, 3, 3, 6, 9, 5, 2, 7, 4 };

        ArrayUDG graph = new ArrayUDG(V, E, Weight);
        graph = graph.init();
        graph = graph.CreateADJ();
        graph.printfADJ();
    }

}

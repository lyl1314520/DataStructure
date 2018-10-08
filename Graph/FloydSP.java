package Graph;

/**
 * Title:����ͼ�����·��
 * Description:���������㷨ʵ�� 
 * @author lyl
 * @date 2018��10��4��
 */
public class FloydSP {

    private int[][] D;// ·������D[i][j]����i��j�����·��

    private int[][] P;// ǰ���� P[i][j]����Ӷ���i��j��·��

    void init(ArrayUDG G) {

        D = new int[G.getV()][G.getV()];// D��ʼ��Ϊͼ������ڽӾ���
        P = new int[G.getV()][G.getV()];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[i].length; j++) {
                P[i][j] = j;
                D[i][j] = G.getAdj()[i][j];
            }
        }

    }

    private void floyd(ArrayUDG G) {
        // ����Ӷ���v������w�����·���ͳ���
        for (int k = 0; k < G.getV(); k++) {
            for (int v = 0; v < G.getV(); v++) {
                for (int w = 0; w < G.getV(); w++) {
                    if (D[v][w] > (D[v][k] + D[k][w])) {
                        D[v][w] = D[v][k] + D[k][w];
                        P[v][w] = P[v][k];
                    }
                }
            }
        }

    }

    // ������·��
    void printfD() {

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                System.out.print(D[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // ������·������
    void printP() {

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[i].length; j++) {
                System.out.print(P[i][j] + "\t");
            }
            System.out.println();
        }

    }

    void printfPathAndDistance(ArrayUDG G) {

        for (int v = 0; v < G.getV(); v++) {
            for (int w = v + 1; w < G.getV(); w++) {
                System.out.printf("(%d,%d): ", v, w);
                String path = v + "->";
                int k = P[v][w];
                path += k;
                while (k != w) {
                    k = P[k][w];
                    path += "->" + k;
                }
                System.out.println(path);
                System.out.printf("%d->%d�����·������Ϊ:%d\n\n ", v, w, D[v][w]);
            }
        }
    }

    public static void main(String[] args) {

        Integer[] V = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        Integer[][] E = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 6 },
                { 4, 5 }, { 4, 6 }, { 4, 7 }, { 5, 7 }, { 6, 7 }, { 6, 8 }, { 7, 8 } };

        int[] Weight = { 1, 5, 3, 7, 5, 1, 7, 2, 3, 3, 6, 9, 5, 2, 7, 4 };

        ArrayUDG graph = new ArrayUDG(V, E, Weight);
        graph = graph.init();
        graph = graph.CreateADJ();

        FloydSP floyd = new FloydSP();
        floyd.init(graph);
        floyd.floyd(graph);

        floyd.printfPathAndDistance(graph);

    }
}

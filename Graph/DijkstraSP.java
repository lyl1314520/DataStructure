package Graph;
import java.util.LinkedList;
/**
 * Title:���·��
 * Description:Dijkstra�㷨ʵ��
 * @author lyl
 * @date 2018��10��3��
 */
public class DijkstraSP {

    private int[] disTo;// disTo[i]����Դ��0������i�����·��

    private final int MAX_SiZE = 10000;
    
    private LinkedList<Integer>[] queue;

    public void getShortestPath(ArrayUDG G) {

        boolean[] isShortestPath = new boolean[G.getV()];// �ж϶���i�Ƿ������·��
        disTo = new int[G.getV()];
        queue = new  LinkedList[G.getV()];
        // ��disTo��ʼ��Ϊ�ڽӾ���ĵ�һ��ֵ
        for (int i = 0; i < disTo.length; i++)
            disTo[i] = G.getAdj()[0][i];

        disTo[0] = 0;
        isShortestPath[0] = true;

        for (int v = 1; v<G.getV(); v++) {
            int min = MAX_SiZE;
            int k = 0;// �����С·�����±�;
            for (int w = 0; w < G.getV(); w++) {
                if (!isShortestPath[w] && disTo[w] < min) {
                    k = w;
                    min = disTo[w];
                }
            }
            
            isShortestPath[k] = true;
            /*
             * //һ�λ��disTo���붥��0���ӵĶ���Ȩֵ��С��Ȩֵ������¼�ö�����±꣬
             * Ϊ�����forѭ����ȡ�����·����������׼��
             */
            for (int j = 0; j < G.getV(); j++) {
                if (!isShortestPath[j] && (min + G.getAdj()[k][j]) < disTo[j]) {
                    //����disTo�����0��������������·��
                    disTo[j] = min + G.getAdj()[k][j];
                }
            }
            
            
        }

        for (int v = 1; v < disTo.length; v++) {
            System.out.println("0������" + v + "�����·������Ϊ" + disTo[v]);
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
        
        DijkstraSP dijkstra = new DijkstraSP();
        dijkstra.getShortestPath(graph);

    }
}

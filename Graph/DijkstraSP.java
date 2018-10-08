package Graph;
import java.util.LinkedList;
/**
 * Title:最短路径
 * Description:Dijkstra算法实现
 * @author lyl
 * @date 2018年10月3日
 */
public class DijkstraSP {

    private int[] disTo;// disTo[i]代表源点0到顶点i的最短路径

    private final int MAX_SiZE = 10000;
    
    private LinkedList<Integer>[] queue;

    public void getShortestPath(ArrayUDG G) {

        boolean[] isShortestPath = new boolean[G.getV()];// 判断顶点i是否获得最短路径
        disTo = new int[G.getV()];
        queue = new  LinkedList[G.getV()];
        // 对disTo初始化为邻接矩阵的第一行值
        for (int i = 0; i < disTo.length; i++)
            disTo[i] = G.getAdj()[0][i];

        disTo[0] = 0;
        isShortestPath[0] = true;

        for (int v = 1; v<G.getV(); v++) {
            int min = MAX_SiZE;
            int k = 0;// 获得最小路径的下标;
            for (int w = 0; w < G.getV(); w++) {
                if (!isShortestPath[w] && disTo[w] < min) {
                    k = w;
                    min = disTo[w];
                }
            }
            
            isShortestPath[k] = true;
            /*
             * //一次获得disTo中与顶点0连接的顶点权值最小的权值，并记录该顶点的下标，
             * 为后面的for循环获取最短命路径长度做好准备
             */
            for (int j = 0; j < G.getV(); j++) {
                if (!isShortestPath[j] && (min + G.getAdj()[k][j]) < disTo[j]) {
                    //更新disTo，获得0到其他顶点的最短路径
                    disTo[j] = min + G.getAdj()[k][j];
                }
            }
            
            
        }

        for (int v = 1; v < disTo.length; v++) {
            System.out.println("0到顶点" + v + "的最短路径长度为" + disTo[v]);
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

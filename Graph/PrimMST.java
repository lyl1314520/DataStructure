package Graph;
/**
 * Title:实现普里姆算法
 * Description:该算法目的是找到一条能够遍历所有顶点的最短路径
 * @author lyl
 * @date 2018年10月1日
 */
public class PrimMST {

    int[] lowCost;// 最小代价顶点权值的数组，每次循环都要获取最小权值和顶点下标，为0代表已经找到最小权值的边

    void getLowCost() {
        for (int w : lowCost)
            System.out.print(w + "  ");

        System.out.println("\n");
    }

    void prim(ArrayUDG G) {

        lowCost = new int[G.getV()];
        int min, minId, sum = 0;

        // 初始化lowCost,另其值为与0顶点相连的所有顶点权值。
        for (int i = 1; i < G.getV(); i++) {
            lowCost[i] = G.adj[0][i];
        }
        for (int i = 1; i < G.getV(); i++) {
            this.getLowCost();
            min = G.Max_Size;
            minId = 0;
            // 每次循环结束，寻找lowCost中的最小权值和顶点下标
            for (int j = 1; j < G.getV(); j++) {
                if (lowCost[j] < min && lowCost[j] > 0) {
                    min = lowCost[j];
                    minId = j;
                }
            }
            System.out.println("找到了顶点" + G.V[minId] + "权值" + min);
            sum += min;
            lowCost[minId] = 0;
            this.getLowCost();
            //跟新lowCost数组，将lowCost中的每个值与adj[minId]中对应的数值比较，取两者中的最小值为新的lowCost
            for (int k = 1; k < G.getV(); k++) {
                if (lowCost[k] != 0 && G.adj[minId][k] < lowCost[k]) {
                    lowCost[k] = G.adj[minId][k];
                }
            }
        }

        System.out.println("最小生成树的权值为" + sum);
    }

    public static void main(String[] args) {

        Integer[] V = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        Integer[][] E = { { 0, 1 }, { 0, 5 }, { 1, 2 }, { 1, 6 }, { 1, 8 }, { 2, 3 }, { 2, 8 }, { 3, 4 }, { 3, 6 },
                { 3, 7 }, { 3, 8 }, { 4, 5 }, { 4, 7 }, { 5, 6 }, { 6, 7 } };

        int[] Weight = { 10, 11, 18, 16, 12, 22, 8, 16, 24, 16, 21, 26, 7, 17, 19 };

        ArrayUDG graph = new ArrayUDG(V, E, Weight);

        graph.init();
        graph = graph.CreateADJ();

        new PrimMST().prim(graph);

    }

}

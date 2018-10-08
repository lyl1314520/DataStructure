package Graph;
/**
 * Title:ʵ������ķ�㷨
 * Description:���㷨Ŀ�����ҵ�һ���ܹ��������ж�������·��
 * @author lyl
 * @date 2018��10��1��
 */
public class PrimMST {

    int[] lowCost;// ��С���۶���Ȩֵ�����飬ÿ��ѭ����Ҫ��ȡ��СȨֵ�Ͷ����±꣬Ϊ0�����Ѿ��ҵ���СȨֵ�ı�

    void getLowCost() {
        for (int w : lowCost)
            System.out.print(w + "  ");

        System.out.println("\n");
    }

    void prim(ArrayUDG G) {

        lowCost = new int[G.getV()];
        int min, minId, sum = 0;

        // ��ʼ��lowCost,����ֵΪ��0�������������ж���Ȩֵ��
        for (int i = 1; i < G.getV(); i++) {
            lowCost[i] = G.adj[0][i];
        }
        for (int i = 1; i < G.getV(); i++) {
            this.getLowCost();
            min = G.Max_Size;
            minId = 0;
            // ÿ��ѭ��������Ѱ��lowCost�е���СȨֵ�Ͷ����±�
            for (int j = 1; j < G.getV(); j++) {
                if (lowCost[j] < min && lowCost[j] > 0) {
                    min = lowCost[j];
                    minId = j;
                }
            }
            System.out.println("�ҵ��˶���" + G.V[minId] + "Ȩֵ" + min);
            sum += min;
            lowCost[minId] = 0;
            this.getLowCost();
            //����lowCost���飬��lowCost�е�ÿ��ֵ��adj[minId]�ж�Ӧ����ֵ�Ƚϣ�ȡ�����е���СֵΪ�µ�lowCost
            for (int k = 1; k < G.getV(); k++) {
                if (lowCost[k] != 0 && G.adj[minId][k] < lowCost[k]) {
                    lowCost[k] = G.adj[minId][k];
                }
            }
        }

        System.out.println("��С��������ȨֵΪ" + sum);
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

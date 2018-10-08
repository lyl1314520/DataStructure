package Graph;

/**
 * Title:��³˹�����㷨
 * Description:ʹ�ø��㷨������С�����������ܳ��ֻػ� 
 * @author lyl
 * @date 2018��10��2��
 */
public class KruskalMST {

    private Edge[] E;// �洢��

    private int EdgeSize;// ����

    public KruskalMST(int EdgeSize) {
        // TODO Auto-generated constructor stub
        this.EdgeSize = EdgeSize;
        E = new KruskalMST.Edge[EdgeSize];
    }

    // �����
    public KruskalMST init(int begin, int end, int weight, int k) {

        E[k] = new Edge(begin, end, weight);

        return this;
    }

    /*
     * void showEdge() {
     * 
     * for(int i = 0;i<E.length;i++)
     * System.out.printf("i=%d,%d-%d,weight=%d\n\n",i,E[i].begin,E[i].end,E[i].
     * weight); }
     */
    void getMiNiTree() {

        int m, n, sum = 0;
        int[] parent = new int[EdgeSize];// �����Ƿ���ڻػ�,�±�Ϊ��㣬ֵΪ�յ�
        for (int w : parent)
            w = 0;

        for (int i = 0; i < EdgeSize; i++) {
            // ͨ�������ķ�ʽ������ĳ���ߵ������յ�����ն���ֵ��
            m = find(parent, E[i].begin);
            n = find(parent, E[i].end);
            if (m != n) {// ��m=n,���γ��˻�
                parent[m] = n;
                System.out.printf("�ҵ���%d-%d�ı�\n\n", E[i].begin, E[i].end);
                sum += E[i].weight;

            } else {
                System.out.println("��" + i + "���߳��ֻػ�\n");
            }
        }
        System.out.println("��С������Ϊ" + sum);
    }

    int find(int[] parent, int f) {

        while (parent[f] > 0) {
            f = parent[f];
        }

        return f;
    }

    private class Edge {

        private int begin;// �ߵ����

        private int end;// �ߵ��յ�

        private int weight;// �ߵ�Ȩֵ

        public Edge(int begin, int end, int weight) {// ���캯����ݼ�,Alt+Shift+S

            super();// ���ø���ĳ�ʼ������
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

    }

    public static void main(String[] args) {

        int[][] E = { { 4, 7, 7 }, { 2, 8, 8 }, { 0, 1, 10 }, { 0, 5, 11 }, { 1, 8, 12 }, { 3, 7, 16 }, { 1, 6, 16 },
                { 5, 6, 17 }, { 1, 2, 18 }, { 6, 7, 19 }, { 3, 4, 20 }, { 3, 8, 21 }, { 2, 3, 22 }, { 3, 6, 24 },
                { 4, 5, 26 } };

        KruskalMST kruskal = new KruskalMST(E.length);

        for (int i = 0; i < E.length; i++) {
            kruskal = kruskal.init(E[i][0], E[i][1], E[i][2], i);
        }

        kruskal.getMiNiTree();
    }

}

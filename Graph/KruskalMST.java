package Graph;

/**
 * Title:克鲁斯卡尔算法
 * Description:使用该算法构建最小生成树，不能出现回环 
 * @author lyl
 * @date 2018年10月2日
 */
public class KruskalMST {

    private Edge[] E;// 存储边

    private int EdgeSize;// 边数

    public KruskalMST(int EdgeSize) {
        // TODO Auto-generated constructor stub
        this.EdgeSize = EdgeSize;
        E = new KruskalMST.Edge[EdgeSize];
    }

    // 构造边
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
        int[] parent = new int[EdgeSize];// 检验是否存在回环,下标为起点，值为终点
        for (int w : parent)
            w = 0;

        for (int i = 0; i < EdgeSize; i++) {
            // 通过迭代的方式，查找某条边的起点和终点的最终顶点值。
            m = find(parent, E[i].begin);
            n = find(parent, E[i].end);
            if (m != n) {// 若m=n,则形成了环
                parent[m] = n;
                System.out.printf("找到了%d-%d的边\n\n", E[i].begin, E[i].end);
                sum += E[i].weight;

            } else {
                System.out.println("第" + i + "条边出现回环\n");
            }
        }
        System.out.println("最小生成树为" + sum);
    }

    int find(int[] parent, int f) {

        while (parent[f] > 0) {
            f = parent[f];
        }

        return f;
    }

    private class Edge {

        private int begin;// 边的起点

        private int end;// 边的终点

        private int weight;// 边的权值

        public Edge(int begin, int end, int weight) {// 构造函数快捷键,Alt+Shift+S

            super();// 调用父类的初始化方法
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

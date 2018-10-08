package Graph;
/*
 * ava中使用Set接口描述一个集合（集合不允许有“重复值”，注意重复的概念），集合Set是Collection的子接口，
 * Set不允许其数据元素重复出现，也就是说在Set中每一个数据元素都是唯一的。
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Title:有向图 Description:通过集合来构建有向图
 * @author lyl
 * @date 2018年9月26日
 */
public class Digraph implements Graph<Integer> {

    private final int V;

    private int E;

    private Set<Integer>[] adj;

    public Digraph(int Vcount) {
        // TODO Auto-generated constructor stub
        this.V = Vcount;
        this.E = 0;
        adj = new HashSet[V];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new HashSet<Integer>();
    }

    public void addEdge(int v, int w) {

        adj[v].add((Integer) w);
        E++;

    }

    @Override
    public Graph init(int Edge) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < Edge; i++) {
            System.out.printf("输入第%d条边\n", (i + 1));
            int v = in.nextInt();
            int w = in.nextInt();
            this.addEdge(v, w);
        }
        return this;
    }

    // 获得图的顶点数
    @Override
    public int getVertex() {
        // TODO Auto-generated method stub
        return V;
    }

    // 获得图的边数
    @Override
    public int getEdge() {
        // TODO Auto-generated method stub
        return E;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        // TODO Auto-generated method stub
        return adj[v];
    }

    // 输出有向图
    public String toString() {

        String graph = "";
        for (int v = 0; v < V; v++) {
            graph += v + ": ";
            for (int w : adj[v]) {
                graph += +w + "\t";
            }
            graph += "\n";
        }

        return graph;
    }

    // 反向输出有向图
    public Digraph reverse() {

        Digraph R = new Digraph(V);

        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                R.addEdge(w, v);
            }
        }

        return R;
    }

}

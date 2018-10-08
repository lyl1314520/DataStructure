package Graph;
/*
 * ava��ʹ��Set�ӿ�����һ�����ϣ����ϲ������С��ظ�ֵ����ע���ظ��ĸ��������Set��Collection���ӽӿڣ�
 * Set������������Ԫ���ظ����֣�Ҳ����˵��Set��ÿһ������Ԫ�ض���Ψһ�ġ�
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Title:����ͼ Description:ͨ����������������ͼ
 * @author lyl
 * @date 2018��9��26��
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
            System.out.printf("�����%d����\n", (i + 1));
            int v = in.nextInt();
            int w = in.nextInt();
            this.addEdge(v, w);
        }
        return this;
    }

    // ���ͼ�Ķ�����
    @Override
    public int getVertex() {
        // TODO Auto-generated method stub
        return V;
    }

    // ���ͼ�ı���
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

    // �������ͼ
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

    // �����������ͼ
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

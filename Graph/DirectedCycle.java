package Graph;

import java.util.Stack;

/**
 * Title:有向图中环的检测
 * Description:寻找有向图中某个环，因为环的个数可能是图的大小的指数级别
 * @author lyl
 * @date 2018年9月27日
 */
public class DirectedCycle {

    private boolean[] marked;// 顶点i是否被访问过

    private int[] edgeTo;// 从起点到一个顶点的已知路径上的最后一个点

    private Stack<Integer> cycle;// 存储环中的顶点

    private boolean[] onStack;// 递归调用栈上的所有顶点

    // 寻找有向环的构造函数
    public DirectedCycle(Digraph G) {

        onStack = new boolean[G.getVertex()];

        marked = new boolean[G.getVertex()];

        edgeTo = new int[G.getVertex()];
        
        cycle = null;

        for (int v = 0; v < G.getVertex(); v++) {

            if (!marked[v]) {
                dfs(G, v);
            }

        }

    }

    // 查找的是一条由起点到v的有向路径
    private void dfs(Digraph g, int v) {

        onStack[v] = true;
        marked[v] = true;

        for (int w : g.adj(v)) {

            if (hasCycle()) {//存在一个有向环，递归则结束
                return;

            } else if (!marked[w]) {

                edgeTo[w] = v;
                dfs(g, w);

            } else if (onStack[w]) {

                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                
                cycle.push(w);
                cycle.push(v);
            }
            
        }

        onStack[v] = false;
    }

    // 检测有向环是否存在
    public boolean hasCycle() {

        return cycle != null;
    }

    // 存在有向环，则将环中所有的顶点全部输出
    public Iterable<Integer> cycle() {

        return cycle;
    }

    public static void main(String[] args) {

        Digraph G = new Digraph(5);
        G.init(5);
        System.out.println(  G.toString());
        DirectedCycle cycle = new DirectedCycle(G);

      /* while(!cycle.cycle.empty())
           System.out.println(cycle.cycle.pop());*/
        
        Stack<Integer> stack = cycle.cycle;
        
        System.out.println("输出有向环");
        while(!stack.isEmpty())
              System.out.print(stack.pop()+"\t");
           
    }
}

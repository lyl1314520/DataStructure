package Graph;

import java.util.Stack;

/**
 * Title:����ͼ�л��ļ��
 * Description:Ѱ������ͼ��ĳ��������Ϊ���ĸ���������ͼ�Ĵ�С��ָ������
 * @author lyl
 * @date 2018��9��27��
 */
public class DirectedCycle {

    private boolean[] marked;// ����i�Ƿ񱻷��ʹ�

    private int[] edgeTo;// ����㵽һ���������֪·���ϵ����һ����

    private Stack<Integer> cycle;// �洢���еĶ���

    private boolean[] onStack;// �ݹ����ջ�ϵ����ж���

    // Ѱ�����򻷵Ĺ��캯��
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

    // ���ҵ���һ������㵽v������·��
    private void dfs(Digraph g, int v) {

        onStack[v] = true;
        marked[v] = true;

        for (int w : g.adj(v)) {

            if (hasCycle()) {//����һ�����򻷣��ݹ������
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

    // ��������Ƿ����
    public boolean hasCycle() {

        return cycle != null;
    }

    // �������򻷣��򽫻������еĶ���ȫ�����
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
        
        System.out.println("�������");
        while(!stack.isEmpty())
              System.out.print(stack.pop()+"\t");
           
    }
}

package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title:哈夫曼树 Description:树中所有的叶子节点到根节点的路径长度乘以该叶子节点的权值之和的最小值。称该树为带权路径长度WPL最小的二叉树
 * 权值越小的的叶子节点离根节点越远
 * 
 * @author lyl
 * @date 2018年10月6日
 */
public class HuffmanTree {
    // 创建内部类构造叶子节点
    private class Node<T> {

        T data;// 叶子节点的数据
        double weight;// 叶子节点的权值;
        Node left, right;// 左右孩子结点

        public Node(T data, double weight) {
            // TODO Auto-generated constructor stub
            super();// 调用父类中初始化方法
            this.data = data;
            this.weight = weight;
            this.left = this.right = null;
        }

        public String toString() {
            return "Node[data=" + data + ",weight=" + weight + "]";
        }
    }

    Node root;// 根节点
    // 创建集合，将叶子节点添加到集合中，再对集合中的结点排序筛选，让其符合赫夫曼树的性质

    void init() {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node("A", 40.0));
        list.add(new Node("B", 8.0));
        list.add(new Node("C", 10.0));
        list.add(new Node("D", 30.0));
        list.add(new Node("E", 10.0));
        list.add(new Node("F", 20.0));
        this.traverseCollection(list);
        root = createTree(list);// root的权值为所有叶子顶点的权值之和，此时哈夫曼树已经构成*/
    }

    // 遍历集合中所有的元素
    void traverseCollection(List<Node> list) {
        /*
         * for(int i=0;i<list.size();i++) {
         * System.out.println(list.get(i).toString()); }
         */
        Iterator iterlist = list.iterator();// ;list实现Iterable接口
        while (iterlist.hasNext()) {
            String strlist = iterlist.next().toString();
            System.out.println(strlist);
        }
    }

    public static void main(String[] args) {
        HuffmanTree huffman = new HuffmanTree();
        huffman.init();

        List<Node> list = new ArrayList<Node>();
        list = huffman.breadthFirst(huffman.root);
        System.out.println("输出哈夫曼树");
        huffman.traverseCollection(list);

        double WPL = huffman.calculateWPL(huffman.root, 0);
        System.out.printf("\n哈夫曼树的带权路径长度为" + WPL);
        huffman.traverseCollection(list);
    }

    // 构造哈夫曼树,集合中第一个元素的索引是0;
    private Node createTree(List<Node> node) {
        // 当集合中的元素为1时，哈夫曼树已构成，该元素就是哈夫曼树的根节点
        while (node.size() != 1) {
            // 对所有叶子节点进行快速排序,为降序
            quickSort(node);
            // this.traverseCollection(node);
            System.out.println();
            // 获取集合中权值最小的练两个结点
            Node Lchild = node.get(node.size() - 1);
            Node Rchild = node.get(node.size() - 2);
            // 生成新结点，该结点为这两个结点的双亲结点，其权值为这两个权值之和
            Node parent = new Node(null, Lchild.weight + Rchild.weight);
            parent.left = Lchild;
            parent.right = Rchild;
            // 删除两个权值最小的结点
            node.remove(node.size() - 1);
            node.remove(node.size() - 1);
            // 将新的结点添加到集合中
            node.add(parent);
            // 每循环一次，集合中的元素又变得无序，需要重新进行快排
        }
        return node.get(0);
    }

    private void quickSort(List<Node> node) {
        subSort(node, 0, node.size() - 1);
    }

    /*
     * 快速排序的核心 以某个值为分界值，分别从集合的左右两端遍历，在左端寻找大于分界值的元素，在右端寻找小于分界值的元素，交换这两个元素的位置
     * 当两个搜索指针相遇时，第一轮排序结束。 利用递归思想对分界值左侧和右侧分别排序，从而使整个集合有序
     */
    private void subSort(List<Node> node, int start, int end) {
        if (start >= end)
            return;
        // 以第一个元素作为分界值
        Node base = node.get(start);
        // i为快排中左侧搜素的指针
        int i = start;
        // j为快排中从右侧搜索的指针
        int j = end + 1;
        while (true) {
            // 遍历集合，寻找大于分界值并且i未到end处的结点的索引
            while (i < end && node.get(++i).weight < base.weight)
                ;
            // 遍历集合，寻找小于分界值并且j未到start处的结点的缩影
            while (j > start && node.get(--j).weight > base.weight)
                ;
            if (i < j) {
                // 找到符合快排规则的元素，将其交换
                swap(node, i, j);
            } else {// 指针相遇遍历结束
                break;
            }
        }
        swap(node, start, j);
        // 递归左边子序列
        subSort(node, start, j - 1);
        // 递归右边子序列
        subSort(node, j + 1, end);

    }

    // 检查快排后集合是否有序
    boolean isSorted(List<Node> node) {
        for (int i = 0; i < node.size() - 1; i++) {
            if (node.get(i).weight > node.get(i + 1).weight)
                return false;
        }
        return true;
    }

    // 交换集合中的元素 ，使集合有序
    private void swap(List<Node> node, int i, int j) {
        Node temp;
        temp = node.get(i);
        // 将第j个元素赋给索引为i的元素
        node.set(i, node.get(j));
        node.set(j, temp);
    }

    // 广度优先遍历
    private List<Node> breadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        // 创建队列
        List<Node> list = new ArrayList<>();
        // add()和offer()都是元素入队 add()适用没有容量限制的队列 offer()适用有容量限制的队列
        if (node != null) { // 将根节点入队
            queue.offer(node);
        }
        while (!queue.isEmpty()) { // 将该队列的队尾元素添加到集合中
            Node p = queue.peek();
            // peek()是获取但不删除队列的头
            list.add(p);
            Node q = queue.poll();// poll()方法是获取并删除队列的头

            // 若左孩子结点不为空，将其加入队列
            if (q.left != null) {
                queue.offer(p.left);
            } // 若右孩子结点不为空，将其加入队列
            if (q.right != null) {
                queue.offer(q.right);
            }

        }
        return list;
    }

    // 计算带权路径长度
    double calculateWPL(Node node, int length) {// length为树的层数
        if (node == null) {// 根节点只是data为null,其权值和左右子树都不为null
            return 0.0;
        } else {
            if (node.left == null && node.right == null) {// 访问到了叶子节点
                return node.weight * length;
            } else {// 访问到非叶子节点，进行递归调用，访问左右子树的带权路径之和，length递增
                return calculateWPL(node.left, length + 1) + calculateWPL(node.right, length + 1);
            }
        }
    }

}

package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title:�������� Description:�������е�Ҷ�ӽڵ㵽���ڵ��·�����ȳ��Ը�Ҷ�ӽڵ��Ȩֵ֮�͵���Сֵ���Ƹ���Ϊ��Ȩ·������WPL��С�Ķ�����
 * ȨֵԽС�ĵ�Ҷ�ӽڵ�����ڵ�ԽԶ
 * 
 * @author lyl
 * @date 2018��10��6��
 */
public class HuffmanTree {
    // �����ڲ��๹��Ҷ�ӽڵ�
    private class Node<T> {

        T data;// Ҷ�ӽڵ������
        double weight;// Ҷ�ӽڵ��Ȩֵ;
        Node left, right;// ���Һ��ӽ��

        public Node(T data, double weight) {
            // TODO Auto-generated constructor stub
            super();// ���ø����г�ʼ������
            this.data = data;
            this.weight = weight;
            this.left = this.right = null;
        }

        public String toString() {
            return "Node[data=" + data + ",weight=" + weight + "]";
        }
    }

    Node root;// ���ڵ�
    // �������ϣ���Ҷ�ӽڵ���ӵ������У��ٶԼ����еĽ������ɸѡ��������Ϻշ�����������

    void init() {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node("A", 40.0));
        list.add(new Node("B", 8.0));
        list.add(new Node("C", 10.0));
        list.add(new Node("D", 30.0));
        list.add(new Node("E", 10.0));
        list.add(new Node("F", 20.0));
        this.traverseCollection(list);
        root = createTree(list);// root��ȨֵΪ����Ҷ�Ӷ����Ȩֵ֮�ͣ���ʱ���������Ѿ�����*/
    }

    // �������������е�Ԫ��
    void traverseCollection(List<Node> list) {
        /*
         * for(int i=0;i<list.size();i++) {
         * System.out.println(list.get(i).toString()); }
         */
        Iterator iterlist = list.iterator();// ;listʵ��Iterable�ӿ�
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
        System.out.println("�����������");
        huffman.traverseCollection(list);

        double WPL = huffman.calculateWPL(huffman.root, 0);
        System.out.printf("\n���������Ĵ�Ȩ·������Ϊ" + WPL);
        huffman.traverseCollection(list);
    }

    // �����������,�����е�һ��Ԫ�ص�������0;
    private Node createTree(List<Node> node) {
        // �������е�Ԫ��Ϊ1ʱ�����������ѹ��ɣ���Ԫ�ؾ��ǹ��������ĸ��ڵ�
        while (node.size() != 1) {
            // ������Ҷ�ӽڵ���п�������,Ϊ����
            quickSort(node);
            // this.traverseCollection(node);
            System.out.println();
            // ��ȡ������Ȩֵ��С�����������
            Node Lchild = node.get(node.size() - 1);
            Node Rchild = node.get(node.size() - 2);
            // �����½�㣬�ý��Ϊ����������˫�׽�㣬��ȨֵΪ������Ȩֵ֮��
            Node parent = new Node(null, Lchild.weight + Rchild.weight);
            parent.left = Lchild;
            parent.right = Rchild;
            // ɾ������Ȩֵ��С�Ľ��
            node.remove(node.size() - 1);
            node.remove(node.size() - 1);
            // ���µĽ����ӵ�������
            node.add(parent);
            // ÿѭ��һ�Σ������е�Ԫ���ֱ��������Ҫ���½��п���
        }
        return node.get(0);
    }

    private void quickSort(List<Node> node) {
        subSort(node, 0, node.size() - 1);
    }

    /*
     * ��������ĺ��� ��ĳ��ֵΪ�ֽ�ֵ���ֱ�Ӽ��ϵ��������˱����������Ѱ�Ҵ��ڷֽ�ֵ��Ԫ�أ����Ҷ�Ѱ��С�ڷֽ�ֵ��Ԫ�أ�����������Ԫ�ص�λ��
     * ����������ָ������ʱ����һ����������� ���õݹ�˼��Էֽ�ֵ�����Ҳ�ֱ����򣬴Ӷ�ʹ������������
     */
    private void subSort(List<Node> node, int start, int end) {
        if (start >= end)
            return;
        // �Ե�һ��Ԫ����Ϊ�ֽ�ֵ
        Node base = node.get(start);
        // iΪ������������ص�ָ��
        int i = start;
        // jΪ�����д��Ҳ�������ָ��
        int j = end + 1;
        while (true) {
            // �������ϣ�Ѱ�Ҵ��ڷֽ�ֵ����iδ��end���Ľ�������
            while (i < end && node.get(++i).weight < base.weight)
                ;
            // �������ϣ�Ѱ��С�ڷֽ�ֵ����jδ��start���Ľ�����Ӱ
            while (j > start && node.get(--j).weight > base.weight)
                ;
            if (i < j) {
                // �ҵ����Ͽ��Ź����Ԫ�أ����佻��
                swap(node, i, j);
            } else {// ָ��������������
                break;
            }
        }
        swap(node, start, j);
        // �ݹ����������
        subSort(node, start, j - 1);
        // �ݹ��ұ�������
        subSort(node, j + 1, end);

    }

    // �����ź󼯺��Ƿ�����
    boolean isSorted(List<Node> node) {
        for (int i = 0; i < node.size() - 1; i++) {
            if (node.get(i).weight > node.get(i + 1).weight)
                return false;
        }
        return true;
    }

    // ���������е�Ԫ�� ��ʹ��������
    private void swap(List<Node> node, int i, int j) {
        Node temp;
        temp = node.get(i);
        // ����j��Ԫ�ظ�������Ϊi��Ԫ��
        node.set(i, node.get(j));
        node.set(j, temp);
    }

    // ������ȱ���
    private List<Node> breadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        // ��������
        List<Node> list = new ArrayList<>();
        // add()��offer()����Ԫ����� add()����û���������ƵĶ��� offer()�������������ƵĶ���
        if (node != null) { // �����ڵ����
            queue.offer(node);
        }
        while (!queue.isEmpty()) { // ���ö��еĶ�βԪ����ӵ�������
            Node p = queue.peek();
            // peek()�ǻ�ȡ����ɾ�����е�ͷ
            list.add(p);
            Node q = queue.poll();// poll()�����ǻ�ȡ��ɾ�����е�ͷ

            // �����ӽ�㲻Ϊ�գ�����������
            if (q.left != null) {
                queue.offer(p.left);
            } // ���Һ��ӽ�㲻Ϊ�գ�����������
            if (q.right != null) {
                queue.offer(q.right);
            }

        }
        return list;
    }

    // �����Ȩ·������
    double calculateWPL(Node node, int length) {// lengthΪ���Ĳ���
        if (node == null) {// ���ڵ�ֻ��dataΪnull,��Ȩֵ��������������Ϊnull
            return 0.0;
        } else {
            if (node.left == null && node.right == null) {// ���ʵ���Ҷ�ӽڵ�
                return node.weight * length;
            } else {// ���ʵ���Ҷ�ӽڵ㣬���еݹ���ã��������������Ĵ�Ȩ·��֮�ͣ�length����
                return calculateWPL(node.left, length + 1) + calculateWPL(node.right, length + 1);
            }
        }
    }

}

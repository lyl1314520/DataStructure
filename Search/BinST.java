package Search;

import java.util.Scanner;

/**
 * Title:���������� Description:���ӽڵ㶼�����ڸ��ڵ㣬�Һ��ӽڵ㶼��С�ڸ��ڵ�,ͨ���ݹ鷽ʽ��ɸ��ֲ���
 * 
 * @author lyl
 * @date 2018��10��4��
 */
public class BinST<Key extends Comparable<Key>, Val> {

    private Node root;// ���ڵ�

    private int N;// ��¼�ڵ���Ŀ;

    private class Node {

        Key key;// ����ֵ
        Val val;// ����λ��
        Node left;// ����
        Node right;// �Һ���;

        public Node(Key key, Val val) {

            this.key = key;

            this.val = val;

            this.left = this.right = null;
        }

    }

    void init() {
        root = null;
        N = 0;
    }

    // ��ȡ���ڵ�
    Node getRoot() {
        return root;
    }

    int size() {
        return N;
    }

    boolean isEmpty() {
        return root == null;// N == 0
    }

    Node put1(Node p, Key key, Val val) {// ʹ�õݹ鷽������������

        if (p == null) {// �������ڵ�
            p = new Node(key, val);
            N++;
        }

        int temp = p.key.compareTo(key);
        //���½���λ��
        if (temp == 0)
            p.val = val;
        //�������ұߴ���
        else if (temp < 0)
            p.right = put1(p.right, key, val);
        else
        //��������ߴ���
            p.left = put1(p.left, key, val);

        return p;
    }

    /*
     * ʹ�÷ǵݹ鷨����������
     */

    Node put2(Node p, Key key, Val val) {

        Node q = p;
        if (p == null) {
            p = new Node(key, val);
            N++;
            return p;
        }

        while (true) {

            int temp = key.compareTo(p.key);

            if (temp == 0) {
                q.val = val;
                break;
            }

            else if (temp < 0) {

                if (q.left == null) {
                    q.left = new Node(key, val);
                    break;
                }
                q = q.left;
            }

            else {
                if (q.right == null) {
                    q.right = new Node(key, val);
                    break;
                }
                q = q.right;
            }
        }

        N++;
        return p;
    }

    /*
     * ���Ҽ�ֵ��С�Ľڵ�
     */
    Node getMin(Node node) {

        if (node == null)
            return null;

        if (node.left != null)
            return getMin(node.left);

        return node;
    }

    /*
     * ����ָ���ļ�
     */

    Node get(Node p, Key key) {

        if (p == null)
            return null;

        int temp = key.compareTo(p.key);

        if (temp == 0)
            return p;
        else if (temp < 0)
            return get(p.left, key);// �������������Ҽ�

        else
            return get(p.right, key);// �������������Ҽ�
    }

    /*
     * ��ȡĳ���ڵ��˫�׽ڵ�
     */
    Node getParent(Key key) {

        if (isEmpty())
            return null;

        else {

            Node temp = getParent(root, key);
            return temp;
        }
    }

    Node getParent(Node node, Key key) {

        if (node != null) {

            Node leftNode = node.left;
            Node rightNode = node.right;

            int temp = node.key.compareTo(key);

            if ((leftNode == null && rightNode == null) || node.key.equals(key))
                return null;

            if (leftNode != null) {
                int temp1 = leftNode.key.compareTo(key);
                if (temp1 == 0)
                    return node;
            }

            if (rightNode != null) {
                int temp2 = rightNode.key.compareTo(key);
                if (temp2 == 0)
                    return node;
            }

            if (temp == 0)
                return null;

            else if (temp > 0)
                return getParent(leftNode, key);

            else
                return getParent(rightNode, key);

        }

        else
            return null;

    }

    /*
     * ɾ����ֵ��С�ļ�
     */
    void removeMin() {

        if (isEmpty())
            return;
        else
            root = removeMin(root);
    }

    Node removeMin(Node p) {

        if (p.left == null) {
            Node Right = p.right;
            p = null;
            N--;
            return Right;
        }

        p.left = removeMin(p.left);

        return p;
    }

    void removeMax() {

        if (isEmpty())
            return;
        else
            root = removeMax(root);
    }

    /*
     * ɾ����ֵ���ļ�
     */
    Node removeMax(Node p) {

        if (p.right == null) {
            Node Left = p.left;
            p = null;
            N--;

            return Left;
        }
        p.right = removeMin(p.right);
        return p;
    }

    /*
     * ɾ��ָ���ļ�
     */

    void removeKey(Key key) {

        if (isEmpty())
            return;

        else
            root = removeKey(root, key);
    }

    Node removeKey(Node node, Key key) {

        if (node == null)
            return null;

        int temp = node.key.compareTo(key);
        // node.key>key
        if (temp > 0) {

            node.left = removeKey(node.left, key);
            return node;

        }
        // node.key<key
        else if (temp < 0) {

            node.right = removeKey(node.right, key);
            return node;
        }
        // node.key = key
        else {
            if (node.left == null) {// ֻ���Һ��ӵĻ������Һ��ӽڵ�����ýڵ�
                Node rightNode = node.right;
                node = null;
                N--;
                return rightNode;
            }

            if (node.right == null) {// ֻ�����ӵĻ��������ӽڵ����ýڵ�
                Node leftNode = node.left;
                node = null;
                N--;
                return leftNode;

            }

            // resultNode.left!=null&&resultNode.right!=null
            // �����������м�ֵ��С�Ľ�������resultNode
            Node successor = getMin(node.right);
            N++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node = null;
            N--;
            return successor;

        }

    }

    /*
     * ��α���������
     */

    void levelOrder(Node node, int level) {

        if (node == null || level < 1)
            return;

        if (level == 1) {
            System.out.print(node.key + "\t");
            return;
        }
        // �������
        levelOrder(node.left, level - 1);
        // �������
        levelOrder(node.right, level - 1);

    }

    void levelOrder(Node node) {

        if (node == null)
            return;
        // ��ȡ�������
        int depth = Depth(node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(node, i);
            System.out.println();
        }
    }

    /*
     * ���������
     */
    int Depth(Node node) {

        int depth, leftDepth, rightDepth;

        leftDepth = rightDepth = 0;

        if (node.left != null)
            leftDepth += Depth(node.left);

        if (node.right != null)
            rightDepth += Depth(node.right);

        depth = (leftDepth) > (rightDepth) ? (leftDepth + 1) : (rightDepth + 1);

        return depth;
    }

    /*
     * ������ʾ���м���ֵ
     */
    void Preorder(Node p) {

        if (p != null) {
            System.out.print(p.key + "\t");

            Preorder(p.left);
            Preorder(p.right);
        }

    }

    /*
     * ������ʾ���м���λ��
     */

    void showVal(Node p) {

        if (p == null)
            return;

        System.out.print(p.val + "\t");

        showVal(p.left);
        showVal(p.right);
    }

}

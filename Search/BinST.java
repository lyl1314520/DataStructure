package Search;

import java.util.Scanner;

/**
 * Title:二分搜索树 Description:左孩子节点都不大于根节点，右孩子节点都不小于根节点,通过递归方式完成各种操作
 * 
 * @author lyl
 * @date 2018年10月4日
 */
public class BinST<Key extends Comparable<Key>, Val> {

    private Node root;// 根节点

    private int N;// 记录节点数目;

    private class Node {

        Key key;// 键的值
        Val val;// 键的位置
        Node left;// 左孩子
        Node right;// 右孩子;

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

    // 获取根节点
    Node getRoot() {
        return root;
    }

    int size() {
        return N;
    }

    boolean isEmpty() {
        return root == null;// N == 0
    }

    Node put1(Node p, Key key, Val val) {// 使用递归方法创建二叉树

        if (p == null) {// 创建根节点
            p = new Node(key, val);
            N++;
        }

        int temp = p.key.compareTo(key);
        //更新结点的位置
        if (temp == 0)
            p.val = val;
        //往树的右边创建
        else if (temp < 0)
            p.right = put1(p.right, key, val);
        else
        //往树的左边创建
            p.left = put1(p.left, key, val);

        return p;
    }

    /*
     * 使用非递归法创建二叉树
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
     * 查找键值最小的节点
     */
    Node getMin(Node node) {

        if (node == null)
            return null;

        if (node.left != null)
            return getMin(node.left);

        return node;
    }

    /*
     * 查找指定的键
     */

    Node get(Node p, Key key) {

        if (p == null)
            return null;

        int temp = key.compareTo(p.key);

        if (temp == 0)
            return p;
        else if (temp < 0)
            return get(p.left, key);// 遍历左子树查找键

        else
            return get(p.right, key);// 遍历右子树查找键
    }

    /*
     * 获取某个节点的双亲节点
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
     * 删除键值最小的键
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
     * 删除键值最大的键
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
     * 删除指定的键
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
            if (node.left == null) {// 只有右孩子的话，让右孩子节点替代该节点
                Node rightNode = node.right;
                node = null;
                N--;
                return rightNode;
            }

            if (node.right == null) {// 只有左孩子的话，让左孩子节点代替该节点
                Node leftNode = node.left;
                node = null;
                N--;
                return leftNode;

            }

            // resultNode.left!=null&&resultNode.right!=null
            // 可让右子树中键值最小的结点替代该resultNode
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
     * 层次遍历二叉树
     */

    void levelOrder(Node node, int level) {

        if (node == null || level < 1)
            return;

        if (level == 1) {
            System.out.print(node.key + "\t");
            return;
        }
        // 从左输出
        levelOrder(node.left, level - 1);
        // 从右输出
        levelOrder(node.right, level - 1);

    }

    void levelOrder(Node node) {

        if (node == null)
            return;
        // 获取树的深度
        int depth = Depth(node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(node, i);
            System.out.println();
        }
    }

    /*
     * 求树的深度
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
     * 先序显示所有键的值
     */
    void Preorder(Node p) {

        if (p != null) {
            System.out.print(p.key + "\t");

            Preorder(p.left);
            Preorder(p.right);
        }

    }

    /*
     * 先序显示所有键的位置
     */

    void showVal(Node p) {

        if (p == null)
            return;

        System.out.print(p.val + "\t");

        showVal(p.left);
        showVal(p.right);
    }

}

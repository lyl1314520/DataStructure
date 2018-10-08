package Tree;

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Title:二叉树 Description:二叉树的链式存储方式，采用非递归方式输出树
 * 
 * @author lyl
 * @param <T>
 * @date 2018年10月5日
 */
public class BinaryTree {

    private TNode root;// 根结点

    private class TNode {
        char data;
        TNode left;
        TNode right;

        public TNode(char data) {// 每创建一个结点，其左右孩子结点必为空
            // TODO Auto-generated constructor stub
            this.data = data;
            this.left = this.right = null;
        }
    }

    public BinaryTree() {
        // TODO Auto-generated constructor stub
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    // 树的顶点数目
    int getSize(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

    // 获取树的高度
    int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        int height, lHeight, rHeight;
        lHeight = getHeight(node.left);
        rHeight = getHeight(node.right);
        height = (lHeight > rHeight) ? lHeight : rHeight;

        return height + 1;
    }
    /*
     *    A 
     * B      C
     D   E  F   
       G     H
     */

    // 递归创建二叉树
    public TNode createTree() {
        TNode nodeA = new TNode('A');
        TNode nodeB = new TNode('B');
        TNode nodeC = new TNode('C');
        TNode nodeD = new TNode('D');
        TNode nodeE = new TNode('E');
        TNode nodeF = new TNode('F');
        TNode nodeG = new TNode('G');
        TNode nodeH = new TNode('H');
        root = nodeA;
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeE.left = nodeG;
        nodeF.right = nodeH;

        return root;
    }

    // 非递归前序输出二叉树，利用栈的特点，将根节点入栈，然后通过循环思想，将根节点出栈。将根节点的右孩子，左孩子先后入栈
    void preOrder(TNode node) {
        if (node == null) {
            return;
        }
        Stack<TNode> stack = new Stack<TNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TNode n = stack.pop();
            System.out.println(n.data);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }

    }

    // 非递归中序遍历二叉树
    void inOrder(TNode node) {

        Stack<TNode> stack = new Stack<TNode>();

        while ((node != null) || (!stack.isEmpty())) {
            // 将node结点的所有左子树都压入栈中
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 将栈顶元素出栈，同时在出栈过程中node指针要移动到栈顶结点的右孩子结点处
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    // 非递归后序遍历二叉树
    void postOrder(TNode node) {
        Stack<TNode> stack = new Stack<TNode>();
        TNode t = node;
        while (node != null) {
            // 左子树全部入栈
            for (; node.left != null; node = node.left) {
                stack.push(node);
            }
            // 当前结点无右子树或右子树已经输出
            while (node != null && (node.right == null || node.right == t)) {
                System.out.println(node.data);
                // 记录一个已经输出结点
                t = node;
                if (stack.isEmpty()) {
                    return;
                }
                node = stack.pop();
            }
            // 处理右子树
            stack.push(node);
            node = node.right;
        }
    }

    // 递归层次遍历二叉树
    void levelOrder(TNode node, int level) {
        if (node == null || level < 1)
            return;
        if (level == 1) {
            System.out.print(node.data + "\t");
        }
        levelOrder(node.left, level - 1);
        levelOrder(node.right, level - 1);
    }

    // 利用队列的特点非递归层次遍历树
    void unLevelOrder(TNode node) {
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    void levelOrder(TNode node) {
        if (node == null)
            return;
        int depth = this.getHeight(node);
        // System.out.println(node.data);
        for (int i = 1; i <= depth; i++) {
            this.levelOrder(node, i);
            System.out.println();
        }
    }

    // 获取某个结点的父节点
    void getParent(TNode node, char data, TNode parent) {
        if (node.data == data) {
            if (parent == null) {
                System.out.println(data + "就是根结点");
                return;
            } else
                System.out.println(data + "的双亲结点为" + parent.data);
        }
        if (node.left != null) {
            getParent(node.left, data, node);

        }
        if (node.right != null) {
            getParent(node.right, data, node);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = tree.createTree();
        Scanner in = new Scanner(System.in);
        // System.out.println("非迭代前序遍历树");
        // tree.preOrder(tree.root);
        // tree.levelOrder(tree.root);
        // tree.inOrder(tree.root);
        // tree.postOrder(tree.root);
        // tree.unLevelOrder(tree.root);
        System.out.println("输入要查找的结点");
        char findNode = in.next().charAt(0);
        // tree.getParent(tree.root, findNode, null);

    }
}

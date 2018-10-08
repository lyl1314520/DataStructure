package Search;

import java.util.Scanner;

/**
 * Title:查找
 * Description:查找链式链表的制定元素
 * @author lyl
 * @date 2018年10月4日
 */
public class Linked_Search<Key, Value> {

    private int N;// 节点个数

    private Node first;// 首节点

    private Node last;// 尾节点

    private class Node {

        Key key;// 某个键的值

        Value val;// 某个键在单链表中的位置

        Node next;

        public Node(Key key, Value val, Node next) {

            this.key = key;

            this.val = val;

            this.next = next;

        }
    }

    void init() {

        first = null;
        last = null;
        N = 0;
    }

    int size() {
        return N;
    }

    /*
     * 查找给定的键，找到更新其位置，否则建立新的键。也可称作链表建立
     */

    void put(Key key, Value val) {

        Node p;

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        // 在表尾插入键创建单链表
        if (first == null) {
            p = new Node(key, val, null);
            first = p;
            last = p;
        }

        else {
            p = new Node(key, val, null);
            last.next = p;
            last = p;
        }

        N++;
    }

    Value get(Key key) {// 查找给定键的位置

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key))
                return x.val;
        }
        return null;
    }

    void delete(Key key) {// 删除指定的键，将其位置赋null；

        if (first.key.equals(key)) {// key为首节点
            Node p = first.next;
            System.out.println("删除的是" + first.val + "号键");
            first.val = null;
            first = p;
            N--;
            return;
        }

        for (Node x = first; x != null; x = x.next)// key不是首节点
            if (x.next.key.equals(key)) {
                Node p = x.next;
                System.out.println("删除的是" + p.val + "号键");
                p.val = null;
                x.next = x.next.next;
                N--;
                return;
            }
        return;// 表示表中没有这个键
    }

    void output() {

        System.out.print("x.key" + "\t");

        for (Node x = first; x != null; x = x.next)
            System.out.print(x.key + "\t");

        System.out.println();

        System.out.print("x.val" + "\t");

        for (Node x = first; x != null; x = x.next)
            System.out.print(x.val + "\t");

        System.out.println();

    }

}

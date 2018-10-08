package LinkedList;

import java.util.*;

/**
 * Title:单链表
 * Description:链式存储结构 
 * @author lyl
 * @date 2018年10月4日
 */
public class SingleLinkedList<Item> {

    private int N = 0;

    Node oldfirst;

    Node first;

    private class Node {

        Node next;

        Item item;
    }

    Node create(Item item) {

        Node p = new Node();

        p.item = item;

        if (first == null)
            first = p;

        else
            oldfirst.next = p;

        oldfirst = p;

        N++;
        return first;
    }

    int size() {
        return N;
    }

    Node q = first;

    boolean isEmpty() {
        return q == null;
    }

    Item max(Node p) {// 使用递归求链表中节点最大的值

        Node q = p;

        if (q == null)
            return null;

        else if (q.next == null)
            return (Item) q.item;

        else {
            Item max = max(q.next);
            return (Integer) max > (Integer) q.item ? max : q.item;
        }

    }

    void insertHead(Item item) {// 表头插入节点

        Node p = first;
        first = new Node();
        first.item = item;
        first.next = p;

        N++;
    }

    // 表头删除节点
    void deleteHead() {
        first = first.next;
    }

    // 表尾插入结点
    void insertFoot(Item item) {

        Node last = new Node();
        last.item = item;
        oldfirst.next = last;
        oldfirst = last;
    }

    Item output() {

        Item item = q.item;
        q = q.next;
        return item;
    }

    // 逆向输出单链表
    Node reverse() {

        Node reverse = null;
        while (first != null) {

            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }

}
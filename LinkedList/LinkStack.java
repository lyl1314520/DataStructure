package LinkedList;

import java.util.Scanner;

/**
 * Title:栈
 * Description:栈的链式结构
 * @author lyl
 * @date 2018年10月4日
 */
public class LinkStack<Item> {

    private static char[] data;

    private int N = 0;

    private class Node {
        Node next;
        Item data;
    }

    Node first = new Node();

    void setEmpty() {
        first.next = null;
    }

    boolean isEmpty() {
        return first.next == null;
    }

    int size() {
        return N;
    }

    void push(Item item) {

        Node top = new Node();
        top.data = item;
        top.next = first.next;
        first.next = top;
        N++;
    }

    // 元素出队
    Item pop() {

        Node p = first.next;
        Item item = p.data;
        first.next = p.next;

        return item;

    }

}

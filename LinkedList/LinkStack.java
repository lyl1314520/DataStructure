package LinkedList;

import java.util.Scanner;

/**
 * Title:ջ
 * Description:ջ����ʽ�ṹ
 * @author lyl
 * @date 2018��10��4��
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

    // Ԫ�س���
    Item pop() {

        Node p = first.next;
        Item item = p.data;
        first.next = p.next;

        return item;

    }

}

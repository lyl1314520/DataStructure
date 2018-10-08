package LinkedList;

import java.util.Scanner;

/**
 * Title:��������
 * Description:���Է�������������һ�����
 * @author lyl
 * @date 2018��10��4��
 */
public class RingList<Item> {

    private Node first, last;

    private int N = 0;

    private class Node {

        Node next;

        Item item;

    }

    void inqueue(Item item) {

        Node p = new Node();
        p.item = item;
        if (first == null) {
            first = p;
            last = first;
        }

        else {
            last.next = p;
            last = p;
            last.next = first;
        }

        N++;
    }

    int size() {
        return N;
    }

    boolean isEmpty() {
        return N == 0;
    }

    Node q;

    void Set() {
        q = last;
    }

    Item dequeue() {
        Item item = q.item;
        q = q.next;
        N--;
        return item;
    }

}

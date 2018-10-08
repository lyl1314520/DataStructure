package LinkedList;

import java.util.*;

/**
 * Title:������
 * Description:��ʽ�洢�ṹ 
 * @author lyl
 * @date 2018��10��4��
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

    Item max(Node p) {// ʹ�õݹ��������нڵ�����ֵ

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

    void insertHead(Item item) {// ��ͷ����ڵ�

        Node p = first;
        first = new Node();
        first.item = item;
        first.next = p;

        N++;
    }

    // ��ͷɾ���ڵ�
    void deleteHead() {
        first = first.next;
    }

    // ��β������
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

    // �������������
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
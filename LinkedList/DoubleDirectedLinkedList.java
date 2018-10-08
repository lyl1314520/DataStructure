package LinkedList;

import java.util.Scanner;

/**
 * Title:˫�����
 * Description:��ʽ�洢�ṹ���������˫�����
 * @author lyl
 * @date 2018��10��4��
 */
public class DoubleDirectedLinkedList<Item> {

    private int N = 0;

    DoubleNode head, end;// ��ͷָ��ͱ�βָ��

    private class DoubleNode {

        DoubleNode prior;

        DoubleNode next;

        Item item;
    }

    void create(Item item) {

        DoubleNode p = new DoubleNode();
        p.item = item;
        if (head == null) {
            head = p;
            end = p;
        }

        else {
            p.prior = end;
            end.next = p;
            end = p;
        }

        N++;
    }

    // ������
    int size() {
        return N;
    }

    // �ڱ�ͷ����Ԫ��
    void insertHead(Item item) {

        DoubleNode p = head;
        head = new DoubleNode();
        head.item = item;
        p.prior = head;
        head.next = p;

        N++;
    }

    // ɾ����ͷ
    void deleteHead() {

        head = head.next;
        N--;
    }

    // �ڱ�β������
    void insertEnd(Item item) {

        DoubleNode p = end;
        end = new DoubleNode();
        end.item = item;
        end.prior = p;
        p.next = end;

        N++;
    }

    // �ڱ�βɾ�����
    void deleteEnd() {

        DoubleNode p = end.prior;
        p.next = null;

        N--;

    }

    void insert1(Item item, int x) {// ָ���ڵ�֮ǰ����

        if (x <= 1 || x >= (N + 1)) {
            System.out.println("����λ������");
            return;
        } else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x - 1; y++) {
                p = p.next;
            }
            DoubleNode q = new DoubleNode();
            q.item = item;
            p.next.prior = q;
            q.next = p.next;
            q.prior = p;
            p.next = q;

            N++;
        }
    }

    void insert2(Item item, int x) {// ָ���ڵ�֮�����

        if (x < 1 || x >= N) {
            System.out.println("����λ������");
            return;
        }

        else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x; y++) {
                p = p.next;
            }

            DoubleNode q = new DoubleNode();
            q.item = item;
            p.next.prior = q;
            q.next = p.next;
            q.prior = p;
            p.next = q;

            N++;
        }
    }

    // ɾ��ָ�����
    void delete(int x) {

        if (x == 1 || x == N) {
            System.out.println("ɾ��λ������");
            return;
        }

        else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x - 1; y++) {
                p = p.next;
            }
            p.next = p.next.next;

            N--;
        }

    }

    // ������������н���ֵ��
    void Output() {

        DoubleNode temp = head;
        for (; temp != null; temp = temp.next) {
            System.out.print(temp.item + " ");
        }

        System.out.println();
    }

}

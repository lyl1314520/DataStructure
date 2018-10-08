package Search;

import java.util.Scanner;

/**
 * Title:����
 * Description:������ʽ������ƶ�Ԫ��
 * @author lyl
 * @date 2018��10��4��
 */
public class Linked_Search<Key, Value> {

    private int N;// �ڵ����

    private Node first;// �׽ڵ�

    private Node last;// β�ڵ�

    private class Node {

        Key key;// ĳ������ֵ

        Value val;// ĳ�����ڵ������е�λ��

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
     * ���Ҹ����ļ����ҵ�������λ�ã��������µļ���Ҳ�ɳ���������
     */

    void put(Key key, Value val) {

        Node p;

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        // �ڱ�β���������������
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

    Value get(Key key) {// ���Ҹ�������λ��

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key))
                return x.val;
        }
        return null;
    }

    void delete(Key key) {// ɾ��ָ���ļ�������λ�ø�null��

        if (first.key.equals(key)) {// keyΪ�׽ڵ�
            Node p = first.next;
            System.out.println("ɾ������" + first.val + "�ż�");
            first.val = null;
            first = p;
            N--;
            return;
        }

        for (Node x = first; x != null; x = x.next)// key�����׽ڵ�
            if (x.next.key.equals(key)) {
                Node p = x.next;
                System.out.println("ɾ������" + p.val + "�ż�");
                p.val = null;
                x.next = x.next.next;
                N--;
                return;
            }
        return;// ��ʾ����û�������
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

package Sort;

import java.util.Scanner;

/**
 * Title:ð������
 * Description:��ʽ�ṹʵ�ִ��������������е�Ԫ�ؽ���ð������ 
 * @author lyl
 * @date 2018��10��4��
 */
public class Bubble_Sort<Item> {

    private class Node {

        Node next;
        Item item;
    }

    private int N;

    private Node first, oldfirst;

    Bubble_Sort() {
        N = 0;
        first = new Node();
        first.next = null;
    }

    void create(Item item) {

        Node p = new Node();
        p.item = item;
        if (first.next == null)
            first.next = p;
        else
            oldfirst.next = p;

        oldfirst = p;
        N++;
    }

    int size() {
        return N;
    }

    private Node sort() {

        Node temp = null;
        Node x, y;
        Node q;
        /*
         * ע��ĵط� 1.���ѭ����������N-1 2.temp����ָ����ѭ������������ֵ 3.ÿ��ѭ����temp������ǰ��һ��
         */

        while (first.next.next != temp) {

            for (q = first; q.next.next != temp; q = q.next) {

                if ((Integer) q.next.item > (Integer) q.next.next.item) {

                    x = q.next;
                    y = q.next.next;
                    x.next = y.next;
                    y.next = x;
                    q.next = y;
                }
            }
            temp = q.next;
        }
        return first;
    }

    void output() {

        Node temp = first.next;

        for (; temp != null; temp = temp.next)
            System.out.print(temp.item + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        Bubble_Sort<Integer> sort = new Bubble_Sort<Integer>();

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();

        while (a != 0) {
            sort.create(new Integer(a));
            a = in.nextInt();
        }

        System.out.println("����ǰ");
        sort.output();

        sort.sort();
        System.out.println("�����");
        sort.output();

    }

}

package LinkedList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Title:����
 * Description:���е�˳��ṹ
 * @author lyl
 * @date 2018��10��4��
 */
public class ArrayQueue<Item> implements Iterable {

    private int N = 0;

    private Item[] queue = (Item[]) new Object[1];

    // ������еĴ洢�ռ�
    void Resize(int max) {
        Item[] a = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            a[i] = queue[i];
        }
        queue = a;
    }

    // Ԫ�����
    void Push(Item item) {
        if (N == queue.length) {
            Resize(2 * N);
        }
        queue[N++] = item;
    }

    int Size() {
        return N;
    }

    // �Ӷ���������
    void pushLeft(Item item) {
        for (int i = N; i > 0; i--) {
            queue[i] = queue[i - 1];
        }
        queue[0] = item;
        N++;
    }

    // �Ӷ����Ҳ����
    void pushRight(Item item) {
        Resize(2 * N);
        queue[N] = item;
        N++;
    }

    // �Ӷ���������
    Item popLeft() {
        Item item = queue[0];
        for (int i = 0; i < N - 1; i++)
            queue[i] = queue[i + 1];

        N--;
        return item;
    }

    // �Ӷ����Ҳ����
    Item popRight() {
        Item item = queue[N - 1];
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return (Iterator<Item>) new arrayQueue();
    }

    private class arrayQueue implements Iterator<Item> {

        int i = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return i != N;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            return queue[i++];
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayQueue<String> queue = new ArrayQueue<String>();

        System.out.println("����˫�����");
        String a = in.next();

        while (!a.equals("0")) {

            queue.Push(a);

            a = in.next();
        }

        System.out.println("���г���Ϊ" + queue.Size());

        Iterator<String> j = queue.iterator();

        System.out.println("Ԫ�س���");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println();

        System.out.println("\n������˲���Ԫ��");

        System.out.print("����Ҫ�����Ԫ��: ");

        queue.pushLeft(in.next());

        System.out.println("���г���Ϊ" + queue.Size());

        j = queue.iterator();

        System.out.println("Ԫ�س���");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println();

        System.out.println("\n�����Ҷ˲���Ԫ��");

        System.out.print("����Ҫ�����Ԫ��: ");

        queue.pushRight(in.next());

        System.out.println("���г���Ϊ" + queue.Size() + "\n");

        j = queue.iterator();

        System.out.println("Ԫ�س���");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println("\n\n���ɾ��Ԫ��");

        queue.popLeft();

        System.out.println("���г���Ϊ" + queue.Size());

        j = queue.iterator();

        System.out.println("Ԫ�س���");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println("\n\n�Ҷ�ɾ��Ԫ��");

        queue.popRight();

        System.out.println("���г���Ϊ" + queue.Size());

        j = queue.iterator();

        System.out.println("Ԫ�س���");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }
    }
}

package LinkedList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Title:ջ
 * Description:˳��ṹ�洢ջ
 * @author lyl
 * @date 2018��10��3��
 */
public class ArrayStack<Item> implements Iterable {

    private int N = 0;

    private Item[] a = (Item[]) new Object[1];

    // �ж��Ƿ�ջΪ��
    boolean isEmpty() {
        return N == 0;
    }

    // ջ�Ĵ�С
    int Size() {
        return N;
    }

    // ����ջ�Ĵ洢�ռ�
    void Resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // Ԫ�ؽ�ջ
    void Push(Item item) {

        if (N == a.length)
            Resize(2 * N);

        a[N++] = item;

    }

    Item Pop() {

        Item item = a[--N];
        // a[N] = null;

        return item;
    }

    public Iterator<Item> iterator() {

        return new ArrayIterator();

    }

    private class ArrayIterator implements Iterator<Item> {

        int i = N;

        public boolean hasNext() {
            // TODO Auto-generated method stub
            return i > 0;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            return a[--i];
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        System.out.println("Ԫ����ջ");

        int a = in.nextInt();

        while (a != 0) {

            stack.Push((Integer) a);
            a = in.nextInt();
        }

        System.out.println("ջ�ĳ���Ϊ: " + stack.Size());

        Iterator<Integer> j = stack.iterator();

        Integer integer;

        System.out.println("Ԫ�س�ջ��ʽһ");
        while (!stack.isEmpty()) {

            integer = stack.Pop();
            System.out.println(integer);
        }

        System.out.println("Ԫ�س�ջ��ʽ��");
        while (j.hasNext()) {

            integer = j.next();
            System.out.println(integer);
        }

    }
}

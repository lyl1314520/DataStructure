package LinkedList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Title:栈
 * Description:顺序结构存储栈
 * @author lyl
 * @date 2018年10月3日
 */
public class ArrayStack<Item> implements Iterable {

    private int N = 0;

    private Item[] a = (Item[]) new Object[1];

    // 判断是否栈为空
    boolean isEmpty() {
        return N == 0;
    }

    // 栈的大小
    int Size() {
        return N;
    }

    // 扩大栈的存储空间
    void Resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // 元素进栈
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

        System.out.println("元素入栈");

        int a = in.nextInt();

        while (a != 0) {

            stack.Push((Integer) a);
            a = in.nextInt();
        }

        System.out.println("栈的长度为: " + stack.Size());

        Iterator<Integer> j = stack.iterator();

        Integer integer;

        System.out.println("元素出栈方式一");
        while (!stack.isEmpty()) {

            integer = stack.Pop();
            System.out.println(integer);
        }

        System.out.println("元素出栈方式二");
        while (j.hasNext()) {

            integer = j.next();
            System.out.println(integer);
        }

    }
}

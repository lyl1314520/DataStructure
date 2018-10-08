package LinkedList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Title:队列
 * Description:队列的顺序结构
 * @author lyl
 * @date 2018年10月4日
 */
public class ArrayQueue<Item> implements Iterable {

    private int N = 0;

    private Item[] queue = (Item[]) new Object[1];

    // 增大队列的存储空间
    void Resize(int max) {
        Item[] a = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            a[i] = queue[i];
        }
        queue = a;
    }

    // 元素入队
    void Push(Item item) {
        if (N == queue.length) {
            Resize(2 * N);
        }
        queue[N++] = item;
    }

    int Size() {
        return N;
    }

    // 从队列左侧入队
    void pushLeft(Item item) {
        for (int i = N; i > 0; i--) {
            queue[i] = queue[i - 1];
        }
        queue[0] = item;
        N++;
    }

    // 从队列右侧入队
    void pushRight(Item item) {
        Resize(2 * N);
        queue[N] = item;
        N++;
    }

    // 从队列左侧出队
    Item popLeft() {
        Item item = queue[0];
        for (int i = 0; i < N - 1; i++)
            queue[i] = queue[i + 1];

        N--;
        return item;
    }

    // 从队列右侧出队
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

        System.out.println("创建双向队列");
        String a = in.next();

        while (!a.equals("0")) {

            queue.Push(a);

            a = in.next();
        }

        System.out.println("队列长度为" + queue.Size());

        Iterator<String> j = queue.iterator();

        System.out.println("元素出队");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println();

        System.out.println("\n队列左端插入元素");

        System.out.print("输入要插入的元素: ");

        queue.pushLeft(in.next());

        System.out.println("队列长度为" + queue.Size());

        j = queue.iterator();

        System.out.println("元素出队");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println();

        System.out.println("\n队列右端插入元素");

        System.out.print("输入要插入的元素: ");

        queue.pushRight(in.next());

        System.out.println("队列长度为" + queue.Size() + "\n");

        j = queue.iterator();

        System.out.println("元素出队");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println("\n\n左端删除元素");

        queue.popLeft();

        System.out.println("队列长度为" + queue.Size());

        j = queue.iterator();

        System.out.println("元素出队");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }

        System.out.println("\n\n右端删除元素");

        queue.popRight();

        System.out.println("队列长度为" + queue.Size());

        j = queue.iterator();

        System.out.println("元素出队");

        while (j.hasNext()) {

            System.out.print(j.next() + " ");
        }
    }
}

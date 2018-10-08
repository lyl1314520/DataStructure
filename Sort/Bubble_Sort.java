package Sort;

import java.util.Scanner;

/**
 * Title:冒泡排序
 * Description:链式结构实现创建链表，对链表中的元素进行冒泡排序 
 * @author lyl
 * @date 2018年10月4日
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
         * 注意的地方 1.外层循环次数总是N-1 2.temp总是指向内循环结束后的最大值 3.每次循环后temp总是向前进一步
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

        System.out.println("排序前");
        sort.output();

        sort.sort();
        System.out.println("排序后");
        sort.output();

    }

}

package LinkedList;
import java.util.Scanner;

/**
 *<p>Title:队列
 *<p>Description:链式存储结构，元素入队时，队尾指针后移，出队时队头指针后移，当两个指针相遇时，队列遍历结束
 * @author lyl
 * @date 2018年10月4日
 */
public class LinkedQueue<Item> {

    private int N = 0;

    private class Node {
        Node next;
        Item data;
    }

    Node front;// 队头指针
    Node rear;// 队尾指针

    void init() {
        front = rear = null;
    }

    boolean isEmpty() {
        return front == rear;
    }

    // 元素入队
    void enqueue(Item item) {

        Node temp = new Node();
        temp.data = item;
        if (rear == null) {
            rear = temp;
            front = rear;
        }

        else {
            // 如果这两条语句互换的话，链表就会断开
            rear.next = temp;
            rear = rear.next;
        }

        N++;
    }

    void setNull() {
        rear.next = null;
        rear = rear.next;
    }

    // 队列长度
    int size() {
        return N;
    }

    // 元素出队
    Item dequeue() {

        Item item = front.data;
        front = front.next;

        return item;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.init();

        System.out.println("元素入队");
        int a = in.nextInt();
        while (a != 0) {
            Integer integer = new Integer(a);
            queue.enqueue(integer);
            a = in.nextInt();
        }

        System.out.println("队列长度\n" + queue.size());

        queue.setNull();
        System.out.println("元素出队");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

    }

}

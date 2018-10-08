package LinkedList;
import java.util.Scanner;

/**
 *<p>Title:����
 *<p>Description:��ʽ�洢�ṹ��Ԫ�����ʱ����βָ����ƣ�����ʱ��ͷָ����ƣ�������ָ������ʱ�����б�������
 * @author lyl
 * @date 2018��10��4��
 */
public class LinkedQueue<Item> {

    private int N = 0;

    private class Node {
        Node next;
        Item data;
    }

    Node front;// ��ͷָ��
    Node rear;// ��βָ��

    void init() {
        front = rear = null;
    }

    boolean isEmpty() {
        return front == rear;
    }

    // Ԫ�����
    void enqueue(Item item) {

        Node temp = new Node();
        temp.data = item;
        if (rear == null) {
            rear = temp;
            front = rear;
        }

        else {
            // �����������以���Ļ�������ͻ�Ͽ�
            rear.next = temp;
            rear = rear.next;
        }

        N++;
    }

    void setNull() {
        rear.next = null;
        rear = rear.next;
    }

    // ���г���
    int size() {
        return N;
    }

    // Ԫ�س���
    Item dequeue() {

        Item item = front.data;
        front = front.next;

        return item;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.init();

        System.out.println("Ԫ�����");
        int a = in.nextInt();
        while (a != 0) {
            Integer integer = new Integer(a);
            queue.enqueue(integer);
            a = in.nextInt();
        }

        System.out.println("���г���\n" + queue.size());

        queue.setNull();
        System.out.println("Ԫ�س���");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

    }

}

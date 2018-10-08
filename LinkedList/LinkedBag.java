package LinkedList;

import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

/**
 * Title:����
 * Description:��ʽ���
 * @author lyl
 * @date 2018��10��4��
 */
public class LinkedBag<Item> implements Iterable<Item> {

    private int N;

    private Node<Item> first;

    private class Node<Item> {

        Node<Item> next;
        Item item;
    }

    LinkedBag() {

        first = null;
        N = 0;
    }

    // �жϱ����Ƿ��ÿ�
    boolean isEmpty() {
        return first == null;
    }

    int size() {
        return N;
    }

    // �����������Ԫ��
    void add(Item item) {

        Node<Item> temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;

        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new IteratorBag();
    }

    private class IteratorBag implements Iterator<Item> {

        Node<Item> current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        LinkedBag<Double> bag = new LinkedBag<Double>();

        double a = in.nextDouble();
        while (a != 0.0) {

            bag.add(a);
            a = in.nextDouble();
        }

        System.out.println("size of the bag:" + " " + bag.size());

        Iterator Bag = bag.iterator();

        while (Bag.hasNext()) {
            System.out.println(Bag.next());
        }

    }

}
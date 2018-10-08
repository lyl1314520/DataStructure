package LinkedList;

import java.util.Scanner;

/**
 * Title:双向队列
 * Description:链式存储结构创建，输出双向队列
 * @author lyl
 * @date 2018年10月4日
 */
public class DoubleDirectedLinkedList<Item> {

    private int N = 0;

    DoubleNode head, end;// 表头指针和表尾指针

    private class DoubleNode {

        DoubleNode prior;

        DoubleNode next;

        Item item;
    }

    void create(Item item) {

        DoubleNode p = new DoubleNode();
        p.item = item;
        if (head == null) {
            head = p;
            end = p;
        }

        else {
            p.prior = end;
            end.next = p;
            end = p;
        }

        N++;
    }

    // 链表长度
    int size() {
        return N;
    }

    // 在表头插入元素
    void insertHead(Item item) {

        DoubleNode p = head;
        head = new DoubleNode();
        head.item = item;
        p.prior = head;
        head.next = p;

        N++;
    }

    // 删除表头
    void deleteHead() {

        head = head.next;
        N--;
    }

    // 在表尾插入结点
    void insertEnd(Item item) {

        DoubleNode p = end;
        end = new DoubleNode();
        end.item = item;
        end.prior = p;
        p.next = end;

        N++;
    }

    // 在表尾删除结点
    void deleteEnd() {

        DoubleNode p = end.prior;
        p.next = null;

        N--;

    }

    void insert1(Item item, int x) {// 指定节点之前插入

        if (x <= 1 || x >= (N + 1)) {
            System.out.println("插入位置有误");
            return;
        } else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x - 1; y++) {
                p = p.next;
            }
            DoubleNode q = new DoubleNode();
            q.item = item;
            p.next.prior = q;
            q.next = p.next;
            q.prior = p;
            p.next = q;

            N++;
        }
    }

    void insert2(Item item, int x) {// 指定节点之后插入

        if (x < 1 || x >= N) {
            System.out.println("插入位置有误");
            return;
        }

        else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x; y++) {
                p = p.next;
            }

            DoubleNode q = new DoubleNode();
            q.item = item;
            p.next.prior = q;
            q.next = p.next;
            q.prior = p;
            p.next = q;

            N++;
        }
    }

    // 删除指定结点
    void delete(int x) {

        if (x == 1 || x == N) {
            System.out.println("删除位置有误");
            return;
        }

        else {
            int y = 1;
            DoubleNode p = head;
            for (; y < x - 1; y++) {
                p = p.next;
            }
            p.next = p.next.next;

            N--;
        }

    }

    // 输出链表中所有结点的值域
    void Output() {

        DoubleNode temp = head;
        for (; temp != null; temp = temp.next) {
            System.out.print(temp.item + " ");
        }

        System.out.println();
    }

}

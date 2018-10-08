package Sort;

import java.io.*;

/*
 * Title:堆排序
 * Description:二叉堆是一棵完全二叉树，并且子节点都不大于父节点。 
 * @author lyl
 * @date 2018年10月4日
 */
public class Heap_Sort<Key extends Comparable<Key>> {

    private Key[] data;

    private int count;// 记录元素个数

    Heap_Sort(int capacity) {

        data = (Key[]) new Comparable[capacity + 1];

        count = 0;
    }

    void insert(Key key) {// 先构建，后建堆

        data[count + 1] = key;
        count++;
    }

    void buildHeap() {// 插入完元素后，建堆

        int k = count / 2;
        while (k >= 1) {

            int i = 2 * k;
            int j = i;
            if ((j + 1 <= count) && less(data[j], data[j + 1]) == -1)
                j++;
            if (less(data[k], data[j]) == -1)
                exch(data, j, k);
            k--;
        }
    }

    void swim(Key[] a, int k) {// 上浮函数，元素自下而上排序使之满足二叉堆的定义

        while (k > 1) {

            if (less(a[k / 2], a[k]) == -1)
                exch(a, k / 2, k);
            k = k / 2;
        }

    }

    void sink(int k) {// 下沉函数，元素自上而下排序使之满足二叉堆的定义

        while (2 * k <= count) {

            int j = 2 * k;

            // 筛选出a[2*k]，a[2*k+1]的最大值
            if (j < count && less(data[j], data[j + 1]) == -1)
                j++;

            if (!(less(data[k], data[j]) == -1))
                break;// 当a[k]>=a[j],循环终止

            exch(data, k, j); // 交换父节点和键值最大的子节点

            k = j;
        }
    }

    Key delmax() {// 返回并删除堆中键值最大的节点

        Key max = data[1];// 获得根节点
        exch(data, 1, count);// 交换根节点和最后一个节点，此时堆变得无序
        data[count] = null;// 防治对象游离
        count--;
        sink(1);
        return max;
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == data.length - 1;
    }

    int less(Key v, Key w) {
        return v.compareTo(w);
    }

    void exch(Key[] a, int i, int j) {

        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    boolean isSorted(int k) {

        for (int i = k; i <= count / 2; i++) {

            int j = 2 * i;
            if (j + 1 <= count && ((less(data[k], data[j]) == -1) || (less(data[k], data[j + 1]) == -1)))
                return false;
            if (less(data[k], data[j]) == -1)
                return false;
        }
        return true;
    }

    void Output() {

        for (int i = 1; i <= count; i++)
            System.out.print("data[" + i + "]=" + data[i] + "  ");

    }

    private void sort(Key[] a) {// 堆排序

        int N = count;
        for (int i = N / 2; i >= 1; i--)// 构建好了堆
            sink(a, i, N);
        if (isSorted(1)) {// 实行堆排序，使整个数组有序
            while (N > 1) {
                exch(a, 1, N--);
                sink(a, 1, N);
            }
        } else
            System.out.println("不是最大堆");

    }

    void sink(Key[] a, int k, int n) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a[j], a[j + 1]) == -1)
                j++;
            if ((Integer) a[k] >= (Integer) a[j])
                break;

            exch(a, j, k);
            k = j;
        }

    }
}

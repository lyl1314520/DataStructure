package Sort;

import java.io.*;

/*
 * Title:������
 * Description:�������һ����ȫ�������������ӽڵ㶼�����ڸ��ڵ㡣 
 * @author lyl
 * @date 2018��10��4��
 */
public class Heap_Sort<Key extends Comparable<Key>> {

    private Key[] data;

    private int count;// ��¼Ԫ�ظ���

    Heap_Sort(int capacity) {

        data = (Key[]) new Comparable[capacity + 1];

        count = 0;
    }

    void insert(Key key) {// �ȹ������󽨶�

        data[count + 1] = key;
        count++;
    }

    void buildHeap() {// ������Ԫ�غ󣬽���

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

    void swim(Key[] a, int k) {// �ϸ�������Ԫ�����¶�������ʹ֮�������ѵĶ���

        while (k > 1) {

            if (less(a[k / 2], a[k]) == -1)
                exch(a, k / 2, k);
            k = k / 2;
        }

    }

    void sink(int k) {// �³�������Ԫ�����϶�������ʹ֮�������ѵĶ���

        while (2 * k <= count) {

            int j = 2 * k;

            // ɸѡ��a[2*k]��a[2*k+1]�����ֵ
            if (j < count && less(data[j], data[j + 1]) == -1)
                j++;

            if (!(less(data[k], data[j]) == -1))
                break;// ��a[k]>=a[j],ѭ����ֹ

            exch(data, k, j); // �������ڵ�ͼ�ֵ�����ӽڵ�

            k = j;
        }
    }

    Key delmax() {// ���ز�ɾ�����м�ֵ���Ľڵ�

        Key max = data[1];// ��ø��ڵ�
        exch(data, 1, count);// �������ڵ�����һ���ڵ㣬��ʱ�ѱ������
        data[count] = null;// ���ζ�������
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

    private void sort(Key[] a) {// ������

        int N = count;
        for (int i = N / 2; i >= 1; i--)// �������˶�
            sink(a, i, N);
        if (isSorted(1)) {// ʵ�ж�����ʹ������������
            while (N > 1) {
                exch(a, 1, N--);
                sink(a, 1, N);
            }
        } else
            System.out.println("��������");

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

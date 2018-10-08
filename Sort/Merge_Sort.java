package Sort;

import java.util.Scanner;

/**
 * Title:�鲢����
 * <p>
 * Description:
 * @author lyl
 * @date 2018��10��4��
 */
public class Merge_Sort implements Comparable {

    long begin, end;

    Comparable[] a = { 8, 14, 15, 1, 6, 23 };

    Comparable[] aux;

    int Count = 0;// Count��¼����������Եĸ���Count=8;

    public Merge_Sort() {

    }

    void init() {
        aux = new Comparable[a.length];
        this.sort(a, 0, a.length - 1);
    }

    void sort(Comparable[] a2, int lo, int lg) { // �Զ�����

        if (lg <= lo)
            return;

        begin = System.currentTimeMillis();
        int mid = lo + (lg - lo) / 2;
        sort(a2, lo, mid);// ����벿������
        sort(a2, mid + 1, lg);// ���Ұ벿������
        if ((Integer) a2[mid] > (Integer) a2[mid + 1])
            merge(a2, lo, mid, lg);// �鲢���

        end = System.currentTimeMillis();
    }

    void merge(Comparable[] a, int lo, int mid, int lg) {

        // ��a[lo...mid]��a[mid+1,lg]�������кϲ�

        int i = lo;
        int j = mid + 1;
        int x = mid + 1;
        for (int k = lo; k <= lg; k++)
            aux[k] = a[k];

        for (int k = lo; k <= lg; k++)

            if (i > mid)
                a[k] = aux[j++];
            else if (j > lg)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) {

                a[k] = aux[j++];
                Count = Count + x;
            }

            else {
                a[k] = aux[i++];
                x--;
            }
    }

    boolean less(Comparable v, Comparable w) {
        return (Integer) v < (Integer) w;
    }

    void sort(Comparable[] a) {// �Ե�����

        int N = a.length;

        for (int sz = 1; sz < N; sz = sz * 2) {

            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }

    }

    boolean isSorted() {

        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }

    void output() {

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "  ");

        System.out.println();
    }

    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

}
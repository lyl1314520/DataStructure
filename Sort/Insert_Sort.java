package Sort;

import java.util.Scanner;

/**
 * Title:插入排序
 * Description:
 * @author lyl
 * @date 2018年10月4日
 */
public class Insert_Sort implements Comparable {

    Comparable[] a = { 24, 63, 16, 30, 24, 9, 77, 36, 90, 56 };

    long start, end;

    void Output() {

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    boolean less(Comparable v, Comparable w) {
        return (Integer) v > (Integer) w;
    }

    void exch(int i, int j) {

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    boolean isSorted() {

        for (int i = 1; i < a.length; i++)
            if (less(a[i - 1], a[i]))
                return false;

        return true;
    }

    void Sort() {

        start = System.currentTimeMillis();
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j - 1], a[j]); j--)
                this.exch(j - 1, j);
        }

        end = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Object that) {
        // TODO Auto-generated method stub
        return 0;
    }

}

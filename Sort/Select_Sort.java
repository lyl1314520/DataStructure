package Sort;

import java.util.Scanner;

/**
 * Title:选择排序
 * @author lyl
 * @date 2018年10月4日
 */
public class Select_Sort implements Comparable {

    Comparable[] a;
    // long start,end;

    public Select_Sort() {

        int N = 400;// 当待排列的数组元素达到400以上时，排序算法时间突出明显
        a = new Comparable[N];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 2000);
        }
    }

    void output() {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    boolean less(Comparable v, Comparable w) {
        return (Integer) v < (Integer) w;
    }

    void exch(int i, int j) {

        Comparable t = a[i];

        a[i] = a[j];

        a[j] = t;
    }

    boolean isSorted() {

        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }

    void sort() {

        long start = System.currentTimeMillis();

        System.out.println(start);

        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            this.exch(i, min);
        }
        long end = System.currentTimeMillis();

        System.out.println(end);
        System.out.println("算法用时 " + (end - start) + "ms");
    }

    @Override
    public int compareTo(Object that) {
        // TODO Auto-generated method stub
        return 0;
    }

}

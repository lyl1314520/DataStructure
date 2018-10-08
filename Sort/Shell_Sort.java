package Sort;

/**
 * Title:希尔排序
 * Description:
 * @author lyl
 * @date 2018年10月4日
 */
public class Shell_Sort implements Comparable {

    Comparable[] a = { 24, 63, 16, 30, 24, 9, 77, 36, 90, 56 };

    long start, end;

    void output() {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

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

        start = System.currentTimeMillis();
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = h * 3 + 1;

        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {

                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(j, j - h);
                }
            }
            h = h / 3;
        }
        end = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

}

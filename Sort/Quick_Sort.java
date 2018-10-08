package Sort;

import java.util.Scanner;

/**
 * Title:快速排序
 * Description:选取某个值为基准值，其左边元素均不大于它，其右边元素均不小于它，再对左右两边元素
 * @author lyl
 * @date 2018年10月4日
 */
public class Quick_Sort {

    int[] data = { 24, 63, 16, 30, 24, 9 };

    int count = 0;

    void Quick3Ways(int[] data, int p, int r) {// 3路排序算法

        if (p >= r)
            return;

        int lt = p;// data[p...lt]<v;
        int gt = r;// data[gt...r]>v;
        int i = p + 1;// data[lt+1...i)=v;

        int v = data[p];

        while (i <= gt) {

            if ((Integer) data[i] < (Integer) v) {
                this.exch(data, lt++, i++);
            }

            else if ((Integer) data[i] > (Integer) v) {
                this.exch(data, i, gt--);
            }

            else
                i++;
        } // 现在data[p...lt-1]<v=data[lt...gt]<data[gt+1...r]

        Quick3Ways(data, p, lt - 1);

        Quick3Ways(data, gt + 1, r);
    }

    void Output() {

        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");

        System.out.println();
    }

    void exch(int[] data2, int i, int j) {

        int temp = data2[i];

        data2[i] = data2[j];

        data2[j] = temp;
    }

    boolean less(int v, int w) {
        return v < w;
    }

    void sort(int[] data, int lo, int lg) {

        if (lo >= lg)
            return;
        long begin = System.currentTimeMillis();
        int p = partition2(data, lo, lg);

        sort(data, lo, p - 1);// 排列p左边的数组元素，使之有序

        sort(data, p + 1, lg);// 排列p右边的元素，使之有序

        long end = System.currentTimeMillis();

    }

    int partition2(int[] data, int p, int r) {// j具有的额性质:data[p..j-1]<=data[j],data[j+1...r]<=data[j];

        int v = data[p];
        int i = p;
        int j = r + 1;
        while (true) {

            while (this.less(data[++i], v)) {// 自左向右扫描，找到一个data[i]不小于v
                if (i == r)
                    break;
                count++;
            }
            count++;
            while (this.less(v, data[--j])) {// 自右向左扫描，找到一个data[j]不大于v

                if (j == p)
                    break;
                count++;

            }
            count++;
            if (i >= j)
                break;// 当i,j指针相遇时，循环结束,
            this.exch(data, i, j);// 交换data[i]和data[j]
        }

        this.exch(data, p, j);
        return j;
    }

    boolean isSorted(int[] data) {

        for (int i = 1; i < data.length; i++)
            if (this.less(data[i], data[i - 1]))
                return false;

        return true;
    }
}

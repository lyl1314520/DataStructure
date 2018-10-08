package Sort;

import java.util.Scanner;

/**
 * Title:��������
 * Description:ѡȡĳ��ֵΪ��׼ֵ�������Ԫ�ؾ��������������ұ�Ԫ�ؾ���С�������ٶ���������Ԫ��
 * @author lyl
 * @date 2018��10��4��
 */
public class Quick_Sort {

    int[] data = { 24, 63, 16, 30, 24, 9 };

    int count = 0;

    void Quick3Ways(int[] data, int p, int r) {// 3·�����㷨

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
        } // ����data[p...lt-1]<v=data[lt...gt]<data[gt+1...r]

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

        sort(data, lo, p - 1);// ����p��ߵ�����Ԫ�أ�ʹ֮����

        sort(data, p + 1, lg);// ����p�ұߵ�Ԫ�أ�ʹ֮����

        long end = System.currentTimeMillis();

    }

    int partition2(int[] data, int p, int r) {// j���еĶ�����:data[p..j-1]<=data[j],data[j+1...r]<=data[j];

        int v = data[p];
        int i = p;
        int j = r + 1;
        while (true) {

            while (this.less(data[++i], v)) {// ��������ɨ�裬�ҵ�һ��data[i]��С��v
                if (i == r)
                    break;
                count++;
            }
            count++;
            while (this.less(v, data[--j])) {// ��������ɨ�裬�ҵ�һ��data[j]������v

                if (j == p)
                    break;
                count++;

            }
            count++;
            if (i >= j)
                break;// ��i,jָ������ʱ��ѭ������,
            this.exch(data, i, j);// ����data[i]��data[j]
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

package Search;

import java.util.Scanner;

/**
 * Title:���ֲ���
 * @author lyl
 * @date 2018��10��4��
 */
public class Binary_Search<Key extends Comparable<Key>, Value> {

    private Key[] keys;// Ԫ�صļ�ֵ

    private Value[] vals;// Ԫ�ص�λ��

    private int N;

    public Binary_Search(int capacity) {

        keys = (Key[]) new Comparable[capacity];

        vals = (Value[]) new Object[capacity];

        N = 0;
    }

    int size() {
        return N;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull() {
        return N == keys.length;
    }

    /*
     * ������������Ĳ���(����),����ָ��Ԫ�ص�λ��
     */

    int rank(Key key) {

        int lo = 0, hi = N - 1;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;// ���lo,hi,����int�е����ֵ mid =
                                         // (lo+lg)/2���׳�Խ����쳣
            int temp = key.compareTo(keys[mid]);
            if (temp < 0)
                hi = mid - 1;
            else if (temp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    /*
     * ���Ҽ���λ��
     */
    Value get(Key key) {

        if (isEmpty())
            return null;

        int i = rank(key);

        if ((i >= 0 && i < N) && keys[i].equals(key))
            return vals[i];

        else
            return null;
    }

    /*
     * ���Ҽ����ҵ��͸���ֵ���������
     */

    void Put(Key key, Value val) {

        int i = rank(key);
        if (i < N && keys[i].equals(key)) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;

        N++;
    }

    // ɾ��ָ���ļ�������λ�ø���
    void delete(Key key) {

        int i = rank(key);
        if ((i >= 0 && i < N) && keys[i].equals(key)) {
            int j = i;
            for (; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }

            N--;
            return;
        }
        System.out.println(key + "����������");
    }
}

package Search;

import java.util.Scanner;

/**
 * Title:二分查找
 * @author lyl
 * @date 2018年10月4日
 */
public class Binary_Search<Key extends Comparable<Key>, Value> {

    private Key[] keys;// 元素的键值

    private Value[] vals;// 元素的位置

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
     * 基于有序数组的查找(迭代),查找指定元素的位置
     */

    int rank(Key key) {

        int lo = 0, hi = N - 1;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;// 如果lo,hi,都是int中的最大值 mid =
                                         // (lo+lg)/2会抛出越界的异常
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
     * 查找键的位置
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
     * 查找键，找到就更新值，否则插入
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

    // 删除指定的键，将其位置赋空
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
        System.out.println(key + "不在数组中");
    }
}

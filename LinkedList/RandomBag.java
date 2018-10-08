package LinkedList;

import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.math.*;

/**
 * Title:随机背包
 * Description:
 * @author lyl
 * @date 2018年10月4日
 */
public class RandomBag<T> implements Iterable {

    private T[] mArray = (T[]) new Object[1];

    private int mBagSize = 0;

    T[] a;

    void Init(T item) {

        a = (T[]) new Object[mBagSize];

        for (int i = 0; i < a.length; i++) {
            a[i] = item;
        }

    }

    public void add(T t) {

        if (mArray.length == mBagSize) {
            ensureCapacity(2 * mBagSize);
        }

        mArray[mBagSize] = t;
        mBagSize++;
    }

    int Size() {
        return mBagSize;
    }

    boolean isEmpty() {
        return mBagSize == 0;
    }

    // 扩大背包空间
    private void ensureCapacity(int newCapacity) {

        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < mArray.length; i++) {
            newArray[i] = mArray[i];
        }

        mArray = newArray;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int currentPositon;

        int N = mBagSize;

        @Override
        public boolean hasNext() {

            currentPositon = (int) (Math.random() * N);
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals(mArray[currentPositon]))
                    return false;
            }
            a[currentPositon] = mArray[currentPositon];
            mBagSize--;

            return true;
        }

        @Override
        public T next() {
            return mArray[currentPositon];

        }

    }

    public static void main(String[] args) {

        RandomBag<String> bag = new RandomBag<String>();

        Scanner in = new Scanner(System.in);

        System.out.println("创建背包");

        String a = in.next();

        while (!a.equals("0")) {

            bag.add(a);

            a = in.next();
        }

        System.out.println("背包大小为: " + bag.Size());

        Iterator<String> j = bag.iterator();

        String b = "0";

        bag.Init(b);

        System.out.println("元素随机出背包");

        while (!bag.isEmpty()) {
            if (j.hasNext())
                System.out.print(j.next() + " ");
        }

        System.out.println();

    }
}
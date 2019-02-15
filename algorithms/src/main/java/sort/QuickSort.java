package sort;

public class QuickSort {
    public void sort(int[] a) {
        int pivot =  a[0];
        sort(a, 0, a.length -1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int key = a[lo];
        while (true) {
            while (less(a[++i], key)) {
                if (i == hi) break;
            }
            while (less(a[--j], key)) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i,j);
        }
        exch(a, lo, j);
        return j;


    }

    private boolean less(int a, int b) {
        return a < b ? true : false;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[j] = a[i];
        a[i] = tmp;
    }

    public int select(int[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j == k) return a[k];
            else if (k < j) hi = j -1;
            else if (k > j) lo = j + 1;
        }
        return a[k];
    }
}

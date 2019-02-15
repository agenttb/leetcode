package sort;

public class MergeSort {
    private int[] aux;
    public void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length -1);
    }

    public void sort(int[] a, int lo, int hi) {
        if (lo <= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public void sort1(int[] a) {
        int N = a.length;
        aux = new int[a.length];
        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N -sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}

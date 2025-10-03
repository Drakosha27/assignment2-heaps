package algorithms;

import metrics.PerformanceTracker;
import java.util.*;

public class MaxHeap<T extends Comparable<T>> {
    private final List<T> a = new ArrayList<>();
    private final PerformanceTracker tracker;

    public MaxHeap(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public int size() { return a.size(); }
    public boolean isEmpty() { return a.isEmpty(); }

    public void insert(T x) {
        a.add(x);
        siftUp(a.size() - 1);
    }

    public T peekMax() {
        if (a.isEmpty()) return null;
        return a.get(0);
    }

    public T extractMax() {
        if (a.isEmpty()) return null;
        T max = a.get(0);
        T last = a.remove(a.size() - 1);
        if (!a.isEmpty()) {
            a.set(0, last);
            siftDown(0);
        }
        return max;
    }

    public void increaseKey(int index, T newValue) {
        checkIndex(index);
        T old = a.get(index);
        if (compare(newValue, old) < 0) {
            throw new IllegalArgumentException("newValue must be >= current value");
        }
        a.set(index, newValue);
        siftUp(index);
    }

    public void buildFrom(Collection<T> items) {
        a.clear();
        a.addAll(items);
        heapify();
    }

    private void heapify() {
        for (int i = parent(a.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp(int i) {
        while (i > 0) {
            int p = parent(i);
            if (compare(a.get(i), a.get(p)) > 0) {
                swap(i, p);
                i = p;
            } else break;
        }
    }

    private void siftDown(int i) {
        int n = a.size();
        while (true) {
            int l = left(i), r = right(i), largest = i;
            if (l < n && compare(a.get(l), a.get(largest)) > 0) largest = l;
            if (r < n && compare(a.get(r), a.get(largest)) > 0) largest = r;
            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else break;
        }
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private int compare(T x, T y) {
        tracker.incComparisons();
        return Objects.compare(x, y, Comparable::compareTo);
    }

    private void swap(int i, int j) {
        tracker.incSwaps();
        T tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= a.size()) throw new IndexOutOfBoundsException("index=" + i);
    }
}

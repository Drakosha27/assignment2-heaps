package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {
    @Test
    void insertAndExtractSorted() {
        PerformanceTracker tr = new PerformanceTracker();
        MinHeap<Integer> h = new MinHeap<>(tr);
        int[] arr = {5, 1, 3, 3, -2, 9};
        for (int x : arr) h.insert(x);

        int[] out = new int[arr.length];
        int i = 0;
        Integer v;
        while ((v = h.extractMin()) != null) out[i++] = v;
        assertArrayEquals(new int[]{-2,1,3,3,5,9}, out);
    }

    @Test
    void decreaseKeyWorks() {
        PerformanceTracker tr = new PerformanceTracker();
        MinHeap<Integer> h = new MinHeap<>(tr);
        h.insert(10);
        h.insert(20);
        h.insert(30);
        h.decreaseKey(2, 0);
        assertEquals(0, h.peekMin());
    }

    @Test
    void mergeHeaps() {
        PerformanceTracker tr = new PerformanceTracker();
        MinHeap<Integer> a = new MinHeap<>(tr);
        MinHeap<Integer> b = new MinHeap<>(tr);
        a.buildFrom(Arrays.asList(5,7,9));
        b.buildFrom(Arrays.asList(1,2,3));
        a.merge(b);
        assertEquals(6, a.size());
        assertEquals(1, a.peekMin());
    }
}

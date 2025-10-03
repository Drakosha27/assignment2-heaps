package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    @Test
    void insertAndExtractSortedDesc() {
        PerformanceTracker tr = new PerformanceTracker();
        MaxHeap<Integer> h = new MaxHeap<>(tr);
        int[] arr = {5, 1, 3, 3, -2, 9};
        for (int x : arr) h.insert(x);

        int[] out = new int[arr.length];
        int i = 0; Integer v;
        while ((v = h.extractMax()) != null) out[i++] = v;
        assertArrayEquals(new int[]{9,5,3,3,1,-2}, out);
    }

    @Test
    void increaseKeyWorks() {
        PerformanceTracker tr = new PerformanceTracker();
        MaxHeap<Integer> h = new MaxHeap<>(tr);
        h.insert(10);
        h.insert(20);
        h.insert(15);
        h.increaseKey(0, 100);
        assertEquals(100, h.peekMax());
    }

    @Test
    void buildFrom() {
        PerformanceTracker tr = new PerformanceTracker();
        MaxHeap<Integer> h = new MaxHeap<>(tr);
        h.buildFrom(Arrays.asList(1,2,3,4,5));
        assertEquals(5, h.size());
        assertEquals(5, h.peekMax());
    }
}

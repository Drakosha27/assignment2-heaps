# Individual Analysis Report — Partner’s Algorithm (MinHeap)
**Student (B): Shakalova Diana**  
**Partner (A): Nurzhaina Kuralbay**  
**Course:** Assignment 2 (Pair 4 — Heaps)

## 1. Algorithm Overview
MinHeap: array-based binary heap; operations insert, peekMin, extractMin, decreaseKey, buildFrom, merge.

## 2. Complexity
peek O(1); insert/extract/decreaseKey O(log n); buildFrom Θ(n); merge via heapify Θ(n+m).

## 3. Correctness
Heap property a[parent(i)] ≤ a[i]; maintained by siftUp/siftDown; decreaseKey only upward.

## 4. Code Review
Generics, centralized comparisons/swaps, heapify; suggest index map for decreaseKey(key,new), docs on non-stability.

## 5. Empirics
Use docs/performance-plots/heaps.csv; plot n vs nanos; expect ~ n log n.

## 6. Conclusion
Correct, matches theory; ergonomic improvements possible.

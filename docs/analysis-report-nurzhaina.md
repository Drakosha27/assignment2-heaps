# Individual Analysis Report — Partner’s Algorithm (MaxHeap)
**Student (A): Nurzhaina Kuralbay**  
**Partner (B): Shakalova Diana**  
**Course:** Assignment 2 (Pair 4 — Heaps)

## 1. Algorithm Overview
MaxHeap: array-based binary heap; insert, peekMax, extractMax, increaseKey, buildFrom.

## 2. Complexity
peek O(1); insert/extract/increaseKey O(log n); buildFrom Θ(n).

## 3. Correctness
Heap property a[parent(i)] ≥ a[i]; maintained by siftUp/siftDown; increaseKey only upward.

## 4. Code Review
Clear generics, metrics; suggest locator map for key updates; optional primitive versions.

## 5. Empirics
Use CSV; expect ~ n log n.

## 6. Conclusion
Correct and efficient; improvements for ergonomics possible.

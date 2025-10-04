# Joint Pair Report — MinHeap vs MaxHeap
**Pair 4** — A: Nurzhaina (MinHeap), B: Diana (MaxHeap)

## Theory
Same asymptotics: peek Θ(1); insert/extract/update O(log n); buildFrom Θ(n); merge Θ(n+m).

## Empirics (fill with your numbers)
Insert your median times from heaps.csv; include plots for Min/Max.

## Code Quality
Shared: generics, metrics, heapify. Improvements: locator map, docs on non-stability.

## Recommendation
Choose Min/Max by required priority semantics; for heavy key-updates consider pairing/Fibonacci (out of scope).

# Assignment 2 — Pair 4

This repo contains **MinHeap** (with `decreaseKey`, `merge`) and **MaxHeap** (with `increaseKey`, `extractMax`), test suite, and a CLI benchmark that exports CSV for plots.

## Build & Test
```bash
mvn -q -DskipTests=false test
```

## Benchmark (CSV → docs/performance-plots/heaps.csv)
```bash
mvn -q -DskipTests=true package
java -jar target/assignment2-heaps-1.0.0.jar --alg=both --sizes=100,1000,10000,100000 --trials=3 --out=docs/performance-plots/heaps.csv
```

Open the CSV in Excel/Google Sheets to plot **time vs n** (log scale optional).

## Structure (per assignment spec)
- `src/main/java/algorithms/MinHeap.java`, `MaxHeap.java`
- `src/main/java/metrics/PerformanceTracker.java`
- `src/main/java/cli/BenchmarkRunner.java`
- `src/test/java/algorithms/*Test.java`
- `docs/analysis-report.pdf` (your individual report on partner’s algorithm)
- `docs/performance-plots/` (CSV and exported images)
- `docs/pair-comparison.md` (joint pair summary)
- `README.md`, `pom.xml`

## Notes
- Complexity: all operations are **O(log n)** except `merge` (implemented as `addAll + heapify`, which is **O(n)**).
- Tests cover edge cases (empty, single element, duplicates).

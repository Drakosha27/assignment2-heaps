package cli;

import algorithms.MinHeap;
import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        String algorithm = argValue(args, "--alg", "both"); // "min", "max", "both"
        int[] sizes = parseSizes(argValue(args, "--sizes", "100,1000,10000,100000"));
        int trials = Integer.parseInt(argValue(args, "--trials", "3"));
        String out = argValue(args, "--out", "docs/performance-plots/heaps.csv");

        Path outPath = Paths.get(out);
        if (Files.notExists(outPath.getParent())) {
            Files.createDirectories(outPath.getParent());
        }

        List<String> lines = new ArrayList<>();
        lines.add(PerformanceTracker.csvHeader());

        Random rnd = new Random(42);

        if (algorithm.equals("min") || algorithm.equals("both")) {
            for (int n : sizes) {
                for (int t = 0; t < trials; t++) {
                    int[] data = randomArray(n, rnd);
                    PerformanceTracker tr = new PerformanceTracker();
                    MinHeap<Integer> heap = new MinHeap<>(tr);
                    long start = System.nanoTime();
                    for (int x : data) heap.insert(x);
                    while (!heap.isEmpty()) heap.extractMin();
                    long end = System.nanoTime();
                    lines.add(tr.toCsvRow("MinHeap", n, (end - start)));
                }
            }
        }

        if (algorithm.equals("max") || algorithm.equals("both")) {
            for (int n : sizes) {
                for (int t = 0; t < trials; t++) {
                    int[] data = randomArray(n, rnd);
                    PerformanceTracker tr = new PerformanceTracker();
                    MaxHeap<Integer> heap = new MaxHeap<>(tr);
                    long start = System.nanoTime();
                    for (int x : data) heap.insert(x);
                    while (!heap.isEmpty()) heap.extractMax();
                    long end = System.nanoTime();
                    lines.add(tr.toCsvRow("MaxHeap", n, (end - start)));
                }
            }
        }

        Files.write(outPath, lines);
        System.out.println("CSV saved to: " + out);
    }

    private static String argValue(String[] args, String key, String def) {
        for (String a : args) {
            if (a.startsWith(key + "=")) return a.substring((key + "=").length());
        }
        return def;
    }

    private static int[] parseSizes(String s) {
        String[] parts = s.split(",");
        int[] r = new int[parts.length];
        for (int i = 0; i < parts.length; i++) r[i] = Integer.parseInt(parts[i].trim());
        return r;
    }

    private static int[] randomArray(int n, Random rnd) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
        return a;
    }
}

package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public static String csvHeader() {
        return "algorithm,n,size,comparisons,swaps,nanos";
    }

    public String toCsvRow(String algorithm, int n, long nanos) {
        return algorithm + "," + n + "," + comparisons + "," + swaps + "," + nanos;
    }
}

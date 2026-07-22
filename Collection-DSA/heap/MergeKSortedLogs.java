import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLogs {
    private static class Entry {
        int sourceIndex;
        int elementIndex;
        LogEntry logEntry;

        Entry(int sourceIndex, int elementIndex, LogEntry logEntry) {
            this.sourceIndex = sourceIndex;
            this.elementIndex = elementIndex;
            this.logEntry = logEntry;
        }
    }

    public static class LogEntry {
        public long timestamp;
        public String message;

        public LogEntry(long timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    public List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.logEntry.timestamp, b.logEntry.timestamp));
        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                LogEntry first = sources.get(i).get(0);
                minHeap.offer(new Entry(i, 0, first));
            }
        }

        List<LogEntry> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Entry top = minHeap.poll();
            merged.add(top.logEntry);
            int nextIndex = top.elementIndex + 1;
            if (nextIndex < sources.get(top.sourceIndex).size()) {
                LogEntry nextLog = sources.get(top.sourceIndex).get(nextIndex);
                minHeap.offer(new Entry(top.sourceIndex, nextIndex, nextLog));
            }
        }

        return merged;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        minHeap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = minHeap.poll();
            if (interval.end > intervals[i].start) {
                minHeap.offer(intervals[i]);
            } else {
                interval.end = intervals[i].end;
            }
                minHeap.offer(interval);
        }
        return minHeap.size();
    }
}

// sweep line
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int count = 1;
        int endIdx = 0;
        for (int i = 1; i < starts.length; i++) {
            if (starts[i] >= ends[endIdx]) {
                endIdx++;
            } else {
                count++;
            }
        }
        return count;
    }
}

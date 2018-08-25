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
            Interval head = minHeap.poll();
            if (intervals[i].start >= head.end) {
                head.end = Math.max(head.end, intervals[i].end);
            } else {
                minHeap.offer(intervals[i]);
            }
            minHeap.offer(head);
        }
        return minHeap.size();
    }
}

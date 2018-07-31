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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Interval pre = null;
        for (Interval interval : intervals) {
            if (pre == null || pre.end <= interval.start) {
                pre = interval;
            } else {
                return false;
            }
        }
        return true;
    }
}

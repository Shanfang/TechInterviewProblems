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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        Interval pre = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre == null || pre.end < cur.start) {
                result.add(cur);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return result;
    }
}

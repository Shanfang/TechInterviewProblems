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
        Interval pre = intervals.get(0);
        result.add(pre);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                result.add(cur);
                pre = cur;
            }
        }
        return result;
    }
}

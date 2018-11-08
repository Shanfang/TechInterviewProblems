import java.util.*;
import java.lang.Math;

class Interval {
    int start;
    int end;
    Interval (int s, int e) {
        this.start = s;
        this.end = e;
    }
}
class CountOverlaps{
    static int count(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        // Collections.sort(intervals, (a, b) -> (a.start - b.start)); // this does not work
        Interval pre = intervals[0];
        int max = 0;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start <= pre.end) {
                count++;
                pre.end = Math.max(pre.end, cur.end);
            } else {
                max = Math.max(max, count);
                count = 1;
                pre = cur;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(0,3);
        Interval i2 = new Interval(6,7);
        Interval i3 = new Interval(1,5);
        Interval i4 = new Interval(9,10);
        Interval i5 = new Interval(10,11);
        Interval[] intervals = new Interval[]{i1,i2, i3, i4, i5};
        System.out.println(count(intervals));
    }
}

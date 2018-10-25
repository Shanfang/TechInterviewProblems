import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        //intervals.sort(Comparator.comparing(i -> i.start));
        Collections.sort(intervals, (a, b)-> a.start - b.start);// sort in collections can be used on object types
        Interval pre = null;

        for (Interval interval : intervals) {
            if (pre == null || pre.end < interval.start) {
                result.add(interval);
                pre = interval;
            } else {
                pre.end = Math.max(pre.end, interval.end);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Interval i1 = new Interval(0, 2);
        Interval i2 = new Interval(1, 4);
        Interval i3 = new Interval(3, 10);
        Interval i4= new Interval(5, 7);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        for (Interval i : merge(list)) {
            System.out.println(i.start + "--" + i.end);
        }
    }
}

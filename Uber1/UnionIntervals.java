import java.util.*;

class Interval {
    int start;
    int end;
    Interval (int s, int e) {
        this.start = s;
        this.end = e;
    }
}
class UnionIntervals {
    private List<Interval> Union(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(list2, (a, b) -> (a.start - b.start));

        Interval pre = null;
        Interval cur = null;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            Interval head1 = list1.get(i);
            Interval head2 = list2.get(j);
            if (head1.start < head2.start) {
                cur = head1;
                i++;
            } else {
                cur = head2;
                j++;
            }

            if (pre == null || pre.end < cur.start) {
                result.add(cur);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }

        if (i < list1.size()) {
            cur = list1.get(i++);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                result.add(cur);
                pre = cur;
            }
        }

        if (j < list2.size()) {
            cur = list2.get(j++);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                result.add(cur);
                pre = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(4,6);
        Interval i3 = new Interval(8,15);
        Interval i4 = new Interval(17,18);
        Interval i5 = new Interval(9,10);
        Interval i6 = new Interval(2,5);
        Interval i7 = new Interval(20,21);
        Interval i8 = new Interval(13,16);
        List<Interval> l1 = new ArrayList<>();
        List<Interval> l2 = new ArrayList<>();
        l1.add(i1);
        l1.add(i2);
        l1.add(i3);
        l1.add(i4);
        l2.add(i5);
        l2.add(i6);
        l2.add(i7);
        l2.add(i8);
        UnionIntervals ui = new UnionIntervals();
        List<Interval> result = ui.Union(l1, l2);
        for (Interval interval : result) {
            System.out.println(interval.start + " - " + interval.end);
        }
    }
}

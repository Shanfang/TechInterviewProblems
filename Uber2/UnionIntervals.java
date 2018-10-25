import java.util.*;

class Interval {
    int start;
    int end;
    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}
class UnionIntervals {
    static List<Interval> union(List<Interval> l1, List<Interval> l2) {
        if (l1 == null || l1.size() == 0) {
            return l2;
        }
        if (l2 == null || l2.size() == 0) {
            return l1;
        }

        Collections.sort(l1, (a, b) -> a.start - b.start);
        Collections.sort(l2, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        Interval pre = null;
        Interval head1 = null;
        Interval head2 = null;
        boolean changePre;
        while (i < l1.size() && j < l2.size()) {
            head1 = l1.get(i);
            head2 = l2.get(j);
            if (pre == null) {
                if (head1.start < head2.start) {
                    pre = head1;
                    i++;
                } else {
                    pre = head2;
                    j++;
                }
                result.add(pre);
                continue;
            }
            if (head1.start < head2.start) {
                changePre = merge(pre, head1, result);
                if (changePre) {
                    pre = head1;
                }
                i++;
            } else {
                changePre = merge(pre, head2, result);
                if (changePre) {
                    pre = head2;
                }
                j++;
            }
        }
        if (i == l1.size()) {
            if (pre.end >= head2.start) {
                merge(pre, head2, result);
                j++;
            }
            while (j < l2.size()) {
                result.add(l2.get(j++));
            }
        }
        if (j == l2.size()) {
            if (pre.end >= head1.start) {
                merge(pre, head1, result);
                i++;
            }
            while (i  < l1.size()) {
                result.add(l1.get(i++));
            }
        }
        return result;
    }

    private static boolean merge(Interval pre, Interval cur, List<Interval> result) {
        if (pre.end >= cur.start) {
            pre.end = Math.max(pre.end, cur.end);
            return false;
        } else {
            result.add(cur);
            return true;
        }
    }

    public static void main(String[] args) {
        List<Interval> l1 = new ArrayList<>();
        List<Interval> l2 = new ArrayList<>();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(4,7);
        Interval i3 = new Interval(9,11);
        l1.add(i1);
        l1.add(i2);
        l1.add(i3);
        Interval i4 = new Interval(2,5);
        Interval i5 = new Interval(8,12);
        l2.add(i4);
        l2.add(i5);
        for (Interval i : union(l1, l2)) {
            System.out.println(i.start + "-" + i.end);
        }
    }
}

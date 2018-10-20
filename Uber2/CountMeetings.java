import java.util.*;

class Meeting {
    int start;
    int end;
    Meeting(int a, int b) {
        this.start = a;
        this.end = b;
    }
}
class Tuple {
    int time;
    boolean isStart;
    Tuple (int t, boolean status) {
        this.time = t;
        this.isStart = status;
    }
}
class CountMeetings {
    static int count(Meeting[] meetings, int target) {
        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        Tuple[] tuples = new Tuple[meetings.length * 2];
        int i = 0;
        for (Meeting m : meetings) {
            tuples[i] = new Tuple(m.start, true);
            tuples[i + 1] = new Tuple(m.end, false);
            i += 2;
        }

        Arrays.sort(tuples, (a, b) -> a.time - b.time);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < tuples.length; j++) {
            Tuple tuple = tuples[j];
            if (tuple.isStart) {
                count++;
            } else {
                count--;
            }
            map.put(tuple.time, count);
        }

        if (target < tuples[0].time || target > tuples[tuples.length - 1].time) {
            return 0;
        }
        int start = 0, end = tuples.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (tuples[mid].time == target) {
                return map.get(target);
            } else if (tuples[mid].time > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (tuples[start].time > target) {
            return map.get(tuples[start - 1].time);
        } else if (tuples[end].time > target) {
            return map.get(tuples[start].time);
        } else {
            return map.get(tuples[end].time);
        }
    }

    public static void main(String[] args) {
        Meeting a = new Meeting(2, 15);
        Meeting b = new Meeting(4, 9);
        Meeting c = new Meeting(9, 29);
        Meeting d = new Meeting(16, 23);
        Meeting e = new Meeting(36, 45);
        Meeting[] meetings = {a, b, c, d, e};
        System.out.println(count(meetings, 9));
    }
}

import java.util.*;

class Request {
    int time;
    Request(int time) {
        this.time = time;
    }
}
class RequestCounter {
    Deque<Request> minute;
    Deque<Request> hour;
    Deque<Request> day;
    int count;
    RequestCounter() {
        minute = new ArrayDeque<>();
        hour = new ArrayDeque<>();
        day = new ArrayDeque<>();
        count = 0;
    }

    public void increment(Request r) {
        updateMinuteDeque(r);
        updateHourDeque(r);
        updateDayDeque(r);
    }
    private void updateMinuteDeque(Request r) {
        while (!minute.isEmpty() && (r.time - minute.peekFirst().time) > 60) {
            minute.pollFirst();
        }
        minute.offer(r);
    }

    private void updateHourDeque(Request r) {
        while (!hour.isEmpty() && (r.time - hour.peekFirst().time) > 3600) {
            hour.pollFirst();
        }
        hour.offer(r);
    }

    private void updateDayDeque(Request r) {
        while (!day.isEmpty() && (r.time - day.peekFirst().time) > 3600 * 24) {
            day.pollFirst();
        }
        day.offer(r);
    }
    public int lastMinute() {
        return minute.size();
    }

    public int lastHour() {
        return hour.size();
    }
    public int lastDay() {
        return day.size();
    }

    public static void main(String[] args) {
        RequestCounter counter = new RequestCounter();
        counter.increment(new Request(0));
        counter.increment(new Request(30));
        counter.increment(new Request(50));
        counter.increment(new Request(60));
        System.out.println(counter.lastMinute());

        counter.increment(new Request(1000));
        counter.increment(new Request(2000));
        counter.increment(new Request(3000));
        counter.increment(new Request(3600));
        System.out.println(counter.lastHour());

        counter.increment(new Request(5000));
        counter.increment(new Request(6000));
        counter.increment(new Request(7000));
        counter.increment(new Request(8000));
        System.out.println(counter.lastDay());
    }
}

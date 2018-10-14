import java.util.*;

class RateLimiter1 {
    Deque<Tuple> deque;
    Map<String, Integer> map;
    int limit;
    RateLimiter1 (int reqLimit) {
        deque = new ArrayDeque<>();
        map = new HashMap<>();
        this.limit = reqLimit;
    }
    class Tuple {
        String ip;
        double timestamp;
        Tuple (String ip, double time) {
            this.ip = ip;
            this.timestamp = time;
        }
    }
    boolean request(String ip, double timestamp) {
        while (!deque.isEmpty() && (timestamp - deque.peekFirst().timestamp > 1)) {
            Tuple tuple = deque.pollFirst();
            map.put(tuple.ip, map.get(tuple.ip) - 1);
        }

        if (map.getOrDefault(ip, 0) >= limit) {
            return false;
        } else {
            deque.offer(new Tuple(ip, timestamp));
            map.put(ip, map.getOrDefault(ip, 0) + 1);
            return true;
        }
    }

    public static void main(String[] args) {
        RateLimiter1 limiter = new RateLimiter1(2);
        String[] ip = {"A", "B", "C","A", "B", "C","A","B"};
        Double[] time = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 1.0, 1.01};

        for (int i = 0; i < ip.length; i++) {
            boolean status = limiter.request(ip[i], time[i]);
            System.out.println("Request status for " + ip[i] + " with timestamp " + time[i] + " is accepted? " + status);
        }
    }
}

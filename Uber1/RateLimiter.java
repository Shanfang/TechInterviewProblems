import java.util.*;

class RateLimiter {
    int limit;
    Queue<Double> queue;
    RateLimiter(int limit) {
        this.limit = limit;
        queue = new LinkedList<>();
    }

    public boolean request(double curTime) {
        while (queue.size() != 0 && curTime - queue.peek() > 1) {
            queue.poll();
        }
        if (queue.size() >= limit) {
            return false;
        }
        queue.offer(curTime);
        return true;
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter(5);
        Double[] arr = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 1.0, 1.01};
        for (int i = 0; i < arr.length; i++) {
            boolean status = limiter.request(arr[i]);
            System.out.println("Request status: " + status);
        }
    }
}

import java.util.*;

class Logger {
    Deque<Tuple> queue;
    Set<String> set;
    /** Initialize your data structure here. */
    public Logger() {
        queue = new ArrayDeque<>();
        set = new HashSet<>();
    }

    class Tuple {
        int time;
        String message;
        Tuple (int time, String msg) {
            this.time = time;
            this.message = msg;
        }
    }
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peekFirst().time >= 10) {
            Tuple tuple = queue.pollFirst();
            set.remove(tuple.message);
        }
        if (!set.contains(message)) {
            queue.offer(new Tuple(timestamp, message));
            set.add(message);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

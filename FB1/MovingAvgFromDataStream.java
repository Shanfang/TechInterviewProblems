class MovingAverage {
    private Queue<Double> queue;
    private int capacity;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.capacity = size;
    }

    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.poll();
        }
        queue.offer((double)val);
        sum += val;
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

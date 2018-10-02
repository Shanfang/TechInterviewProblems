class MinStack {
    Stack<Long> stack;
    long minVal;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            minVal = x;
        } else {
            stack.push(x - minVal);
            if (x < minVal) {
                minVal = x;
            }
        }
    }

    public void pop() {
        long top = stack.pop();
        if (top < 0) {
            minVal = minVal - top;
        }
    }

    public int top() {
        if (stack.peek() < 0) {
            return (int)minVal;
        } else {
            return (int)(stack.peek() + minVal);
        }
    }

    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

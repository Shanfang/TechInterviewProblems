import java.util.Stack;

class ProductOfMinMax {
    static Stack<Integer> stack;
    static Stack<Integer> minStack;
    static Stack<Integer> maxStack;

    ProductOfMinMax() {
        stack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    static int push(int val) {
        stack.push(val);
        if (stack.size() == 1) {
            minStack.push(val);
            maxStack.push(val);
        } else {
            if (val <= minStack.peek())  {
                minStack.push(val);
                maxStack.push(maxStack.peek());
            } else if (val >= maxStack.peek()) {
                minStack.push(minStack.peek());
                maxStack.push(val);
            } else {
                minStack.push(minStack.peek());
                maxStack.push(maxStack.peek());
            }
        }

        return minStack.peek() * maxStack.peek();
    }

    static int pop() {
        stack.pop();
        minStack.pop();
        maxStack.pop();
        return minStack.peek() * maxStack.peek();
    }

    public static void main(String[] args) {
        ProductOfMinMax s = new ProductOfMinMax();
        System.out.println(s.push(5));
        System.out.println(s.push(1));
        System.out.println(s.push(3));
        System.out.println(s.push(7));
        System.out.println(s.push(0));
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

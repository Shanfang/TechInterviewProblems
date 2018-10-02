import java.util.*;

class AugmentedStack {
    static Stack<Integer> stack;

    AugmentedStack () {
        stack = new Stack<>();
    }
    static int push (int val) {
        stack.push(val);
        return stack.peek();
    }

    static int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        stack.pop();
        return stack.peek();
    }

    static int increment(int a) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop() + a);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return stack.peek();
    }

    public static void main(String args[]) {
        AugmentedStack s = new AugmentedStack();
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.push(3));
        System.out.println(s.pop());
        System.out.println(s.increment(1));
    }
}

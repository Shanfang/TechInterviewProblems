import java.util.*;

class SlideWindowMin {
    static int[] window (int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] result = new int[arr.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {
            push(deque, arr[i]);
        }

        for (int i = k - 1; i < arr.length; i++) {
            push(deque, arr[i]);
            result[index++] = deque.peekFirst();
            pop(deque, arr[i - k + 1]);
        }
        return result;
    }

    private static void push(Deque<Integer> deque, int num) {
        if (!deque.isEmpty() && deque.peekLast() > num) {
            deque.pollLast();// pollLast will retrun null is deque is empty
        }
        deque.offer(num);
    }

    private static void pop(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,7,3,2,0,5};
        //int[] arr = {1,2,3,4,5,6};
        int[] result = window(arr, 3);
        for(int num : result) {
            System.out.println(num);
        }
    }
}

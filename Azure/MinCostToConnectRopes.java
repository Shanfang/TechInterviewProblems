import java.util.*;

class MinCostToConnectRopes {
    static int minCost(int[] ropes) {
        if (ropes == null || ropes.length == 0) {
            return 0;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int cost = 0;
        // int i = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            // i++;
            cost += first + second;
            // System.out.println(i + " iteration with total cost " +  cost);
            minHeap.offer(first + second);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCost(ropes));
    }
}

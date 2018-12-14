class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        double[][] pairs = new double[len][2];

        for (int i = 0; i < len; i++) {
            pairs[i] = new double[] {(double)(wage[i]) / quality[i], (double) quality[i]};

        }
        Arrays.sort(pairs, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());

        double minCost = Double.MAX_VALUE;
        double cost = 0;
        for (int i = 0; i < len; i++) {
            cost += pairs[i][1];
            maxHeap.offer(pairs[i][1]);
            if (maxHeap.size() > K) {
                double top = maxHeap.poll();
                cost -= top;
            }
            if (maxHeap.size() == K) {
                minCost = Math.min(minCost, pairs[i][0] * cost);
            }
        }
        return minCost;
    }
}

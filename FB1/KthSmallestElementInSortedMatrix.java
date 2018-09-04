// optimized version of priority queue
class Solution {
    class Pair {
        int row;
        int col;
        int num;
        Pair(int r, int c, int val) {
            row = r;
            col = c;
            num = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        Queue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
          public int compare(Pair a, Pair b) {
                return a.num - b.num;
            }
        });
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
        }

        for (int i = 0; i < k - 1; i++) {
            Pair p = minHeap.poll();
            if (p.col == n - 1) {
                continue;
            }
            minHeap.offer(new Pair(p.row, p.col + 1, matrix[p.row][p.col + 1]));
        }
        return minHeap.peek().num;
    }
}

// use priority queue, does not take advantage that matrix is sorted
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                maxHeap.offer(num);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }
}

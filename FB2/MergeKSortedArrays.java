public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */

     class Triple {
         int row;
         int col;
         int val;
         Triple(int r, int c, int v) {
             row = r;
             col = c;
             val = v;
         }
     }
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        //
        // Queue<Triple> minHeap = new PriorityQueue<>(new Comparator<Triple>(){
        //     public int comparator(Triple a, Triple b) {
        //         return a.val - b.val;
        //     }
        // });
        int total = 0;
        Queue<Triple> minHeap = new PriorityQueue<Triple>((a, b) -> a.val - b.val);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new Triple(i, 0, arrays[i][0]));
                total += arrays[i].length;
            }
        }
        int[] result = new int[total];
        int index = 0;

        while (!minHeap.isEmpty()) {
            Triple triple = minHeap.poll();
            result[index++] = triple.val;
            if (triple.col < arrays[triple.row].length - 1) {
                triple.col = triple.col + 1;
                triple.val = arrays[triple.row][triple.col];
                minHeap.offer(triple);
                //minHeap.offer(new Triple(triple.row, triple.col + 1, arrays[triple.row][triple.col + 1]));
            }
        }
        return result;
    }
}

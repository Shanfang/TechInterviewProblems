class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[] noSwap = new int[len];
        int[] swap = new int[len];

        Arrays.fill(noSwap, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        noSwap[0] = 0;
        swap[0] = 1;

        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                noSwap[i] = noSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
                swap[i] = Math.min(noSwap[i - 1] + 1, swap[i]);
            }
        }
        return Math.min(noSwap[len - 1], swap[len - 1]);
    }
}

class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[] keep = new int[len];
        int[] swap = new int[len];
        for (int i = 0; i < len; i++) {
            keep[i] = Integer.MAX_VALUE;
            swap[i] = Integer.MAX_VALUE;
        }
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
                keep[i] = Math.min(keep[i], swap[i - 1]);
            }
        }
        return Math.min(swap[len - 1], keep[len - 1]);
    }
}

// dfs
class Solution {
    public int min = Integer.MAX_VALUE;
    public int minSwap(int[] A, int[] B) {
        helper(A, B, 0, 0);
        return min;
    }

    private void helper(int[] A, int[] B, int index, int curSwap) {
        if (curSwap > min) {
            return;
        }
        if (index == A.length) {
            min = Math.min(min, curSwap);
            return;
        }
        if(index == 0 || A[index] > A[index - 1] && B[index] > B[index - 1]) {
            helper(A, B, index + 1, curSwap);
        }
        if (index == 0 || A[index] > B[index - 1] && B[index] > A[index - 1]) {
            swap(A, B, index);
            helper(A, B, index + 1, curSwap + 1);
            swap(A, B, index);
        }
    }

    private void swap(int[] A, int[] B, int i) {
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
}

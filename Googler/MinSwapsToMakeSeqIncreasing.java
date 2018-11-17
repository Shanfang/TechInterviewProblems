// dfs
class Solution {
    public int min = Integer.MAX_VALUE;
    public int minSwap(int[] A, int[] B) {
        helper(A, B, 1, 0);
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
        if(A[index] > A[index - 1] && B[index] > B[index - 1]) {
            helper(A, B, index + 1, curSwap);
        }
        if (A[index] > B[index - 1] && B[index] > A[index - 1]) {
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

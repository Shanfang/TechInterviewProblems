class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i -1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                max = Math.max(max, left[i] + right[i] + 1);
            }
        }
        return max;
    }
}

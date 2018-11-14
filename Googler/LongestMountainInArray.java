// one pass with direction flags
class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int index = 0;
        int left = 0;
        boolean upward = false;
        boolean downward = false;
        int max = 0;
        while (index < A.length - 1) {
            index = left;
            while (index + 1 < A.length && A[index] < A[index + 1]) {
                index++;
                upward = true;
            }
            while (upward && index + 1 < A.length && A[index] > A[index + 1]) {
                index++;
                downward = true;
            }
            if (upward && downward) {
                max = Math.max(max, index - left + 1);
            }
            upward = false;
            downward = false;
            left = index > left ? index : index + 1;
        }
        return max;
    }
}

// 3 passes
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

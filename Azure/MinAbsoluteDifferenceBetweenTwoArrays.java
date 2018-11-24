import java.util.*;
import java.math.*;

class MinAbsoluteDifferenceBetweenTwoArrays {
    static int minDiffAbs(int[] arr1, int[] arr2) {
        int minDiff = Integer.MAX_VALUE;
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return minDiff;
        }
        if (arr1.length > arr2.length) {
            return minDiffAbs(arr2, arr1);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            int index = Arrays.binarySearch(arr2, arr1[i]);
            if (index > 0) {
                minDiff = Math.min(minDiff, arr1[i] - arr2[index]);
            } else if (index == -1) {
                minDiff = Math.min(minDiff, arr2[0] - arr1[i]);
            } else if (index == -arr2.length - 1) {
                minDiff = Math.min(minDiff, arr1[i] - arr2[arr2.length - 1]);
            }
            else {
                int insertIdx = -index - 1;
                minDiff = Math.min(minDiff, Math.min(arr1[i] - arr2[insertIdx - 1], arr2[insertIdx] - arr1[i]));
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -2, 2, -3, 7, 11};
        int[] arr2 = {-1, 1, 3, -5, 5, 6};
        System.out.println(minDiffAbs(arr1, arr2));
    }
}

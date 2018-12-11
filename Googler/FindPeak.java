import java.util.*;

class FindPeak {
    static int peak(int[] arr) {
        if (arr == null || arr.length < 3) {
            return Integer.MIN_VALUE;
        }

        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[start] > arr[end]) {
            return arr[start];
        }
        return arr[end];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0,-1,-2,-3};
        System.out.println(peak(arr));
    }
}

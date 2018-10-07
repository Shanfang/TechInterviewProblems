// use binary search to find start index
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x > arr[mid]) {
                if (x - arr[mid] > arr[mid + k] - x) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(arr[start + i]);
        }
        return result;
    }
}


// binary search and two pointers, order in result is sorted with distance
public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] arr, int x, int k) {
        // write your code here
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (start >= 0 && end < arr.length) {
                if (x - arr[start] <= arr[end] - x) {
                    result[i] = arr[start];
                    start--;
                } else {
                    result[i] = arr[end];
                    end++;
                }
            } else if (start >= 0 && end >= arr.length) {
                result[i] = arr[start];
                start--;
            } else {
                result[i] = arr[end];
                end++;
            }
        }
        return result;
    }
}

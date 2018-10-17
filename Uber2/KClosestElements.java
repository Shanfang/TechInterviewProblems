class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid;
            } else {
                if (x - arr[mid] <= arr[mid + k] - x) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(arr[start + i]);
        }
        return result;
    }
}

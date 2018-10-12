import java.util.*;

class MinSubarray {
    static int[] minSubarray(int[] arr) {
        int degree = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > degree) {
                degree = map.get(arr[i]);
            }
        }

        map.clear();
        int left = 0, minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < arr.length) {
            int num1 = arr[end];
            map.put(num1, map.getOrDefault(num1, 0) + 1);
            end++;

            while (map.get(num1) == degree) {
                if (end - start < minLen) {
                    minLen = end - start;
                    left = start;
                }
                int num2 = arr[start];
                map.put(num2, map.get(num2) - 1);
                start++;
            }
        }
        return new int[]{left, left + minLen - 1};
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,2,3,2,3,3};
        int[] result = minSubarray(array);
        System.out.println("Min length subarray with same degree is " + (result[1] - result[0] + 1));
        System.out.println(result[0] + "-" + result[1]);
    }
}

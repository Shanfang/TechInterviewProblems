import java.util.*;
/*
this method can handle unsorted array with duplicats, the result does not contain duplicates
*/
class AllSums {
    static Set<Integer> allSums(int[] arr) {
        Set<Integer> result = new HashSet<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        Arrays.sort(arr);

        for (int i = 0; i <= arr.length; i++) {
            helper(arr, 0, i, 0, result);
        }
        return result;
    }

    private static void helper(int[] arr, int sum, int count, int index, Set<Integer> result) {
        if (count == 0) {
            result.add(sum);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            helper(arr, sum + arr[i], count - 1, i + 1, result);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,2,3};

        for (int num : allSums(arr)) {
            System.out.println(num);
        }
    }
}

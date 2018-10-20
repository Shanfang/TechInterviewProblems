import java.util.*;

class CountTarget{
    static int count(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int start = 0, end = nums.length - 1;
        while (start +  1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (target == nums[start]) {
            left = start;
        } else if (target == nums[end]) {
            left = end;
        } else {
            return 0;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == nums[end]) {
            right = end;
        } else {
            right = start;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,6,6,6,6,6,6,6,9,12,14,19};
        System.out.println(count(array, 1));
    }
}

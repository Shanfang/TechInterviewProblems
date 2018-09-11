// with two pointers, prefered if two arrays are already sorted, otherwise need to sort with O(NlogN)
//  need to sort both arrays, time complexity if O(NlogN)
// the result is not ordered, since in the end we iterate over the set to get the result
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int size = set.size();
        int[] result = new int[size];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }
}

// binary search from one of the arrays, time complexity O(NlogN)
// same as poitners approach in time complexity and space complexity
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 < len2) {
            return intersection(nums2, nums1);
        }

        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();

        for (int num : nums2) {
            if (!set.contains(num) && binarySearch(nums1, num)) {
                set.add(num);
            }
        }
        int size = set.size();
        int[] result = new int[size];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] == target || nums[end] == target;
    }
}


// O(N) time complexity, but high space complexity
// preferred for the cases when there are lot of duplicates in both or one of the arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            if (!set1.contains(num)) {
                set1.add(num);
            }
        }

        Set<Integer> set2 = new HashSet<>();
        for(int num :  nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int size = set2.size();
        int[] result = new int[size];
        int index = 0;
        for (int num : set2) {
            result[index++] = num;
        }
        return result;
    }
}

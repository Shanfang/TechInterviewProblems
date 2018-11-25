class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (len1 + len2 + 1) / 2; // median is the kth element for the merged array

        // do a binay search on nums1 for the number of elements needed
        int left = 0, right = len1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int m2 = k - mid;
            if (nums1[mid] < nums2[m2 - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int m1 = left;
        int m2 = k - m1;
        int mid1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                            m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((len1 + len2) % 2 == 1) {
            return mid1;
        }

        int mid2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
                            m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);

        return (mid1 + mid2) * 0.5;
    }
}

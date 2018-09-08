class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (findKth(nums1, 0, len1, nums2, 0, len2, left) +
                findKth(nums1, 0, len1, nums2, 0, len2, right)) / 2;
    }

    private double findKth(int[] nums1, int start1, int remainL1, int[] nums2, int start2, int remainL2, int k) {
        if (remainL1 > remainL2) {
            return findKth(nums2, start2, remainL2, nums1, start1, remainL1, k);
        }
        if (remainL1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = Math.min(remainL1, k / 2);
        int j = Math.min(remainL2, k / 2);
        if (nums1[start1 + i - 1] < nums2[start2 + j - 1]) {
            return findKth(nums1, start1 + i, remainL1 - i, nums2, start2, remainL2, k - i);
        } else {
            return findKth(nums1, start1, remainL1, nums2, start2 + j, remainL2 - j, k - j);
        }
    }
}

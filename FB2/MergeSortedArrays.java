class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[index--] = nums2[n];
                n--;
            } else {
                nums1[index--] = nums1[m];
                m--;
            }
        }
        while (n >= 0) {
            nums1[index--] = nums2[n];
            n--;
        }
    }
}

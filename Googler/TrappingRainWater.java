class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int total = 0;
        while (left <= right) {
            if(height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                total += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}

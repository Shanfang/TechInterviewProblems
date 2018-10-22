class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int i = 0, j = height.length - 1;
        int amount = 0;
        while (i <= j) {
            if (height[i] <= height[j]) {
                if (height[i] > height[left]) {
                    left = i;
                }
                amount += height[left] - height[i];
                i++;
            } else {
                if (height[j] > height[right]) {
                    right = j;
                }
                amount += height[right] - height[j];
                j--;
            }
        }
        return amount;
    }
}

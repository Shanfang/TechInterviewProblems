class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int volume = 0;
        int i = 0, j = height.length - 1;
        int leftMaxHeight = 0, rightMaxHeight = 0;
        while (i < j) {
            leftMaxHeight = Math.max(leftMaxHeight, height[i]);
            rightMaxHeight = Math.max(rightMaxHeight, height[j]);
            if (height[i] < height[j]) {
                volume += leftMaxHeight - height[i];
                i++;
            } else {
                volume += rightMaxHeight - height[j];
                j--;
            }
        }
        return volume;
    }
}

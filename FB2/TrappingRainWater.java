class Solution {
    public int trap(int[] height) {
        if (height == null ||height.length == 0) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int leftH = height[i], rightH = height[j];
        int volume = 0;
        while (i <= j) {
            if (height[i] < height[j]) {
                if (height[i] > leftH) {
                    leftH = height[i];
                }
                volume += leftH - height[i];
                i++;
            } else {
                if (height[j] > rightH) {
                    rightH = height[j];
                }
                volume += rightH - height[j];
                j--;
            }
        }
        return volume;
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int volume = 0;
        int i = 0, j = height.length - 1;
        int leftH = height[i], rightH = height[j];
        while (i <= j) {
            if (leftH <= rightH) {
                if (height[i] < leftH) {
                    volume += leftH - height[i];
                } else {
                    leftH = height[i];
                }
                i++;
            } else {
                if (height[j] < rightH) {
                    volume += rightH - height[j];
                } else {
                    rightH = height[j];
                }
                j--;
            }
        }
        return volume;
    }
}

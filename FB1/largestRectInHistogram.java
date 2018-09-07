// o(n^2) time complexity
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minH = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (heights[j] < minH) {
                    minH = heights[j];
                }
                maxArea = Math.max(maxArea, (j - i + 1) * minH);
            }
        }
        return maxArea;
    }
}

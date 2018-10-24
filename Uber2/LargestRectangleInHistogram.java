class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        int len = heights.length;
        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (len - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

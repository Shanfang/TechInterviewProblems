// use stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1) {
                stack.push(i);
            } else {
                if (heights[i] >= heights[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                        maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
                    }
                    stack.push(i);
                }
            }
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}

// use divide and conquer
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        return findArea(heights, 0, heights.length - 1);
    }

    private int findArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minHeightIndx = findMinHeight(heights, start, end);

        int midPart = heights[minHeightIndx] * (end - start + 1);
        int leftPart = findArea(heights, start, minHeightIndx - 1);
        int rightPart = findArea(heights, minHeightIndx + 1, end);
        return Math.max(Math.max(leftPart, rightPart), midPart);
    }

    private int findMinHeight(int[] heights, int start, int end) {
        int min = start;
        int i = start;
        while (i <= end) {
            if (heights[i] < heights[min]) {
                min = i;
            }
            i++;
        }
        return min;
    }
}
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

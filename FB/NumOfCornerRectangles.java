// time complexity O(row ^2 * col)
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                int ones = 0;
                for (int k = 0; k < col; k++) {
                    ones += grid[i][k] & grid[j][k];
                }
                count += ones * (ones - 1) / 2;
            }
        }
        return count;
    }
}

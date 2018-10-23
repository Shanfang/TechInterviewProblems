class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter = dfs(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        int sum = 0;
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i, j - 1);
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i, j + 1);
        return sum;
    }
}

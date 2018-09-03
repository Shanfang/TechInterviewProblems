// use DFS, get the DFS idea from Jimmy's solution for max perimeter
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        int perimeter = 0;
        perimeter += dfs(grid, i, j - 1);
        perimeter += dfs(grid, i - 1, j);
        perimeter += dfs(grid, i, j + 1);
        perimeter += dfs(grid, i + 1, j);
        return perimeter;
    }
}

// just count 1s
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int perimeter = 0;
        int row = grid.length, col = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    for (int k = 0; k < 4; k++) {
                        if (islandNeighbor(i + dx[k], j + dy[k], grid)) {
                            perimeter -= 1;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    private boolean islandNeighbor(int i, int j, int[][] grid) {
        return i >=0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }
}

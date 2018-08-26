class Solution {
    public int count = 0;
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (inBound(grid, newX, newY) && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inBound(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}

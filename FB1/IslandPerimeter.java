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

class IslandMaxPerimeter {
    public static void main (String[] args) {
        char[][] grid = {{'1', '1', '1'},{'1', '0', '1'},{'1', '1', '1'}};
        IslandMaxPerimeter island = new IslandMaxPerimeter();
        int result = island.islandMaxPerimeter(grid);
        System.out.println(result);
    }
    public int islandMaxPerimeter (char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxP = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    maxP = Math.max(maxP, dfs(grid, i, j));
                }
            }
        }
        return maxP;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 1;
        }

        if (grid[i][j] == '2') {
            return 0;
        }

        int perimeter = 0;
        grid[i][j] = '2';
        perimeter += dfs(grid, i, j - 1);
        perimeter += dfs(grid, i - 1, j);
        perimeter += dfs(grid, i, j + 1);
        perimeter += dfs(grid, i + 1, j);
        return perimeter;
    }
}

//DFS
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (inBound(newX, newY, grid) && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inBound(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}

// BFS
// mark the grid as visited while offering it on queue, otherwise one grid might be offered multiple times by its neighbors 
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = arr[0] + dx[k];
                            int newY = arr[1] + dy[k];
                            if (inBound(newX, newY, grid) && grid[newX][newY] == '1') {
                                queue.offer(new int[]{newX, newY});
                                grid[newX][newY] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean inBound(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}

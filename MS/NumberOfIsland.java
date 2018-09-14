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

// use Union Find
class Solution {
    class UnionFind {
        int[] parent;
        int count;
        UnionFind(int num) {
            parent = new int[num];
            count = 0;
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }
        private void setCount (int count) {
            this.count = count;
        }

        private int getCount() {
            return this.count;
        }

        private int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        private void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootB] = rootA;
                count--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        UnionFind uf = new UnionFind(row * col);

        int ones = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ones++;
                }
            }
        }
        uf.setCount(ones);
        int[] dx = {1, 0};
        int[] dy = {0 , -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1') {
                            uf.union(i * col + j, newX * col + newY);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }
}

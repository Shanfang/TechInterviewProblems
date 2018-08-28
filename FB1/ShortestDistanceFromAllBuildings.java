class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int[][] dist = new int[row][col];
        int[][] visitCount = new int[row][col];
        for (int[] array : dist) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        int buildingCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    markDist(i, j, grid, dist, new boolean[row][col], visitCount);
                    buildingCount++;
                }
            }
        }

        // loop through dist to find the smallest distance
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dist[i][j] < min && visitCount[i][j] == buildingCount) {
                    min = dist[i][j];
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void markDist(int i, int j, int[][] grid, int[][] dist, boolean[][] visited, int[][] visitCount) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        //dist[i][j] = 0;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int p = 0; p < size; p++) {
                int[] head = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = head[0] + dx[k];
                    int newY = head[1] + dy[k];
                    if (inBound(grid, newX, newY) && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        if (dist[newX][newY] == Integer.MAX_VALUE) {
                            dist[newX][newY] = 0;
                        }
                        visitCount[newX][newY]++;
                        dist[newX][newY] += step;
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

    private boolean inBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}

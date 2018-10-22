class Solution {
    class UnionFind {
        int num;
        int[] parents;
        UnionFind(int count) {
            this.num = count;
            parents = new int[count];
            for (int i = 0; i < num; i++) {
                parents[i] = i;
            }
        }
        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            parents[x] = y;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions[0].length == 0) {
            return result;
        }
        char[][] grid = new char[m][n];
        UnionFind uf = new UnionFind(m * n);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int root = row * n + col;
            int rootP = uf.find(root);
            grid[row][col] = '1';
            count++;
            for (int j = 0; j < 4; j++) {
                int newX = row + dx[j];
                int newY = col + dy[j];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                    int neighbor = newX * n + newY;
                    int neighborP = uf.find(neighbor);
                    if (rootP != neighborP) {
                        uf.union(rootP, neighborP);
                        count--;
                        rootP = neighborP;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}

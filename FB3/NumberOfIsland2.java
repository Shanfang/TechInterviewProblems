class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }

        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int count = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int root = positions[i][0] * n + positions[i][1];
            parents[root] = root;
            for (int k = 0; k < 4; k++) {
                int newX = positions[i][0] + dx[k];
                int newY = positions[i][1] + dy[k];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || parents[newX * n + newY] == -1) {
                    continue;
                }
                int neighborRoot = findRoot(parents, newX * n + newY);
                if (root != neighborRoot) {
                    parents[root] = parents[neighborRoot];
                    root = neighborRoot;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    private int findRoot(int[] parents, int id) {
        while (id != parents[id]) {
            parents[id] = parents[parents[id]];
            id = parents[id];
        }
        return id;
    }

    // private int compressedFindRoot(int[] parents, int id) {
    //     int parent = parents[id];
    //     while (parents[parent] != parent) {
    //         parent = parents[parent];
    //     }
    //     int temp = -1;
    //     while (parents[id] != id) {
    //         temp = parents[id];
    //         parents[id] = parent;
    //         id = temp;
    //     }
    //     return parent;
    // }
}

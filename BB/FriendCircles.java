// BFS
class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int head = queue.poll();
                    visited[head] = true;
                    for (int j = 0; j < len; j++) {
                        if (M[head][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}

// DFS
class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int count = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }
}

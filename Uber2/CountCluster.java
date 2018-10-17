import java.util.*;

class CountCluster {
    class Tuple {
        char c;
        int num;
        Tuple (char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
    public List<Tuple> count(char[][] board) {
        List<Tuple> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(board, i, j, visited);
                    map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                }
            }
        }
        for (char c : map.keySet()) {
            result.add(new Tuple(c, map.get(c)));
        }
        return result;
    }
    int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (inBound(newX, newY, board) && !visited[newX][newY] && board[newX][newY] == board[i][j]) {
                dfs(board, newX, newY, visited);
            }
        }
    }

    private boolean inBound(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) {
        CountCluster counter = new CountCluster();
        char[][] board = {{'a', 'a', 'b'}, {'c', 'a', 'b'}, {'c', 'c', 'c'}, {'c', 'c', 'a'}};
        for (Tuple tuple : counter.count(board)) {
            System.out.println(tuple.c + " - " + tuple.num);
        }
    }
}

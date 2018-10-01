import java.util.*;
class BlackAndWhite {
    public static int countBlack(char[][] board, int H, int W) {
        if (board == null || H == 0 || W == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 'B') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = 'W';
        for (int k = 0; k < 8; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'B') {
                dfs(board, newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        int H = 4;
        int W = 6;
        char[][] board = {{'B', 'B', 'W', 'W', 'B', 'W'}, {'W', 'W','B', 'B', 'W', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'B', 'B', 'W', 'W', 'B', 'W'}};
        int count = countBlack(board, H, W);
        System.out.println(count);
    }
}

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int mines = countMines(board, x, y);
        if (mines == 0) {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = x + i;
                    int newY = y + j;
                    dfs(board, newX, newY);
                }
            }
        } else {
            board[x][y] = (char)('0' + mines);
        }
    }

    private int countMines(char[][] board, int x, int y) {
        int mines = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) {
                    continue;
                }
                if (board[newX][newY] == 'M') {
                    mines++;
                }
            }
        }
        return mines;
    }
}

// O(N^3) time complexity
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!valid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] != '.' && board[i][col] == board[row][col]) {
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] != '.' && board[row][col] == board[row][i]) {
                return false;
            }
        }

        for (int i = (row / 3) * 3; i < (row / 3 + 1) * 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3 + 1) * 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] != '.' && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}

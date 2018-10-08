// O(N^2) time complexity, with extra space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }

                int rowIdx = 3 * (i / 3);
                int colIdx = 3 * (i % 3);
                if (board[rowIdx + j / 3][colIdx + j % 3] != '.' && !cube.add(board[rowIdx + j / 3][colIdx + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}

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

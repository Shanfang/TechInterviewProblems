class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }

        boolean result = false;
        board[i][j] = '#';
        result = dfs(board, i, j - 1, word, index + 1) || dfs(board, i - 1, j, word, index + 1) ||
                dfs(board, i, j + 1, word, index + 1) || dfs(board, i + 1, j, word, index + 1);
        board[i][j] = word.charAt(index);
        return result;
    }
}

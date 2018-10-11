class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        helper(new int[n], 0, n, result);
        return result;
    }

    private void helper(int[] col, int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> board = buildBoard(col, n);
            result.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            col[row] = i;
            if (valid(col, row)) {
                helper(col, row + 1, n, result);
            }
        }
    }

    private boolean valid(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }
            if (Math.abs(col[row] - col[i]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private List<String> buildBoard(int[] col, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j != col[i]) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}

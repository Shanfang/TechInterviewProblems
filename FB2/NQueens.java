class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        backtrack(new int[n], 0, result);
        return result;
    }

    private void backtrack(int[] colPos, int row, List<List<String>> result) {
        if (row == colPos.length) {
            List<String> list = draw(colPos);
            result.add(list);
            return;
        }

        for (int i = 0; i < colPos.length; i++) {
            colPos[row] = i;
            if (valid(colPos, row)) {
                backtrack(colPos, row + 1, result);
            }
        }
    }

    private boolean valid(int[] colPos, int row) {
        for (int i = 0; i < row; i++) {
            if (colPos[i] == colPos[row]) {
                return false;
            }
            if (Math.abs(colPos[i] - colPos[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private List<String> draw(int[] colPos) {
        int n = colPos.length;
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (colPos[i] != j) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
}

class Solution {
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        return helper(new int[n], 0);
    }

    private int helper(int[] colPos, int row) {
        if (row == colPos.length) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < colPos.length; i++) {
            colPos[row] = i;
            if (isValid(colPos, row)) {
                count += helper(colPos, row + 1);
            }
        }
        return count;
    }

    private boolean isValid(int[] colPos, int row) {
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
}

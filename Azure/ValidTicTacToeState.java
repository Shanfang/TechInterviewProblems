class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antidiagonal = 0;
        int role = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    rows[i]++;
                    cols[j]++;
                    if (i == j) {
                        diagonal++;
                    }
                    if (i + j == 2) {
                        antidiagonal++;
                    }
                    role++;
                }
                if (board[i].charAt(j) == 'O') {
                    rows[i]--;
                    cols[j]--;
                    if (i == j) {
                        diagonal--;
                    }
                    if (i + j == 2) {
                        antidiagonal--;
                    }
                    role--;
                }
            }
        }
        xWin = check(rows, cols, diagonal, antidiagonal, 'X') ? true : false;
        oWin = check(rows, cols, diagonal, antidiagonal,'O') ? true : false;
        if (xWin && role == 0 || oWin && role == 1) {
            return false;
        }
        return (role == 0 || role == 1) && (!xWin || !oWin);
    }

    private boolean check(int[] rows, int[] cols, int diagonal, int antidiagonal, char role) {
        if (role == 'X') {
            for (int i = 0; i < 3; i++) {
                if (rows[i] == 3 || cols[i] == 3) {
                    return true;
                }
            }
            if (diagonal == 3 || antidiagonal == 3) {
                return true;
            }
        }
        if (role == 'O') {
            for (int i = 0; i < 3; i++) {
                if (rows[i] == -3 || cols[i] == -3) {
                    return true;
                }
            }
            if (diagonal == -3 || antidiagonal == -3) {
                return true;
            }
        }
        return false;
    }
}

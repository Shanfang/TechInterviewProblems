class Solution {
    double[][][] memo;
    int[] dx = {1,2,2,1,-1,-1,-2,-2};
    int[] dy = {2,1,-1,-2,2,-2,1,-1};
    public double knightProbability(int N, int K, int r, int c) {
        memo = new double[N][N][K + 1];
        return dfs(N, K, r, c);
    }

    private double dfs(int N, int toMoveStep, int curRow, int curCol) {
        if (curRow < 0 || curRow >= N || curCol < 0 || curCol >= N) {
            return 0;
        }

        if (toMoveStep == 0) {
            return 1;
        }

        if (memo[curRow][curCol][toMoveStep] != 0) {
            return memo[curRow][curCol][toMoveStep];
        }
        double prob = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = curRow + dx[i];
            int newCol = curCol + dy[i];
            prob += 0.125 * dfs(N, toMoveStep - 1, newRow, newCol);
        }
        memo[curRow][curCol][toMoveStep] = prob;
        return prob;
    }
}

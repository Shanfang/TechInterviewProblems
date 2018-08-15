class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int row = costs.length, col = costs[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                costs[i][j] += findPreMin(costs, i, j);
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (costs[row - 1][i] < minCost) {
                minCost = costs[row - 1][i];
            }
        }
        return minCost;
    }

    private int findPreMin(int[][] costs, int cur, int color) {
        int minPre = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            if (i == color) {
                continue;
            }
            minPre = Math.min(minPre, costs[cur - 1][i]);
        }
        return minPre;
    }
}

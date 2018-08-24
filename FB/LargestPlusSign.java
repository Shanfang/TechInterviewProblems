class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];

        int[][] matrix = new int[N][N];
        for (int[] row : matrix) {
            Arrays.fill(row, 1);
        }

        for (int[] point : mines) {
            matrix[point[0]][point[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            left[i][0] = matrix[i][0] == 1 ? 1 : 0;
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            right[i][N - 1] = matrix[i][N - 1] == 1 ? 1 : 0;
            for (int j = N - 2; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            up[0][j] = matrix[0][j] == 1 ? 1 : 0;
            for (int i = 1; i < N; i++) {
                if (matrix[i][j] == 1) {
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            down[N -1][j] = matrix[N -1][j] == 1 ? 1 : 0;
            for (int i = N - 2; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                maxLen = Math.max(maxLen, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
            }
        }
        return maxLen;
    }
}

// collapse left and up sweep, right and down sweep
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];

        int[][] matrix = new int[N][N];
        for (int[] row : matrix) {
            Arrays.fill(row, 1);
        }

        for (int[] point : mines) {
            matrix[point[0]][point[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    up[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    up[i][j] = matrix[i][j] == 1 ? up[i - 1][j] + 1 : 0;
                }

                if (j == 0) {
                    left[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    left[i][j] = matrix[i][j] == 1 ? left[i][j - 1] + 1 : 0;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == N  - 1) {
                    down[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    down[i][j] = matrix[i][j] == 1 ? down[i + 1][j] + 1 : 0;
                }

                if (j == N - 1) {
                    right[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    right[i][j] = matrix[i][j] == 1 ? right[i][ j + 1] + 1 : 0;
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                maxLen = Math.max(maxLen, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
            }
        }
        return maxLen;
    }
}

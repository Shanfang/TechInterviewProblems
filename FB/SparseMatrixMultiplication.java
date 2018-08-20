class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int col = B[0].length;
        int k = A[0].length;

        int[][] result = new int[row][col];

        // convert into array of list
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> rList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (A[i][j] != 0) {
                    rList.add(j);
                    rList.add(A[i][j]);
                }
            }
            lists.add(rList);
        }

        // do multiplication only with non-zero values
        for (int i = 0; i < row; i++) {
            List<Integer> rList = lists.get(i);
            for (int j = 0; j < col; j++) {
                int sum = 0;
                for (int p = 0; p < rList.size(); p += 2) {
                    sum += rList.get(p + 1) * B[rList.get(p)][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}

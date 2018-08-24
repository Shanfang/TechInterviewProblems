// time complexity O(row ^2 * col)
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                int ones = 0;
                for (int k = 0; k < col; k++) {
                    ones += grid[i][k] & grid[j][k];
                }
                count += ones * (ones - 1) / 2;
            }
        }
        return count;
    }
}

// NOTE!!!: the following solution does not give correct answer sometimes, to be fixed!
// sparse dense rows
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        int num = 0; // count the number of 1 in grid, so we can set a criteria to check whether an row is dense or not
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    rowList.add(j);
                }
            }
            list.add(rowList);
        }

        int criteria = (int)Math.sqrt(num);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            if (list.get(i).size() > criteria) { // a dense row
                Set<Integer> set = new HashSet<>(list.get(i));

                for (int j = 0; j < row; j++) {
                    if (j <= i && list.get(j).size() >= criteria) {
                        continue;
                    }
                    int ones = 0;
                    for (int index : list.get(j)) {
                        if (set.contains(index)) {
                            ones++;
                        }
                    }
                    count += ones * (ones - 1) / 2;
                }
            } else { // always use the sparse row to check against dense row
                List<Integer> sparseRow = list.get(i);
                for (int j = 0; j < sparseRow.size(); j++) {
                    int leftIdx = sparseRow.get(j);
                    for (int k = j + 1; k < sparseRow.size(); k++) {
                        int rightIdx = sparseRow.get(j);
                        int ones = map.getOrDefault(200 * leftIdx + rightIdx, 0);
                        count += ones;
                        map.put(200 * leftIdx + rightIdx, ones + 1);
                    }
                }
            }
        }
        return count;
    }
}

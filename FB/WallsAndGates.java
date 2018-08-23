class Solution {
    public static final int[] deltaX = new int[]{-1, 0, 1, 0};
    public static final int[] deltaY = new int[]{0, 1, 0, -1};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queueX.add(i);
                    queueY.add(j);
                }
            }
        }

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + deltaX[i];
                int newY = y + deltaY[i];
                if (inBound(newX, newY, m, n)) {
                    if (rooms[newX][newY] == Integer.MAX_VALUE) {
                        rooms[newX][newY] = rooms[x][y] + 1;
                        queueX.offer(newX);
                        queueY.offer(newY);
                    }
                }
            }
        }
    }

    private boolean inBound(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}

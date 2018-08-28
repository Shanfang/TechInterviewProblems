// In order to start searching at the same time, we must push all gates on queue frist.
// cant do BFS one gate after another

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = head[0] + dx[k];
                int newY = head[1] + dy[k];
                if (inBound(newX, newY, rooms) && rooms[newX][newY] == Integer.MAX_VALUE) {
                    rooms[newX][newY] = rooms[head[0]][head[1]] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean inBound(int i, int j, int[][] rooms) {
        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length;
    }
}

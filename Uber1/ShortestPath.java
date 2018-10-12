import java.util.*;

class ShortestPath {
    static int path(int[][] board, int[] s, int[] d) {
        Queue<int[]> queue = new LinkedList<>();
        int path = -1;
        queue.offer(s);
        int row = board.length;
        int col = board[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == d[0] && cur[1] == d[1]) {
                    return path;
                }
                for (int k = 0; k < 4; k++) {
                    int newX = cur[0] + dx[k];
                    int newY = cur[1] + dy[k];
                    if (newX >= 0 && newY >= 0 && newX < row && newY < col && board[newX][newY] != -1) {
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,-1,0},{-1,0,0,0,0},{0,-1,-1,0,0},{0,0,0,0,0}};
        int[] source = {0, 0};
        int[] dest = {3,2};
        int path = path(board, source, dest);
        System.out.println("Shortest path is: " + path);
    }
}

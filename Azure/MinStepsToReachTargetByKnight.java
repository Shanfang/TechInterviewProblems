import java.util.*;

class MinStepsToReachTargetByKnight {
    static int steps(int[][] board, int[] s, int[] e) {
        if (s == e) {
            return 0;
        }
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s[0], s[1], 0});
        board[s[0]][s[1]] = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                int[] triple = queue.poll();
                if (triple[0] == e[0] && triple[1] == e[1]) {
                    return triple[2];
                }
                for (int j = 0; j < 8; j++) {
                    int newX = triple[0] + dx[j];
                    int newY = triple[1] + dy[j];
                    if (newX >= 0 && newX < board.length && newY >= 0 &&
                        newY < board[0].length && board[newX][newY] == 0) {
                            board[newX][newY] = -1;
                            queue.offer(new int[]{newX, newY, triple[2] + 1});
                        }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = new int[6][6];
        int[] s = {1, 3};
        int[] e = {5, 0};

        System.out.println(steps(board, s, e));
    }
}

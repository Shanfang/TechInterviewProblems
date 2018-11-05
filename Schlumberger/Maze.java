import java.util.*;

class Maze {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static boolean exit(boolean[][] maze, int i, int j) {
        maze[i][j] = true;
        boolean result = false;
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) {
                result = true;
                break;
            }
            if (!maze[newX][newY]) {
                result |= exit(maze, newX, newY);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true, true},{true, false, false, true},
                            {true, false, false, true},{true, true, true, true}};
        System.out.println(exit(maze, 1, 1));
    }
}

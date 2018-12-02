import java.util.*;

// class Cell {
//     boolean isRevealed;
//     int x;
//     int y;
//     char status;
//     Cell(boolean r,)
// }
class MineSweepGame {
    char[][] board;
    int bombs;
    Random rand;

    MineSweepGame(int r, int c, int b) {
        this.board = new char[r][c];
        this.bombs = b;
        this.rand = new Random();
    }
    public void startGame() {
        generateBoard(board, bombs);
    }

    private void generateBoard(char[][] board, int count) {
        int row = board.length;
        int col = board[0].length;
        // init the board with empty space
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = 'E';
            }
        }
        // using java8 method to generate random number and set the bombs
        int[] bombPositions = rand.ints(bombs, 0, row * col).toArray();
        for (int index : bombPositions) {
            board[index / col][index % col] = 'B';
        }
        // print out the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        MineSweepGame game = new MineSweepGame(10,10,66);
        game.startGame();
    }
}

package homework4.task25;

import static homework4.task25.TicTacToy.COLS;
import static homework4.task25.TicTacToy.ROWS;

/**
 * Created by koval on 15.12.2016.
 */
public class Memento {

    private int currentState;
    private int currentPlayer;
    private int currentRow;
    private int currentCol;

    private int[][] board;

    public Memento(int currentState, int currentPlayer, int currentRow, int currentCol, int[][] board) {
        this.currentState = currentState;
        this.currentPlayer = currentPlayer;
        this.currentRow = currentRow;
        this.currentCol = currentCol;

        this.board = new int[ROWS][COLS];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, board[0].length);
        }
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public int[][] getBoard() {
        return board;
    }
}

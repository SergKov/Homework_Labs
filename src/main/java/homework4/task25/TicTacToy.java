package homework4.task25;

import java.util.Scanner;

/**
 * Created by koval on 15.12.2016.
 */
public class TicTacToy {

    private static final int EMPTY = 0;
    private static final int CROSS = 1;
    private static final int NOUGHT = 2;
    private static final int PLAYING = 0;
    private static final int DRAW = 1;
    private static final int CROSS_WON = 2;
    private static final int NOUGHT_WON = 3;
    public static final int ROWS = 3;
    public static final int COLS = 3;

    private int currentState;
    private int currentPlayer;
    private int currentRow;
    private int currentCol;

    private int[][] board = new int[ROWS][COLS];

    private Memento memento;

    public static void main(String[] args) {
        final TicTacToy ticTacToy = new TicTacToy();
        ticTacToy.startGame();
    }


    public void startGame() {

        initGame();

        do {

            playerMove();
            updateGame();
            printBoard();

            if (currentState == CROSS_WON) {
                System.out.println("'X' won! Bye!");
            } else if (currentState == NOUGHT_WON) {
                System.out.println("'O' won! Bye!");
            } else if (currentState == DRAW) {
                System.out.println("It's a Draw! Bye!");
            }

            currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
        } while (currentState == PLAYING);
    }

    private void initGame() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = EMPTY;
            }
        }
        currentState = PLAYING;
        currentPlayer = CROSS;
    }


    private void playerMove() {

        boolean validInput = false;

        final Scanner in = new Scanner(System.in);

        do {

            if (currentPlayer == CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }

            final String rowLine = in.next();

            if (rowLine.equals("s")) {
                memento = saveStateToMemento();
            } else if (rowLine.equals("b")) {
                this.currentState = memento.getCurrentState();
                this.currentPlayer = memento.getCurrentPlayer();
                this.currentRow = memento.getCurrentRow();
                this.currentCol = memento.getCurrentCol();
                this.board = memento.getBoard();
            } else {

                final String colLine = in.next();

                int row = Integer.parseInt(rowLine) - 1;
                int col = Integer.parseInt(colLine) - 1;
                if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
                    currentRow = row;
                    currentCol = col;
                    board[currentRow][currentCol] = currentPlayer;
                    validInput = true;
                } else {
                    System.err.println("This move at (" + (row + 1) + "," + (col + 1)
                            + ") is not valid. Try again...");
                }
            }

        } while (!validInput);
    }

    public Memento saveStateToMemento() {
        return new Memento(currentState, currentPlayer, currentRow, currentCol, board);
    }


    private void updateGame() {
        if (hasWon()) {
            currentState = (currentPlayer == CROSS) ? CROSS_WON : NOUGHT_WON;
        } else if (isDraw()) {
            currentState = DRAW;
        }

    }


    private boolean isDraw() {
        for (int[] line : board) {
            for (int elem : line) {
                if (elem == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean hasWon() {
        return (board[currentRow][0] == currentPlayer
                && board[currentRow][1] == currentPlayer
                && board[currentRow][2] == currentPlayer

                || board[0][currentCol] == currentPlayer
                && board[1][currentCol] == currentPlayer
                && board[2][currentCol] == currentPlayer

                || currentRow == currentCol
                && board[0][0] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][2] == currentPlayer

                || currentRow + currentCol == 2
                && board[0][2] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][0] == currentPlayer);
    }


    private void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                printCell(board[row][col]);
                if (col != COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }


    private void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case NOUGHT: System.out.print(" O "); break;
            case CROSS:  System.out.print(" X "); break;
        }
    }
}

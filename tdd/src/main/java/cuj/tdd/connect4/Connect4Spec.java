package cuj.tdd.connect4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Connect4Spec {
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private String[][] board = new String[ROWS][COLUMNS];
    private String currentPlayer = Color.RED.toString();

    public Connect4Spec() {
        for (String[] color : board)
            Arrays.fill(color, Color.EMPTY.toString());
    }

    public int getNumberOfDiscs() {
        return IntStream.range(0, COLUMNS)
                .map(this::getNumberOfDiscsInColumn).sum();
    }

    private int getNumberOfDiscsInColumn(int column) {
        return (int) IntStream.range(0, ROWS)
                .filter(row -> !Color.EMPTY.toString().equals(board[row][column])).count();
    }

    public int putDiscInColumn(int column) {
        checkColumn(column);
        int row = getNumberOfDiscsInColumn(column);
        board[row][column] = getCurrentPlayer();
        switchPlayer();
        return row;
    }

    private void switchPlayer() {
        if(Color.RED.toString().equals(getCurrentPlayer())){
            currentPlayer = Color.GREEN.toString();
            return;
        }
        currentPlayer = Color.RED.toString();
    }

    private void checkColumn(int column) {
        if (column < 0 || column >= COLUMNS) {
            throw new RuntimeException("Invalid column " + column);
        }
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}

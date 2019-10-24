package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents the board of the game. The board is a 8x8 board
 */
public class Board {

    private static final int BOARD_SIZE = 8;
    private Cell[][] cells = new Cell[BOARD_SIZE][BOARD_SIZE];

    /**
     * Fills the 8x8 board with empty cells
     */
    public Board() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                cells[row][column] = new Cell();
            }
        }
    }

    /**
     * Returns true if the position passed in parameter is in the board, false
     * otherwise
     *
     * @param position the position to check
     * @return true if the position passed in parameter is in the board, false
     * otherwise
     */
    boolean isInside(Position position) {
        return (position.getRow() > 0
                && position.getRow() < BOARD_SIZE)
                && (position.getColumn() > 0
                && position.getColumn() < BOARD_SIZE);
    }
}

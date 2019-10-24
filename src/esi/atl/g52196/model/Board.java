package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents the board of the game.
 *
 * This is a 8x8 board
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

    /**
     * Returns the board
     *
     * @return a 2d array of BOARD_SIZE x BOARD_SIZE
     */
    Cell[][] getCells() {
        return cells;
    }

    /**
     * Returns the cell at the position passed in parameter
     *
     * @param position the position of the cell we want to get
     * @return the cell at the position passed in parameter
     */
    Cell getCell(Position position) {
        checkIsInside(position);
        return getCells()[position.getRow()][position.getColumn()];
    }

    /**
     * Returns the Pawn at the position passed in parameter
     *
     * @param position the position of the Pawn we want to get
     * @return the Pawn at the position passed in parameter
     */
    Pawn getPawn(Position position) {
        checkIsInside(position);
        return getCell(position).getPawn();
    }

    /**
     * Adds a pawn in the cell at the position passed in parameter
     *
     * @param position the position of the cell we want to set
     * @param pawn the pawn we want to add in the cell
     */
    void addPawn(Pawn pawn) {
        checkIsInside(pawn.getPosition());
        getCell(pawn.getPosition()).fill(pawn);
    }

    /**
     * Removes a pawn from the board
     *
     * @param position the position of the pawn to remove
     */
    public void remove(Position position) {
        checkIsInside(position);
        if (getCell(position) != null) {
            getCells()[position.getRow()][position.getColumn()] = new Cell();
        }
    }

    /**
     * @param position the position to look at
     * @throws IllegalArgumentException if the position is not part of the board
     */
    void checkIsInside(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException(
                    "The position is not part of the board");
        }
    }
}

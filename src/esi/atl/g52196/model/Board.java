package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents the board of the game.
 *
 * This is a 8x8 board
 */
public class Board {

    public static final int BOARD_SIZE = 8;
    private final Pawn[][] pawns = new Pawn[BOARD_SIZE][BOARD_SIZE];

    /**
     * Fills the 8x8 board with empty cells
     */
    public Board() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                pawns[row][column] = null;  //.
            }
        }
    }

    /**
     * Creates a new Board from a board.
     *
     * @param oldBoard the old board to copy
     */
    public Board(Board oldBoard) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                pawns[row][column] = oldBoard.getPawn(
                        new Position(row, column));
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
        return (position.getRow() >= 0
                && position.getRow() < BOARD_SIZE)
                && (position.getColumn() >= 0
                && position.getColumn() < BOARD_SIZE);
    }

    /**
     * Returns the cell at the position passed in parameter
     *
     * @param position the position of the cell we want to get
     * @return the cell at the position passed in parameter
     */
    public Pawn getPawn(Position position) {
        checkIsInside(position);
        if (isEmpty(position)) {
            return null;
        }
        return new Pawn(pawns[position.getRow()][position.getColumn()]);  //TODO defensive copy
    }

    /**
     * Adds a pawn in the cell at the position passed in parameter
     *
     * @param position the position of the cell we want to set
     * @param pawn the pawn we want to add in the cell
     */
    void addPawn(Pawn pawn) {
        Position pos = pawn.getPosition();
        checkIsInside(pos);
        pawns[pos.getRow()][pos.getColumn()] = pawn;
    }

    /**
     * Removes a pawn from the board
     *
     * @param position the position of the pawn to remove
     */
    void remove(Position position) {
        checkIsInside(position);
        if (getPawn(position) != null) {
            pawns[position.getRow()][position.getColumn()] = null;
        }
    }

    public boolean isEmpty(Position position) {
        return pawns[position.getRow()][position.getColumn()] == null;
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

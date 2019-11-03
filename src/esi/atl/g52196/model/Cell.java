package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents one cell of the Board
 */
public class Cell {

    private Pawn pawn;

    /**
     * Creates an empty cell of the board
     */
    Cell() {
        this.pawn = null;
    }

    /**
     * Returns the pawn in the cell
     *
     * @return the pawn in the cell
     */
    public Pawn getPawn() {
        return pawn;
    }

    /**
     * Returns true if the Cell is empty
     *
     * A cell is empty if there is no pawn in it
     *
     * @return true if the cell is empty, false otherwise
     */
    public boolean isEmpty() {
        return pawn == null;
    }

    /**
     * Adds a pawn to the cell if the pawn is not null and the cell is free
     *
     * @param pawn the pawn to be added
     * @throws NullPointerException if the pawn passed in parameter is null
     * @throws IllegalStateException if the cell is not empty
     */
    void fill(Pawn pawn) {
        if (pawn == null) {
            throw new NullPointerException("The pawn can't be null");
        } else if (!isEmpty()) {
            throw new IllegalStateException("The cell is not free");
        }
        this.pawn = pawn;
    }
}

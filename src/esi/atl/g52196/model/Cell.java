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
    public Cell() {
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
     * Adds a pawn to the cell if the pawn is not null and the cell is free
     *
     * @param pawn the pawn to be added
     * @throws NullPointerException if the pawn passed in parameter is null
     * @throws IllegalStateException if the cell is not empty
     */
    public void fill(Pawn pawn) {
        if (pawn == null) {
            throw new NullPointerException("The pawn can't be null");
        } else if (this.pawn != null) {
            throw new IllegalStateException("The cell is not free");
        }
        this.pawn = pawn;
    }
}

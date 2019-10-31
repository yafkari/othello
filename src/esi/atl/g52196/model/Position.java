package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Allows to manage the coordinates of the cells of the game board
 */
public class Position {

    private int row;
    private int column;

    /**
     * Creates a position with a row and a column passed in parameter
     *
     * @param row the position in y-axis
     * @param column the position in x-axis
     */
    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Row and column can't be negative");
        }
        this.row = row;
        this.column = column;
    }

    /**
     * Creates a position with the parameters of another position
     *
     * @param position
     */
    public Position(Position position) {
        this(position.getRow(), position.getColumn());
    }

    /**
     * Returns the position in the y-axis of the position
     *
     * @return the row of the position
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the position in the x-axis of the position
     *
     * @return the column of the position
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * Returns the next position depending to the direction passed in parameter
     *
     * @param direction the direction for the next position
     * @return the next position
     */
    public Position nextPos(Direction direction) {
        return new Position(row + direction.getRow(),
                column + direction.getColumn());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
}

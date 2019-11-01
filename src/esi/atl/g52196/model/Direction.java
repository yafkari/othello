package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents the possible directions
 */
public enum Direction {
    NORTH(-1, 0),
    NORTHEAST(-1, 1),
    EAST(0, 1),
    SOUTHEAST(1, 1),
    SOUTH(1, 0),
    SOUTHWEST(1, -1),
    WEST(0, -1),
    NORTHWEST(-1, -1);

    private int row;
    private int column;

    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the movement on the y-axis of the direction
     *
     * @return the movement on the y-axis of the direction
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the movement on the x-axis of the direction
     *
     * @return the movement on the x-axis of the direction
     */
    public int getColumn() {
        return column;
    }
}

package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents a pawn
 */
public class Pawn {

    private PlayerColor color;
    private Position position;
    private int value;

    /**
     * Creates a pawn with a color, a position and a value that are passed in
     * parameter
     *
     * @param color the color of the pawn
     * @param position the position of the pawn
     * @param value the value of the pawn
     */
    public Pawn(PlayerColor color, Position position, int value) {
        this.color = color;
        this.position = position;
        this.value = value;
    }

    /**
     * Returns the color of the pawn
     *
     * @return the color of the pawn
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Returns the position of the pawn
     *
     * @return the position of the pawn
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns the value of the pawn
     *
     * @return the value of the pawn
     */
    public int getValue() {
        return value;
    }
}

package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents a pawn
 */
public class Pawn {

    private PlayerColor color;
    private Position position;

    /**
     * Creates a pawn with a color and a position that are passed in parameter
     *
     * @param color the color of the pawn
     */
    public Pawn(PlayerColor color, Position position) {
        this.color = color;
        this.position = position;
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
}

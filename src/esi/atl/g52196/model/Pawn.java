package esi.atl.g52196.model;

/**
 * @author 52196
 * 
 * Represents a pawn
 */
public class Pawn {
    private PlayerColor color;
    
    public Pawn(PlayerColor color) {
        this.color = color;
    }
    
    /**
     * Returns the color of the pawn
     *
     * @return the color of the pawn
     */
    public PlayerColor getColor() {
        return color;
    }
}

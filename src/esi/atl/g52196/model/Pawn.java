package esi.atl.g52196.model;

import java.util.Objects;

/**
 * @author 52196
 *
 * Represents a pawn
 */
public class Pawn {

    private PlayerColor color;
    private Position position; // supprimer 
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
        if (position != null && (position.getRow() < 0
                || position.getColumn() < 0)) {
            throw new IllegalArgumentException("Position cannott be negative");
        }
        this.color = color;
        this.position = position;
        this.value = value;
    }

    /**
     * Creates a pawn from a pawn
     *
     * @param oldPawn the pawn to copy
     */
    public Pawn(Pawn oldPawn) {
        color = oldPawn.getColor();
        position = oldPawn.getPosition();
        value = oldPawn.getValue();
    }

    /**
     * Returns the color of the pawn
     *
     * @return the color of the pawn
     */
    public PlayerColor getColor() {
        return color == PlayerColor.BLACK
                ? PlayerColor.BLACK
                : PlayerColor.WHITE;
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
     * Sets the color of a pawn
     *
     * @param color the future color of the pawn
     */
    void setColor(PlayerColor color) {
        this.color = color;
    }

    /**
     * Sets the position on the board of a pawn
     *
     * @param position the future position of the pawn
     */
    void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Returns the value of the pawn
     *
     * @return the value of the pawn
     */
    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.color);
        hash = 43 * hash + Objects.hashCode(this.position);
        hash = 43 * hash + this.value;
        return hash;
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
        final Pawn other = (Pawn) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return Objects.equals(this.position, other.position);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

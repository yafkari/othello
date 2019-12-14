package esi.atl.g52196.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 52196
 *
 * Represents a player
 */
public class Player {

    private PlayerColor color;
    private List<Pawn> pawns;
    private String name;
    private boolean isBot;

    /**
     * Creates a new player
     *
     * @param color the color of the player (black or white)
     * @param name the name of the player
     * @param isBot true if the player is a bot, otherwise false
     * @throws NullPointerException if the color is null
     */
    Player(PlayerColor color, String name, boolean isBot) {
        if (color == null) {
            throw new NullPointerException("The color can't be null !");
        }
        this.color = color;
        this.pawns = new ArrayList<>();
        this.isBot = isBot;
        this.name = name;
    }

    /**
     * Creates a copy of a player
     *
     * @param player the player to copy
     */
    Player(Player player) {
        this.color = player.getColor();
        this.pawns = player.getPawns();
        this.name = player.getName();
        this.isBot = player.isABot();
    }

    /**
     * Returns the color of the player
     *
     * @return the color of the player
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Returns the name of the player
     *
     * @return the name of the player
     */
    String getName() {
        return name;
    }

    /**
     * Returns the list of pawns of the player
     *
     * @return the list of pawns of the player
     */
    List<Pawn> getPawns() {
        return pawns;
    }

    /**
     * Returns if the player is a bot or not
     *
     * @return true if the player is a bot, otherwise false
     */
    public boolean isABot() {
        return isBot;
    }

    /**
     * Adds a pawn passed in parameter to the list of pawns of the player
     *
     * @param pawn the pawn to be added to the list
     */
    void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    /**
     * Removes a pawn passed in parameter.
     *
     * Returns it if it has been effectively removed
     *
     * @param pawn the pawn to be removed
     * @return the pawn if it has been remove, otherwise null
     */
    Pawn removePawn(Pawn pawn) {
        if (pawns.contains(pawn)) {
            if (pawns.remove(pawn)) {
                return pawn;
            }
        }
        return null;
    }
}

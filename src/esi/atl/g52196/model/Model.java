package esi.atl.g52196.model;

/**
 *
 * @author g52196
 */
public interface Model {

    /**
     * Initalizes the board
     */
    void initialize();

    /**
     * Returns the cells of the board
     *
     * @return the cells of the board
     */
    Board getBoard();

    /**
     * Returns true if the game is over
     *
     * @return true if the game is over, otherwise false
     */
    boolean isOver();

    /**
     * Returns the color of the current player
     *
     * @return the color of the current player
     */
    PlayerColor getCurrentColor();

    /**
     * Returns the score of a player
     *
     * @param color the color of the player we wants to get the score
     * @return the score of a player
     */
    int getScore(PlayerColor color);
}

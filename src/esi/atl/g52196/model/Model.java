package esi.atl.g52196.model;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author g52196
 */
public interface Model extends Observable {

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
     * Returns a copy of the current player
     *
     * @return a copy of the current player
     */
    Player getCurrent();

    /**
     * Returns a copy of the opponent player
     *
     * @return a copy of the opponent player
     */
    Player getOpponent();

    /**
     * Returns the score of a player
     *
     * @param color the color of the player we wants to get the score
     * @return the score of a player
     */
    int getScore(PlayerColor color);

    /**
     * Returns a list of possible moves for the current player
     *
     * @return a list of possible move (position) for the current player
     */
    List<Position> getPossibleMoves();

    /**
     * Returns true if the move has been done, otherwise false
     *
     * Checks if the player has possible moves, if not return false
     *
     * if the player has possible moves :
     *
     * If the move was legal the method checks for the first pawn of the
     * currentPlayer that is not present on board and sets its position and adds
     * it to the board. Finally, the methods checks if the game need to be set
     * to true
     *
     * If it returns false, it means that the move was not legal
     *
     * @param position The future position of the pawn
     *
     * @return true if the move has been done, otherwise false
     */
    boolean play(Position position);

    /**
     * Returns the color of the player that as the highest score.
     *
     * Returns null if players have the same score.
     *
     * @return the color of the player that as the highest score
     */
    PlayerColor getWinner();

    /**
     * Returns the historic of the game
     *
     * @return the historic of the game
     */
    ObservableList<History> getHistory();

    /**
     * Swaps the players
     */
    void swapPlayers();

    /**
     * Get the name of a player
     *
     * @param color the color of the player we want
     * @return the name of a player
     */
    String getPlayerName(PlayerColor color);

    /**
     * Resets the game
     */
    void reset();

    /**
     * Skip turn of current player
     */
    void skipTurn();
}

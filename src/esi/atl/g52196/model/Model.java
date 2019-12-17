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
     * it to the board.
     *
     * @param position The future position of the pawn
     *
     */
    void play(Position position);

    /**
     * Returns the color of the player that as the highest score.
     *
     * Returns null if players have the same score.
     *
     * @return the color of the player that as the highest score
     */
    Player getWinner();

    /**
     * Returns the player with the color passed in parameter
     *
     * @param color the color of the player we want to get
     * @return
     */
    Player getPlayer(PlayerColor color);

    /**
     * Returns the historic of the game
     *
     * @return the historic of the game
     */
    ObservableList<HistoryAction> getHistory();

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

    /**
     * Plays a random move
     */
    void playRandomMove();

    /**
     * Counts the number of pawn on the board
     *
     * @return the number of pawn on the board
     */
    int getNbPawnsOnBoard();

    /**
     * Counts the number of pawn on the board of a player
     *
     * @return the number of pawn on the board of a player
     */
    int getNbPawnsOnBoard(PlayerColor color);

    /**
     * Returns a copy of the list of bonus positions
     *
     * @return a copy of the list of bonus positions
     */
    List<Position> getBonusPositions();
    
    /**
     * Returns the score of a player
     *
     * @param color the color of the player
     * @return the score of a player
     */
    int getScore(PlayerColor color);
}

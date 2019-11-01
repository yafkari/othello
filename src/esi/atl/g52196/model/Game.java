package esi.atl.g52196.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @author 52196
 *
 * Represents a game
 */
public class Game {

    private Board board;
    private Player currentPlayer;
    private Player opponentPlayer;
    private boolean isOver;

    /**
     * Creates a game with two players one black and one white
     *
     * The first player is black
     */
    public Game() {
        currentPlayer = new Player(PlayerColor.BLACK);
        opponentPlayer = new Player(PlayerColor.WHITE);
    }

    /**
     * Initalizes the board
     */
    public void initialize() {
        board = new Board();

        Pawn whitePawn1 = new Pawn(PlayerColor.WHITE, new Position(3, 3), 1);
        Pawn blackPawn1 = new Pawn(PlayerColor.BLACK, new Position(3, 4), 1);
        Pawn blackPawn2 = new Pawn(PlayerColor.BLACK, new Position(4, 3), 1);
        Pawn whitePawn2 = new Pawn(PlayerColor.WHITE, new Position(4, 4), 1);

        board.addPawn(whitePawn1);
        board.addPawn(blackPawn1);
        board.addPawn(blackPawn2);
        board.addPawn(whitePawn2);

        currentPlayer.addPawn(blackPawn1);
        currentPlayer.addPawn(blackPawn2);
        opponentPlayer.addPawn(whitePawn1);
        opponentPlayer.addPawn(whitePawn2);

        currentPlayer.addPawn(new Pawn(PlayerColor.BLACK, null, 0));
        currentPlayer.addPawn(new Pawn(PlayerColor.BLACK, null, 3));
        opponentPlayer.addPawn(new Pawn(PlayerColor.WHITE, null, 0));
        opponentPlayer.addPawn(new Pawn(PlayerColor.WHITE, null, 3));
        for (int i = 0; i < 10; i++) {
            currentPlayer.addPawn(new Pawn(PlayerColor.BLACK, null, 2));
            opponentPlayer.addPawn(new Pawn(PlayerColor.WHITE, null, 2));
        }
        for (int i = 0; i < 18; i++) {
            currentPlayer.addPawn(new Pawn(PlayerColor.BLACK, null, 1));
            opponentPlayer.addPawn(new Pawn(PlayerColor.WHITE, null, 1));
        }
        Collections.shuffle(currentPlayer.getPawns());
        Collections.shuffle(opponentPlayer.getPawns());
    }

    /**
     * Returns the cells of the board
     *
     * @return the cells of the board
     */
    public Cell[][] getBoard() {
        return board.getCells();
    }

    /**
     * Returns the cells of the board
     *
     * @return the cells of the board
     */
    public boolean getIsOver() {
        return isOver;
    }

    /**
     * Returns the color of the current player
     *
     * @return the color of the current player
     */
    public PlayerColor getCurrentColor() {
        return currentPlayer.getColor();
    }

    /**
     * Returns the score each player
     *
     * @return the score each player
     */
    public int[] getScores() {
        int[] scores = new int[2];
        scores[0] = currentPlayer.getPawns().stream()
                .mapToInt(x -> x.getPosition() != null ? x.getValue() : 0)
                .sum();
        scores[1] = opponentPlayer.getPawns().stream()
                .mapToInt(x -> x.getPosition() != null ? x.getValue() : 0)
                .sum();

        return scores;
    }

    /**
     * Returns the pawn of a position
     *
     * @param position the position to look at
     * @return the pawn at the position or null if there is no pawn
     */
    private Pawn getPawn(Position position) {
        return board.getCell(position).getPawn();
    }

    public List<Position> getPossibleMoves() {
        List<Position> result = new ArrayList<>();

        for (int row = 0; row < board.getCells().length; row++) {
            for (int col = 0; col < board.getCells()[row].length; col++) {
                Position position = new Position(row, col);
                if (board.isInside(position)) {
                    if (!board.getCell(position).isEmpty() && IsMyPawn(getPawn(position))) {
                        for (Direction direction : Direction.values()) {
                            Position nextPos = position.nextPos(direction);
                            if (!board.getCell(nextPos).isEmpty() && !IsMyPawn(getPawn(nextPos))) {
                                while (!board.getCell(nextPos).isEmpty() && !IsMyPawn(getPawn(nextPos))) {
                                    nextPos = nextPos.nextPos(direction);
                                }
                                if (board.getCell(nextPos).isEmpty()) {
                                    if (!result.contains(nextPos)) {
                                        result.add(nextPos);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns true if the pawn passed in parameter is a pawn of the current
     * player
     *
     * @param pawn the player to look at
     * @return true if the pawn belongs to the current player, otherwise false
     */
    private boolean IsMyPawn(Pawn pawn) {
        return pawn.getColor() == getCurrentColor();
    }

    /**
     * Returns true if the move to the position passed in parameter is legal
     *
     * @param position the position to check
     * @return true if the move to the position passed in parameter is legal
     */
    private boolean isLegalMove(Position position) {
        System.out.println(getPossibleMoves());
        return getPossibleMoves().contains(position);
    }

    /**
     * Returns true if the move has been done, otherwise false
     *
     * If it returns false, it means that the move was not legal
     *
     * @param position The future position of the pawn
     *
     * @return true if the move has been done, otherwise false
     */
    public boolean play(Position position) {
        if (!isLegalMove(position)) {
            return false;
        }
        Pawn pawn = currentPlayer.getPawns().get(0);
        pawn.setPosition(position);
        board.addPawn(pawn);
        return true;
    }

    /**
     * Sets the game as over.
     *
     * The game is set as over if a player does not have any pawn or if there is
     * no possible moves for the two players anymore.
     */
    void gameOver() {
        isOver = true;
    }

    /**
     * Swaps the players
     */
    public void swapPlayers() {
        Player tmp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = tmp;
    }
}

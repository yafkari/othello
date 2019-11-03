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

    /**
     * Returns true if the pawn passed in parameter is a pawn of the current
     * player
     *
     * @param pawn the player to look at
     * @return true if the pawn belongs to the current player, otherwise false
     */
    private boolean isMyPawn(Pawn pawn) {
        return pawn.getColor() == getCurrentColor();
    }

    /**
     * Changes the color of a pawn to the color of the current player and
     * returns it
     *
     * @param pawn the pawn to change the color
     * @return the pawn passed in parameter after changing its color
     */
    private Pawn eatPawn(Pawn pawn) {
        pawn.setColor(getCurrentColor());
        currentPlayer.addPawn(opponentPlayer.removePawn(pawn));
        return pawn;
    }

    /**
     * Returns true if the move to the position passed in parameter is legal
     *
     * @param position the position to check
     * @return true if the move to the position passed in parameter is legal
     */
    private boolean isLegalMove(Position position) {
        List<Position> toEat = new ArrayList<>();
        boolean legit = false;
        for (Direction direction : Direction.values()) {
            Position nextPos = position.nextPos(direction);
            if (board.isInside(nextPos) && !board.getCell(nextPos).isEmpty()
                    && !isMyPawn(getPawn(nextPos))) {
                while (!board.getCell(nextPos).isEmpty()
                        && !isMyPawn(getPawn(nextPos))) {
                    toEat.add(nextPos);
                    nextPos = nextPos.nextPos(direction);
                }

                if (!board.getCell(nextPos).isEmpty()
                        && isMyPawn(getPawn(nextPos))) {
                    toEat.stream().forEach(p -> eatPawn(getPawn(p)));
                    legit = true;
                } else {
                    toEat.clear();
                }
            }
        }
        return legit;
    }

    /**
     * Returns a list of possible moves for the current player
     *
     * @return a list of possible move (position) for the current player
     */
    public List<Position> getPossibleMoves() {
        List<Position> result = new ArrayList<>();

        for (int row = 0; row < board.getCells().length; row++) {
            for (int col = 0; col < board.getCells()[row].length; col++) {
                Position currentPos = new Position(row, col);
                if (board.isInside(currentPos)) {
                    if (!board.getCell(currentPos).isEmpty()
                            && isMyPawn(getPawn(currentPos))) {
                        for (Direction direction : Direction.values()) {
                            Position nextPos = currentPos.nextPos(direction);
                            if (board.isInside(nextPos)
                                    && !board.getCell(nextPos).isEmpty()
                                    && !isMyPawn(getPawn(nextPos))) {
                                while (board.isInside(nextPos)
                                        && !board.getCell(nextPos).isEmpty()
                                        && !isMyPawn(getPawn(nextPos))) {
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
     * Returns the first pawn that as no position (not on the board) of the
     * current player
     *
     * @return the first pawn that as no position (not on the board) of the
     * current player
     */
    private Pawn pickUnusedPawn() {
        return currentPlayer.getPawns()
                .stream()
                .filter(p -> p.getPosition() == null)
                .findFirst()
                .orElse(null);
    }

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
    public boolean play(Position position) {
        if (getPossibleMoves().isEmpty()) {
            swapPlayers();
            if (getPossibleMoves().isEmpty()) {
                isOver = true;
                return false;
            }
        }
        if (!isLegalMove(position)) {
            return false;
        }
        Pawn pawn = pickUnusedPawn();
        pawn.setPosition(position);
        if (!board.getCell(pawn.getPosition()).isEmpty()) {
            return false;
        }

        board.addPawn(pawn);
        return true;
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

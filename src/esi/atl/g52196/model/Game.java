package esi.atl.g52196.model;

import static esi.atl.g52196.model.Board.BOARD_SIZE;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author 52196
 *
 * Represents a game
 */
public class Game implements Model, Observable {

    private Board board;
    private Player currentPlayer;
    private Player opponentPlayer;
    private boolean isOver;
    private List<Observer> observers;
    private List<History> history;

    /**
     * Creates a game with two players.One is black and the other is white
     *
     * The first player is black
     *
     */
    public Game() {
        observers = new ArrayList();
        history = new ArrayList();
        currentPlayer = new Player(PlayerColor.BLACK);
        opponentPlayer = new Player(PlayerColor.WHITE);
        history.add(new History(currentPlayer.getName(),
                "New game started", ""));
    }

    /**
     * Initalizes the board
     */
    @Override
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

        initializePlayerPawns();
    }

    /**
     * Initialize and shuffle player pawns
     */
    private void initializePlayerPawns() {
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
    @Override
    public Board getBoard() {
        return new Board(board);
    }

    /**
     * Returns true if the game is over
     *
     * @return true if the game is over, otherwise false
     */
    @Override
    public boolean isOver() {
        return isOver;
    }

    /**
     * Returns the color of the current player
     *
     * @return the color of the current player
     */
    @Override
    public PlayerColor getCurrentColor() {
        return currentPlayer.getColor();
    }

    /**
     * Returns the color of the opponent player
     *
     * @return the color of the opponent player
     */
    @Override
    public PlayerColor getOpponentColor() {
        return opponentPlayer.getColor();
    }

    /**
     * Returns the score of a player
     *
     * @param color the color of the player we wants to get the score
     * @return the score of a player
     */
    @Override
    public int getScore(PlayerColor color) {
        if (getCurrentColor() == color) {
            return currentPlayer.getPawns().stream()
                    .mapToInt(x -> x.getPosition() != null ? x.getValue() : 0)
                    .sum();
        }

        return opponentPlayer.getPawns().stream()
                .mapToInt(x -> x.getPosition() != null ? x.getValue() : 0)
                .sum();
    }

    /**
     * Changes the color of a pawn to the color of the current player and
     * removes it from the opponent
     *
     * @param pawn the pawn to change the color
     * @return true if the pawn has been eaten
     */
    boolean eatPawn(Pawn pawn) {
        if (pawn != null) {
            if (opponentPlayer.getPawns().contains(pawn)) {
                currentPlayer.addPawn(opponentPlayer.removePawn(pawn));
                pawn.setColor(getCurrentColor());
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if the move to the position passed in parameter is legal
     *
     * @param position the position to check
     * @return true if the move to the position passed in parameter is legal
     */
    boolean applyMove(Position position) {
        List<Position> toEat = new ArrayList<>();
        boolean legit = false;
        for (Direction direction : Direction.values()) {
            Position nextPos = position.nextPos(direction);
            if (isInside(nextPos) && !isEmpty(nextPos) && !isMyPawn(nextPos)) {
                while (isInside(nextPos) && !isEmpty(nextPos)
                        && !isMyPawn(nextPos)) {
                    toEat.add(nextPos);
                    nextPos = nextPos.nextPos(direction);
                }

                if (isInside(nextPos) && !isEmpty(nextPos) && isMyPawn(nextPos)) {
                    toEat.stream().forEach(p -> {
                        Pawn pawn = getPawn(p);
                        if (pawn != null) {
                            if (eatPawn(pawn)) {
                                board.addPawn(pawn);
                            }
                        }
                    });
                    System.out.println("toEat=" + toEat);
                    legit = true;
                } else {
                    toEat.clear();
                    legit = legit == true ? true : false;
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
    @Override
    public List<Position> getPossibleMoves() {
        List<Position> moves = new ArrayList<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Position currentPos = new Position(row, col);
                if (isInside(currentPos)) {
                    checkDirections(currentPos, moves);
                }
            }
        }
        return moves;
    }

    /**
     * Looks for possible moves in each directions.
     *
     * @param currentPos the current position to look at
     * @param moves the list of moves to update
     */
    private void checkDirections(Position currentPos, List<Position> moves) {
        if (!isEmpty(currentPos) && isMyPawn(currentPos)) {
            for (Direction direction : Direction.values()) {
                Position nextPos = currentPos.nextPos(direction);
                if (isInside(nextPos) && !isEmpty(nextPos)
                        && !isMyPawn(nextPos)) {
                    while (isInside(nextPos) && !isEmpty(nextPos)
                            && !isMyPawn(nextPos)) {
                        nextPos = nextPos.nextPos(direction);
                    }
                    if (isEmpty(nextPos)) {
                        if (!moves.contains(nextPos)) {
                            moves.add(nextPos);
                        }
                    }
                }
            }
        }
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
    @Override
    public boolean play(Position position) {
        if (!getPossibleMoves().contains(position)) {
            return false;
        }

        applyMove(position);
        Pawn pawn = pickUnusedPawn();
        pawn.setPosition(position);

        if (!board.isEmpty(position)) {
            return false;
        }

        board.addPawn(pawn);
        history.add(new History(currentPlayer.getName(), "made a move",
                position.toString()));
        swapPlayers();
        checkIsOver();
        notifyObservers();

        return true;
    }

    /**
     * Returns true if the pawn passed in parameter is a pawn of the current
     * player
     *
     * @param pawn the pawn to look at
     * @return true if the pawn belongs to the current player, otherwise false
     */
    private boolean isMyPawn(Pawn pawn) {
        return pawn.getColor() == getCurrentColor();
    }

    /**
     * Returns true if the pawn at the position passed in parameter is a pawn of
     * the current player
     *
     * @param position the position of the pawn to look at
     * @return true if the pawn belongs to the current player, otherwise false
     */
    private boolean isMyPawn(Position position) {
        return isMyPawn(getPawn(position));
    }

    /**
     * Returns true if the position passed in parameter is in the board, false
     * otherwise
     *
     * @param position the position to check
     * @return true if the position passed in parameter is in the board, false
     * otherwise
     */
    private boolean isInside(Position position) {
        return getBoard().isInside(position);
    }

    /**
     * Returns if the position is free or not
     * 
     * @param position the position to look at
     * @return true if the position is free, otherwise false
     */
    private boolean isEmpty(Position position) {
        return getBoard().isEmpty(position);
    }
    
    /**
     * Returns the pawn at the position passed in parameter
     *
     * @param position the position of the pawn we want to get
     * @return the pawn at the position passed in parameter
     */
    private Pawn getPawn(Position position) {
        return getBoard().getPawn(position);
    }

    /**
     * Returns the color of the player that as the highest score.
     *
     * Returns null if players have the same score.
     *
     * @return the color of the player that as the highest score
     */
    @Override
    public PlayerColor getWinner() {
        int currentScore = getScore(currentPlayer.getColor());
        int opponentScore = getScore(opponentPlayer.getColor());

        if (currentScore == opponentScore) {
            return null;
        }

        return currentScore > opponentScore
                ? currentPlayer.getColor()
                : opponentPlayer.getColor();
    }

    /**
     * Returns the historic of the game
     *
     * @return the historic of the game
     */
    @Override
    public ObservableList<History> getHistory() {
        return FXCollections.observableArrayList(history);
    }

    /**
     * Swaps the players
     */
    @Override
    public void swapPlayers() {
        Player tmp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = tmp;
    }

    /**
     * Checks if the game is over
     */
    private void checkIsOver() {
        if (getPossibleMoves().isEmpty()) {
            swapPlayers();
            if (getPossibleMoves().isEmpty()) {
                isOver = true;
                swapPlayers();
            }
        }
    }

    /**
     * Get the name of a player
     *
     * @param color the color of the player we want
     * @return the name of a player
     */
    @Override
    public String getPlayerName(PlayerColor color) {
        if (color == currentPlayer.getColor()) {
            return currentPlayer.getName().length() == 0
                    ? currentPlayer.getColor().toString()
                    : currentPlayer.getName();
        } else {
            return opponentPlayer.getName().length() == 0
                    ? opponentPlayer.getColor().toString()
                    : opponentPlayer.getName();
        }
    }

    /**
     * Sets player's name
     *
     * @param color the color of the player
     * @param name the name to set
     */
    @Override
    public void setPlayerName(PlayerColor color, String name) {
        if (getCurrentColor() == color) {
            currentPlayer.setName(name.length() == 0
                    ? color.toString()
                    : name);
        } else {
            opponentPlayer.setName(name.length() == 0
                    ? color.toString()
                    : name);
        }
    }

    /**
     * Resets the game
     */
    @Override
    public void reset() {
        String currentName = currentPlayer.getName();
        String opponentName = opponentPlayer.getName();
        history.add(new History(currentName, "restarted game", ""));

        currentPlayer = new Player(PlayerColor.BLACK);
        currentPlayer.setName(currentName);

        opponentPlayer = new Player(PlayerColor.WHITE);
        opponentPlayer.setName(opponentName);
        initialize();
        isOver = false;
        notifyObservers();
    }

    /**
     * Skip turn of current player
     */
    @Override
    public void skipTurn() {
        swapPlayers();
        history.add(new History(currentPlayer.getName(), "change player", ""));
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        if (observers.contains(obs)) {
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}

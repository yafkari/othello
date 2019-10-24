package esi.atl.g52196.model;

/**
 * @author 52196
 *
 * Represents a game
 */
public class Game {

    private Board board;
    private Player blackPlayer;
    private Player whitePlayer;
    private boolean isOver;

    /**
     * Creates a game with two players one black and one white
     *
     * The first player is black
     */
    public Game() {
        blackPlayer = new Player(PlayerColor.BLACK);
        whitePlayer = new Player(PlayerColor.WHITE);
    }

    /**
     * Initalizes the board
     */
    public void initialize() {
        board = new Board();

        Pawn whitePawn1 = new Pawn(PlayerColor.WHITE, new Position(3, 3));
        Pawn blackPawn1 = new Pawn(PlayerColor.BLACK, new Position(3, 4));
        Pawn blackPawn2 = new Pawn(PlayerColor.BLACK, new Position(4, 3));
        Pawn whitePawn2 = new Pawn(PlayerColor.BLACK, new Position(4, 4));

        board.addPawn(whitePawn1);
        board.addPawn(blackPawn1);
        board.addPawn(blackPawn2);
        board.addPawn(whitePawn2);

        blackPlayer.addPawn(blackPawn1);
        blackPlayer.addPawn(blackPawn2);
        whitePlayer.addPawn(whitePawn1);
        whitePlayer.addPawn(whitePawn2);
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
     * Sets the game as over.
     *
     * The game is set as over if a player does not have any pawn or if there is
     * no possible moves for the two players anymore.
     */
    public void gameOver() {
        isOver = true;
    }
}

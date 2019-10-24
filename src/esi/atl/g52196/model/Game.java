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

    /**
     * Creates a game with two players one black and one white
     *
     * The first player is black
     */
    public Game() {
        blackPlayer = new Player(PlayerColor.BLACK);
        whitePlayer = new Player(PlayerColor.WHITE);
    }

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
    }
}

package esi.atl.g52196.model;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 52196
 */
public class GameTest {

    private Board board = new Board();

    @Before
    public void setUp() throws Exception {
        Pawn whitePawn1 = new Pawn(PlayerColor.WHITE, new Position(3, 3), 1);
        Pawn blackPawn1 = new Pawn(PlayerColor.BLACK, new Position(3, 4), 1);
        Pawn blackPawn2 = new Pawn(PlayerColor.BLACK, new Position(4, 3), 1);
        Pawn whitePawn2 = new Pawn(PlayerColor.WHITE, new Position(4, 4), 1);

        board.addPawn(whitePawn1);
        board.addPawn(blackPawn1);
        board.addPawn(blackPawn2);
        board.addPawn(whitePawn2);
    }

    @Test
    public void testInitialize() {
        System.out.println("testInitialize");
        Game instance = new Game();

        instance.initialize();
        assertFalse(instance.getBoard().isEmpty(new Position(3, 3)));
        assertFalse(instance.getBoard().isEmpty(new Position(3, 4)));
        assertFalse(instance.getBoard().isEmpty(new Position(4, 3)));
        assertFalse(instance.getBoard().isEmpty(new Position(4, 4)));
    }

    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = new Game();
        instance.initialize();
        Board result = instance.getBoard();
        assertEquals(board.getPawn(new Position(3, 3)),
                result.getPawn(new Position(3, 3)));
        assertEquals(board.getPawn(new Position(0, 0)),
                result.getPawn(new Position(0, 0)));

    }

    @Test
    public void testGetIsOver() {
        System.out.println("testGetIsOver");
        Game instance = new Game();
        boolean result = instance.isOver();
        assertEquals(false, result);
    }

    @Test
    public void testGetCurrentColorWhenBlack() {
        System.out.println("testGetCurrentColorWhenBlack");
        Game instance = new Game();
        PlayerColor result = instance.getCurrentColor();
        assertEquals(PlayerColor.BLACK, result);
    }

    @Test
    public void testGetCurrentColorWhenWhite() {
        System.out.println("testGetCurrentColorWhenWhite");
        Game instance = new Game();
        instance.swapPlayers();
        PlayerColor result = instance.getCurrentColor();
        assertEquals(PlayerColor.WHITE, result);
    }

    @Test
    public void testGetScore() {
        System.out.println("testGetScore");
        Game instance = new Game();
        instance.initialize();
        int expResult = 2;
        int result = instance.getScore(PlayerColor.BLACK);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves() {
        System.out.println("testGetPossibleMoves");
        Game instance = new Game();
        instance.initialize();
        List<Position> expResult = Arrays.asList(new Position(5, 4),
                new Position(3, 2), new Position(2, 3), new Position(4, 5));
        List<Position> result = instance.getPossibleMoves();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsLegalMoveWhenTrue() {
        System.out.println("testIsLegalMoveWhenTrue");
        Game instance = new Game();
        instance.initialize();
        assertTrue(instance.isLegalMove(new Position(2, 3)));
    }

    @Test
    public void testIsLegalMoveWhenFalse() {
        System.out.println("testIsLegalMoveWhenFalse");
        Game instance = new Game();
        instance.initialize();
        assertFalse(instance.isLegalMove(new Position(0, 0)));
    }

    @Test
    public void testPlayWhenTrue() {
        System.out.println("testPlayWhenTrue");
        Game instance = new Game();
        instance.initialize();
        assertFalse(instance.getPossibleMoves().isEmpty());
        assertTrue(instance.play(new Position(2, 3)));
    }

    @Test
    public void testPlayWhenFalse() {
        System.out.println("testPlayWhenFalse");
        Game instance = new Game();
        instance.initialize();
        assertFalse(instance.play(new Position(0, 0)));
    }

    @Test
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game();
        assertEquals(PlayerColor.BLACK, instance.getCurrentColor());
        instance.swapPlayers();
        assertEquals(PlayerColor.WHITE, instance.getCurrentColor());
    }

    @Test
    public void testEatPawn() {
        System.out.println("testEatPawn");
        Game instance = new Game();
        instance.initialize();
        instance.play(new Position(2, 3));
    }

    @Test
    public void testGetWinner() {
        System.out.println("testGetWinner");
        Game instance = new Game();
        instance.initialize();
        assertTrue(instance.play(new Position(2, 3)));
        PlayerColor result = instance.getWinner();
        assertEquals(PlayerColor.BLACK, result);
    }
}

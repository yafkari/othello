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

        board[3][3].fill(whitePawn1);
        board[3][4].fill(blackPawn1);
        board[4][3].fill(blackPawn2);
        board[4][4].fill(whitePawn2);
    }

    @Test
    public void testInitialize() {
        System.out.println("testInitialize");
        Game instance = new Game();
        instance.initialize();
        assertEquals(4, instance.getPossibleMoves().size());
    }

    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = new Game();
        instance.initialize();
        Cell[][] result = instance.getBoard().getCells();
        assertEquals(board[3][3].getPawn(), result[3][3].getPawn());
        assertEquals(board[0][0].getPawn(), result[0][0].getPawn());

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
    public void testGetScores() {
        System.out.println("testGetScores");
        Game instance = new Game();
        instance.initialize();
        int[] expResult = {2, 2};
        int[] result = instance.getScores();
        assertArrayEquals(expResult, result);
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
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game();
        assertEquals(PlayerColor.BLACK, instance.getCurrentColor());
        instance.swapPlayers();
        assertEquals(PlayerColor.WHITE, instance.getCurrentColor());
    }

    @Test
    public void testIsLegalMoveWhenTrue() {
        System.out.println("testIsLegalMoveWhenTrue");
        Game instance = new Game();
        instance.initialize();
        assertTrue(instance.isLegalMove(instance.getPossibleMoves().get(0)));
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
        assertTrue(instance.play(instance.getPossibleMoves().get(0)));
    }

    @Test
    public void testPlayWhenFalse() {
        System.out.println("testPlayWhenFalse");
        Game instance = new Game();
        instance.initialize();
        assertFalse(instance.play(new Position(0, 0)));
    }

    @Test
    public void testGetWinner() {
        System.out.println("testGetWinner");
        Game instance = new Game();
        instance.initialize();
        instance.play(new Position(2, 3));
        
        assertEquals(PlayerColor.BLACK, instance.getWinnwer());
    }
}

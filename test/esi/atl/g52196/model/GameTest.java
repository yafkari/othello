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
        Game instance = new Game("", false, "", false);

        instance.initialize();
        assertFalse(instance.getBoard().isEmpty(new Position(3, 3)));
        assertFalse(instance.getBoard().isEmpty(new Position(3, 4)));
        assertFalse(instance.getBoard().isEmpty(new Position(4, 3)));
        assertFalse(instance.getBoard().isEmpty(new Position(4, 4)));
    }

    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = new Game("", false, "", false);

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
        Game instance = new Game("", false, "", false);

        boolean result = instance.isOver();
        assertEquals(false, result);
    }

    @Test
    public void testGetCurrentColorWhenBlack() {
        System.out.println("testGetCurrentColorWhenBlack");
        Game instance = new Game("", false, "", false);
        PlayerColor result = instance.getCurrent().getColor();
        assertEquals(PlayerColor.BLACK, result);
    }

    @Test
    public void testGetCurrentColorWhenWhite() {
        System.out.println("testGetCurrentColorWhenWhite");
        Game instance = new Game("", false, "", false);
        instance.swapPlayers();
        PlayerColor result = instance.getCurrent().getColor();
        assertEquals(PlayerColor.WHITE, result);
    }

    @Test
    public void testGetScore() {
        System.out.println("testGetScore");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        int expResult = 2;
        int result = instance.getPlayer(PlayerColor.BLACK).getScore();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPossibleMoves() {
        System.out.println("testGetPossibleMoves");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        List<Position> expResult = Arrays.asList(new Position(5, 4),
                new Position(3, 2), new Position(2, 3), new Position(4, 5));
        List<Position> result = instance.getPossibleMoves();
        assertEquals(expResult, result);
    }

    /*@Test
    public void testIsLegalMoveWhenTrueFirstTurn() {
        System.out.println("testIsLegalMoveWhenTrueFirstTurn");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        assertTrue(instance.applyMove(new Position(2, 3)));

    }

    @Test
    public void testIsLegalMoveWhenTrueSecondTurn() {
        System.out.println("testIsLegalMoveWhenTrueSecondTurn");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        testIsLegalMoveWhenTrueFirstTurn();
        instance.play(new Position(2, 3));
        assertTrue(instance.applyMove(new Position(4, 2)));
    }

    @Test
    public void testIsLegalMoveWhenTrueThirdTurn() {
        System.out.println("testIsLegalMoveWhenTrueThirdTurn");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        testIsLegalMoveWhenTrueSecondTurn();
        instance.play(new Position(2, 3));
        instance.play(new Position(4, 2));
        assertTrue(instance.applyMove(new Position(5, 3)));
    }

    @Test
    public void testIsLegalMoveWhenFalse() {
        System.out.println("testIsLegalMoveWhenFalse");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        assertFalse(instance.applyMove(new Position(0, 0)));
    }*/
    @Test
    public void testPlayWhenTrue() {
        System.out.println("testPlayWhenTrue");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        assertFalse(instance.getPossibleMoves().isEmpty());
//        assertTrue(instance.play(new Position(2, 3)));
    }

    @Test
    public void testPlayWhenFalse() {
        System.out.println("testPlayWhenFalse");
        Game instance = new Game("", false, "", false);
        instance.initialize();
//        assertFalse(instance.play(new Position(0, 0)));
    }

    @Test
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game("", false, "", false);
        assertEquals(PlayerColor.BLACK, instance.getCurrent().getColor());
        instance.swapPlayers();
        assertEquals(PlayerColor.WHITE, instance.getCurrent().getColor());
    }

    @Test
    public void testEatPawn() {
        System.out.println("testEatPawn");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        instance.play(new Position(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWinnerWhenNotOver() {
        System.out.println("testGetWinnerWhenNotOver");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        instance.play(new Position(2, 3));
        instance.getWinner();
    }

    @Test
    public void testGetWinnerWhenWinner() {
        System.out.println("testGetWinnerWhenWinner");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        instance.play(new Position(2, 3));
        instance.skipTurn();
        instance.play(instance.getPossibleMoves().get(0));
        Player result = instance.getWinner();
        assertEquals(PlayerColor.BLACK, result.getColor());
    }

    /*@Test
   public void testGetWinnerWhenEquality() {
        System.out.println("testGetWinnerWhenEquality");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        PlayerColor result = instance.getWinner();
        assertNull(result);
    }*/
    @Test
    public void testReset() {
        System.out.println("testReset");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        int expResult = instance.getPossibleMoves().size();
        instance.initialize();
        instance.reset();
        assertEquals(expResult, instance.getPossibleMoves().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testWhenGameNotInitialized() {
        System.out.println("testWhenGameNotInitialized");
        Game instance = new Game("", false, "", false);
        instance.getPossibleMoves();
    }

    @Test
    public void testPlayRandomMove() {
        System.out.println("testPlayRandomMove");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        instance.playRandomMove();
    }

    @Test
    public void testSkipTurn() {
        System.out.println("testSkipTurn");
        Game instance = new Game("", false, "", false);
        instance.initialize();
        instance.skipTurn();
        assertEquals(PlayerColor.WHITE, instance.getCurrent().getColor());
        assertEquals(2, instance.getHistory().size());
    }

    @Test
    public void testGetPlayerName() {
        System.out.println("testGetBlackPlayerName");
        Game instance = new Game("Black", false, "White", false);
        instance.initialize();
        assertTrue("Black".equals(instance.getPlayerName(PlayerColor.BLACK)));
        assertTrue("White".equals(instance.getPlayerName(PlayerColor.WHITE)));
    }

    public void testGetOpponent() {
        System.out.println("testGetOpponent");
        Game instance = new Game("Black", false, "White", false);
        instance.initialize();
        assertEquals(PlayerColor.WHITE, instance.getOpponent().getColor());
    }

    public void testGetHistory() {
        System.out.println("testGetHistory");
        Game instance = new Game("Black", false, "White", false);
        instance.initialize();
        assertEquals(1, instance.getHistory().size());
    }

}

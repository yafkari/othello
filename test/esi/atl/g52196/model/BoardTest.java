package esi.atl.g52196.model;

import static esi.atl.g52196.model.Board.BOARD_SIZE;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 52196
 */
public class BoardTest {

    private Board board = new Board();

    @Before
    public void setUp() throws Exception {
        board.addPawn(new Pawn(PlayerColor.WHITE, new Position(3, 3), 1));
        board.addPawn(new Pawn(PlayerColor.BLACK, new Position(3, 4), 1));
        board.addPawn(new Pawn(PlayerColor.BLACK, new Position(4, 3), 1));
        board.addPawn(new Pawn(PlayerColor.WHITE, new Position(4, 4), 1));
    }

    @Test
    public void testIsInsideWhenFalse() {
        System.out.println("testIsInsideWhenFalse");
        Position position = new Position(-1, -1);
        assertFalse(board.isInside(position));
    }

    @Test
    public void testIsInsideWhenTrue() {
        System.out.println("testIsInsideWhenTrue");
        Position position = new Position(0, 0);

        assertTrue(board.isInside(position));
    }

    @Test
    public void testIsEmptyWhenFalse() {
        System.out.println("testIsEmptyWhenFalse");
        assertFalse(board.isEmpty(new Position(3, 4)));
    }

    @Test
    public void testIsEmptyWhenTrue() {
        System.out.println("testIsEmptyWhenTrue");
        assertTrue(board.isEmpty(new Position(1, 1)));
    }

    @Test
    public void testAddPawnWhenNotFree() {
        System.out.println("testAddPawnWhenNotFree");
        Pawn pawn = new Pawn(PlayerColor.WHITE, new Position(3, 3), 1);
        assertFalse(board.isEmpty(pawn.getPosition()));
        board.addPawn(pawn);
        assertEquals(pawn, board.getPawn(pawn.getPosition()));
    }

    @Test
    public void testAddPawnWhenFree() {
        System.out.println("testAddPawnWhenFree");
        Pawn pawn = new Pawn(PlayerColor.WHITE, new Position(0, 0), 1);
        assertTrue(board.isEmpty(pawn.getPosition()));
        board.addPawn(pawn);
        assertEquals(pawn, board.getPawn(pawn.getPosition()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPawnWhenNotInside() {
        System.out.println("testAddPawnWhenNotInside");
        Pawn pawn = new Pawn(PlayerColor.WHITE, new Position(-1, -1), 1);
        board.addPawn(pawn);
    }

    @Test
    public void testRemoveWhenPawnNotPresent() {
        System.out.println("testRemoveWhenPawnNotPresent");
        Position position = new Position(3, 3);
        board.remove(position);
        assertTrue(board.isEmpty(position));
    }

    @Test
    public void testRemoveWhenPawnPresent() {
        System.out.println("testRemoveWhenPawnPresent");
        assertFalse(board.isEmpty(new Position(3, 3)));
    }
}

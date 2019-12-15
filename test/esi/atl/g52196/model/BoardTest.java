package esi.atl.g52196.model;

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
        assertFalse(board.isInside(new Position(-1, -1)));
        assertFalse(board.isInside(new Position(8, 8)));
        assertFalse(board.isInside(new Position(8, 0)));
        assertFalse(board.isInside(new Position(0, 8)));
        assertFalse(board.isInside(new Position(-1, 8)));
        assertFalse(board.isInside(new Position(8, -1)));

    }

    @Test
    public void testIsInsideWhenTrue() {
        System.out.println("testIsInsideWhenTrue");
        assertTrue(board.isInside(new Position(0, 0)));
        assertTrue(board.isInside(new Position(1, 1)));
        assertTrue(board.isInside(new Position(7, 7)));
        assertTrue(board.isInside(new Position(6, 7)));
        assertTrue(board.isInside(new Position(7, 6)));

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

    @Test(expected = NullPointerException.class)
    public void testAddPawnWhenNull() {
        System.out.println("testAddPawnWhenNull");
        board.addPawn(null);
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
    
    @Test(expected = NullPointerException.class)
    public void testRemoveWhenNull() {
        System.out.println("testRemoveWhenNull");
        board.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckIsInside() {
        System.out.println("testCheckIsInside");
        board.isEmpty(new Position(-1, 0));
    }
}

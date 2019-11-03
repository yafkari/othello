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
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells()[i].length; j++) {
                board.getCells()[i][j] = new Cell();
            }
        }
        Pawn whitePawn1 = new Pawn(PlayerColor.WHITE, new Position(3, 3), 1);
        Pawn blackPawn1 = new Pawn(PlayerColor.BLACK, new Position(3, 4), 1);
        Pawn blackPawn2 = new Pawn(PlayerColor.BLACK, new Position(4, 3), 1);
        Pawn whitePawn2 = new Pawn(PlayerColor.WHITE, new Position(4, 4), 1);

        board.getCells()[3][3].fill(whitePawn1);
        board.getCells()[3][4].fill(blackPawn1);
        board.getCells()[4][3].fill(blackPawn2);
        board.getCells()[4][4].fill(whitePawn2);
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
        Board instance = new Board();

        assertTrue(instance.isInside(position));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddPawnWhenNotFree() {
        System.out.println("testAddPawnWhenNotFree");
        Pawn pawn = new Pawn(PlayerColor.WHITE, new Position(3, 3), 1);
        board.addPawn(pawn);
    }

    @Test
    public void testAddPawnWhenFree() {
        System.out.println("testAddPawnWhenFree");
        Pawn pawn = new Pawn(PlayerColor.WHITE, new Position(0, 0), 1);
        board.addPawn(pawn);
    }

    @Test
    public void testRemoveWhenPawnPresent() {
        System.out.println("testRemoveWhenPawnPresent");
        Position position = new Position(3, 3);
        board.remove(position);
        assertTrue(board.getCell(position).getPawn() == null);
    }

}

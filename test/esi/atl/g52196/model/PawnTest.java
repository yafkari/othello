package esi.atl.g52196.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g52196
 */
public class PawnTest {

    @Test
    public void testGetColorWhenBlack() {
        System.out.println("testGetColorWhenBlack");
        Pawn instance = new Pawn(PlayerColor.BLACK, null, 0);
        assertEquals(PlayerColor.BLACK, instance.getColor());
    }

    @Test
    public void testGetColorWhenWhite() {
        System.out.println("testGetColorWhenWhite");
        Pawn instance = new Pawn(PlayerColor.WHITE, null, 0);
        assertEquals(PlayerColor.WHITE, instance.getColor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPositionWhenNegative() {
        System.out.println("testGetPositionWhenNegative");
        Pawn instance = new Pawn(PlayerColor.WHITE, new Position(-1, -1), 0);
    }

    @Test
    public void testGetPositionWhenPositive() {
        System.out.println("testGetPositionWhenPositive");
        Pawn instance = new Pawn(PlayerColor.WHITE, new Position(0, 1), 0);
        assertEquals(0, instance.getPosition().getRow());
        assertEquals(1, instance.getPosition().getColumn());

    }

    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Pawn instance = new Pawn(PlayerColor.BLACK, null, 0);
        assertEquals(0, instance.getValue());
    }
}

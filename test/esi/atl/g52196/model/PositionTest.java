package esi.atl.g52196.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 52196
 */
public class PositionTest {

    @Test
    public void testEqualsWhenTrue() {
        System.out.println("testEqualsWhenTrue");
        Position instance = new Position(1, 1);
        Position other = new Position(1, 1);
        boolean result = instance.equals(other);
        assertEquals(true, result);
    }

    @Test
    public void testEqualsWhenFalse() {
        System.out.println("testEqualsWhenFalse");
        Position instance = new Position(1, 1);
        Position other = new Position(1, 0);
        boolean result = instance.equals(other);
        assertEquals(false, result);
    }

    @Test
    public void testNextPos() {
        System.out.println("testNextPos");
        Position instance = new Position(1, 1);
        Position result = instance.nextPos(Direction.NORTH);
        assertTrue(result.equals(new Position(0, 1)));
    }
}

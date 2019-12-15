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
        assertTrue(result);
    }

    @Test
    public void testEqualsWhenFalse() {
        System.out.println("testEqualsWhenFalse");
        Position instance = new Position(1, 1);
        Position other = new Position(1, 0);
        boolean result = instance.equals(other);
        assertFalse(result);
    }
    
    @Test
    public void testEqualsWhenSame() {
        System.out.println("testEqualsWhenSame");
        Position instance = new Position(1, 1);
        boolean result = instance.equals(instance);
        assertTrue(result);
    }
    
    @Test
    public void testEqualsWhenDifferentClass() {
        System.out.println("testEqualsWhenDifferentClass");
        Position instance = new Position(1, 1);
        boolean result = instance.equals(new String());
        assertFalse(result);
    }

    @Test
    public void testNextPos() {
        System.out.println("testNextPos");
        Position instance = new Position(1, 1);
        Position result = instance.nextPos(Direction.NORTH);
        assertTrue(result.equals(new Position(0, 1)));
    }

    @Test
    public void testHashCodeWhenNull() {
        System.out.println("testHashCodeWhenNotEquals");
        Position instance1 = new Position(0,0);
        assertFalse(instance1.equals(null));
    }

    @Test
    public void testHashCodeWhenNotEquals() {
        System.out.println("testHashCodeWhenNotEquals");
        Position instance1 = new Position(0,0);
        Position instance2 = new Position(0,1);
        assertFalse(instance1.equals(instance2));
    }

    @Test
    public void testHashCodeWhenEquals() {
        System.out.println("testHashCodeWhenEquals");
        Position instance1 = new Position(0,0);
        Position instance2 = new Position(0,0);
        assertTrue(instance1.equals(instance2));
    }
}

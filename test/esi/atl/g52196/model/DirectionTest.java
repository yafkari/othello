package esi.atl.g52196.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 52196
 */
public class DirectionTest {

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Direction instance = Direction.NORTH;
        int expResult = -1;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Direction instance = Direction.WEST;
        int expResult = -1;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

}

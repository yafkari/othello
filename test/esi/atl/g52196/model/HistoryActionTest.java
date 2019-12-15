package esi.atl.g52196.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 52196
 */
public class HistoryActionTest {

    @Test
    public void testGetId() {
        System.out.println("testGetId");
        HistoryAction instance = new HistoryAction("", "");
        HistoryAction instance2 = new HistoryAction("", "");
        //one already created during unit test launch ??
        
        assertEquals(1, instance.getId());
        assertEquals(2, instance2.getId());
    }

    @Test
    public void testGetPlayerName() {
        System.out.println("testGetPlayerName");
        HistoryAction instance = new HistoryAction("name", "");
        assertEquals("name", instance.getPlayerName());
    }

    @Test
    public void testGetAction() {
        System.out.println("testGetAction");
        HistoryAction instance = new HistoryAction("", "action");
        assertEquals("action", instance.getAction());
    }

    @Test
    public void testGetPosition() {
        System.out.println("testGetPosition");
        HistoryAction instance = new HistoryAction("", "", new Position(0, 0));
        assertEquals("(0,0)", instance.getPosition());
    }
}

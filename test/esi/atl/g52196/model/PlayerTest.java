package esi.atl.g52196.model;

import static esi.atl.g52196.model.PlayerColor.BLACK;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 52196
 */
public class PlayerTest {

    @Test(expected = NullPointerException.class)
    public void testConstructWhenNull() {
        System.out.println("testConstructWhenNull");
        Player player = new Player(null, "", false);
    }

    @Test
    public void testConstructWhenNameGiven() {
        System.out.println("testConstructWhenNull");
        Player player = new Player(BLACK, "name", false);
    }

    @Test
    public void testGetColor() {
        System.out.println("testGetColor");
        Player player = new Player(BLACK, "", false);
        PlayerColor result = player.getColor();
        assertEquals(BLACK, result);
    }

    @Test
    public void testGetPawnsWhenNoPawns() {
        System.out.println("testGetPawnsWhenNoPawns");
        Player player = new Player(BLACK, "", false);
        int result = player.getPawns().size();
        assertEquals(0, result);
    }

    @Test
    public void testGetPawnsWhenPawns() {
        System.out.println("testGetPawnsWhenPawns");
        Player player = new Player(BLACK, "", false);
        for (int i = 0; i < 10; i++) {
            player.addPawn(new Pawn(BLACK, null, i));
        }
        int result = player.getPawns().size();
        assertEquals(10, result);
    }

    @Test
    public void testRemovePawnWhenExist() {
        System.out.println("testRemovePawnWhenExist");
        Player player = new Player(BLACK, "", false);
        for (int i = 0; i < 10; i++) {
            player.addPawn(new Pawn(BLACK, null, i));
        }
        Pawn result = player.removePawn(new Pawn(BLACK, null, 7));
        assertEquals(new Pawn(BLACK, null, 7), result);
        assertTrue(!player.getPawns()
                .contains(new Pawn(BLACK, null, 7)));
    }

    @Test
    public void testRemovePawnWhenNull() {
        System.out.println("testRemovePawnWhenNull");
        Player player = new Player(BLACK, "", false);
        player.addPawn(new Pawn(BLACK, null, 0));
        assertNull(player.removePawn(new Pawn(BLACK, null, 1)));
    }
}

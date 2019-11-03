package esi.atl.g52196.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 52196
 */
public class PlayerTest {

    @Test
    public void testGetColor() {
        System.out.println("testGetColor");
        Player player = new Player(PlayerColor.BLACK);
        PlayerColor result = player.getColor();
        assertEquals(PlayerColor.BLACK, result);
    }

    @Test
    public void testGetPawnsWhenNoPawns() {
        System.out.println("testGetPawnsWhenNoPawns");
        Player player = new Player(PlayerColor.BLACK);
        int result = player.getPawns().size();
        assertEquals(0, result);
    }

    @Test
    public void testGetPawnsWhenPawns() {
        System.out.println("testGetPawnsWhenPawns");
        Player player = new Player(PlayerColor.BLACK);
        for (int i = 0; i < 10; i++) {
            player.addPawn(new Pawn(PlayerColor.BLACK, null, i));
        }
        int result = player.getPawns().size();
        assertEquals(10, result);
    }

    @Test
    public void testRemovePawnWhenExist() {
        System.out.println("testRemovePawnWhenExist");
        Player player = new Player(PlayerColor.BLACK);
        for (int i = 0; i < 10; i++) {
            player.addPawn(new Pawn(PlayerColor.BLACK, null, i));
        }
        Pawn result = player.removePawn(new Pawn(PlayerColor.BLACK, null, 7));
        assertEquals(new Pawn(PlayerColor.BLACK, null, 7), result);
        assertTrue(!player.getPawns()
                .contains(new Pawn(PlayerColor.BLACK, null, 7)));
    }
}

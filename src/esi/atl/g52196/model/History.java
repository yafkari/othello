package esi.atl.g52196.model;

/**
 *
 * @author 52196
 */
public class History {

    private int id;
    private static int idCounter;
    private String playerName;
    private String action;
    private String position;
    //private int nbTaken;

    public History(String playerName, String action, String position) {
        this.id = idCounter++;
        this.playerName = playerName;
        this.action = action;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getAction() {
        return action;
    }

    public String getPosition() {
        return position;
    }
}

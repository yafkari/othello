package esi.atl.g52196.model;

/**
 *
 * @author 52196
 */
public class History {

    private int id;
    private String playerName;
    private String action;
    private Position position;
    //private int nbTaken;

    public History(String playerName, String action, Position position) {
        id++;
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

    public Position getPosition() {
        return new Position(position);
    }
}

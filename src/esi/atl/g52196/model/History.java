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

    public History(String playerName, String action, Position position) {
        this.id = idCounter++;
        this.playerName = playerName;
        this.action = action;
        if (position == null) {
            this.position = "";
        } else {
            this.position = position.toString();
        }
    }

    public History(String playerName, String action) {
        this(playerName, action, null);
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

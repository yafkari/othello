package esi.atl.g52196.model;

/**
 *
 * @author 52196
 *
 * Represents an action in the history
 */
public class HistoryAction {

    private int id;
    private static int idCounter;
    private String playerName;
    private String action;
    private String position;

    /**
     * Creates an action made by the player
     *
     * @param playerName the name of the player
     * @param action the action performed
     * @param position the position of the action
     */
    public HistoryAction(String playerName, String action, Position position) {
        this.id = idCounter++;
        this.playerName = playerName;
        this.action = action;
        if (position == null) {
            this.position = "";
        } else {
            this.position = position.toString();
        }
    }

    /**
     *
     * @param playerName the name of the player
     * @param action the action performed
     */
    public HistoryAction(String playerName, String action) {
        this(playerName, action, null);
    }

    /**
     * Returns the id of the action
     *
     * @return the id of the action
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the player
     *
     * @return the name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the action performed
     *
     * @return the action performed
     */
    public String getAction() {
        return action;
    }

    /**
     * Returns the position of the action
     *
     * @return the position of the action
     */
    public String getPosition() {
        return position;
    }
}

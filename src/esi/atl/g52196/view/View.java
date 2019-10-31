package esi.atl.g52196.view;

import esi.atl.g52196.model.Cell;
import esi.atl.g52196.model.PlayerColor;
import java.util.Scanner;

/**
 * @author 52196
 *
 * Represents the view
 */
public class View {

    private Scanner stdin;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Initialize the Scanner
     */
    public View() {
        stdin = new Scanner(System.in);
    }

    /**
     * Displays a welcome message
     */
    public void initialize() {
        displayInfo("Welcome in Othello\n");
    }

    /**
     * Displays a goodbye message
     */
    public void quit() {
        displayInfo("See you soon !");
    }

    /**
     * Asks the user to make an action
     *
     * @return the chosen action
     */
    public String askAction() {
        displayInfo("Please, choose an action:");

        return stdin.nextLine().toLowerCase();
    }

    /**
     * Displays the board passed in parameter
     *
     * @param cells the board to be displayed
     */
    public void displayBoard(Cell[][] cells) {
        System.out.println("  A B C D E F G H");

        for (int i = 0; i < cells.length; i++) {
            System.out.print(i + 1);
            for (Cell column : cells[i]) {
                if (column.isEmpty()) {
                    System.out.print(" _");
                } else {
                    if (column.getPawn().getColor() == PlayerColor.WHITE) {
                        System.out.print(" W");
                    } else {
                        System.out.print(" B");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Displays a message passed in parameter in blue
     *
     * @param message the message that will be displayed
     */
    private void displayInfo(String message) {
        System.out.println(ANSI_BLUE + message + ANSI_RESET);
    }

    /**
     * Displays the error message passed in parameter in red
     *
     * @param message the message that will be displayed
     */
    public void displayError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET + "\n");
    }

    /**
     * Displays the possible action that the user can perform
     */
    public void displayActions() {
        System.out.println("-show : displays the board\n"
                + "-score : displays the score of each player\n"
                + "-play <row> <column> : allows to add a pawn in the board");
    }

    /**
     * Displays the score of each player
     *
     * @param scores the scores of each player. scores[0] correspond to the
     * black player
     */
    public void displayScores(int[] scores) {
        displayInfo("Score:");
        System.out.println("Black player: " + String.valueOf(scores[0]));
        System.out.println("White player: " + String.valueOf(scores[1]));
    }
}

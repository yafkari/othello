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
        System.out.print("A B C D E F G H");

        for (int i = 0; i < cells.length; i++) {
            System.out.print(i + 1);
            for (Cell column : cells[i]) {
                if (column.getPawn().getColor() == PlayerColor.WHITE) {
                    System.out.print("W ");
                } else {
                    System.out.print("B ");
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
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
}

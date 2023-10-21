
package game.Utils;

import edu.monash.fit2099.engine.displays.Display;
import game.CombatArchetypes.Player;

import java.util.Scanner;

public class ArchetypeMenuManager {

    private static Display display = new Display();

    public static int menuItem() {
        Scanner chooseClass = new Scanner(System.in);
        display.println("Choose your starting class: ");
        display.println("1: Samurai");
        display.println("2: Bandit");
        display.println("3: Wretch");
        try {
            int choice = chooseClass.nextInt();
            display.println("Your choice:" + choice);
            return choice;
        } catch (Exception e) {
            display.println("Input must be between 1, 2 or 3");
        }
        return 0;
    }
}



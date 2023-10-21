package game.Utils;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Keith Ong Guo Er
 *
 */
public class ResetManager {
    /**
     * A list of resettables
     */
    private List<Resettable> resettables;
    /**
     * An instance of reset manager
     */
    private static ResetManager instance = null;

    /**
     * Constructor for the ResetManager class
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Resets everything that is resettable on game map
     * @param map the game map
     */
    public void run(GameMap map) {
        for (Resettable resettable : resettables){
            resettable.reset(map);
        }
    }

    /**
     * Add it into the list of Resettable
     * @param resettable the resettable object
     */
    public void registerResettable(Resettable resettable) {resettables.add(resettable);}

    /**
     * Remove resettable from list of Resettable
     * @param resettable the resettable object
     */
    public void removeResettable(Resettable resettable) {resettables.remove(resettable);}

    /**
     * Remove resettable from list of Resettable
     * @return the list of resettables
     */
    public List<Resettable> getResettables(){
        return resettables;
    }


    /**
     * Gets and instance of ResetManager class
     * @return the instance of ResetManager class
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }
}

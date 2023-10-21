package game.Environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Enemies.Enemy;
import game.Utils.SpawnManager;

/**
 * A class that represents the Puddle Of Water environment.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Enemy
 * @see SpawnManager
 */
public class PuddleOfWater extends Ground {
    /**
     * Constructor for PuddleOfWater class
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Perform spawning action on enemies
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) {
            SpawnManager spawnManager = new SpawnManager(this, location);
            Enemy enemy = spawnManager.spawn();
            if (enemy != null) {
                location.addActor(enemy);
            }
        }
    }
}
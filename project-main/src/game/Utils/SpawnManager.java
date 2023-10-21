package game.Utils;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.CombatArchetypes.Player;
import game.Enemies.*;

/**
 * A spawn manager class that manages the action of spawning actors on ground
 * @author Keith Ong Guo Er
 * @version 1.0
 */
public class SpawnManager {
    /**
     * The type of ground
     */
    private Ground ground;
    /**
     * Location on the game map
     */
    private Location location;
    /**
     * The player of Elden Ring
     */
    private Player player;

    /**
     * Constructor for the SpawnManager class
     * @param ground
     * @param location
     */
    public SpawnManager(Ground ground, Location location) {
        this.ground = ground;
        this.location = location;
    }

    /**
     * Helps determine what type of enemies ground will spawn
     * @return Enemy depending on their ground
     */
    public Enemy spawn() {
        char groundChar = ground.getDisplayChar();
        int middle = location.map().getYRange().max() + 1 / 2;
        if (groundChar == 'n') {
            if (RandomNumberGenerator.getRandomInt(100) <= 27) {
                if (location.x() <= middle) {
                    return new HeavySkeletalSwordsman(player);
                } else {
                    return new SkeletalBandit(player);
                }
            }
        } else if (groundChar == '&') {
            if (location.x() <= middle) {
                if (RandomNumberGenerator.getRandomInt(100) <= 33) {
                    return new LoneWolf(player);
                }
            } else {
                if (RandomNumberGenerator.getRandomInt(100) <= 4) {
                    return new GiantDog(player);
                }
            }
        } else if (groundChar == '~') {
            if (location.x() <= middle) {
                if (RandomNumberGenerator.getRandomInt(100) <= 2) {
                    return new GiantCrab(player);
                }
            } else {
                if (RandomNumberGenerator.getRandomInt(100) <= 1) {
                    return new GiantCrayfish(player);
                }
            }
        }
        return null;
    }

    /**
     * setter method for player
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}

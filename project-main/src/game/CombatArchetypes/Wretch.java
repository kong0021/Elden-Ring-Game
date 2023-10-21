package game.CombatArchetypes;

import game.Weapons.Club;
/**
 * The Wretch starting class, has 414 hp and gets a Club.
 * @author Yap Wing Joon
 * @version 1.0
 * @see Player
 */
public class Wretch extends Player{
    /**
     * Constructor for Wretch class.
     */
    public Wretch() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new Club());
    }
}

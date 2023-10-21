package game.CombatArchetypes;

import game.Weapons.Uchigatana;
/**
 * The Samurai starting class, has 455 hp and gets a Uchigatana.
 * @author Yap Wing Joon
 * @version 1.0
 * @see Player
 */
public class Samurai extends Player{
    /**
     * Constructor for Samurai class.
     */
    public Samurai() {
        super("Tarnished", '@', 455);
        this.addWeaponToInventory(new Uchigatana());
    }
}

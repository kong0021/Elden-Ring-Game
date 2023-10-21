package game.CombatArchetypes;


import game.Weapons.GreatKnife;

/**
 * The Bandit starting class, has 414 hp and gets a Great Knife.
 * @author Yap Wing Joon
 * @version 1.0
 * @see Player
 */
public class Bandit extends Player{
    /**
     * Constructor for Bandit class.
     */
    public Bandit() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new GreatKnife());
    }
}

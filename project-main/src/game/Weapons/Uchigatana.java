package game.Weapons;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.*;
import game.Actions.UnsheatheAction;
import game.Items.Runes;
import game.Status;
import game.Utils.RunesManager;

/**
 * @author Yap Wing Joon
 * @version 1.0
 * @see WeaponItem
 *
 * Description: Uchigatana
 * - A katana with a long single-edged curved blade that deals 115 damage with an 80% hit rate.
 */

public class Uchigatana extends WeaponItem implements PurchasableWeapons, SellableWeapons {
    protected final int buyPrice = 5000;
    protected final int sellPrice = 500;

    /**
     * Constructor for Uchigatana class
     */

    public Uchigatana() {
        super("Uchigatana", ')', 115, "slices", 80);

    }

    /**
     * Constructor for Uchigatana class
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */

    public Uchigatana(String name, char displayChar, int damage, String verb, int hitRate){
        super(name, displayChar, damage, verb, hitRate);

    }

    /**
     * Method for purchasing Uchigatana
     *
     * @param actor the actor purchasing Uchigatana
     *
     */

    @Override
    public String purchase(Actor actor) {
        Runes runes = RunesManager.getInstance().getRune(actor);
        int runesAmount = runes.getAmount();
        if (runesAmount >= buyPrice){
            actor.addWeaponToInventory(this);
            runesAmount -= buyPrice;
            return actor + " purchased an " + this + " for " + this.buyPrice;
        } else {
            return (buyPrice - runesAmount) + " more runes needed to purchase " + this;
        }

    }

    /**
     * Method for selling Uchigatana
     *
     * @param actor the actor selling Uchigatana
     *
     */

    @Override
    public String sell(Actor actor) {
        if (actor.getWeaponInventory().contains(this)){
            Runes runes = RunesManager.getInstance().getRune(actor);
            int runesAmount = runes.getAmount();
            actor.getWeaponInventory().remove(this);
            runesAmount += sellPrice;
            return actor + " sold " + this + " to obtain " + this.sellPrice + " runes.";
        } else {
            return this + " does not exist in player's inventory";
        }
    }

    /**
     * Get the skill action from Uchigatana. Use this method if you want to use an UnsheatheAction
     * against one targeted Actor
     * @param target the target actor
     * @param direction the direction of target, e.g. "north"
     * @return returns an UnsheatheAction
     */

    @Override
    public Action getSkill(Actor target, String direction) {

        return new UnsheatheAction(target,direction,this);

    }
}



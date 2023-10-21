package game.Weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AOEAttackAction;
import game.Actions.QuickstepAction;
import game.Items.Runes;
import game.Status;
import game.Utils.RunesManager;

/**
 * Created by:
 * @author Yap Wing Joon
 * @version 1.0
 * @see WeaponItem
 *
 * Description: Grossmesser
 *  - A curved sword boasting a large blade that deals 115 with an 85% hit rate.
 *
 */
public class Grossmesser extends WeaponItem implements SellableWeapons {

    protected final int sellPrice = 100;

    /**
     * Constructor for Grossmesser class
     */

    public Grossmesser(){
        super("Grossmesser", '?', 115, "strikes", 85);
    }

    /**
     * Method for selling Grossmesser
     *
     * @param actor the actor seling Grossmesser
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
     * Get the skill action from Grossmesser. Use this method if you want to use a AOEAttackAction.
     * @param target target actor
     * @param direction
     * @return
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AOEAttackAction(target, direction,this);
    }

}

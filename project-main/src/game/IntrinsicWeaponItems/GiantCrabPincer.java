package game.IntrinsicWeaponItems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AOEAttackAction;
import game.Status;

/**
 * Created by:
 * @author Yap Wing Joon
 * @version 1.0
 * @see WeaponItem
 *
 * Description: Giant Crab Pincer
 *  - The pincer of a Giant Crab that deals 208 damage with a 90% hitrate
 *
 */

public class GiantCrabPincer extends WeaponItem {

    /**
     * Constructor for GiantCrabPincer class
     */

    public GiantCrabPincer(){
        super("Giant Crab Pincer",'[',208,"slams",90);
        this.togglePortability();

    }

    /**
     * Get the skill action from GiantCrabPincer. Use this method if you want to use a AOEAttackAction.
     * @param target target actor
     * @param direction
     * @return
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AOEAttackAction(target, direction,this);
    }
}

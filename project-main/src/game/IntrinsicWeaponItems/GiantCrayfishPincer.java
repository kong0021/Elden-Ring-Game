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
 * Description: Giant Crayfish Pincer
 *  - The pincer of a Giant Crayfish that deals 527 damage with a 100% hitrate
 *
 */

public class GiantCrayfishPincer extends WeaponItem {

    /**
     * Constructor for GiantCrayfishPincer class
     */

    public GiantCrayfishPincer(){
        super("Giant Crayfish Pincer",'{',527,"slams",100);
        this.togglePortability();

    }

    /**
     * Get the skill action from GiantCrayfishPincer. Use this method if you want to use a AOEAttackAction.
     * @param target target actor
     * @param direction
     * @return
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AOEAttackAction(target, direction,this);
    }
}
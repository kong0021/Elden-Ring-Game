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
 *  - The head of a Giant Dog that deals 314 damage with a 90% hitrate
 *
 */

public class GiantDogHead extends WeaponItem {

    /**
     * Constructor for GiantDogHead class
     */

    public GiantDogHead(){
        super("Giant Dog Head",'R',314,"slams",90);
        this.togglePortability();

    }

    /**
     * Get the skill action from GiantDogHead. Use this method if you want to use a AOEAttackAction.
     * @param target target actor
     * @param direction
     * @return
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AOEAttackAction(target, direction,this);
    }
}
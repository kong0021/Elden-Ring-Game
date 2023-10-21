package game.Actions;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Weapons.Uchigatana;

/**
 * An Action which is the Uchigatana's unique skill that attacks an actor for double the base damage
 * @author: Yap Wing Joon
 * @version: 1.0
 * @see: Action
 */

public class UnsheatheAction extends Action {

    /**
     * The target of the actor using the weapon with UnsheatheAction
     */

    private Actor target;

    /**
     * The direction of the attack
     */

    private String direction;

    /**
     * The weapon being used with UnsheatheAction
     */

    private WeaponItem weapon;

    /**
     * Constructor of the UnsheatheAction
     *
     * @param target the target to perform Unsheathe against.
     * @param direction direction the direction of target, e.g. "north".
     * @param weapon the weapon UnsheatheAction is used with.
     *
     */

    public UnsheatheAction(Actor target, String direction, WeaponItem weapon) {

        this.target = target;
        this.direction = direction;
        this.weapon = weapon;

    }


    /**
     * Performs UnsheatheAction
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The menu description of the action.
     * @see AttackAction
     *
     */

    @Override
    public String execute(Actor actor, GameMap map) {

        String result = new AttackAction(target, direction, new Uchigatana("Uchigatana", ')', 230,"super slashes", 60)).execute(actor, map);
        return result;

    }


    /**
     * Returns description of performing the skill
     *
     * @param actor The actor performing the action.
     * @return The description of performing the action.
     *
     */

    @Override
    public String menuDescription(Actor actor) {
            return actor + " activates Unsheathe on " + target + " at " + direction + " with " + weapon;
    }


}
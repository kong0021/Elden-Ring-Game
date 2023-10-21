package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Weapons.GreatKnife;

/**
 * An Action which is the Great Knife's unique skill that attacks an actor then moves awy
 * @author: Yap Wing Joon
 * @version: 1.0
 * @see: Action
 */

public class QuickstepAction extends Action {

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
     */

    public QuickstepAction(Actor target, String direction, WeaponItem weapon) {

        this.target = target;
        this.direction = direction;
        this.weapon = weapon;

    }

    /**
     * Performs QuickstepAction
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The menu description of the action.
     * @see AttackAction
     * @see MoveActorAction
     *
     */

    @Override
    public String execute(Actor actor, GameMap map) {


        String result = new AttackAction(target, direction, new GreatKnife("Great Knife",'/',75,"quickstabs",100)).execute(actor, map);
        for(Exit surroundingLocation: map.locationOf(actor).getExits()){
            Location potentialDestination = surroundingLocation.getDestination();
            if(!(potentialDestination.containsAnActor())){

                result += new MoveActorAction(potentialDestination,surroundingLocation.getName()).execute(actor,map);
            }
        }

        return result + " and moves away" ;

    }
    /**
     * Returns description of performing the skill
     *
     * @param actor The actor performing the action.
     * @return The description of performing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " activates Quickstep on " + target + " at " + direction + " with " + weapon + " and moves away";
    }


}

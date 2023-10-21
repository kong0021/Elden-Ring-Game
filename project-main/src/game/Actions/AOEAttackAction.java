package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;


/**
 * An AOE Attack Action that attacks actor surrounding the actor holding the weapon
 * @author Yap Wing Joon
 * @version 1.0
 * @see Action
 */
public class AOEAttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;


    /**
     * The weapon being used with SlamAttackAction
     */

    private WeaponItem weapon;


    /**
     * Constructor for SlamAction class
     *
     * @param weapon the weapon SlamAction is used with.
     *
     */

    public AOEAttackAction(Actor target, String direction, WeaponItem weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Performs AOEAttackAction
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The menu description of the action.
     * @see AttackAction
     *
     */

    @Override
    public String execute(Actor actor, GameMap map) {

        for(Exit surroundingLocation: map.locationOf(actor).getExits()){
            Location aoeTarget = surroundingLocation.getDestination();
            if (aoeTarget.containsAnActor()){
                new AttackAction(aoeTarget.getActor(),surroundingLocation.getName(),weapon).execute(actor,map);
            }

        }

        return menuDescription(actor);
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
        return actor + weapon.verb() + target + " at " + direction + " with " + weapon;
    }
}

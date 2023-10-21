package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An action to transform an actor to another targeted actor.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Action
 */
public class TransformAction extends Action {
    /**
     * Targeted actor to be transformed
     */
    Actor transformTarget;

    public TransformAction(Actor transformTarget){
        this.transformTarget = transformTarget;
    }

    /**
     * When executed, the current actor will be removed and replaced by the target actor to be transformed to.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of type string which shows the actor that is transformed into.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        Location here = map.locationOf(actor);
        map.removeActor(actor);
        map.addActor(transformTarget, here);
        result += System.lineSeparator() + menuDescription(actor);
        return result;
    }

    /**
     * Describes which actor has transformed into the other targeted actor.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has transformed into " + transformTarget.toString();
    }
}

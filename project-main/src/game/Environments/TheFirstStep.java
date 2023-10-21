package game.Environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.RestAction;
import game.Status;

/**
 * A class the represents The First Step which is the first site of lost grace.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Location
 * @see RestAction
 */
public class TheFirstStep extends Ground {
    /**
     * Constructor for TheFirstStep class.
     */
    public TheFirstStep() {
        super('U');
    }

    /**
     * List of allowable actions that can be done by actor at this location.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a list of actions that are able to be performed by actor.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.RESTING)){
            actions.add(new RestAction());
        }
        return actions;
    }
}

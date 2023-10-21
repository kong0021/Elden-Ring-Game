package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Consumable;

/**
 * An Action to consume a consumable
 * Created by:
 * @author Sam Zachary Chee
 * Modified by:
 * Yap Wing Joon
 */
public class ConsumeAction extends Action {

    /**
     * The item that the actor will consume
     */
    Consumable consumable;

    /**
     * Constructor for ConsumeAction.
     *
     * @param consumable the item to be consumed
     *
     */

    public ConsumeAction(Consumable consumable){
        this.consumable = consumable;
    }

    /**
     * Constructor for ConsumeAction.
     *
     * @param actor The actor consuming the consumable
     * @param map The map the actor is on
     *
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = consumable.consume(actor);
        return result;
    }

    /**
     * Describes the actor consuming the consumable
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     *
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable.toString() +
                "(Uses left: " +consumable.getUseCount() + ")";
    }
}

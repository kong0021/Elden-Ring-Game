package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.AttackAction;
import game.Enemies.EnemyType;

/**
 * Created by:
 * @author Sam Zachary Chee Hao Yuan
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Enemies can attack other enemies of different type and player
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return Attack action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        EnemyType enemyType = (EnemyType) actor.capabilitiesList().stream().filter(w -> EnemyType.matchEnum(w)).toArray()[0];
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                if (!target.hasCapability(enemyType)) {
                    if (!actor.getWeaponInventory().isEmpty()) {
                        return new AttackAction(target, exit.getName(), actor.getWeaponInventory().get(0));
                    } else {
                        return new AttackAction(target, exit.getName());
                    }
                }
            }
        }
        return null;
    }
}

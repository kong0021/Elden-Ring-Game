package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.AOEAttackAction;
import game.Enemies.EnemyType;
import game.Utils.RandomNumberGenerator;
/**
 * Created by:
 * @author Yap Wing Joon
 * Modified by:
 *
 */
public class AOEAttackBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        EnemyType enemyType = (EnemyType) actor.capabilitiesList().stream().filter(w -> EnemyType.matchEnum(w)).toArray()[0];
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                if (!target.hasCapability(enemyType)) {
                    if (RandomNumberGenerator.getRandomInt(100) >= 50) {
                        return new AOEAttackAction(target, exit.getName(), actor.getWeaponInventory().get(0));
                    } else {
                        return null;
                    }
                }
            }

        }
        return null;
    }
}
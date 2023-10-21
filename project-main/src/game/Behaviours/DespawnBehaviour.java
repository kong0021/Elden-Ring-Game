package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.DespawnAction;
import game.Utils.RandomNumberGenerator;

public class DespawnBehaviour implements Behaviour {
    private final int chanceToDespawn = 10;

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(100) <= chanceToDespawn){
            return new DespawnAction();
        } else {
            return null;
        }
    }
}

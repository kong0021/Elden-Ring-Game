package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Respawnable;

public class IdleRespawnBehaviour implements Behaviour {


    Respawnable respawnable;

    public IdleRespawnBehaviour(Respawnable respawnable){
        this.respawnable = respawnable;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (respawnable.getTurnsToRespawn() >  0){
            respawnable.countDown();
            return null;
        } else {
            return respawnable.respawn();
        }
    }
}

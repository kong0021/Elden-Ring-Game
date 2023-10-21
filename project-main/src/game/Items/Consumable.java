package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import game.CombatArchetypes.Player;

public interface Consumable {
    String consume(Actor actor);
    int getUseCount();
}

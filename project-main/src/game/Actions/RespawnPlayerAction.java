package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.CombatArchetypes.Player;
import game.Utils.FancyMessage;
import game.Items.Runes;
import game.Utils.RunesManager;

/**
 * Since the player can never truly die, a special class is created to handle the player's "death"
 *
 */
public class RespawnPlayerAction extends Action {
    Player player;

    RunesManager runesManager = RunesManager.getInstance();

    public RespawnPlayerAction(Player player){
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Runes runes = runesManager.getRune(player);
        Runes dummyRunes = runesManager.getRune(null);
        dummyRunes.setAmount(runes.getAmount());
        player.getPreviousLocation().addItem(dummyRunes);
        runes.setAmount(0);
        System.out.println("hi");
        map.moveActor(player, player.getRespawnPoint());
        System.out.println(FancyMessage.YOU_DIED);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " respawns at " + player.getRespawnPoint().toString();
    }
}

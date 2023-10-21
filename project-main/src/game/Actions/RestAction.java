package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Runes;
import game.Utils.ResetManager;
import game.Utils.RunesManager;

public class RestAction extends Action {
    private ResetManager resetManager = ResetManager.getInstance();

    @Override
    public String execute(Actor actor, GameMap map) {
        Object[] runesArray = resetManager.getResettables().stream().filter(resettable -> resettable.getClass() == Runes.class).toArray();
        if (runesArray.length != 0){
            Runes runes = (Runes) runesArray[0];
            resetManager.removeResettable(runes);
            new ResetAction().execute(actor, map);
            resetManager.registerResettable(runes);
        } else {
            new ResetAction().execute(actor, map);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at a Site of Grace";
    }
}

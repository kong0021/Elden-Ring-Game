package game.Actions;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Runes;
import game.Utils.RunesManager;

public class PickUpRunesAction extends PickUpAction {
    Runes runesOnTheGround;

    public PickUpRunesAction(Runes runesOnTheGround){
        super(runesOnTheGround);
        this.runesOnTheGround = runesOnTheGround;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        RunesManager.getInstance().getRune(actor).setAmount(runesOnTheGround.getAmount() + RunesManager.getInstance().getRune(actor).getAmount());
        return menuDescription(actor);
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " pick up Runes (value:" + runesOnTheGround.getAmount() + ")";
    }




}

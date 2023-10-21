package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.CombatArchetypes.Player;
import game.Weapons.PurchasableWeapons;

public class PurchaseAction extends Action {

    private PurchasableWeapons purchasableWeapons;

    public PurchaseAction(PurchasableWeapons purchasableWeapons){
        this.purchasableWeapons = purchasableWeapons;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = purchasableWeapons.purchase(actor);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasableWeapons.toString();
    }
}

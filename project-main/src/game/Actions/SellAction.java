package game.Actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Weapons.SellableWeapons;

public class SellAction extends Action {

    private SellableWeapons sellableWeapons;

    public SellAction (SellableWeapons sellableWeapons){
        this.sellableWeapons = sellableWeapons;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = sellableWeapons.sell(actor);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellableWeapons.toString();
    }
}

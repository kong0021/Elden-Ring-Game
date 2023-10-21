package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Actions.PurchaseAction;
import game.Actions.SellAction;
import game.CombatArchetypes.Player;
import game.Items.Runes;
import game.Weapons.*;

import java.util.ArrayList;

public class MerchantKale extends Actor {
    protected ArrayList<game.Weapons.PurchasableWeapons> weaponsForSale = new ArrayList<>();
    protected ArrayList<game.Weapons.SellableWeapons> weaponsAcceptedForPurchase = new ArrayList<>();

    /**
     * Constructor.
     */
    public MerchantKale() {
        super("Merchant Kale", 'K', 9999);
        this.addCapability(Status.TRADABLE);
        this.addWeaponForSale(new game.Weapons.Club());
        this.addWeaponForSale(new game.Weapons.GreatKnife());
        this.addWeaponForSale(new game.Weapons.Scimitar());
        this.addWeaponForSale(new game.Weapons.Uchigatana());
        this.addWeaponsAcceptedForPurchase(new game.Weapons.Club());
        this.addWeaponsAcceptedForPurchase(new game.Weapons.GreatKnife());
        this.addWeaponsAcceptedForPurchase(new game.Weapons.Grossmesser());
        this.addWeaponsAcceptedForPurchase(new game.Weapons.Scimitar());
        this.addWeaponsAcceptedForPurchase(new game.Weapons.Uchigatana());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if(otherActor.hasCapability(Status.TRADABLE)){
            for (game.Weapons.PurchasableWeapons purchasableWeapons : weaponsForSale){
                actions.add(new PurchaseAction(purchasableWeapons));
            }
            for (game.Weapons.SellableWeapons sellableWeapons : weaponsAcceptedForPurchase ){
                actions.add(new SellAction(sellableWeapons));
            }
        }
        return actions;
    }

    public void addWeaponForSale (game.Weapons.PurchasableWeapons purchasableWeapons){
        this.weaponsForSale.add(purchasableWeapons);
    }

    public void addWeaponsAcceptedForPurchase (game.Weapons.SellableWeapons sellableWeapons){
        this.weaponsAcceptedForPurchase.add(sellableWeapons);
    }
}
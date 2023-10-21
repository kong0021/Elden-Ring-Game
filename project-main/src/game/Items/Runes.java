package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.PickUpRunesAction;
import game.Utils.RandomNumberGenerator;
import game.Utils.Resettable;

public class Runes extends Item implements Resettable{

    protected int amount;

    Location currentLocation;

    /***
     * Constructor.
     */
    private Runes(int amount) {
        super("Runes", '$', false);
        setAmount(amount);
    }

    public static Runes generateRunesItem(int low, int high){
        return new Runes(RandomNumberGenerator.getRandomInt(low, high));
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        return new PickUpRunesAction(this);
    }

    @Override
    public void reset(GameMap map) {
        if (currentLocation != null) {
            currentLocation.removeItem(this);
        }
    }
}

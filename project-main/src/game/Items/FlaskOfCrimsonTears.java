package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.ConsumeAction;
import game.Status;
import game.Utils.ResetManager;
import game.Utils.Resettable;

public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {
    private int useCount = 2;
    private int healAmount = 250;
    private ResetManager resetManager = ResetManager.getInstance();
    /***
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'c', false);
        this.addAction(new ConsumeAction(this));
        resetManager.registerResettable(this);

    }

    @Override
    public String consume(Actor actor) {
        if (useCount < 1){
            return "Item out of uses";
        } else {
            useCount -= 1;
            actor.heal(healAmount);
            return actor + " consumes Flask of Crimson Tears to heal " + healAmount + "." ;
        }
    }

    @Override
    public int getUseCount() {
        return useCount;
    }

    @Override
    public void reset(GameMap map) {
        useCount = 2;
    }


}

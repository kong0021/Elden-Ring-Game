package game.Utils;

import edu.monash.fit2099.engine.actors.Actor;
import game.Items.Runes;

import java.util.HashMap;
import java.util.Map;


/**
 * A rune manager class to manage every rune item in the game
 * Created by:
 * @author Sam Zachary Chee Hao Yuan
 *
 */
public class RunesManager{
    /**
     * Hashmap to store key-pair values of actor and their runes
     */
    private static HashMap<Actor, Runes> runesMap;

    /**
     * A static instance of RunesManager
     */
    private static RunesManager instance;

    /**
     * Constructor
     */
    private RunesManager() {
        runesMap = new HashMap<>();
        createRune(null, 0);
        ResetManager.getInstance().registerResettable(getRune(null));
    }

    /**
     * Return an instance of RunesManager
     * @return an instance of RunesManager
     */
    public static RunesManager getInstance() {
        if (instance == null) {
            instance = new RunesManager();
        }
        return instance;
    }

    /**
     * create Rune and store it in hashmap (for enemies as they have randomised rune amount)
     * @param actor the actor that the Rune belong to
     * @param lower smaller int
     * @param upper larger int
     */
    public void createRune(Actor actor, int lower, int upper) {
        if (!runesMap.containsKey(actor)) {
            runesMap.put(actor, Runes.generateRunesItem(lower, upper));
        }
    }

    /**
     * create Rune and store it in hashmap (for players)
     * @param actor the actor that the Rune belong to
     * @param amount rune amount
     */
    public void createRune(Actor actor, int amount){
        if (!runesMap.containsKey(actor)) {
            Runes runes = Runes.generateRunesItem(0, 0);
            runesMap.put(actor, runes);
            runes.setAmount(amount);
        }
    }

    /**
     * Get the specified rune based on the actor
     * @param actor the actor that the Rune belong to
     * @return Rune item
     */
    public Runes getRune(Actor actor) {
        return runesMap.get(actor);
    }

    /**
     * For transaction purposes between to actors
     * @param receiver
     * @param sender
     * @return String
     */
    public String transferRune(Actor receiver, Actor sender) {
        Runes receiverRune =runesMap.get(receiver);
        Runes senderRune = runesMap.get(sender);
        int receiverAmount = senderRune.getAmount() + receiverRune.getAmount();
        receiverRune.setAmount(receiverAmount);
        return  receiver + " retrieved " + receiverAmount + " runes from " + sender;
    }

    /**
     * Remove rune from hashmap
     * @param actor
     */
    public void removeRune(Actor actor){
        runesMap.remove(actor);
    }
}


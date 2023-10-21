package game.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.Items.Runes;
import game.Utils.RunesManager;

import javax.swing.text.html.HTMLDocument;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Yap Wing Joon
 */
public class LoneWolf extends Enemy{

    /**
     * Constructor for LoneWolf class.
     * @param player the player the wolf will follow
     */
    public LoneWolf(Player player) {
        super("Lone Wolf",
                'h',
                102,
                EnemyType.CANINE);
        RunesManager.getInstance().createRune(this, 55, 1470);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(4, new WanderBehaviour());
    }

    /**
     * Wolf uses its claws
     * @return claws
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}



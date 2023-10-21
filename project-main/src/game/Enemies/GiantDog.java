package game.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.IntrinsicWeaponItems.GiantDogHead;
import game.Items.Runes;
import game.Status;
import game.Utils.RunesManager;

/**
 * A Giant Dog that settles in the eastern gusts of wind.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */
public class GiantDog extends Enemy {


    /**
     * Constructor for GiantDog class.
     * @param player Player that will be followed.
     */
    public GiantDog(Player player) {
        super("Giant Dog",
                'G',
                693,
                EnemyType.CANINE);
        RunesManager.getInstance().createRune(this, 313, 1808);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new GiantDogHead());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }
}

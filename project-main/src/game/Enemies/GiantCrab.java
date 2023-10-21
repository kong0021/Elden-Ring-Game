package game.Enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.IntrinsicWeaponItems.GiantCrabPincer;
import game.Items.Runes;
import game.Status;
import game.Utils.RunesManager;
/**
 *
 * A Giant Crab that settles in the western puddles of water.
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */
public class GiantCrab extends Enemy {

    /**
     * Constructor for GiantCrab class.
     * @param player Player that will be followed.
     */

    public GiantCrab(Player player) {
        super("Giant Crab",
                'C',
                407,
                EnemyType.AQUAMARINE);
        RunesManager.getInstance().createRune(this, 318, 4961);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new GiantCrabPincer());
    }

    /**
     * Gets the intrinsic weapon of Giant Crab
     * @return a new intrinsic weapon that deals 208 damage with a 90% hit rate
     */

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }


}


package game.Enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.IntrinsicWeaponItems.GiantCrayfishPincer;
import game.Utils.RunesManager;

/**
 * A Giant Crayfish that settles in the eastern puddles of water.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */
public class GiantCrayfish extends Enemy {

    /**
     * Constructor for GiantCrayFish class.
     * @param player Player that will be followed.
     */
    public GiantCrayfish(Player player) {
        super("Giant Crayfish",
                'R',
                4803,
                EnemyType.AQUAMARINE);
        RunesManager.getInstance().createRune(this, 500, 2374);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new GiantCrayfishPincer());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}

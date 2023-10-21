package game.Enemies;


import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.Status;
import game.Utils.Resettable;
import game.Utils.RunesManager;
import game.Weapons.Scimitar;

/**
 * A Skeletal Bandit that settles in the eastern graveyards.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */

public class SkeletalBandit extends Enemy {
    /**
     * Constructor for SkeletalBandit class.
     * @param player Player that will be followed.
     */
    public SkeletalBandit(Player player) {
        super("Skeletal Bandit",
                'b',
                184,
                EnemyType.SKELETON);
        this.addCapability(Status.RESPAWNABLE);
        RunesManager.getInstance().createRune(this, 35, 892);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new Scimitar());
    }

}

package game.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Behaviours.*;
import game.CombatArchetypes.Player;
import game.Items.Runes;
import game.Status;
import game.Utils.RunesManager;
import game.Weapons.Grossmesser;
/**
 * A Heavy Skeletal Swordsman that settles in the western graveyards.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */
public class HeavySkeletalSwordsman extends Enemy {
    /**
     * Constructor for HeavySkeletalSwordsman.
     * @param player Player that will be followed.
     */
    public HeavySkeletalSwordsman(Player player) {
        super("Heavy Skeletal Swordsman",
                'q',
                153,
                EnemyType.SKELETON);
        this.addCapability(Status.RESPAWNABLE);
        RunesManager.getInstance().createRune(this, 35, 892);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new Grossmesser());
    }


}



package game.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.TransformAction;
import game.Behaviours.Behaviour;
import game.Behaviours.IdleRespawnBehaviour;
import game.Respawnable;
import game.Utils.Resettable;
import game.Utils.RunesManager;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * Poor skeleton, hopefully you come back.
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Enemy
 * Modified by:
 * Yap Wing Joon
 */
public class PilesOfBones extends Enemy implements Respawnable {

    /**
     * number of turns needed for the piles of bones to respawn/transform back
     */
    private int turnsToRespawn = 3;

    /**
     * Actor to be transformed
     */
    private Actor transformTarget;


    /**
     * Constructor for PilesOfBones class.
     * @param transformTarget Actor to be transformed into a pile of bones
     */
    public PilesOfBones(Actor transformTarget) {
        super("Pile of Bones",
                'X',
                1,
                EnemyType.SKELETON);
        this.transformTarget = transformTarget;
        this.behaviours.put(1, new IdleRespawnBehaviour(this));
        for (WeaponItem weaponItem: transformTarget.getWeaponInventory()){
            this.addWeaponToInventory(weaponItem);
        }
        RunesManager.getInstance().createRune(this,RunesManager.getInstance().getRune(transformTarget).getAmount());
    }

    public int getTurnsToRespawn() {
        return turnsToRespawn;
    }

    @Override
    public void countDown() {
        turnsToRespawn --;
    }

    @Override
    public Action respawn() {
        return new TransformAction(transformTarget);
    }


}

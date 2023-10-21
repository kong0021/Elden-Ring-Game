package game.Enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.AttackAction;
import game.Actions.DespawnAction;
import game.Behaviours.Behaviour;
import game.Status;
import game.Utils.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Actor
 * @see Resettable
 * Modified by:
 * Yap Wing Joon
 */
public abstract class Enemy extends Actor implements Resettable {
    /**
     * Behaviours of enemy
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints, EnemyType enemyType) {
        super(name, displayChar, hitPoints);
        this.addCapability(enemyType);

    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }


    /**
     * The enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            if(!otherActor.getWeaponInventory().isEmpty()){
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
                for(WeaponItem weapon: otherActor.getWeaponInventory()) {
                    Action specialAttack = weapon.getSkill(this, direction);
                    actions.add(specialAttack);
                }
            } else {
                actions.add(new AttackAction(this, direction));
            }
        }
        return actions;
    }

    /**
     * Resets when the player rests at a site of grace (Enemy despawns)
     * @param map current GameMap
     */
    @Override
    public void reset(GameMap map) {
        new DespawnAction().execute(this, map);
    }


}

package game.CombatArchetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.ResetAction;
import game.Actions.RespawnPlayerAction;
import game.Items.FlaskOfCrimsonTears;
import game.Status;
import game.Utils.ResetManager;
import game.Utils.Resettable;
import game.Utils.RunesManager;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public abstract class Player extends Actor implements Resettable {
	private final Menu menu = new Menu();

	private ResetManager resetManager = ResetManager.getInstance();

	private RunesManager runesManager = RunesManager.getInstance();

	private Location previousLocation;

	private Location respawnPoint;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addItemToInventory(new FlaskOfCrimsonTears());
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.TRADABLE);
		this.addCapability(Status.RESTING);
		resetManager.registerResettable(this);
		runesManager.createRune(this, 0, 0);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if (!this.isConscious()){
			new ResetAction().execute(this,map);
			runesManager.getRune(null).setLocation(previousLocation);
			new RespawnPlayerAction(this).execute(this, map);
			return new DoNothingAction();
		}
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		this.previousLocation = map.locationOf(this);
		System.out.println("Hit Points: " + this.printHp() + " | Runes: " + RunesManager.getInstance().getRune(this).getAmount());
		// return/print the console menu
		Action actionChosen =  menu.showMenu(this, actions, display);
		return actionChosen;
	}

	public Location getPreviousLocation() {
		return previousLocation;
	}

	public Location getRespawnPoint() {
		return respawnPoint;
	}

	@Override
	public void reset(GameMap map) {
		this.hitPoints = maxHitPoints;
	}

	public void setRespawnPoint(Location location){
		this.respawnPoint = location;
	}
}

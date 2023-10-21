package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.CombatArchetypes.Bandit;
import game.CombatArchetypes.Player;
import game.CombatArchetypes.Samurai;
import game.CombatArchetypes.Wretch;
import game.Enemies.HeavySkeletalSwordsman;
import game.Environments.*;
import game.Utils.ArchetypeMenuManager;
import game.Utils.FancyMessage;
import game.Utils.SpawnManager;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(),
				new PuddleOfWater(), new TheFirstStep());

		List<String> map = Arrays.asList(
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#___U____................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................&&&......######..##...",
				"..#.....__...........................................&&&......#....____....",
				"..#___..............&&&..............................&&&........__.....#...",
				"..####__###.........&&&......................................._.....__.#...",
				"....................&&&.......................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		Player player = null;
		int choice = ArchetypeMenuManager.menuItem();
		switch (choice) {
			case 1:
				player = new Samurai();
				break;
			case 2:
				player = new Bandit();
				break;
			case 3:
				player = new Wretch();
		}

		// HINT: what does it mean to prefer composition to inheritance?
		player.setRespawnPoint(gameMap.at(38, 11));
		SpawnManager spawnManager = new SpawnManager(null, null);
		spawnManager.setPlayer(player);
		gameMap.at(40, 12).addActor(new MerchantKale());
		world.addPlayer(player, gameMap.at(36, 10));

		world.run();
	}
}

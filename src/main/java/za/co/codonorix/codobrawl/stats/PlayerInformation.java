package za.co.codonorix.codobrawl.stats;

import za.co.codonorix.codobrawl.game_mechanics.GamePlayerObject;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;

import java.util.HashMap;
import java.util.UUID;

public class PlayerInformation {
	/*
	This is our singlton instance, the idea behind this line is to allow us to only have one instance of this hashmap
	 */
	private static HashMap<UUID, PlayerInformationObject> instance = null;
	private static HashMap<UUID, GamePlayerObject> gamePlayerObjectHashMap = null;

	/*
	This will return the users data information. We check for a null value to see if we need to create the hashmap
	 */
	public static PlayerInformationObject getInformation(UUID uuid) {
		if (instance == null)
			instance = new HashMap<>();

		return instance.get(uuid);
	}

	/*
	This method is used to add information when certain player information changes, this can be coins, wins, etc.
	 */
	public static void addPlayerData(UUID uuid, PlayerInformationObject playerInformationObject){
		if (instance == null)
			instance = new HashMap<>();

		instance.put(uuid, playerInformationObject);
	}

	//=============================================================================
	public static GamePlayerObject getGameInformation(UUID uuid) {
		if (gamePlayerObjectHashMap == null)
			gamePlayerObjectHashMap = new HashMap<>();

		return gamePlayerObjectHashMap.get(uuid);
	}

	/*
	This method is used to add information when certain player information changes, this can be coins, wins, etc.
	 */
	public static void addPlayerGameData(UUID uuid, GamePlayerObject playerInformationObject){
		if (gamePlayerObjectHashMap == null)
			gamePlayerObjectHashMap = new HashMap<>();

		gamePlayerObjectHashMap.put(uuid, playerInformationObject);
	}
}

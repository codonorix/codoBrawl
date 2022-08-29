package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import za.co.codonorix.codobrawl.CodoBrawl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ArenaCreatorLoader {
	public static ArrayList<ArenaCreatorObject> arenas = new ArrayList<>();

	public void arenaCreatorLoader() {
		FileConfiguration config = CodoBrawl.getInstance().getConfig();

		Map<String, Object> getConfig = config.getConfigurationSection("arenas").getValues(false);
		Object[] testing = getConfig.keySet().toArray();
		for(int i = 0; i < testing.length; i++) {
			Map<String, Object> arenaData = config.getConfigurationSection("arenas." + testing[i]).getValues(true);
			Object[] arenaDataList = arenaData.values().toArray();
			Component name = Component.text((String) arenaDataList[0]);
			int arenaMode = (int) arenaDataList[1];
			Location spawn1 = (Location) arenaDataList[2];
			Location spawn2 = (Location) arenaDataList[3];
			ArrayList<Location> healLocations = (ArrayList<Location>) arenaDataList[4];
			ArrayList<Location> ddLocation = (ArrayList<Location>) arenaDataList[5];
			Location waitingLobby = (Location) arenaDataList[6];

			ArenaCreatorObject newArena = new ArenaCreatorObject(name, arenaMode, spawn1, spawn2, healLocations, ddLocation, waitingLobby);
			arenas.add(newArena);
		}
	}
}

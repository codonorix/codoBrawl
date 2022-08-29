package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import za.co.codonorix.codobrawl.CodoBrawl;

import java.util.ArrayList;

public class ArenaCreatorStagesClick implements Listener {
	static Location spawn1 = null;
	static Location spawn2 = null;
	static ArrayList<Location> healLocations = new ArrayList<>();
	static ArrayList<Location> ddLocations = new ArrayList<>();
	static Location waitingLobby = null;

	@EventHandler
	public void onClickEvent(PlayerInteractEvent event) {
				/*
		Arena requirements
		0: Arena Name
		1: Mode (1v1, 2v2, 4v4)
		2: Arena spawn 1
		3: Arena spawn 2
		4: # of health placements
		5: (loop) health placement location
		6: # of double damage placements
		7: (loop) double damage locations
		 */

		Player player = event.getPlayer();
		if(!(ArenaCreator.playerStage.containsKey(player.getUniqueId())))return;
		if(event.getItem() == null) return;

		PersistentDataContainer dataContainer = event.getItem().getItemMeta().getPersistentDataContainer();


		if(ArenaCreator.playerStage.get(player.getUniqueId()) == 2) {


			NamespacedKey spawn1Key = new NamespacedKey(CodoBrawl.getInstance(), "SET_SPAWN_1");
			NamespacedKey spawn2Key = new NamespacedKey(CodoBrawl.getInstance(), "SET_SPAWN_2");
			NamespacedKey confirmKey = new NamespacedKey(CodoBrawl.getInstance(), "CONFIRM_SPAWN");


			try {
				if (dataContainer.has(spawn1Key)) {
					spawn1 = event.getClickedBlock().getLocation();
					player.sendMessage(Component.text("Spawn 1 set!", TextColor.color(0, 255, 0)));
				}
				if (dataContainer.has(spawn2Key)) {
					spawn2 = event.getClickedBlock().getLocation();
					player.sendMessage(Component.text("Spawn 2 set!", TextColor.color(0, 255, 0)));
				}
			}catch(Exception ex){
				player.sendMessage(Component.text("Please look at a valid block.", TextColor.color(255, 0, 20)));
			}
			if(dataContainer.has(confirmKey)) {
				if (spawn1 == null)
					//255 0 20
					player.sendMessage(Component.text("Spawn 1 is not set!", TextColor.color(255, 0, 20)));
				else if (spawn2 == null)
					player.sendMessage(Component.text("Spawn 2 is not set!", TextColor.color(255, 0, 20)));
				else{
					player.sendMessage(Component.text("Spawn locations set.", TextColor.color(0, 255, 0)));
					ArenaCreator.playerStage.replace(player.getUniqueId(), 3);
					player.getInventory().clear();
				}
			}
		} else if (ArenaCreator.playerStage.get(player.getUniqueId()) == 3) {
			NamespacedKey healBoost = new NamespacedKey(CodoBrawl.getInstance(), "PLACE_HEAL_BOOST");
			NamespacedKey confirmKey = new NamespacedKey(CodoBrawl.getInstance(), "CONFIRM_SPAWN");

			try {
				if (dataContainer.has(healBoost)) {
					healLocations.add(event.getClickedBlock().getLocation());
					player.sendMessage(Component.text("Added health boost.", TextColor.color(0, 255, 0)));
				}
			}catch (Exception ex){
				player.sendMessage(Component.text("Please look at a valid block.", TextColor.color(255, 0, 20)));
				ex.printStackTrace();
			}

			if(dataContainer.has(confirmKey)) {
				if(healLocations.isEmpty())
					player.sendMessage(Component.text("You need at least one health spawn location!", TextColor.color(255, 0, 20)));
				else{
					player.sendMessage(Component.text("Heal locations set.", TextColor.color(0, 255, 0)));
					ArenaCreator.playerStage.replace(player.getUniqueId(), 4);
					player.getInventory().clear();
				}
			}
		} else if (ArenaCreator.playerStage.get(player.getUniqueId()) == 4) {
			NamespacedKey healBoost = new NamespacedKey(CodoBrawl.getInstance(), "PLACE_DAMAGE_BOOST");
			NamespacedKey confirmKey = new NamespacedKey(CodoBrawl.getInstance(), "CONFIRM_SPAWN");

			try {
				if (dataContainer.has(healBoost)) {
					ddLocations.add(event.getClickedBlock().getLocation());
					player.sendMessage(Component.text("Added double damage boost.", TextColor.color(0, 255, 0)));
				}
			}catch (Exception ex){
				player.sendMessage(Component.text("Please look at a valid block.", TextColor.color(255, 0, 20)));
				ex.printStackTrace();
			}

			if(dataContainer.has(confirmKey)) {
				if(ddLocations.isEmpty())
					player.sendMessage(Component.text("You need at least one double damage spawn location!", TextColor.color(255, 0, 20)));
				else{
					player.sendMessage(Component.text("Double damage locations set.", TextColor.color(0, 255, 0)));
					ArenaCreator.playerStage.replace(player.getUniqueId(), 5);
					player.getInventory().clear();
				}
			}
		}else if(ArenaCreator.playerStage.get(player.getUniqueId()) == 5){
			NamespacedKey waitingLobbyKey = new NamespacedKey(CodoBrawl.getInstance(), "SET_WAITING_LOBBY");
			NamespacedKey confirmKey = new NamespacedKey(CodoBrawl.getInstance(), "CONFIRM_SPAWN");

			try {
				if (dataContainer.has(waitingLobbyKey)) {
					waitingLobby = event.getClickedBlock().getLocation();
					player.sendMessage(Component.text("Waiting lobby location set.", TextColor.color(0, 255, 0)));
				}
			}catch (Exception ex){
				player.sendMessage(Component.text("Please look at a valid block.", TextColor.color(255, 0, 20)));
			}

			if(dataContainer.has(confirmKey)) {
				if(waitingLobby == null)
					player.sendMessage(Component.text("You need to set a waiting lobby!", TextColor.color(255, 0, 20)));
				else{
					player.sendMessage(Component.text("Waiting lobby set.", TextColor.color(0, 255, 0)));
					ArenaCreator.playerStage.replace(player.getUniqueId(), 6);
					player.getInventory().clear();
				}
			}
		}
	}
}

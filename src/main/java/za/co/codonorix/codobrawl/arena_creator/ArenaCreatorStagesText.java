package za.co.codonorix.codobrawl.arena_creator;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;


//This event handler is used to check which stage the user is in and will listen for the input entered by the user
public class ArenaCreatorStagesText implements Listener {
	static Component arenaName;
	static int modeInt;
	static Location spawnOne;
	static Location spawnTwo;
	static ArrayList<Location> healthSpawns;
	static ArrayList<Location> ddSpawns;

	@EventHandler
	public void onAsyncChatEvent(AsyncChatEvent event) {
		Player player = event.getPlayer();

		if(!(ArenaCreator.playerStage.containsKey(player.getUniqueId()))) return;

		event.setCancelled(true);
		int stage = ArenaCreator.playerStage.get(player.getUniqueId());


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
		if(event.message().asComponent().equals(Component.text("-1"))) {
			player.sendMessage(ChatColor.RED + "Exiting arena creator.");
			ArenaCreator.playerStage.replace(player.getUniqueId(), -1);
			return;
		}

		switch(stage) {
			case 0:
				arenaName = event.message().asComponent();
				player.sendMessage(arenaName.color(TextColor.color(255, 255, 255)));

				//Moving the player up to the next stage in the arena creation process.
				ArenaCreator.playerStage.replace(player.getUniqueId(), 1);
				ArenaCreator.firstRun = false;
				break;
			case 1:
				Component mode = event.message().asComponent();

				if(mode.equals(Component.text("1"))) {
					player.sendMessage(Component.text("4v4").color(TextColor.color(255, 255, 255)));
					modeInt = 1;
				}else if(mode.equals(Component.text("2"))) {
					player.sendMessage(Component.text("2v2").color(TextColor.color(255, 255, 255)));
					modeInt = 2;
				}else if(mode.equals(Component.text("3"))) {
					player.sendMessage(Component.text("1v1").color(TextColor.color(255, 255, 255)));
					modeInt = 3;
				}
				ArenaCreator.playerStage.replace(player.getUniqueId(), 2);
				ArenaCreator.firstRun = false;
				break;
		}
	}
}

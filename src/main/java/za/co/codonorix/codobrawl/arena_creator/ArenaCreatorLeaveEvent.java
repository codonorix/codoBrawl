package za.co.codonorix.codobrawl.arena_creator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

//Used to remove the player from the arena creator hashmap should the player leave the server.
public class ArenaCreatorLeaveEvent implements Listener {
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(ArenaCreator.playerStage.containsKey(player.getUniqueId()))
			ArenaCreator.playerStage.replace(player.getUniqueId(), -1);
	}
}

package za.co.codonorix.codobrawl.arena_creator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ArenaCreatorDropItemEvent implements Listener {
	@EventHandler
	public void itemDrop(PlayerDropItemEvent event) {
		if(ArenaCreator.playerStage.containsKey(event.getPlayer().getUniqueId()))
			event.setCancelled(true);
	}
}

package za.co.codonorix.codobrawl.arena_creator;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ArenaCreatorBlockPlaceEvent implements Listener {
	@EventHandler
	public void blockPlaceEvent(BlockPlaceEvent event){
		if(ArenaCreator.playerStage.containsKey(event.getPlayer().getUniqueId())){
			event.setCancelled(true);
		}
	}
}

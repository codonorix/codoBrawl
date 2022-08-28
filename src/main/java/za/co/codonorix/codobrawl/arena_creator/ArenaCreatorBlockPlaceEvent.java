package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ArenaCreatorBlockPlaceEvent implements Listener {
	@EventHandler
	public void blockPlaceEvent(BlockPlaceEvent event){

		if(ArenaCreator.playerStage.containsKey(event.getPlayer().getUniqueId())){
			event.setCancelled(true);
			return;
		}
	}
}

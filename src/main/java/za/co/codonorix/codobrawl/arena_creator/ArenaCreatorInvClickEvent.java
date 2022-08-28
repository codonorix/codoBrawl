package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ArenaCreatorInvClickEvent implements Listener {
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		if(ArenaCreator.playerStage.containsKey(event.getWhoClicked().getUniqueId())){
			event.setCancelled(true);
		}
	}
}

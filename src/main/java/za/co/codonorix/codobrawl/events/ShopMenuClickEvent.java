package za.co.codonorix.codobrawl.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import za.co.codonorix.codobrawl.guis.shop.ShopHolder;

public class ShopMenuClickEvent implements Listener {
	@EventHandler
	public void onClickEvent(InventoryClickEvent event) {
		if(event.getInventory().getHolder() instanceof ShopHolder){
			event.setCancelled(true);
		}
	}
}

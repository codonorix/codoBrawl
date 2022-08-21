package za.co.codonorix.codobrawl.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import za.co.codonorix.codobrawl.join_items.ShopItem;

public class OnJoinEvent implements Listener {
	@EventHandler
	private void onJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();

		player.getInventory().setItem(0, new ShopItem().shopMenu());
	}
}

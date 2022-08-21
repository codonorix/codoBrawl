package za.co.codonorix.codobrawl.events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkills;
import za.co.codonorix.codobrawl.guis.shop.ShopHolder;

public class ShopMenuClickEvent implements Listener {
	@EventHandler
	public void onClickEvent(InventoryClickEvent event) {

		if(event.getInventory().getHolder() instanceof ShopHolder){
			event.setCancelled(true);

			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();

			if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(CodoBrawl.getInstance(), "OFFENSIVE_SKILLS"))) {
				player.openInventory(new OffensiveSkills().offensiveSkills());
			}
		}
	}
}

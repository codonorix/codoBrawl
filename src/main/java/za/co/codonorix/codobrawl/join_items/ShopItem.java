package za.co.codonorix.codobrawl.join_items;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import za.co.codonorix.codobrawl.CodoBrawl;

public class ShopItem {
	public ItemStack shopMenu() {
		/*
		This creates a name space key. This is how we uniquely identify different items and which ones should have an
		effect during certain event triggers.

		1- Value 1 is the instance of our plugin to allow it to understand which project we're using
		2- This is the unique key we'll have for this item.
		 */
		NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), "shopMenuItem");

		ItemStack shopMenuItem = new ItemStack(Material.EMERALD, 1);
		ItemMeta shopMenuMeta = shopMenuItem.getItemMeta();

		/*
		This then sets our key and the value assigned to the key. It can be any datatype but we use a string to easily
		identify what the data container data is.

		Important to remember that the value for this is only there to find which key we're looking for, the main key
		we have when we create the NamespacedKey is the key we'll be making use of when doing checks for events

		i.e.
		shopMenuItem (NamespacedKey) > shopMenuItem (persistentDataContainer)
		 */
		shopMenuMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "shopMenuItem");
		shopMenuMeta.displayName(Component.text(ChatColor.GREEN + "Shop"));

		shopMenuItem.setItemMeta(shopMenuMeta);

		return shopMenuItem;
	}
}

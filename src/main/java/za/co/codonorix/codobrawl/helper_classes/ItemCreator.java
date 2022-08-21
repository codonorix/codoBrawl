package za.co.codonorix.codobrawl.helper_classes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import za.co.codonorix.codobrawl.CodoBrawl;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {
	public ItemStack itemBuilder(String itemName, Material material, List<String> lore, int price ,String id) {
		/*
		Creates a new TextComponent converting a normal string using the base string we feed in the method above.

		IMPORTANT NOTES
		1- Paperspigot makes use of components as this is what minecraft is built on. This creates a better programming
		environment.

		2. (For my learning coz I should have known this) all List objects can work with the rest of the list types
		(arrayLists for eg)
		 */
		TextComponent itemNameComponent = Component.text(itemName);
		List<Component> itemLore = new ArrayList<Component>();

		/*
		We loop through the original list and add all thje components to the component data type and then push that into
		the new lore list.
		 */
		if(!(lore == null)) {
			for (int i = 0; i < lore.size(); i++) {
				itemLore.add(Component.text(lore.get(i)));
			}
		}

		/*
		If the item price is -1 we assume that it's a normal menu item and will not have a price, thus meaning we don't
		need to add it to the item.
		 */
		if(!(price == -1)) {
			itemLore.add(Component.text(""));
			itemLore.add(Component.text(ChatColor.LIGHT_PURPLE + Integer.toString(price) + " crystals."));
		}

		ItemStack itemStack = new ItemStack(material, 1);
		ItemMeta itemStackItemMeta = itemStack.getItemMeta();


		itemStackItemMeta.displayName(itemNameComponent);
		itemStackItemMeta.lore(itemLore);

		NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), id);
		itemStackItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);

		itemStack.setItemMeta(itemStackItemMeta);

		return itemStack;
	}
}

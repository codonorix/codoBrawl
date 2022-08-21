package za.co.codonorix.codobrawl.guis.shop;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ShopMenu {
	public Inventory shopMenu() {
		Inventory shopMenu = Bukkit.createInventory(new ShopHolder(), 27);
		ItemStack offensiveSkills = itemBuilder(ChatColor.GOLD + "Offensive Skills", Material.IRON_SWORD, null);
		ItemStack utilitySkills = itemBuilder(ChatColor.YELLOW + "Utility Skills", Material.GLOWSTONE_DUST, null);
		ItemStack SupportSkills = itemBuilder(ChatColor.GREEN + "Support Skills", Material.GREEN_DYE, null);
		ItemStack ultimateSkills = itemBuilder(ChatColor.RED + "Ultimate Skills", Material.ORANGE_DYE, null);
		ItemStack runes = itemBuilder(ChatColor.BLUE + "Runes", Material.LAPIS_LAZULI, null);
		ItemStack combatUpgrades = itemBuilder(ChatColor.GRAY + "Combat Upgrades", Material.IRON_CHESTPLATE, null);
		ItemStack hats = itemBuilder(ChatColor.AQUA + "Hats",Material.LEATHER_HELMET, null);

		shopMenu.setItem(1, offensiveSkills);
		shopMenu.setItem(3, utilitySkills);
		shopMenu.setItem(5, SupportSkills);
		shopMenu.setItem(7, ultimateSkills);
		shopMenu.setItem(20, runes);
		shopMenu.setItem(22, combatUpgrades);
		shopMenu.setItem(24, hats);

		return shopMenu;
	}

	private ItemStack itemBuilder(String itemName, Material material, List<String> lore) {
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

		ItemStack offensiveSkill = new ItemStack(material, 1);
		ItemMeta offensiveSkillMeta = offensiveSkill.getItemMeta();


		offensiveSkillMeta.displayName(itemNameComponent);
		offensiveSkillMeta.lore(itemLore);

		offensiveSkill.setItemMeta(offensiveSkillMeta);

		return offensiveSkill;
	}
}

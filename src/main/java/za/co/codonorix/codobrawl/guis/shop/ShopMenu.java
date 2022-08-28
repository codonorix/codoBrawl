package za.co.codonorix.codobrawl.guis.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;

public class ShopMenu {
	public Inventory shopMenu() {
		Inventory shopMenu = Bukkit.createInventory(new ShopHolder(), 27, Component.text("Brawl Shop"));
		ItemCreator itemBuilder = new ItemCreator();

		ItemStack offensiveSkills = itemBuilder.itemBuilder(ChatColor.GOLD + "Offensive Skills", Material.IRON_SWORD, null, -1, "OFFENSIVE_SKILLS");
		ItemStack utilitySkills = itemBuilder.itemBuilder(ChatColor.YELLOW + "Utility Skills", Material.GLOWSTONE_DUST, null, -1, "UTILITY_SKILLS");
		ItemStack SupportSkills = itemBuilder.itemBuilder(ChatColor.GREEN + "Support Skills", Material.GREEN_DYE, null, -1, "SUPPORT_SKILLS");
		ItemStack ultimateSkills = itemBuilder.itemBuilder(ChatColor.RED + "Ultimate Skills", Material.ORANGE_DYE, null, -1, "ULTIMATE_SKILLS");
		ItemStack runes = itemBuilder.itemBuilder(ChatColor.BLUE + "Runes", Material.LAPIS_LAZULI, null, -1, "RUNES");
		ItemStack combatUpgrades = itemBuilder.itemBuilder(ChatColor.GRAY + "Combat Upgrades", Material.IRON_CHESTPLATE, null, -1, "COMBAT_UPGRADES");
		ItemStack hats = itemBuilder.itemBuilder(ChatColor.AQUA + "Hats",Material.LEATHER_HELMET, null, -1, "HATS");

		shopMenu.setItem(1, offensiveSkills);
		shopMenu.setItem(3, utilitySkills);
		shopMenu.setItem(5, SupportSkills);
		shopMenu.setItem(7, ultimateSkills);
		shopMenu.setItem(20, runes);
		shopMenu.setItem(22, combatUpgrades);
		shopMenu.setItem(24, hats);

		return shopMenu;
	}
}

package za.co.codonorix.codobrawl.guis.offensive_skills;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;
import za.co.codonorix.codobrawl.helper_classes.ShopItemObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OffensiveSkillsMenu {
	public Inventory offensiveSkills() {
		Inventory offensiveSkillsMenu = Bukkit.createInventory(new OffensiveSkillsHolder(), 36, Component.text("Offensive skills"));
		ArrayList<ShopItemObject> items = new OffensiveSkillsItems().getInstance();

		offensiveSkillsMenu.setItem(10, items.get(0).createItem());
		offensiveSkillsMenu.setItem(11, items.get(1).createItem());
		offensiveSkillsMenu.setItem(12, items.get(2).createItem());
		offensiveSkillsMenu.setItem(13, items.get(3).createItem());
		offensiveSkillsMenu.setItem(14, items.get(4).createItem());
		offensiveSkillsMenu.setItem(15, items.get(5).createItem());
		offensiveSkillsMenu.setItem(16, items.get(6).createItem());
		offensiveSkillsMenu.setItem(20, items.get(7).createItem());
		offensiveSkillsMenu.setItem(21, items.get(8).createItem());
		offensiveSkillsMenu.setItem(22, items.get(9).createItem());
		offensiveSkillsMenu.setItem(23, items.get(10).createItem());
		offensiveSkillsMenu.setItem(24, items.get(11).createItem());

		return offensiveSkillsMenu;
	}
}
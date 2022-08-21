package za.co.codonorix.codobrawl.guis.offensive_skills;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OffensiveSkills {
	ItemCreator itemBuilder = new ItemCreator();

	public Inventory offensiveSkills() {
		Inventory offensiveSkillsMenu = Bukkit.createInventory(new OffensiveSkillsHolder(), 36, Component.text("Offensive skills"));

		offensiveSkillsMenu.setItem(10, boulderToss());
		offensiveSkillsMenu.setItem(11, cookieShotgun());
		offensiveSkillsMenu.setItem(12, fireBall());
		offensiveSkillsMenu.setItem(13, flameBreath());
		offensiveSkillsMenu.setItem(14, freezeBreath());
		offensiveSkillsMenu.setItem(15, guidedPig2000());
		offensiveSkillsMenu.setItem(16, lightningShot());
		offensiveSkillsMenu.setItem(20, melonLauncher());
		offensiveSkillsMenu.setItem(21, proximityMine());
		offensiveSkillsMenu.setItem(22, rocketChicken());
		offensiveSkillsMenu.setItem(23, seismicSlam());
		offensiveSkillsMenu.setItem(24, snowball());

		return offensiveSkillsMenu;
	}

	private ItemStack boulderToss() {
		String name = ChatColor.GREEN + "Boulder Toss";
		List<String> lore = new ArrayList<>(Arrays.asList("Throws a hard rock at your enemies", "Ouch... sounds like you hit rock bottom."));

		return itemBuilder.itemBuilder(name, Material.COBBLESTONE, lore, 5000, "BOULDER_TOSS");
	}

	private ItemStack cookieShotgun() {
		String name = ChatColor.BLUE + "Cookie Shotgun";
		List<String> lore = new ArrayList<>(Arrays.asList("The creator of this plugin loves cookies!", "So now you can shoot people with them!"));

		return itemBuilder.itemBuilder(name, Material.COOKIE, lore, 15000, "COOKIE_SHOTGUN");
	}

	private ItemStack fireBall() {
		String name = ChatColor.GREEN + "Fireball";
		List<String> lore = new ArrayList<>(Arrays.asList("A simple ball of fire that does...", "well damage... with fire!"));

		return itemBuilder.itemBuilder(name, Material.FIRE_CHARGE, lore,0, "FIREBALL");
	}

	private ItemStack flameBreath() {
		String name = ChatColor.GOLD + "Flame Breath";
		List<String> lore = new ArrayList<>(Arrays.asList("Used by the greatest warriors when going against", "the ice dragon in the nobal war."));

		return itemBuilder.itemBuilder(name, Material.BLAZE_POWDER, lore, 25000, "FLAME_BREATH");
	}

	private ItemStack freezeBreath() {
		String name = ChatColor.GOLD + "Freeze Breath";
		List<String> lore = new ArrayList<>(Arrays.asList("Used by the greatest warriors when going against", "the flame dragon in the nobal war."));

		return itemBuilder.itemBuilder(name, Material.ICE, lore, 25000, "FREEZE_BREATH");
	}

	private ItemStack guidedPig2000() {
		String name = ChatColor.LIGHT_PURPLE + "Guided Pig";
		List<String> lore = new ArrayList<>(Arrays.asList("Oink oink oink", "BOOM BOOM BOOM!"));

		return itemBuilder.itemBuilder(name, Material.PORKCHOP, lore, 90000, "GUIDED_PIG_2000");
	}

	private ItemStack lightningShot() {
		String name = ChatColor.BLUE + "Lightning Strike";
		List<String> lore = new ArrayList<>(Arrays.asList("Become a god and shoot", "lightning from the sky!"));

		return itemBuilder.itemBuilder(name, Material.GOLDEN_AXE, lore, 10000, "LIGHTNING_STRIKE");
	}

	private ItemStack melonLauncher() {
		String name = ChatColor.DARK_PURPLE + "Melon Launcher";
		List<String> lore = new ArrayList<>(Arrays.asList("The sweetest melons shot out", "by the sweetest victors"));

		return itemBuilder.itemBuilder(name, Material.MELON_SLICE, lore, 15000, "MELON_LAUNCHER");
	}

	private ItemStack proximityMine() {
		String name = ChatColor.DARK_PURPLE + "Proximity Mine";
		List<String> lore = new ArrayList<>(Arrays.asList("Place a hidden bomb and wait for them", "to walk over it... big boom"));

		return itemBuilder.itemBuilder(name, Material.TNT, lore, 15000, "PROXIMITY_MINE");
	}

	private ItemStack rocketChicken() {
		String name = ChatColor.LIGHT_PURPLE + "Rocket Chicken";
		List<String> lore = new ArrayList<>(Arrays.asList("shoot the cluck cluck boi out your sword"));

		return itemBuilder.itemBuilder(name, Material.FEATHER, lore, 15000, "ROCKET_CHICKEN");
	}

	private ItemStack seismicSlam() {
		String name = ChatColor.BLUE + "Seismic Slam";
		List<String> lore = new ArrayList<>(Arrays.asList("Sesmic slam"));
		//10k
		return itemBuilder.itemBuilder(name, Material.IRON_AXE, lore, 10000, "SEISMIC_SLAM");
	}

	private ItemStack snowball() {
		String name = ChatColor.GREEN + "Snowball";
		List<String> lore = new ArrayList<>(Arrays.asList("Snowball"));

		return itemBuilder.itemBuilder(name, Material.SNOWBALL, lore, 5000, "SNOWBALL");
	}
}
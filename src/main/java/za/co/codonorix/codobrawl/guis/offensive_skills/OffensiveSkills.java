package za.co.codonorix.codobrawl.guis.offensive_skills;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;
import za.co.codonorix.codobrawl.helper_classes.ShopItemObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OffensiveSkills {
	ItemCreator itemBuilder = new ItemCreator();

	public Inventory offensiveSkills() {
		Inventory offensiveSkillsMenu = Bukkit.createInventory(new OffensiveSkillsHolder(), 36, Component.text("Offensive skills"));

		offensiveSkillsMenu.setItem(10, boulderToss().createItem());
		offensiveSkillsMenu.setItem(11, cookieShotgun().createItem());
		offensiveSkillsMenu.setItem(12, fireBall().createItem());
		offensiveSkillsMenu.setItem(13, flameBreath().createItem());
		offensiveSkillsMenu.setItem(14, freezeBreath().createItem());
		offensiveSkillsMenu.setItem(15, guidedPig2000().createItem());
		offensiveSkillsMenu.setItem(16, lightningShot().createItem());
		offensiveSkillsMenu.setItem(20, melonLauncher().createItem());
		offensiveSkillsMenu.setItem(21, proximityMine().createItem());
		offensiveSkillsMenu.setItem(22, rocketChicken().createItem());
		offensiveSkillsMenu.setItem(23, seismicSlam().createItem());
		offensiveSkillsMenu.setItem(24, snowball().createItem());

		return offensiveSkillsMenu;
	}

	private ShopItemObject boulderToss() {
		String name = ChatColor.GREEN + "Boulder Toss";
		List<String> lore = new ArrayList<>(Arrays.asList("Throws a hard rock at your enemies", "Ouch... sounds like you hit rock bottom."));

		return new ShopItemObject(name, Material.COBBLESTONE, lore, 5000, "BOULDER_TOSS", false);
	}

	private ShopItemObject cookieShotgun() {
		String name = ChatColor.BLUE + "Cookie Shotgun";
		List<String> lore = new ArrayList<>(Arrays.asList("The creator of this plugin loves cookies!", "So now you can shoot people with them!"));

		return new ShopItemObject(name, Material.COOKIE, lore, 15000, "COOKIE_SHOTGUN", false);
	}

	private ShopItemObject fireBall() {
		String name = ChatColor.GREEN + "Fireball";
		List<String> lore = new ArrayList<>(Arrays.asList("A simple ball of fire that does...", "well damage... with fire!"));

		return new ShopItemObject(name, Material.FIRE_CHARGE, lore,-1, "FIREBALL", false);
	}

	private ShopItemObject flameBreath() {
		String name = ChatColor.GOLD + "Flame Breath";
		List<String> lore = new ArrayList<>(Arrays.asList("Used by the greatest warriors when going against", "the ice dragon in the nobal war."));

		return new ShopItemObject(name, Material.BLAZE_POWDER, lore, 25000, "FLAME_BREATH", false);
	}

	private ShopItemObject freezeBreath() {
		String name = ChatColor.GOLD + "Freeze Breath";
		List<String> lore = new ArrayList<>(Arrays.asList("Used by the greatest warriors when going against", "the flame dragon in the nobal war."));

		return new ShopItemObject(name, Material.ICE, lore, 25000, "FREEZE_BREATH", false);
	}

	private ShopItemObject guidedPig2000() {
		String name = ChatColor.LIGHT_PURPLE + "Guided Pig";
		List<String> lore = new ArrayList<>(Arrays.asList("Oink oink oink", "BOOM BOOM BOOM!"));

		return new ShopItemObject(name, Material.PORKCHOP, lore, 90000, "GUIDED_PIG_2000", false);
	}

	private ShopItemObject lightningShot() {
		String name = ChatColor.BLUE + "Lightning Strike";
		List<String> lore = new ArrayList<>(Arrays.asList("Become a god and shoot", "lightning from the sky!"));

		return new ShopItemObject(name, Material.GOLDEN_AXE, lore, 10000, "LIGHTNING_STRIKE", false);
	}

	private ShopItemObject melonLauncher() {
		String name = ChatColor.DARK_PURPLE + "Melon Launcher";
		List<String> lore = new ArrayList<>(Arrays.asList("The sweetest melons shot out", "by the sweetest victors"));

		return new ShopItemObject(name, Material.MELON_SLICE, lore, 15000, "MELON_LAUNCHER", false);
	}

	private ShopItemObject proximityMine() {
		String name = ChatColor.DARK_PURPLE + "Proximity Mine";
		List<String> lore = new ArrayList<>(Arrays.asList("Place a hidden bomb and wait for them", "to walk over it... big boom"));

		return new ShopItemObject(name, Material.TNT, lore, 15000, "PROXIMITY_MINE", false);
	}

	private ShopItemObject rocketChicken() {
		String name = ChatColor.LIGHT_PURPLE + "Rocket Chicken";
		List<String> lore = new ArrayList<>(Arrays.asList("shoot the cluck cluck boi out your sword"));

		return new ShopItemObject(name, Material.FEATHER, lore, 15000, "ROCKET_CHICKEN", false);
	}

	private ShopItemObject seismicSlam() {
		String name = ChatColor.BLUE + "Seismic Slam";
		List<String> lore = new ArrayList<>(Arrays.asList("Sesmic slam"));
		//10k
		return new ShopItemObject(name, Material.IRON_AXE, lore, 10000, "SEISMIC_SLAM", false);
	}

	private ShopItemObject snowball() {
		String name = ChatColor.GREEN + "Snowball";
		List<String> lore = new ArrayList<>(Arrays.asList("Snowball"));

		return new ShopItemObject(name, Material.SNOWBALL, lore, 5000, "SNOWBALL", false);
	}
}
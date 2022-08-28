package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;

import java.util.HashMap;
import java.util.UUID;

public class ArenaCreator implements CommandExecutor {
	public static HashMap<UUID, Integer> playerStage = new HashMap<>();
	public static HashMap<UUID, ItemStack[]> playerInv = new HashMap<>();
	public static boolean firstRun = false;

	ItemCreator itemCreator = new ItemCreator();


	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(!(sender instanceof Player))return false;

		Player player = (Player) sender;
		playerStage.put(player.getUniqueId(), 0);

		ItemStack[] oldInv = player.getInventory().getContents();
		playerInv.put(player.getUniqueId(), oldInv);

		player.getInventory().clear();

		ItemStack confirm = itemCreator.itemBuilder("Confirm", TextColor.color(0, 255, 7), Material.LIME_CONCRETE, null, -1, "CONFIRM_SPAWN");


		new BukkitRunnable() {
			@Override
			public void run(){
				int stage = playerStage.get(player.getUniqueId());
//				System.out.println(firstRun);
				switch (stage) {
					case 0:
						if(!firstRun){
							player.sendMessage(Component.text("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀").color(TextColor.color(255, 0, 179)));
							player.sendMessage(Component.text("Enter Arena name: ").color(TextColor.color(0, 255, 7)));
							firstRun = true;
						}
						break;
					case 1:
						if(!firstRun){
							player.sendMessage(Component.text("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀").color(TextColor.color(255, 0, 179)));
							player.sendMessage(Component.text("Please enter arena mode: ").color(TextColor.color(0, 255, 7)));
							player.sendMessage(Component.text("1").append(Component.text("► 4v4", TextColor.color(0, 255, 7))));
							player.sendMessage(Component.text("2").append(Component.text("► 2v2", TextColor.color(0, 255, 7))));
							player.sendMessage(Component.text("3").append(Component.text("► 1v1", TextColor.color(0, 255, 7))));

							firstRun = true;
						}
						break;
					case 2:
						ItemStack spawn1 = itemCreator.itemBuilder("Spawn 1", TextColor.color(255, 160, 0), Material.BLAZE_ROD, null, -1, "SET_SPAWN_1");
						ItemStack spawn2 = itemCreator.itemBuilder("Spawn 2", TextColor.color(140, 10, 0), Material.STICK, null, -1, "SET_SPAWN_2");

						player.getInventory().setItem(0, spawn1);
						player.getInventory().setItem(1, spawn2);
						player.getInventory().setItem(2, confirm);

						break;
					case 3:
						ItemStack healItem = itemCreator.itemBuilder("Add health boost", TextColor.color(0, 255, 0), Material.EMERALD, null, -1, "PLACE_HEAL_BOOST");

						player.getInventory().setItem(0, healItem);
						player.getInventory().setItem(1, confirm);
						break;
					case 4:
						ItemStack doubleDamageItem = itemCreator.itemBuilder("Add damage boost", TextColor.color(0, 255, 0), Material.REDSTONE, null, -1, "PLACE_DAMAGE_BOOST");

						player.getInventory().setItem(0, doubleDamageItem);
						player.getInventory().setItem(1, confirm);
						break;
					case 5:
						Component arenaName = ArenaCreatorStagesText.arenaName;
						int modeType = ArenaCreatorStagesText.modeInt;
						Location spawn1value = ArenaCreatorStagesClick.spawn1;
						Location spawn2value = ArenaCreatorStagesClick.spawn2;

						ArenaCreatorObject arenaObj = new ArenaCreatorObject(arenaName, modeType, spawn1value, spawn2value, ArenaCreatorStagesClick.healLocations,ArenaCreatorStagesClick.ddLocations);
						new ArenaCreatorToConfig().addArenaToConfig(arenaObj);
						player.sendMessage("Arena setup complete.");
						playerStage.replace(player.getUniqueId(), -1);

						//TODO - Write arena creation message.
						break;
						//If the player leaves/quits setup/finishes setup we cancel this section.
					case -1:
						firstRun = false;
						playerStage.remove(player.getUniqueId());
						player.getInventory().clear();

						player.getInventory().setContents(playerInv.get(player.getUniqueId()));
						player.updateInventory();

						playerInv.remove(player.getUniqueId());

						cancel();
						break;
				}
			}
		}.runTaskTimer(CodoBrawl.getInstance(), 1, 1);


		return false;
	}
}

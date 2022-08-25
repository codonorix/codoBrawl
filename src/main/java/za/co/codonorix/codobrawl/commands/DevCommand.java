package za.co.codonorix.codobrawl.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.effects.DeathEffect;
import za.co.codonorix.codobrawl.game_mechanics.ManaBar;
import za.co.codonorix.codobrawl.guis.shop.ShopMenu;

public class DevCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player player = (Player) sender;

		double playerX = player.getLocation().getX();
		double playerY = player.getLocation().getY();
		double playerZ = player.getLocation().getZ();
		ArmorStand as = (ArmorStand) player.getWorld().spawn(new Location(player.getWorld(), playerX + 1, playerY + 0.5, playerZ + 1), ArmorStand.class);
		double asX = as.getLocation().getX();
		double asY = as.getLocation().getY();
		double asZ = as.getLocation().getZ();

		as.setItem(EquipmentSlot.HEAD, new ItemStack(Material.EMERALD_BLOCK));
		as.setInvisible(true);
		as.setCustomNameVisible(true);
		as.customName(Component.text(ChatColor.GREEN + "" + ChatColor.BOLD + "HEALTH"));
		as.setSmall(true);
		as.setGravity(false);
		new BukkitRunnable(){
			int i = 1;
			@Override
			public void run(){
				double playerX = player.getLocation().getX();
				double playerY = player.getLocation().getY();
				double playerZ = player.getLocation().getZ();

				double asX = as.getLocation().getX();
				double asY = as.getLocation().getY();
				double asZ = as.getLocation().getZ();

				if(i == 360) i = 1;
				if(i <= 360){
					as.setHeadPose(new EulerAngle(0,Math.toRadians(i),0));
					i++;
				}
				as.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, new Location(as.getWorld(), asX, asY + 1, asZ),1, 0.2, 0, 0.2);
				if((Math.round(asX) == Math.round(playerX)) &&
						(Math.round(asY) == Math.round(playerY + 0.5)) &&
						(Math.round(asZ) == Math.round(playerZ))){
					as.remove();
					player.sendMessage(ChatColor.GREEN + "Added +250 health.");
					cancel();
				}
			}
		}.runTaskTimer(CodoBrawl.getInstance(), 0, 1L);
//		new DeathEffect().deathEffectNormal(player);
//		manaBar.setPlayerLevel(player);

//		ManaBar manaBar = new ManaBar();
		return false;
	}
}

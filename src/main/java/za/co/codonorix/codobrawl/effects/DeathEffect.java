package za.co.codonorix.codobrawl.effects;

import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import za.co.codonorix.codobrawl.CodoBrawl;

import java.util.ArrayList;
import java.util.Random;

public class DeathEffect {

	public void deathEffectNormal(Player player) {
		Random random = new Random();

		ArrayList<Item> locations = new ArrayList<>();
		ArrayList<Item> itemsList = new ArrayList<>();

		World world = player.getWorld();
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
		double z = player.getLocation().getZ();

		//Stops player picking up the item
		Item roseDye = world.dropItem(new Location(world, x, y, z), new ItemStack(Material.RED_DYE));
		Item redstone = world.dropItem(new Location(world, x, y, z), new ItemStack(Material.REDSTONE));
		Item bone = world.dropItem(new Location(world, x, y, z), new ItemStack(Material.BONE));
		Item rottenflesh = world.dropItem(new Location(world, x, y, z), new ItemStack(Material.ROTTEN_FLESH));

		itemsList.add(roseDye);
		itemsList.add(redstone);
		itemsList.add(bone);
		itemsList.add(rottenflesh);
		new DamageEffect().damageEffect(player, Sound.BLOCK_SNOW_BREAK);
		player.setGameMode(GameMode.SPECTATOR);

		for(int i = 0; i <= 10; i++) {
			double randomItemOne = Math.random() * (0.2 - 0) + 0;
			double randomItemTwo = Math.random() * (0.2 - 0) + 0;
			double randomItemThree = Math.random() * (0.2 - 0) + 0;
			Item item = itemsList.get(random.nextInt(itemsList.size()));
			item.setPickupDelay(5000);
			item.setCanPlayerPickup(false);
			item.setVelocity(new Vector(randomItemOne, 0.7, randomItemThree));
			locations.add(item);
		}


		//Stops player picking up the item
//		dropItem.setCanPlayerPickup(false);
//		dropItem.setVelocity(new Vector(0.3, 0.5, 0.1));

		Bukkit.getScheduler().runTaskLater(CodoBrawl.getInstance(), () -> {
			for(int i = 0; i < locations.size(); i++) {
				Location location = locations.get(i).getLocation();
				locations.get(i).remove();
				location.getWorld().spawnParticle(Particle.SWEEP_ATTACK, location.getX(), location.getY(), location.getZ(), 1);
			}
			player.setGameMode(GameMode.CREATIVE);
		},5*20);
	}
}

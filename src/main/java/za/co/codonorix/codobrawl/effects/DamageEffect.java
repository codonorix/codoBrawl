package za.co.codonorix.codobrawl.effects;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class DamageEffect {
	public void damageEffect(Player player, Sound sound) {
		World world = player.getWorld();
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
		double z = player.getLocation().getZ();

		double min = -1;
		double max = 2;
		for(int i = 0; i <= 5; i++){
			double randomItemOne = Math.random() * (1 - min) + min;
			double randomItemTwo = Math.random() * (max - min) + min;
			double randomItemThree = Math.random() * (1 - min) + min;

			world.spawnParticle(Particle.BLOCK_CRACK, x+randomItemOne, y+randomItemTwo, z+randomItemThree, 10,0, 0, 0, Material.RED_CARPET.createBlockData());
			player.playSound(player.getLocation(), sound, 1, 1);
		}
	}
}

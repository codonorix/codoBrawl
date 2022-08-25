package za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.effects.DamageEffect;
import za.co.codonorix.codobrawl.game_mechanics.GamePlayerObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

import java.util.Random;

public class SnowballHitEvent implements Listener {
	@EventHandler
	public void snowballHitEvent(EntityDamageByEntityEvent event) {
		SnowBall snowBall = new SnowBall();
		if(!(event.getDamager() instanceof Snowball))return;
		if (!(event.getEntity() instanceof Player))return;

		Player player = (Player) event.getEntity();

		NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), "SNOWBALL_FIRE");

		if(event.getDamager().getPersistentDataContainer().has(key)) {
			event.setCancelled(true);

			World world = player.getWorld();
			double x = player.getLocation().getX();
			double y = player.getLocation().getY();
			double z = player.getLocation().getZ();

			new DamageEffect().damageEffect(player, Sound.BLOCK_POWDER_SNOW_BREAK);

			GamePlayerObject data = PlayerInformation.getGameInformation(player.getUniqueId());
			data.setHealth(data.getHealth() - 25);
			player.sendMessage("Snowball hit you for 20 damage, " + data.getHealth() + "/2000 hp");

			if(data.getHealth() <= 0){
				player.sendTitle(ChatColor.RED + "YOU LOST!", "");
				GamePlayerObject gpo = new GamePlayerObject(1, 2000, 100);
				PlayerInformation.addPlayerGameData(player.getUniqueId(),gpo);
//				world.dropItem()
				return;
			}
			PlayerInformation.addPlayerGameData(player.getUniqueId(), data);


//			world.spawnParticle(Particle.REDSTONE, player.getLocation(), 30, new Particle.DustOptions(Color.RED, 3.0f));

		}
	}
}

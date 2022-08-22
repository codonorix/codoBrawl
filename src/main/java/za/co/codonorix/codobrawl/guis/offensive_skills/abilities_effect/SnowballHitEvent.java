package za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import za.co.codonorix.codobrawl.CodoBrawl;

public class SnowballHitEvent implements Listener {
	@EventHandler
	public void snowballHitEvent(EntityDamageByEntityEvent event) {
		SnowBall snowBall = new SnowBall();
		if(!(event.getDamager() instanceof Snowball))return;
		System.out.println("I make it here");


		if (!(event.getEntity() instanceof Player))return;

		Player player = (Player) event.getEntity();

		NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), "SNOWBALL_FIRE");

		if(event.getDamager().getPersistentDataContainer().has(key)) {
			player.damage(1);
		}


	}
}

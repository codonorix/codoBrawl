package za.co.codonorix.codobrawl.arena_game;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignJoinEvent implements Listener {
	@EventHandler
	public void onSignClick(PlayerInteractEvent event) {
		event.getPlayer().sendMessage("test");
		if(event.getClickedBlock() == null)return;

		if(event.getClickedBlock().getState() instanceof Sign ) {
			event.getPlayer().sendMessage("Works!");
		}
	}
}

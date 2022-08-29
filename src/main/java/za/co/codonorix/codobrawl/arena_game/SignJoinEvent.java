package za.co.codonorix.codobrawl.arena_game;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import za.co.codonorix.codobrawl.arena_creator.ArenaCreator;
import za.co.codonorix.codobrawl.arena_creator.ArenaCreatorLoader;
import za.co.codonorix.codobrawl.arena_creator.ArenaCreatorObject;

public class SignJoinEvent implements Listener {
	@EventHandler
	public void onSignClick(PlayerInteractEvent event) {
		if(event.getClickedBlock() == null || event.getHand() == EquipmentSlot.OFF_HAND || event.getAction().isLeftClick())return;

		if(event.getClickedBlock().getState() instanceof Sign) {
			ArenaCreatorObject gameArena = null;

			Sign joinSign = (Sign) event.getClickedBlock().getState();
			TextComponent signTitle = (TextComponent) joinSign.line(0);
			TextComponent arenaName = (TextComponent) joinSign.line(1);

			if(signTitle.content().equals("[CB]")){
				for(int i = 0; i < ArenaCreatorLoader.arenas.size(); i++){
					TextComponent arenaNamesList = (TextComponent) ArenaCreatorLoader.arenas.get(i).getName();
					if(arenaName.content().equals(arenaNamesList.content())) {
						gameArena = ArenaCreatorLoader.arenas.get(i);
						break;
					}
				}

				if(gameArena == null)return;

				event.getPlayer().teleport(gameArena.getWaitingLobby());
			}
			//collosium
		}
	}
}

package za.co.codonorix.codobrawl.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import za.co.codonorix.codobrawl.game_items.OffensiveItem;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkillsMenu;
import za.co.codonorix.codobrawl.join_items.ShopItem;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;
import za.co.codonorix.codobrawl.stats.PlayerScoreboard;

import java.util.ArrayList;

public class OnJoinEvent implements Listener {
	@EventHandler
	private void onJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerScoreboard playerScoreboard = new PlayerScoreboard();
		player.getInventory().clear();

		player.getInventory().setItem(0, new ShopItem().shopMenu());
		player.getInventory().setItem(1, new OffensiveItem().offensiveItem(player.getUniqueId()));
		ArrayList<String> blankList = new ArrayList<>();

		OffensiveSkillsMenu offensiveSkillsMenu = new OffensiveSkillsMenu();
		PlayerInformationObject pio = new PlayerInformationObject(0, 0, 0, 0, 0, 0, 0, 5000,0,blankList,blankList,blankList,blankList,blankList,blankList,blankList,null, "test2","test3", "test4", "test5", "test6");
		PlayerInformation.addPlayerData(player.getUniqueId(), pio);

//		player.setScoreboard(playerScoreboard.setScoreBoard(player));
		new PlayerScoreboard().setScoreBoard(player);
	}
}

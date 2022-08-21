package za.co.codonorix.codobrawl.stats;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;

public class PlayerScoreboard {
	public Scoreboard setScoreBoard(Player player) {
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("Codonorix", "dummy", "testServer");
		PlayerInformationObject playerData = PlayerInformation.getInformation(player.getUniqueId());

		objective.displayName(Component.text(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "CODONORIX"));
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		/*
		Lines that are exactly the same in terms of data (kills and wins for exmple) will be duplicated and won't return
		the first set of data.
		 */
		Score blank1 = objective.getScore("  ");
		Score fourVsFour = objective.getScore(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[4v4]");
		Score fourVsFourWins = objective.getScore(ChatColor.GREEN + "Wins: " + ChatColor.WHITE + playerData.getFourVsFourWins() + " ");
		Score fourVsFourKills = objective.getScore(ChatColor.GREEN + "Kills: " + ChatColor.WHITE + playerData.getFourVsFourKills() + " ");
		Score blank2 = objective.getScore("");
		Score twoVsTwo = objective.getScore(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[2v2]");
		Score twoVsTwoWins = objective.getScore(ChatColor.GREEN + "Wins: " + ChatColor.WHITE + playerData.getTwoVsTwoWins());
		Score twoVsTwoKills = objective.getScore(ChatColor.GREEN + "Kills: " + ChatColor.WHITE + playerData.getTwoVsTwoKills());
		Score rating = objective.getScore(ChatColor.GREEN + "Rating: " + ChatColor.WHITE + playerData.getRating());
		Score blank3 = objective.getScore(" ");
		Score crystals = objective.getScore(ChatColor.LIGHT_PURPLE + "✸ Crystals: " + ChatColor.WHITE + playerData.getCrystals());
		Score keys = objective.getScore(ChatColor.LIGHT_PURPLE + "⇴ Keys: " + ChatColor.WHITE + playerData.getKeys());

		blank1.setScore(15);
		fourVsFour.setScore(14);
		fourVsFourWins.setScore(13);
		fourVsFourKills.setScore(12);
		blank2.setScore(11);
		twoVsTwo.setScore(10);
		twoVsTwoWins.setScore(9);
		twoVsTwoKills.setScore(8);
		rating.setScore(7);
		blank3.setScore(6);
		crystals.setScore(5);
		keys.setScore(4);

		return scoreboard;
	}
}

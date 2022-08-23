package za.co.codonorix.codobrawl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import za.co.codonorix.codobrawl.game_mechanics.ManaBar;
import za.co.codonorix.codobrawl.guis.shop.ShopMenu;

public class DevCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		Player player = (Player) sender;

		ManaBar manaBar = new ManaBar();
		manaBar.setPlayerLevel(player);
		return false;
	}
}

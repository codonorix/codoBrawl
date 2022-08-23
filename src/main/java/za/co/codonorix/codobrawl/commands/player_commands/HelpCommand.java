package za.co.codonorix.codobrawl.commands.player_commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ArrayList<String> message = new ArrayList<>();
        //◢ ◣ ◤ ◥
        if(!(commandSender instanceof Player))return false;
        message.add(ChatColor.LIGHT_PURPLE + "▦▦▦▦▦▦▦▦▦▦▦◤ " + ChatColor.DARK_PURPLE + "CODO BRAWL" + ChatColor.LIGHT_PURPLE + "◥▦▦▦▦▦▦▦▦▦▦▦");
        message.add("");
        message.add(ChatColor.LIGHT_PURPLE + "/givecrystals <name> <amount>" + ChatColor.WHITE + " - Adds crystals to users account.");
        message.add("");
        message.add(ChatColor.LIGHT_PURPLE + "/removecrystals <name> <amount>" + ChatColor.WHITE + " - Removes crystals from users account.");

        Player player = (Player) commandSender;
        for(int i = 0; i < message.size(); i++){
            player.sendMessage(message.get(i));
        }
        return false;
    }
}

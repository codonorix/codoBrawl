package za.co.codonorix.codobrawl.commands.admin_commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import za.co.codonorix.codobrawl.messages.Messages;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

import java.io.Console;

public class GiveCrystals implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        Player player = (Player) commandSender;
        Messages messages = new Messages();
        if(args.length < 2){
            player.sendMessage(messages.prefix + ChatColor.RED + "/crystalsAdd {player_name} {amount}");
            return false;
        }

        if(Bukkit.getPlayerExact(args[0]) == null) {
            player.sendMessage(messages.prefix + ChatColor.RED + "Player " + args[0] + " is not online.");
            return false;
        }

        try{
        if(Integer.parseInt(args[1]) < 0) {
            player.sendMessage(messages.prefix + ChatColor.RED + "Please enter a number larger than -1");
            return false;
        }
        }catch (Exception exception){
            player.sendMessage(messages.prefix + ChatColor.RED + "Please enter a valid number.");
            return false;
        }

        player.sendMessage(messages.prefix + ChatColor.GREEN + "Added " + args[1] + " crystals to " + args[0] + "'s account");
        PlayerInformationObject test = PlayerInformation.getInformation(player.getUniqueId());
        test.setCrystals(test.getCrystals() + Integer.parseInt(args[1]));
        return false;
    }
}

package za.co.codonorix.codobrawl.commands.admin_commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import za.co.codonorix.codobrawl.CodoBrawl;

public class SetLobby implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player))return false;

        FileConfiguration config = CodoBrawl.getInstance().getConfig();
        Player player = (Player) commandSender;

        config.set("location.World", player.getWorld().getName());
        config.set("location.x", player.getLocation().getX());
        config.set("location.y", player.getLocation().getY());
        config.set("location.z", player.getLocation().getZ());
        config.set("location.yaw", player.getLocation().getYaw());
        config.set("location.pitch", player.getLocation().getPitch());

        CodoBrawl.getInstance().saveConfig();
        return false;
    }
}

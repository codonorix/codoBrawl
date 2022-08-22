package za.co.codonorix.codobrawl.game_items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import za.co.codonorix.codobrawl.helper_classes.ItemCreator;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

import java.util.UUID;

public class OffensiveItem {
    public ItemStack offensiveItem(UUID uuid) {
        ItemCreator itemCreator = new ItemCreator();
        PlayerInformationObject playerData = PlayerInformation.getInformation(uuid); //TODO - Fix nullpoint exception
        String name = ChatColor.GOLD + "Offensive Item";

        return itemCreator.itemBuilder(name, Material.IRON_SWORD, null, -1, "OFFENSIVE_ITEM");
    }
}

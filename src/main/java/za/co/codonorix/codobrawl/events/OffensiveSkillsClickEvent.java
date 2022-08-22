package za.co.codonorix.codobrawl.events;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkills;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkillsHolder;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

public class OffensiveSkillsClickEvent implements Listener {
    @EventHandler
    private void onClickEvent(InventoryClickEvent event) {

        if(event.getInventory().getHolder() instanceof OffensiveSkillsHolder){
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCurrentItem();

            if(item == null)return;

            PersistentDataContainer itemData = item.getItemMeta().getPersistentDataContainer();
            PlayerInformationObject playerData = PlayerInformation.getInformation(player.getUniqueId());

            if(itemData.has(getKey("BOULDER_TOSS"))) {
                player.sendMessage("boulder toss works!");

            } else if (itemData.has(getKey("SNOWBALL"))) {
                if(playerData.getOffensiveSkillsUnlocked().contains("SNOWBALL")) {
                    playerData.setOffensiveSkillSelected("SNOWBALL");
                    player.sendMessage(ChatColor.GREEN + "Selected snowball!");
                }else{
                    if(!(playerData.getCrystals() >= 5000)) {
                        player.sendMessage(ChatColor.RED + "You can't afford that item!");
                        return;
                    }
                    playerData.getUtilitySkillsUnlocked().add("SNOWBALL");
                    playerData.setCrystals(playerData.getCrystals() - 5000);
                    PlayerInformation.addPlayerData(player.getUniqueId(), playerData);

                    player.sendMessage(ChatColor.GREEN + "Purchased snowball! You now have " + ChatColor.LIGHT_PURPLE + playerData.getCrystals() + ChatColor.GREEN + " crystals left.");
                }
            }
        }
    }

    private NamespacedKey getKey(String key) {
        return new NamespacedKey(CodoBrawl.getInstance(), key);
    }
}

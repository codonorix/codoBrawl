package za.co.codonorix.codobrawl.events;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkillsItems;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkillsMenu;
import za.co.codonorix.codobrawl.guis.offensive_skills.OffensiveSkillsHolder;
import za.co.codonorix.codobrawl.helper_classes.ShopItemObject;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OffensiveSkillsClickEvent implements Listener {
    @EventHandler
    private void onClickEvent(InventoryClickEvent event) {

        if(event.getInventory().getHolder() instanceof OffensiveSkillsHolder){
            event.setCancelled(true);

            boolean selected = false;
            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCurrentItem();
            ArrayList<ShopItemObject> offensiveSkillsItems = new OffensiveSkillsItems().getInstance();

            if(item == null)return;

            PersistentDataContainer itemData = item.getItemMeta().getPersistentDataContainer();
            PlayerInformationObject playerData = PlayerInformation.getInformation(player.getUniqueId());

            OffensiveSkillsMenu offensiveSkillsMenu = new OffensiveSkillsMenu();
            if(itemData.has(getKey("BOULDER_TOSS"))) {
                player.sendMessage("boulder toss works!");

            } else if (itemData.has(getKey("SNOWBALL"))) {
                if(playerData.getOffensiveSkillsUnlocked().contains("SNOWBALL")) {
                    playerData.setOffensiveSkillSelected(offensiveSkillsItems.get(11));
                    player.sendMessage(ChatColor.GREEN + "Selected snowball!");
                    playerData.getOffensiveSkillSelected().setSelected(true);
                    player.playSound(player.getLocation(), Sound.BLOCK_POWDER_SNOW_BREAK, 1, 0.9f);
//                    player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SCREAM, 1, 10f);


                }else{
                    if(!(playerData.getCrystals() >= 5000)) {
                        player.sendMessage(ChatColor.RED + "You can't afford that item!");
                        return;
                    }
                    playerData.getUtilitySkillsUnlocked().add("SNOWBALL");
                    playerData.setCrystals(playerData.getCrystals() - offensiveSkillsItems.get(11).getPrice());
                    PlayerInformation.addPlayerData(player.getUniqueId(), playerData);

                    player.sendMessage(ChatColor.GREEN + "Purchased snowball! You now have " + ChatColor.LIGHT_PURPLE + playerData.getCrystals() + ChatColor.GREEN + " crystals left.");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                }
            }
            player.closeInventory();
            player.openInventory(new OffensiveSkillsMenu().offensiveSkills());
        }
    }

    private NamespacedKey getKey(String key) {
        return new NamespacedKey(CodoBrawl.getInstance(), key);
    }
}

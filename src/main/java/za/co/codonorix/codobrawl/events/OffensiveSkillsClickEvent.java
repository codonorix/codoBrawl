package za.co.codonorix.codobrawl.events;

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

public class OffensiveSkillsClickEvent implements Listener {
    @EventHandler
    private void onClickEvent(InventoryClickEvent event) {

        if(event.getInventory().getHolder() instanceof OffensiveSkillsHolder){
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCurrentItem();

            if(item == null)return;

            PersistentDataContainer itemData = item.getItemMeta().getPersistentDataContainer();

            if(itemData.has(getKey("BOULDER_TOSS"))) {
                player.sendMessage("boulder toss works!");
            }
        }
    }

    private NamespacedKey getKey(String key) {
        return new NamespacedKey(CodoBrawl.getInstance(), key);
    }
}

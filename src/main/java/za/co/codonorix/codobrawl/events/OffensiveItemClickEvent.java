package za.co.codonorix.codobrawl.events;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect.SnowBall;
import za.co.codonorix.codobrawl.guis.shop.ShopMenu;
import za.co.codonorix.codobrawl.helper_classes.ShopItemObject;
import za.co.codonorix.codobrawl.player_info.PlayerInformationObject;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

public class OffensiveItemClickEvent implements Listener {
    @EventHandler
    private void itemClickEvent(PlayerInteractEvent event) {

        NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), "OFFENSIVE_ITEM");
        ItemMeta itemMeta;
		/*
		Used to check if the item that was clicked is null, if it is simply return the data. This will typically happen
		due to right-clicking a block that is not air (as the PlayerIntereactEvent by default works with air)
		 */
        if (event.getItem() == null) return;

        itemMeta = event.getItem().getItemMeta();

        if (itemMeta.getPersistentDataContainer().has(key)) {
            ShopItemObject skill = PlayerInformation.getInformation(event.getPlayer().getUniqueId()).getOffensiveSkillSelected();
            if(skill == null)return;

            switch (skill.getId()){
                case "SNOWBALL":
                    new SnowBall().snowBallEffect(event.getPlayer());
                    break;
            }
        }
    }
}

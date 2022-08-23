package za.co.codonorix.codobrawl.game_mechanics;

import org.bukkit.entity.Player;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

public class ManaBar {
    public void setPlayerLevel(Player player) {
        GamePlayerObject gpo = PlayerInformation.getGameInformation(player.getUniqueId());
        player.setLevel(gpo.getMana());
    }
}

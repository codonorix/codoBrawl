package za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import za.co.codonorix.codobrawl.CodoBrawl;
import za.co.codonorix.codobrawl.game_mechanics.GamePlayerObject;
import za.co.codonorix.codobrawl.game_mechanics.ManaBar;
import za.co.codonorix.codobrawl.stats.PlayerInformation;

public class SnowBall {
    public Snowball snowBallEffect(Player player) {
        Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);

        NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), "SNOWBALL_FIRE");
        snowball.getPersistentDataContainer().set(key, PersistentDataType.STRING, "SNOWBALL_FIRE");

        GamePlayerObject playerData = PlayerInformation.getGameInformation(player.getUniqueId());
        playerData.setMana(playerData.getMana() - 15);
        new ManaBar().setPlayerLevel(player);

        snowball.setVelocity(player.getLocation().getDirection().multiply(1.5));

        return snowball;
    }
}

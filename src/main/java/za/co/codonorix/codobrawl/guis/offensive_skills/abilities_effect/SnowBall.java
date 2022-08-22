package za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

public class SnowBall {
    public void snowBallEffect(Player player) {
        Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);
        snowball.setVelocity(player.getLocation().getDirection().multiply(1.5));
    }
}

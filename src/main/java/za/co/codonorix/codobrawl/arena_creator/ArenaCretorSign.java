package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class ArenaCretorSign implements Listener {
	@EventHandler
	public void signPlaceEvent(SignChangeEvent event) {
		Block block = event.getBlock();

		if(block.getType().equals(Material.OAK_WALL_SIGN)) {
			TextComponent title = (TextComponent) event.line(0);
			String titleText = title.content();
			if(titleText.equals(("[CB]"))){
				System.out.println("testing");
				event.line(0, Component.text("[CB]", TextColor.color(255, 0, 255)));
				event.line(1, Component.text("Lake side", TextColor.color(255,255,255)));
				event.line(2, Component.text("0/4", TextColor.color(255, 255, 255)));
				event.line(3,Component.text("-*+*-"));
			}
		}
	}
}

package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import za.co.codonorix.codobrawl.CodoBrawl;

public class ArenaCreatorToConfig {
	public void addArenaToConfig(ArenaCreatorObject arena) {
		FileConfiguration config = CodoBrawl.getInstance().getConfig();

		TextComponent textComponent;
		textComponent = (TextComponent) arena.getName();
		String name = textComponent.content();

		config.set("arenas."+ name +".name", textComponent.content());
		config.set("arenas."+ name +".mode", arena.getMode());
		config.set("arenas."+ name +".spawn1", arena.getSpawn1());
		config.set("arenas."+ name +".spawn2", arena.getSpawn2());
		config.set("arenas."+ name +".healthLocations", arena.getHealthLocation());
		config.set("arenas."+ name +".ddLocations", arena.getDdLocation());

		CodoBrawl.getInstance().saveConfig();
	}
}

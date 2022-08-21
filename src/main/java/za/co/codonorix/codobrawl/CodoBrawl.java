package za.co.codonorix.codobrawl;

import org.bukkit.plugin.java.JavaPlugin;
import za.co.codonorix.codobrawl.commands.DevCommand;
import za.co.codonorix.codobrawl.events.ShopMenuClickEvent;

public final class CodoBrawl extends JavaPlugin {

	@Override
	public void onEnable() {
		//Command registration
		this.getCommand("dev").setExecutor(new DevCommand());

		//Event registration
		getServer().getPluginManager().registerEvents(new ShopMenuClickEvent(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}

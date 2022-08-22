package za.co.codonorix.codobrawl;

import org.bukkit.plugin.java.JavaPlugin;
import za.co.codonorix.codobrawl.commands.DevCommand;
import za.co.codonorix.codobrawl.events.*;
import za.co.codonorix.codobrawl.guis.offensive_skills.abilities_effect.SnowballHitEvent;

public final class CodoBrawl extends JavaPlugin {
	private static CodoBrawl instance;
	@Override
	public void onEnable() {
		instance = this;

		//Command registration
		this.getCommand("dev").setExecutor(new DevCommand());

		//Event registration
		getServer().getPluginManager().registerEvents(new ShopMenuClickEvent(), this);
		getServer().getPluginManager().registerEvents(new OnJoinEvent(), this);
		getServer().getPluginManager().registerEvents(new ShopItemClick(), this);
		getServer().getPluginManager().registerEvents(new OffensiveSkillsClickEvent(), this);
		getServer().getPluginManager().registerEvents(new OffensiveItemClickEvent(), this);
		getServer().getPluginManager().registerEvents(new SnowballHitEvent(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static CodoBrawl getInstance(){
		return instance;
	}
}

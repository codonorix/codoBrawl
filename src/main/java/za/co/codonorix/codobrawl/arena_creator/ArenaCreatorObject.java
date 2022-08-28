package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;

import java.util.ArrayList;

public class ArenaCreatorObject {
	Component name;
	int mode;
	Location spawn1;
	Location spawn2;
	ArrayList<Location> healthLocation;
	ArrayList<Location> ddLocation;

	public ArenaCreatorObject(Component name, int mode, Location spawn1, Location spawn2, ArrayList<Location> healthLocation, ArrayList<Location> ddLocation) {
		this.name = name;
		this.mode = mode;
		this.spawn1 = spawn1;
		this.spawn2 = spawn2;
		this.healthLocation = healthLocation;
		this.ddLocation = ddLocation;
	}

	public Component getName() {
		return name;
	}

	public int getMode() {
		return mode;
	}

	public Location getSpawn1() {
		return spawn1;
	}

	public Location getSpawn2() {
		return spawn2;
	}

	public ArrayList<Location> getHealthLocation() {
		return healthLocation;
	}

	public ArrayList<Location> getDdLocation() {
		return ddLocation;
	}
}

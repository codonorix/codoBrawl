package za.co.codonorix.codobrawl.arena_creator;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;

import java.util.ArrayList;

public class ArenaCreatorObject {
	private Component name;
	private int mode;
	private Location spawn1;
	private Location spawn2;
	private ArrayList<Location> healthLocation;
	private ArrayList<Location> ddLocation;
	private Location waitingLobby;

	public ArenaCreatorObject(Component name, int mode, Location spawn1, Location spawn2, ArrayList<Location> healthLocation, ArrayList<Location> ddLocation, Location waitingLobby) {
		this.name = name;
		this.mode = mode;
		this.spawn1 = spawn1;
		this.spawn2 = spawn2;
		this.healthLocation = healthLocation;
		this.ddLocation = ddLocation;
		this.waitingLobby = waitingLobby;
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

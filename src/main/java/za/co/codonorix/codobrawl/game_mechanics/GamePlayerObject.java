package za.co.codonorix.codobrawl.game_mechanics;

public class GamePlayerObject {
	private int teamNumber;
	private int health;

	public GamePlayerObject(int teamNumber, int health) {
		this.teamNumber = teamNumber;
		this.health = health;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}

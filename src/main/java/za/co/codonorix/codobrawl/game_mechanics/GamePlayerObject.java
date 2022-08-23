package za.co.codonorix.codobrawl.game_mechanics;

public class GamePlayerObject {
	private int teamNumber;
	private int health;
	private int mana;

	public GamePlayerObject(int teamNumber, int health, int mana) {
		this.teamNumber = teamNumber;
		this.health = health;
		this.mana = mana;
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

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
}

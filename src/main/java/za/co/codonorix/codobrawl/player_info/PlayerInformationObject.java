package za.co.codonorix.codobrawl.player_info;

import za.co.codonorix.codobrawl.helper_classes.ShopItemObject;

import java.util.ArrayList;

public class PlayerInformationObject {
	private int rating;
	private int twoVsTwoKills;
	private int twoVsTwoWins;
	private int twoVsTwoWinStreak;
	private int fourVsFourKills;
	private int fourVsFourWins;
	private int fourVsFourWinSteak;
	private int crystals;
	private int keys;
	private ArrayList<String> offensiveSkillsUnlocked;
	private ArrayList<String> utilitySkillsUnlocked;
	private ArrayList<String> supportSkillsUnlocked;
	private ArrayList<String> ultimateSkillsUnlocked;
	private ArrayList<String> runesUnlocked;
	private ArrayList<String> combatUpgradesUnlocked;
	private ArrayList<String> hatsUnlocked;
	private ShopItemObject offensiveSkillSelected;
	private String utilitySkillSelected;
	private String supportSkillSelected;
	private String ultimateSkillSelected;
	private String runeSelected;
	private String hatSelected;

	/*
	It's huge :( TODO - Refactor below content at some point
	 */
	public PlayerInformationObject(int rating, int twoVsTwoKills, int twoVsTwoWins, int twoVsTwoWinStreak, int fourVsFourKills,
								   int fourVsFourWins, int fourVsFourWinSteak, int crystals, int keys, ArrayList<String> offensiveSkillsUnlocked,
								   ArrayList<String> utilitySkillsUnlocked, ArrayList<String> supportSkillsUnlocked,
								   ArrayList<String> ultimateSkillsUnlocked, ArrayList<String> runesUnlocked,
								   ArrayList<String> combatUpgradesUnlocked, ArrayList<String> hatsUnlocked,
								   ShopItemObject offensiveSkillSelected, String utilitySkillSelected, String supportSkillSelected,
								   String ultimateSkillSelected, String runeSelected, String hatSelected) {

		this.rating = rating;
		this.twoVsTwoKills = twoVsTwoKills;
		this.twoVsTwoWins = twoVsTwoWins;
		this.twoVsTwoWinStreak = twoVsTwoWinStreak;
		this.fourVsFourKills = fourVsFourKills;
		this.fourVsFourWins = fourVsFourWins;
		this.fourVsFourWinSteak = fourVsFourWinSteak;
		this.crystals = crystals;
		this.keys = keys;
		this.offensiveSkillsUnlocked = offensiveSkillsUnlocked;
		this.utilitySkillsUnlocked = utilitySkillsUnlocked;
		this.supportSkillsUnlocked = supportSkillsUnlocked;
		this.ultimateSkillsUnlocked = ultimateSkillsUnlocked;
		this.runesUnlocked = runesUnlocked;
		this.combatUpgradesUnlocked = combatUpgradesUnlocked;
		this.hatsUnlocked = hatsUnlocked;
		this.offensiveSkillSelected = offensiveSkillSelected;
		this.utilitySkillSelected = utilitySkillSelected;
		this.supportSkillSelected = supportSkillSelected;
		this.ultimateSkillSelected = ultimateSkillSelected;
		this.runeSelected = runeSelected;
		this.hatSelected = hatSelected;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTwoVsTwoKills() {
		return twoVsTwoKills;
	}

	public void setTwoVsTwoKills(int twoVsTwoKills) {
		this.twoVsTwoKills = twoVsTwoKills;
	}

	public int getTwoVsTwoWins() {
		return twoVsTwoWins;
	}

	public void setTwoVsTwoWins(int twoVsTwoWins) {
		this.twoVsTwoWins = twoVsTwoWins;
	}

	public int getTwoVsTwoWinStreak() {
		return twoVsTwoWinStreak;
	}

	public void setTwoVsTwoWinStreak(int twoVsTwoWinStreak) {
		this.twoVsTwoWinStreak = twoVsTwoWinStreak;
	}

	public int getFourVsFourKills() {
		return fourVsFourKills;
	}

	public void setFourVsFourKills(int fourVsFourKills) {
		this.fourVsFourKills = fourVsFourKills;
	}

	public int getFourVsFourWins() {
		return fourVsFourWins;
	}

	public void setFourVsFourWins(int fourVsFourWins) {
		this.fourVsFourWins = fourVsFourWins;
	}

	public int getFourVsFourWinSteak() {
		return fourVsFourWinSteak;
	}

	public void setFourVsFourWinSteak(int fourVsFourWinSteak) {
		this.fourVsFourWinSteak = fourVsFourWinSteak;
	}

	public int getCrystals() {
		return crystals;
	}

	public void setCrystals(int crystals) {
		this.crystals = crystals;
	}

	public int getKeys() {
		return keys;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

	public ArrayList<String> getOffensiveSkillsUnlocked() {
		return offensiveSkillsUnlocked;
	}

	public void setOffensiveSkillsUnlocked(ArrayList<String> offensiveSkillsUnlocked) {
		this.offensiveSkillsUnlocked = offensiveSkillsUnlocked;
	}

	public ArrayList<String> getUtilitySkillsUnlocked() {
		return utilitySkillsUnlocked;
	}

	public void setUtilitySkillsUnlocked(ArrayList<String> utilitySkillsUnlocked) {
		this.utilitySkillsUnlocked = utilitySkillsUnlocked;
	}

	public ArrayList<String> getSupportSkillsUnlocked() {
		return supportSkillsUnlocked;
	}

	public void setSupportSkillsUnlocked(ArrayList<String> supportSkillsUnlocked) {
		this.supportSkillsUnlocked = supportSkillsUnlocked;
	}

	public ArrayList<String> getUltimateSkillsUnlocked() {
		return ultimateSkillsUnlocked;
	}

	public void setUltimateSkillsUnlocked(ArrayList<String> ultimateSkillsUnlocked) {
		this.ultimateSkillsUnlocked = ultimateSkillsUnlocked;
	}

	public ArrayList<String> getRunesUnlocked() {
		return runesUnlocked;
	}

	public void setRunesUnlocked(ArrayList<String> runesUnlocked) {
		this.runesUnlocked = runesUnlocked;
	}

	public ArrayList<String> getCombatUpgradesUnlocked() {
		return combatUpgradesUnlocked;
	}

	public void setCombatUpgradesUnlocked(ArrayList<String> combatUpgradesUnlocked) {
		this.combatUpgradesUnlocked = combatUpgradesUnlocked;
	}

	public ArrayList<String> getHatsUnlocked() {
		return hatsUnlocked;
	}

	public void setHatsUnlocked(ArrayList<String> hatsUnlocked) {
		this.hatsUnlocked = hatsUnlocked;
	}

	public ShopItemObject getOffensiveSkillSelected() {
		return offensiveSkillSelected;
	}

	public void setOffensiveSkillSelected(ShopItemObject offensiveSkillSelected) {
		this.offensiveSkillSelected = offensiveSkillSelected;
	}

	public String getUtilitySkillSelected() {
		return utilitySkillSelected;
	}

	public void setUtilitySkillSelected(String utilitySkillSelected) {
		this.utilitySkillSelected = utilitySkillSelected;
	}

	public String getSupportSkillSelected() {
		return supportSkillSelected;
	}

	public void setSupportSkillSelected(String supportSkillSelected) {
		this.supportSkillSelected = supportSkillSelected;
	}

	public String getUltimateSkillSelected() {
		return ultimateSkillSelected;
	}

	public void setUltimateSkillSelected(String ultimateSkillSelected) {
		this.ultimateSkillSelected = ultimateSkillSelected;
	}

	public String getRuneSelected() {
		return runeSelected;
	}

	public void setRuneSelected(String runeSelected) {
		this.runeSelected = runeSelected;
	}

	public String getHatSelected() {
		return hatSelected;
	}

	public void setHatSelected(String hatSelected) {
		this.hatSelected = hatSelected;
	}

	@Override
	public String toString() {
		return "PlayerInformationObject{" +
				"rating=" + rating +
				", twoVsTwoKills=" + twoVsTwoKills +
				", twoVsTwoWins=" + twoVsTwoWins +
				", twoVsTwoWinStreak=" + twoVsTwoWinStreak +
				", fourVsFourKills=" + fourVsFourKills +
				", fourVsFourWins=" + fourVsFourWins +
				", fourVsFourWinSteak=" + fourVsFourWinSteak +
				", crystals=" + crystals +
				", keys=" + keys +
				", offensiveSkillsUnlocked=" + offensiveSkillsUnlocked +
				", utilitySkillsUnlocked=" + utilitySkillsUnlocked +
				", supportSkillsUnlocked=" + supportSkillsUnlocked +
				", ultimateSkillsUnlocked=" + ultimateSkillsUnlocked +
				", runesUnlocked=" + runesUnlocked +
				", combatUpgradesUnlocked=" + combatUpgradesUnlocked +
				", hatsUnlocked=" + hatsUnlocked +
				", offensiveSkillSelected='" + offensiveSkillSelected + '\'' +
				", utilitySkillSelected='" + utilitySkillSelected + '\'' +
				", supportSkillSelected='" + supportSkillSelected + '\'' +
				", ultimateSkillSelected='" + ultimateSkillSelected + '\'' +
				", runeSelected='" + runeSelected + '\'' +
				", hatSelected='" + hatSelected + '\'' +
				'}';
	}
}

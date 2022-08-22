package za.co.codonorix.codobrawl.helper_classes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import za.co.codonorix.codobrawl.CodoBrawl;

import java.util.ArrayList;
import java.util.List;

public class ShopItemObject {
	private String name;
	private Material material;
	private List<String> lore;
	private int price;
	private String id;
	private boolean selected;

	public ShopItemObject(String name, Material material, List<String> lore, int price, String id, boolean selected) {
		this.name = name;
		this.material = material;
		this.lore = lore;
		this.price = price;
		this.id = id;
		this.selected = selected;
	}

	public ItemStack createItem() {
		TextComponent itemNameComponent = Component.text(getName());
		List<Component> itemLore = new ArrayList<Component>();

		if(!(lore == null)) {
			for (int i = 0; i < lore.size(); i++) {
				itemLore.add(Component.text(getLore().get(i)));
			}
		}

		if(!(price == -1)) {
			itemLore.add(Component.text(""));
			itemLore.add(Component.text(ChatColor.LIGHT_PURPLE + Integer.toString(getPrice()) + " crystals."));
		}else{
			itemLore.add(Component.text(""));
			itemLore.add(Component.text(ChatColor.GREEN + "FREE"));
		}

		ItemStack itemStack = new ItemStack(getMaterial(), 1);
		ItemMeta itemStackItemMeta = itemStack.getItemMeta();

		if(selected){
			itemStackItemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			itemNameComponent = Component.text(getName() + ChatColor.GREEN + "" + ChatColor.BOLD + "SELECTED");
		}

		itemStackItemMeta.displayName(itemNameComponent);
		itemStackItemMeta.lore(itemLore);

		NamespacedKey key = new NamespacedKey(CodoBrawl.getInstance(), getId());
		itemStackItemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, getId());

		itemStack.setItemMeta(itemStackItemMeta);

		return itemStack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}

package me.Matt5067.MattSmithingTableDisabler;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		super.onEnable();
		Bukkit.getServer().getLogger().info("[MattSmithingTableDisabler] MSTD Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info("[MattSmithingTableDisabler] MSTD Disabled!");
		super.onDisable();
	}
	
	@EventHandler
	public void onSmith(PrepareSmithingEvent e) {
		ItemStack result = e.getResult();
		if (result.hasItemMeta() && result.getItemMeta().hasLore()) {
			ItemMeta meta = result.getItemMeta();
			meta.setLore(new ArrayList<String>());
			result.setItemMeta(meta);
		}
	}
}
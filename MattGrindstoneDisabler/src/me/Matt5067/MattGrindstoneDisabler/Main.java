package me.Matt5067.MattGrindstoneDisabler;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		super.onEnable();
		Bukkit.getServer().getLogger().info("[MattGrindstoneDisabler] MGD Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
  
	public void onDisable() {
	  Bukkit.getServer().getLogger().info("[MattGrindstoneDisabler] MGD Disabled!");
    	super.onDisable();
  	}

  	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
			if (event.getBlock().getType() == Material.GRINDSTONE) {
				event.getPlayer().sendMessage("§4[§c§lMLMC§4] §7Grindstones are disabled. You can only place a grindstone for decoration.");
			}
  	}

  	@EventHandler
	public void onBlockClick(PlayerInteractEvent event) {
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	            Player player = (Player) event.getPlayer();
	            Material clicked = event.getClickedBlock().getType();
	            if (clicked == Material.GRINDSTONE) {
	            	player.sendMessage("§4[§c§lMLMC§4] §7Grindstones are disabled. You may only use a grindstone for decoration.");
	            	event.setCancelled(true);
	            }
			}
  	}
}

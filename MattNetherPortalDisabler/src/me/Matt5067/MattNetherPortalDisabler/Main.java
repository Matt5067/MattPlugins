package me.Matt5067.MattNetherPortalDisabler;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
  implements Listener
{
  public void onEnable()
  {
    super.onEnable();
    Bukkit.getServer().getLogger().info("[MattNetherPortalDisabler] MNPD Enabled!");
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  public void onDisable()
  {
    Bukkit.getServer().getLogger().info("[MattNetherPortalDisabler] MNPD Disabled!");
    super.onDisable();
  }
  
  @EventHandler
  public void onWorldEvent(PortalCreateEvent event)
  {
    System.out.println("test this happened");
    event.getEntity().sendMessage("§4[§c§lMLMC§4] §7Nether portal creation is disabled. Please access the Nether using §c/warp nether§7.");
    event.setCancelled(true);
  }
}
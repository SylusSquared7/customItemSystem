package com.sylus.newcustomitemsystem.handlers;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerHandler implements Listener {
    public playerHandler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
//Welcomes every player to the server
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server. Currently testing adding lore /loreadd.", ChatColor.YELLOW + "build 22");
      /*
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 64);
        Inventory inv = player.getInventory();
        inv.setItem(8,item); */
    }
}



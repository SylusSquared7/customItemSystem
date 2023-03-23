package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class launcher implements Listener {

    public void launcherHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            Player player = event.getPlayer();
            if (event.getItem() != null){
                if (player.getInventory().getItemInMainHand().getItemMeta() != null){
                    player.sendMessage(ChatColor.RED + "TEST");
                    ItemStack item = event.getItem();
                    System.out.println(item);
                    ItemStack heldItem = event.getItem();
                    if ( NBTEditor.contains(heldItem, "A VALUE") ) {
                        //String owner = NBTEditor.getString( item, "any custom string key", "item", "owner" );
                        player.sendMessage(ChatColor.GOLD + "IT WORKS");
                    }
                }
            }
        }
    }
}

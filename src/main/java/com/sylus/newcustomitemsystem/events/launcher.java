package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static com.sylus.newcustomitemsystem.manager.cooldowns.getCooldowns;

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
                    ItemStack item = event.getItem();
                    ItemStack heldItem = event.getItem();
                    if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "A VALUE")) {
                    //   if (player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                           int delay = getCooldowns(player, 5000);
                           if (delay == 0){
                               player.setVelocity(player.getLocation().getDirection().multiply(0.2).setY(1));
                           } else {
                               player.sendMessage(ChatColor.RED + "Can't use for" + delay + " seconds");
                           }


                   //     }


                    }
                }
            }
        }
    }
}

package com.sylus.newcustomitemsystem.events;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class eventsManager implements Listener {
    @EventHandler
    public void playerRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getItem() != null){
                ItemStack item = event.getItem();
                ItemStack heldItem = event.getItem();
                if (Objects.equals(NBTEditor.getString(heldItem, "test", "value"), "EGGTHROW")) {

                }

            }
        }
    }
}

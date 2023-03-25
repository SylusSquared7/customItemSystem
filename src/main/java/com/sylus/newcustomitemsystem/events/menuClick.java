package com.sylus.newcustomitemsystem.events;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.commands.menu;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Switch;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class menuClick implements Listener {

    public void menuHandeler(NewCustomItemSystem plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        if (event.getView().getTitle().equals("Modify an Item")){
            switch (event.getCurrentItem().getType()){
                case SLIME_BLOCK:
                    player.closeInventory();
                    ItemStack heldItem = player.getInventory().getItemInMainHand();
                    if (heldItem.getItemMeta().hasLore() != true){
                        ItemMeta meta = heldItem.getItemMeta();
                        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                        lore.add("New lore test");
                        meta.setLore(lore);
                        heldItem.setItemMeta(meta);
                        player.getInventory().setItemInMainHand(heldItem);
                        heldItem = NBTEditor.set( heldItem, "A VALUE", "test", "value" );
                        player.setItemInHand( heldItem );
                        player.sendMessage(ChatColor.GOLD + "Test");
                    }else {

                        ItemStack item = player.getItemInHand();
                        if ( item != null ) {
                            item = NBTEditor.set( item, "A VALUE", "test", "value" );
                            player.setItemInHand( item );
                            player.sendMessage( "" + NBTEditor.getString( item, "test", "value" ) );
                        }
                        Bukkit.getLogger().info(ChatColor.GREEN + "Test");
                        ItemMeta meta = heldItem.getItemMeta();
                        List oldMeta = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
                        lore.add("New lore test");
                        meta.setLore(lore);
                        heldItem.setItemMeta(meta);
                        player.getInventory().setItemInMainHand(heldItem);
                        player.sendMessage(ChatColor.GOLD + "Test");
                    }
            }
        }

    }
}

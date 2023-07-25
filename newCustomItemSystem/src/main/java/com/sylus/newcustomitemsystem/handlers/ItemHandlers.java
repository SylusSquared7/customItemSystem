package com.sylus.newcustomitemsystem.handlers;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import com.sylus.newcustomitemsystem.events.*;
import com.sylus.newcustomitemsystem.manager.cooldowns;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemHandlers implements Listener {
    public void itemHandlerHandler(NewCustomItemSystem plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private int cooldownSeconds = 10;
    private String source = "Right click lightning";
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            ItemStack heldItem = player.getInventory().getItemInMainHand();

            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                switch (NBTEditor.getString(heldItem, "test", "value")) {

                    case "LAUNCHER":
                        cooldownSeconds = 10;
                        source = "Right click Launcher";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            Launcher logic = new Launcher(player);
                            logic.launcherLogic(player);
                        } else {
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }

                    case "LIGHTNING":
                        cooldownSeconds = 60;
                        source = "Right click lightning";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            LightningStrike logic = new LightningStrike(player);
                            logic.lightningLogic(player);

                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }

                    case "GLOWOING":
                        cooldownSeconds = 60;
                        source = "Right click glow";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            GlowEffect logic = new GlowEffect(player);
                            logic.glowLogic(player);
                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }
                    case "ARROW":
                        cooldownSeconds = 60;
                        source = "Right click Arrow";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            Arrow arrow = new Arrow();
                            arrow.arrowLogic(player);

                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }
                    case "EGGTHROW":
                        cooldownSeconds = 60;
                        source = "Right click Egg";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            EggThrow eggThrow = new EggThrow();
                            eggThrow.eggThrowLogic(player);

                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }
                    case "OTHERLAUNCHER":
                        cooldownSeconds = 60;
                        source = "Right click otherLauncher";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            OtherLauncher otherLauncher = new OtherLauncher();
                            otherLauncher.otherLauncherLogic(player);

                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }
                    case "TNTTHROW":
                        cooldownSeconds = 60;
                        source = "Right click tntThrow";
                        if (!cooldowns.hasCooldown(player, source)) {
                            cooldowns.setCooldown(player, cooldownSeconds, source);
                            TntThrow tntThrow = new TntThrow();
                            tntThrow.tntThrowLogic(player);

                        } else {
                            event.setCancelled(true);
                            long cooldownRemainingSeconds = cooldowns.getCooldown(player, source);
                            player.sendMessage(ChatColor.RED + "You must wait " + cooldownRemainingSeconds + ChatColor.RED + " seconds before you can use this item again.");
                        }
                }
            }
        }
    }
}


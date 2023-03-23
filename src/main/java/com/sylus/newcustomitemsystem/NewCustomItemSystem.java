package com.sylus.newcustomitemsystem;

import com.sylus.newcustomitemsystem.commands.loreAddTest;
import com.sylus.newcustomitemsystem.handlers.playerHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NewCustomItemSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info(ChatColor.GREEN + "Plugin started");
        getCommand("fly").setExecutor(new com.sylus.newcustomitemsystem.commands.fly());
        getCommand("menu").setExecutor(new com.sylus.newcustomitemsystem.commands.menu(this));
        getCommand("loreAddTest").setExecutor(new loreAddTest());

        new playerHandler(this);
        new com.sylus.newcustomitemsystem.manager.cooldowns(this);
        new com.sylus.newcustomitemsystem.manager.itemManager();
        new com.sylus.newcustomitemsystem.events.launcher();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(ChatColor.RED + "Plugin stopped");
    }
}

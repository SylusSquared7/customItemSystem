package com.sylus.newcustomitemsystem.manager;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class cooldowns implements Listener {
private static HashMap<UUID, Long> cooldown;

public static int getCooldowns(Player player, int delay){
    return cooldownsLogic(player, delay);
}
    private static int cooldownsLogic(Player player, int delay){
        if (!cooldown.containsKey(player.getUniqueId())){
            cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            return delay / 1000;
        }
        long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
        if (timeElapsed >= delay){
            cooldown.remove(player.getUniqueId());
            return 0;
        }
        int toReturnTimeElapsed = (int) timeElapsed / 1000;
        return toReturnTimeElapsed;
    }

/*
    public long cooldowns(Player player, int delay){


    if (! this.cooldown.containsKey(player.getUniqueId())){
        this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
        return 0;

    } else {
        //in miliseconds
        long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
        if (timeElapsed >= delay){
            return 0;
        }else {
            return timeElapsed / 1000;
        }
    }

} */
}

package com.sylus.newcustomitemsystem.manager;

import com.sylus.newcustomitemsystem.NewCustomItemSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class cooldowns implements Listener {

    private Map<UUID, Integer> playerCooldownMap = new HashMap<>();
    public cooldowns(NewCustomItemSystem plugin){
        new BukkitRunnable(){
            @Override
            public void run(){
                for (UUID uuid : playerCooldownMap.keySet()){
                    if (playerCooldownMap.get(uuid) == 1){
                        playerCooldownMap.remove(uuid);
                        continue;
                    }
                    playerCooldownMap.put(uuid,playerCooldownMap.get(uuid) -1);
                }
            }
        }.runTaskTimer(plugin, 0, 25);
    }
    public void addPlayerToMap(Player player, Integer time){
        playerCooldownMap.put(player.getUniqueId(),time);
    }

    public boolean isPlayerInCooldown(Player player){
        return playerCooldownMap.containsKey(player.getUniqueId());

    }
}

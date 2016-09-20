package com.sumeshdesh.tpbow;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;


/**
 * Created by Sumesh on 9/19/2016.
 */
public class LocSetter implements Listener {
    @EventHandler
    public void onShoot(ProjectileHitEvent event){
        if ((event.getEntity() instanceof Arrow) &&
                (event.getEntity().getShooter() instanceof Player)){
            Location loc = event.getEntity().getLocation();
            Player player = ((Player) event.getEntity().getShooter()).getPlayer();

            if (player.getItemInHand().getItemMeta().hasDisplayName()) {
                if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"TP-Bow")) {
                    ((Player) event.getEntity().getShooter()).teleport(loc);
                    Location playerLoc = ((Player) event.getEntity().getShooter()).getLocation();
                    playCircularEffect(playerLoc, Effect.ENDER_SIGNAL, true);
                    event.getEntity().playEffect(EntityEffect.VILLAGER_ANGRY);
                }
            }


        }
    }

    public void playCircularEffect(Location location, Effect effect, boolean v){
        for (int i = 0; i <= 8; i += ((!v && (i == 3)) ? 2 : 1))location.getWorld().playEffect(location, effect, i);
    }
}


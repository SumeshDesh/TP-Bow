package com.sumeshdesh.tpbow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Sumesh on 9/19/2016.
 */
public class TPBow extends JavaPlugin {
    LocSetter locsetter = new LocSetter();
   public void onEnable(){
       Bukkit.getPluginManager().registerEvents(locsetter,this);
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
       if (cmd.getName().equalsIgnoreCase("tpbow") && sender instanceof Player){
           Player player = (Player) sender;
           if (player.getInventory().getItemInHand().getType() == Material.BOW){
               ItemStack i = player.getItemInHand();
               ItemMeta im = i.getItemMeta();
               im.setDisplayName(ChatColor.GREEN + "TP-Bow");
               i.setItemMeta(im);

           }
       }
       return false;
   }
}

package com.aviloo.rewardchests.Events.OpenChest;

import com.aviloo.rewardchests.ItemStack.Rewards.Casual.*;
import com.aviloo.rewardchests.ItemStack.Rewards.Special.fishingRod;
import com.aviloo.rewardchests.Utils.getPlayerOnline;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;



public class openEvent implements Listener {

    @EventHandler
    public void onOpenFish(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getPlayer().getInventory().getItemInMainHand().equals(com.aviloo.rewardchests.ItemStack.Chests.fisherChest.chestStack())){
                double ran = Math.random();
                if(ran <= 0.4){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(fourDiamond.diamondStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпало 4 алмаза.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпало 4 алмаза, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.41 && ran < 0.5){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(goldenApple.goldApple());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпало золотое яблоко.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпало золотое яблоко, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.5 && ran < 0.51){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(fishingRod.fishingRodStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал "+ChatColor.DARK_PURPLE+"особенный предмет.");
                    for(Player es : getPlayerOnline.getOnlinePlayers()){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпал "+ChatColor.DARK_PURPLE+"особый предмет"+ChatColor.WHITE+", из сундука рыбака.");;
                    }
                }
                if(ran >= 0.51 && ran < 0.54){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(food.chickenStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпала курица.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпала курица, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.54 && ran < 0.57){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(food.pigStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпала свининна.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпала свининна, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.57 && ran < 0.64){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(arrows.arrowsStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпали стрелы.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпали стрелы, из сундука рыбака.");;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onOpenHunt(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getPlayer().getInventory().getItemInMainHand().equals(com.aviloo.rewardchests.ItemStack.Chests.hunterChest.chestStack())){
                double ran = Math.random();
                if(ran <= 0.4){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(fourDiamond.diamondStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпало 4 алмаза.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпало 4 алмаза, из сундука рыбака.");;
                    }
                }
                if(ran > 0.41 && ran < 0.5){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(goldenApple.goldApple());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпало золотое яблоко.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпало золотое яблоко, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.5 && ran < 0.55 ){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(nether.netherStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал незер слиток.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпал незер слиток, из сундука рыбака.");;
                    }
                }
                if(ran >= 0.56 && ran < 0.57 ){
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.getInventory().addItem(nether.netherStack());
                    player.sendMessage(ChatColor.GRAY+"[Ларцы] " +ChatColor.WHITE+"Поздравляем! Вам выпал незер слиток.");
                    for(Entity es : player.getNearbyEntities(25,25,25)){
                        es.sendMessage(ChatColor.GRAY+"[Новости] " +ChatColor.WHITE+"Поздравляем, игрока "+player.getDisplayName()+"! Ему выпал незер слиток, из сундука рыбака.");;
                    }
                }
            }
        }
    }
}

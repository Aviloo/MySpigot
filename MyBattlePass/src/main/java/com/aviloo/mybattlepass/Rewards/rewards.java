package com.aviloo.mybattlepass.Rewards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class rewards {

    //Methods Path
    public static void getRewardItem(ItemStack reward, Player player){
        player.getInventory().addItem(reward);
    }

    public static void getRewardCoin(Double count,Player player){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"eco give " + count +" "+player.getName());
        player.sendMessage(ChatColor.GRAY + "[Банк] " + ChatColor.GRAY + "Вам было зачисленно "+count+" коинов на счёт.");
    }

    public static void getRewardChest(String type,Player player){
        if(Bukkit.getServer().getPluginManager().getPlugin("RewardChests") == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Вы забыли установить " +
                    "плагин RewardChest в сборку этого сервера. Без этого метод getRewardChest работать не будет!");
        }

        if(type.equals("hero")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"givechest hero " + player.getName());
        }
        if(type.equals("legendary")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"givechest legendary " + player.getName());
        }
        if(type.equals("fisher")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"givechest fisher_chest " + player.getName());
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Вы указали неверный тип " +
                    "ларца!");
        }
    }
}

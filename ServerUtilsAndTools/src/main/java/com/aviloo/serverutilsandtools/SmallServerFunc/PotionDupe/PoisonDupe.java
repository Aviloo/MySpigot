package com.aviloo.serverutilsandtools.SmallServerFunc.PotionDupe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class PoisonDupe implements Listener {

    @EventHandler
    public void addToDupe(InventoryInteractEvent event){

        //Variables
        Player player = (Player) event.getWhoClicked();

        //ItemStacks
        ItemStack OnePoison = new ItemStack(Material.POTION,1);
        PotionMeta OnePotionMeta = (PotionMeta) OnePoison.getItemMeta();
        OnePotionMeta.setBasePotionData(new PotionData(PotionType.SPEED));
        OnePoison.setItemMeta(OnePotionMeta);

        ItemStack[] OnePotionList = {OnePoison,OnePoison,OnePoison,OnePoison,OnePoison,OnePoison,OnePoison,
                OnePoison,OnePoison,};

        ItemStack TenPotion = new ItemStack(Material.POTION,9);
        PotionMeta TenPotionMeta = (PotionMeta) TenPotion.getItemMeta();
        TenPotionMeta.setBasePotionData(new PotionData(PotionType.SPEED));
        TenPotion.setItemMeta(OnePotionMeta);

        ItemStack[] TenPotionList = {TenPotion};

        //Event
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Ультимативная зельеварка")){
            if(!event.getInventory().getType().equals(InventoryType.DROPPER)){return;}
            if(event.getInventory().getContents().equals(OnePotionList)){
                event.getInventory().clear();
                event.getInventory().setContents(TenPotionList);
                player.sendMessage("Вы скрафтили зелье (x9)");
            }
        }
    }
}

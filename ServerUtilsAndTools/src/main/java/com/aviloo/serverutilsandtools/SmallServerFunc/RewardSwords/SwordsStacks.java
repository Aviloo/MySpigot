package com.aviloo.serverutilsandtools.SmallServerFunc.RewardSwords;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SwordsStacks {

    public static ItemStack getLoveSword(Player player){
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD,1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Клинок любви " + ChatColor.WHITE+ "♥");
        ArrayList<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.GRAY+"За твои героические подвиги,");
        swordLore.add(ChatColor.GRAY+player.getName() +", ты удостоился этого клинка ");
        swordLore.add(ChatColor.GRAY+"и нашей благодарности.");
        swordLore.add(" ");
        swordLore.add(ChatColor.GRAY+"                          (с) FullVision");
        swordMeta.setLore(swordLore);
        sword.setItemMeta(swordMeta);

        return sword;
    }
}

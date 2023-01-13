package com.aviloo.mydaily.Quests;

import com.aviloo.mydaily.MyDaily;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CrystalQuest implements Listener {

    private JavaPlugin plugin;

    public CrystalQuest(JavaPlugin plugin){
        this.plugin = plugin;
    }

    private static final ConcurrentHashMap<UUID,Boolean> CrystalQuestStatus = new ConcurrentHashMap<>();

    public static Boolean isCrystalQuestComplete(Player player){
        if(CrystalQuestStatus.get(player.getUniqueId())){return true;}
        return false;
    }

    private static final ConcurrentHashMap<UUID,Integer> CrystalCount = new ConcurrentHashMap<>();

    public static void addCrystal(Player player){
        CrystalCount.put(player.getUniqueId(),CrystalCount.getOrDefault(player.getUniqueId(),0) + 1);
    }

    public static Integer getCrystal(Player player){
        return CrystalCount.get(player.getUniqueId());
    }
    public static void setCrystalQuestDefault(Player player){
        CrystalCount.put(player.getUniqueId(),0);
        CrystalQuestStatus.put(player.getUniqueId(),false);
    }

    @EventHandler
    public void onCraft(CraftItemEvent event){
        ItemStack result = new ItemStack(Material.END_CRYSTAL,1);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin,"crystal"),result);
        recipe.shape("XXX","XAX","XBX");
        recipe.setIngredient('X',Material.GLASS);
        recipe.setIngredient('A',Material.ENDER_EYE);
        recipe.setIngredient('B',Material.IRON_NUGGET);
        Bukkit.addRecipe(recipe);

        if(!event.getRecipe().equals(recipe)){return;}
        if(!(event.getWhoClicked() instanceof Player)){return;}

        Player player = (Player) event.getWhoClicked();
        if(getCrystal(player) == 25){
            CoalQuest.giveReward(player);
            CrystalQuestStatus.put(player.getUniqueId(),true);
        }
        if(getCrystal(player) < 25){addCrystal(player);}
    }
}

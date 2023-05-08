package me.aviloo.mypotionsystem.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryUtils {
    //Material Part

    private static final ConcurrentHashMap<UUID,Integer> SelectedMaterial = new ConcurrentHashMap<>();

    public static void addSelectedMaterial(Player player){
        SelectedMaterial.put(player.getUniqueId(),SelectedMaterial.getOrDefault(player.getUniqueId(),0)+1);
    }

    public static Integer getSelectedMaterial(Player player){
        return SelectedMaterial.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID, Material> FirstSelectedMaterial = new ConcurrentHashMap<>();

    public static void setFirstSelectedMaterial(Player player,Material material){
        FirstSelectedMaterial.put(player.getUniqueId(),material);
    }
    public static Material getFirstSelectedMaterial(Player player){
        return FirstSelectedMaterial.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID, Material> SecondSelectedMaterial = new ConcurrentHashMap<>();

    public static void setSecondSelectedMaterial(Player player,Material material){
        SecondSelectedMaterial.put(player.getUniqueId(),material);
    }
    public static Material getSecondSelectedMaterial(Player player){
        return SecondSelectedMaterial.get(player.getUniqueId());
    }

    private static final ConcurrentHashMap<UUID, Material> ThirdSelectedMaterial = new ConcurrentHashMap<>();

    public static void setThirdSelectedMaterial(Player player,Material material){
        ThirdSelectedMaterial.put(player.getUniqueId(),material);
    }
    public static Material getThirdSelectedMaterial(Player player){
        return ThirdSelectedMaterial.get(player.getUniqueId());
    }

    //Abilities Part

    private static final ConcurrentHashMap<UUID,Integer> SelectedAbility = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<UUID, Material> FirstSelectedAbility = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<UUID, Material> SecondSelectedAbility = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<UUID, Material> ThirdSelectedAbility = new ConcurrentHashMap<>();

    //Clean Part
    
    public static void cleanMaterial(Player player){
        SelectedMaterial.put(player.getUniqueId(),0);
        FirstSelectedMaterial.put(player.getUniqueId(),Material.STRUCTURE_VOID);
        SecondSelectedMaterial.put(player.getUniqueId(),Material.STRUCTURE_VOID);
        ThirdSelectedMaterial.put(player.getUniqueId(),Material.STRUCTURE_VOID);
    }

    public static void cleanAbility(Player player){
        SelectedAbility.put(player.getUniqueId(),0);
        FirstSelectedAbility.put(player.getUniqueId(),Material.STRUCTURE_VOID);
        SecondSelectedAbility.put(player.getUniqueId(),Material.STRUCTURE_VOID);
        ThirdSelectedAbility.put(player.getUniqueId(),Material.STRUCTURE_VOID);
    }

    //Check Part

    protected static boolean isMaterialSelected(Player player,Material material){
        if(getFirstSelectedMaterial(player).equals(material)
        || getSecondSelectedMaterial(player).equals(material)
        || getThirdSelectedMaterial(player).equals(material)){
            return true;
        }
        return false;
    }

    public static void selectMaterial(Player player,Material material){
        if(getSelectedMaterial(player) >= 3){
            player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Достигнут лимит максимального кол-ва материалов!");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,5,0);
            return;
        }
        if(isMaterialSelected(player,material)){
            player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Этот материал уже выбран!");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,5,0);
            return;
        }
        if(getFirstSelectedMaterial(player).equals(Material.STRUCTURE_VOID)){
            FirstSelectedMaterial.put(player.getUniqueId(),material);
            addSelectedMaterial(player);
            return;
        }
        if(getSecondSelectedMaterial(player).equals(Material.STRUCTURE_VOID)){
            SecondSelectedMaterial.put(player.getUniqueId(),material);
            addSelectedMaterial(player);
            return;
        }
        if(getThirdSelectedMaterial(player).equals(Material.STRUCTURE_VOID)){
            ThirdSelectedMaterial.put(player.getUniqueId(),material);
            addSelectedMaterial(player);
        }
    }

    //ItemStack Editor Part

    public static void itemsEditor(ItemStack stack, String name, String ... lore){
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        ArrayList<String> ItemLore = new ArrayList<>();
        for(String str : lore){
            ItemLore.add(ChatColor.translateAlternateColorCodes('&',str));
        }
        meta.setLore(ItemLore);
        stack.setItemMeta(meta);
    }

}

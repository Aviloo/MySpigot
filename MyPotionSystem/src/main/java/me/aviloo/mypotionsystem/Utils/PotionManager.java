package me.aviloo.mypotionsystem.Utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionManager {

    public static ItemStack createPotion(Player player){
        ItemStack potion = new ItemStack(Material.POTION,1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        setPotionColor(player,meta);
        if(InventoryUtils.isMaterialSelected(player,Material.NETHER_WART)){
            if(InventoryUtils.isMaterialSelected(player,Material.SUGAR)){ // Зелье Скорости
                if(InventoryUtils.isMaterialSelected(player,Material.REDSTONE)){ // Это увеличивает время действия
                    meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED,
                            getDuration(player),getAmplifier(player)),true);
                    potion.setItemMeta(meta);
                    return potion;
                }
                if(InventoryUtils.isMaterialSelected(player,Material.GLOWSTONE_DUST)){ //Это увеличивает силу зелья
                    meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED,
                            getDuration(player),getAmplifier(player)),true);
                    potion.setItemMeta(meta);
                    return potion;
                }

            }
            if(InventoryUtils.isMaterialSelected(player,Material.FERMENTED_SPIDER_EYE)){ // Зелье замедления
                meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW,
                        getDuration(player),getAmplifier(player)),true);
                potion.setItemMeta(meta);
                return potion;
            }
            //todo Добавить зелий
        }

        return potion;
    }

    private static Integer getDuration(Player player){
        if(PotionProperties.getBurn(player) < 90){
            return PotionProperties.getTime(player) + 1300;
        }

        return PotionProperties.getTime(player) + 1300 + 1300; // 1300 - Базовое значение равное 1 минуте
    }

    private static Integer getAmplifier(Player player){
        if((PotionProperties.getEnvironmentalInfluence(player) < 100)
                && PotionProperties.getFeculence(player) < 50){
            return 1;
        }
        if(PotionProperties.getFeculence(player) < 50){
            return 1 + (PotionProperties.getEnvironmentalInfluence(player) / 100);
        }

        return 1 + 1 + (PotionProperties.getEnvironmentalInfluence(player) / 100);
    }

    private static void setPotionColor(Player player, PotionMeta meta){
        if(PotionProperties.getWitchLuck(player) >= 100){
            meta.setColor(Color.YELLOW);
            return;
        }
        if(PotionProperties.getFeculence(player) <= 5){
            meta.setColor(Color.WHITE);
            return;
        }
        if(PotionProperties.getFeculence(player) > 70 && PotionProperties.getFeculence(player) < 85){
            meta.setColor(Color.SILVER);
            return;
        }
        if(PotionProperties.getFeculence(player) >= 85){
            meta.setColor(Color.GRAY);
            return;
        }

        if(Math.random() < 0.1){
            meta.setColor(Color.LIME);
            return;
        }
        if(Math.random() >= 0.1 && Math.random() < 0.2){
            meta.setColor(Color.RED);
            return;
        }
        if(Math.random() >= 0.2 && Math.random() < 0.3){
            meta.setColor(Color.ORANGE);
            return;
        }
        if(Math.random() >= 0.3 && Math.random() < 0.4){
            meta.setColor(Color.BLUE);
            return;
        }
        if(Math.random() >= 0.4 && Math.random() < 0.5){
            meta.setColor(Color.PURPLE);
            return;
        }
        if(Math.random() >= 0.5 && Math.random() < 0.6){
            meta.setColor(Color.AQUA);
            return;
        }
        if(Math.random() >= 0.6 && Math.random() < 0.7){
            meta.setColor(Color.NAVY);
            return;
        }
        if(Math.random() >= 0.7 && Math.random() < 0.8){
            meta.setColor(Color.OLIVE);
            return;
        }
        if(Math.random() >= 0.8 && Math.random() < 0.9){
            meta.setColor(Color.FUCHSIA);
            return;
        }
        if(Math.random() >= 0.9 && Math.random() < 0.99){
            meta.setColor(Color.MAROON);
        }else {
            meta.setColor(Color.TEAL);
        }
    }

}

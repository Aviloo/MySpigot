package me.aviloo.mypotionsystem.Events;

import me.aviloo.mypotionsystem.Inventories.MainInventory;
import me.aviloo.mypotionsystem.Utils.EconomyManager;
import me.aviloo.mypotionsystem.Utils.InventoryUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MaterialsInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Материалы")){
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,9,1);
                    break;
                case STRUCTURE_VOID:
                    InventoryUtils.cleanMaterial(player);
                    player.playSound(player.getLocation(),Sound.BLOCK_ANVIL_BREAK,3,0);
                    break;
                case MAGMA_CREAM:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.MAGMA_CREAM);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case GHAST_TEAR:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.GHAST_TEAR);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case BLAZE_POWDER:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.BLAZE_POWDER);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case GOLDEN_CARROT:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.GOLDEN_CARROT);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case PHANTOM_MEMBRANE:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.PHANTOM_MEMBRANE);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case RABBIT_FOOT:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.RABBIT_FOOT);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case GLISTERING_MELON_SLICE:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.GLISTERING_MELON_SLICE);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case FERMENTED_SPIDER_EYE:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.FERMENTED_SPIDER_EYE);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case GLOWSTONE_DUST:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.GLOWSTONE_DUST);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case REDSTONE:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.REDSTONE);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case TURTLE_HELMET:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.TURTLE_HELMET);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case PUFFERFISH:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.PUFFERFISH);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case SUGAR:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.SUGAR);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
                case NETHER_WART:
                    if(EconomyManager.hasPlayerMoney(player,4.0)){
                        InventoryUtils.selectMaterial(player, Material.NETHER_WART);
                        EconomyManager.takeMoney(player,4.0);
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}

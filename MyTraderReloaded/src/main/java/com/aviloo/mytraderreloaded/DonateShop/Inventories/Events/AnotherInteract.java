package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AnotherInteract implements Listener {

    protected static boolean isInventoryFull(Player p)
    {
        return p.getInventory().firstEmpty() == -1;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}

        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Полезные предметы")){
            switch (event.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case END_PORTAL_FRAME:
                    if(isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,125)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,125)){
                            EnchantedInteract.takePlayerPoints(player,125);
                            player.getInventory().addItem(new ItemStack(Material.END_PORTAL,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,250000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughVault(player,250000)){
                            EnchantedInteract.takeVault(player,250000);
                            player.getInventory().addItem(new ItemStack(Material.END_PORTAL,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
            }
            event.setCancelled(true);
        }
    }
}

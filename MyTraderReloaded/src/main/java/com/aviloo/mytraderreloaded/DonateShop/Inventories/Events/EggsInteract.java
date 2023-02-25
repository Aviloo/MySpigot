package com.aviloo.mytraderreloaded.DonateShop.Inventories.Events;

import com.aviloo.mytraderreloaded.DonateShop.Inventories.MainInventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class EggsInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}

        if(event.getView().getTitle().equals(ChatColor.WHITE+"Яйца для спавнеров")) {
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()) {
                case RED_STAINED_GLASS_PANE:
                    player.closeInventory();
                    break;
                case SPECTRAL_ARROW:
                    player.openInventory(MainInventory.getInv(player));
                    break;
                case ZOMBIE_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            EnchantedInteract.takePlayerPoints(player,30);
                            player.getInventory().addItem(new ItemStack(Material.ZOMBIE_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,60000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,60000)){
                            EnchantedInteract.takeVault(player,60000);
                            player.getInventory().addItem(new ItemStack(Material.ZOMBIE_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
                case CREEPER_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            EnchantedInteract.takePlayerPoints(player,30);
                            player.getInventory().addItem(new ItemStack(Material.CREEPER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,60000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,60000)){
                            EnchantedInteract.takeVault(player,60000);
                            player.getInventory().addItem(new ItemStack(Material.CREEPER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
                case SKELETON_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            EnchantedInteract.takePlayerPoints(player,30);
                            player.getInventory().addItem(new ItemStack(Material.SKELETON_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,60000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,60000)){
                            EnchantedInteract.takeVault(player,60000);
                            player.getInventory().addItem(new ItemStack(Material.SKELETON_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
                case SPIDER_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,30)){
                            EnchantedInteract.takePlayerPoints(player,30);
                            player.getInventory().addItem(new ItemStack(Material.SPIDER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,60000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,60000)){
                            EnchantedInteract.takeVault(player,60000);
                            player.getInventory().addItem(new ItemStack(Material.SPIDER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
                case CAVE_SPIDER_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,35)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,35)){
                            EnchantedInteract.takePlayerPoints(player,35);
                            player.getInventory().addItem(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,70000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,70000)){
                            EnchantedInteract.takeVault(player,70000);
                            player.getInventory().addItem(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
                case ZOMBIFIED_PIGLIN_SPAWN_EGG:
                    if(AnotherInteract.isInventoryFull(player)){
                        player.sendMessage(ChatColor.RED+"[Ошибка] "+ChatColor.WHITE+"Ваш инвентарь заполнен.");
                        break;
                    }
                    if(event.isLeftClick()){
                        if(!EnchantedInteract.hasEnoughPlayerPoints(player,50)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;}
                        if(EnchantedInteract.hasEnoughPlayerPoints(player,50)){
                            EnchantedInteract.takePlayerPoints(player,50);
                            player.getInventory().addItem(new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    if(event.isRightClick()){
                        if(!EnchantedInteract.hasEnoughVault(player,100000)){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7[Система] " +
                                    "&4У вас недостаточно средств."));
                            player.closeInventory();
                            break;
                        }
                        if(EnchantedInteract.hasEnoughVault(player,100000)){
                            EnchantedInteract.takeVault(player,100000);
                            player.getInventory().addItem(new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,1));
                            player.closeInventory();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}

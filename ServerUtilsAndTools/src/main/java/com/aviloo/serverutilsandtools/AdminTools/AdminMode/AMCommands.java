package com.aviloo.serverutilsandtools.AdminTools.AdminMode;

import com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats.AdministratorProperties;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class AMCommands implements CommandExecutor {

//Inventory Path
    public static ItemStack firstItem(){
        ItemStack item = new ItemStack(Material.WHITE_DYE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Невидимость");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(">> ");
        lore.add(ChatColor.WHITE+"ПКМ - выключить");
        lore.add(ChatColor.WHITE+"ЛКМ - включить");
        lore.add(">> ");
        //meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
    public static ItemStack secondItem(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD,AMUtils.getPlayersCount());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Список игроков онлайн");
        item.setItemMeta(meta);

        return item;
    }
    public static ItemStack thirdItem(){
        ItemStack item = new ItemStack(Material.STICK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Кик-Палка");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(">> ");
        lore.add(ChatColor.WHITE+"Причина кика - помеха.");
        lore.add(">> ");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack fourthItem(){
        ItemStack item = new ItemStack(Material.BOOK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE+"Справочник по админ командам");
        item.setItemMeta(meta);

        return item;
    }
    private ItemStack[] adminCollection(){
        ItemStack air = new ItemStack(Material.AIR);

        ItemStack[] itemStack = {firstItem(),air,secondItem(),air,thirdItem(),air,air,air,fourthItem()};
        return itemStack;
    }
    private Inventory choiceYourMode(Player player){
        Inventory inv = Bukkit.createInventory(player,9,ChatColor.WHITE+"Выбор режима");

        ItemStack allow = new ItemStack(Material.GREEN_DYE,1);
        ItemMeta aMeta = allow.getItemMeta();
        aMeta.setDisplayName(ChatColor.YELLOW+"Выживание");
        allow.setItemMeta(aMeta);

        ItemStack deny = new ItemStack(Material.RED_DYE,1);
        ItemMeta dMeta = deny.getItemMeta();
        dMeta.setDisplayName(ChatColor.YELLOW+"Остаться в креативе");
        deny.setItemMeta(dMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack[] inv_stack = {air,air,allow,air,air,air,deny,air,air};
        inv.setContents(inv_stack);

        return inv;
    }

    //HashMap Path
    private static final LinkedHashMap<Player, ItemStack[]> savedInventories = new LinkedHashMap<>();

    public static ItemStack[] returnInventory(Player player){
        ItemStack[] inv = savedInventories.get(player);
        savedInventories.remove(player,savedInventories.get(player));
        return inv;
    }

    private void addInventory(Player player){
        savedInventories.put(player,player.getInventory().getContents());
    }

    private static ConcurrentHashMap<Player,Boolean> modeStatus = new ConcurrentHashMap<>();

    public static boolean getStatus(Player player){
        return modeStatus.get(player);
    }
    public static void setTrue(Player player){
        modeStatus.put(player,true);
    }

    public static void setFalse(Player player){
        modeStatus.put(player,false);
    }
//Command Path
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("This command can execute ONLY players.");
            return true;
        }
        if(command.getName().equalsIgnoreCase("adminmode")){
            Player player = (Player) sender;
            if(args.length < 1){return false;}
            if(!player.hasPermission("SUAT.adminmode") && !player.isOp()){return true;}

            if(Objects.equals(args[0], "on")){
                if(getStatus(player)){
                    player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы уже активировали режим администратора.");
                    return true;
                }
                setTrue(player);
                addInventory(player);
                player.getInventory().clear();
                player.getInventory().setContents(adminCollection());
                Bukkit.dispatchCommand(player,"gamemode creative");
                player.sendMessage(ChatColor.GRAY+"[Система]"+ChatColor.WHITE+"Режим администратора включен.");
                //Timer Path
                AdministratorProperties.setStartTime(player.getUniqueId());
                AdministratorProperties.setDefaultEndTime(player.getUniqueId());
                AdministratorProperties.setAdmin(player.getUniqueId());
                //Место под предметы
            }
            if(Objects.equals(args[0], "off")){
                if(!getStatus(player)){
                    player.sendMessage(ChatColor.GRAY+"[Система] "+ChatColor.WHITE+"Вы уже отключили режим администратора.");
                    return true;
                }
                setFalse(player);
                player.getInventory().clear();
                player.getInventory().setContents(returnInventory(player));
                player.openInventory(choiceYourMode(player));
                player.sendMessage(ChatColor.GRAY+"[Система]"+ChatColor.WHITE+"Режим администратора выключен.");
                //Timer Path
                AdministratorProperties.setEndTime(player.getUniqueId());
                AdministratorProperties.setSession(player.getUniqueId());
                AdministratorProperties.setDefaultStartTime(player.getUniqueId());
            }
        }
        return true;
    }
}

package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.PlayerReputation;
import com.aviloo.mytraderreloaded.Seller.Utils.PriceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ReputationProductInventory {

    private static FileConfiguration settingsConfig =
            MyTraderReloaded.getPlugin().sellerSettingsFileManager.getSettingsSellerConfig();

    private static void ReputationItemRedactor(Inventory inv,Player player,Integer NeedRep,ItemStack item,
        Material material, String name,Integer index,String ... lore){
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> LoreList = new ArrayList<>();
        if(MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
            if (PlayerReputation.getReputation(player) < NeedRep) {
                meta.setDisplayName(ChatColor.WHITE + "Недоступно");
                LoreList.add(ChatColor.translateAlternateColorCodes('&', " "));
                LoreList.add(ChatColor.translateAlternateColorCodes('&',
                        "&7Товар разблокируется, когда у вас будет - &b" + NeedRep));
                LoreList.add(ChatColor.translateAlternateColorCodes('&', "&7очков репутации."));
                LoreList.add(ChatColor.translateAlternateColorCodes('&', "&7У вас сейчас - &f" +
                        PlayerReputation.getReputation(player) + " &7очков."));
                LoreList.add(" ");
            }
            if (PlayerReputation.getReputation(player) >= NeedRep) {
                item.setType(material);
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
                for (String str : lore) {
                    LoreList.add(ChatColor.translateAlternateColorCodes('&', str));
                }
            }
        }
        if(!MyTraderReloaded.getPlugin().getConfig().getBoolean("useSQL")) {
            if (PlayerReputation.getReputationFromUsermap(player) < NeedRep) {
                meta.setDisplayName(ChatColor.WHITE + "Недоступно");
                LoreList.add(ChatColor.translateAlternateColorCodes('&', " "));
                LoreList.add(ChatColor.translateAlternateColorCodes('&',
                        "&7Товар разблокируется, когда у вас будет - &b" + NeedRep));
                LoreList.add(ChatColor.translateAlternateColorCodes('&', "&7очков репутации."));
                LoreList.add(ChatColor.translateAlternateColorCodes('&', "&7У вас сейчас - &f" +
                        PlayerReputation.getReputationFromUsermap(player) + " &7очков."));
                LoreList.add(" ");
            }
            if (PlayerReputation.getReputationFromUsermap(player) >= NeedRep) {
                item.setType(material);
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
                for (String str : lore) {
                    LoreList.add(ChatColor.translateAlternateColorCodes('&', str));
                }
            }
        }

        LoreList.add(" ");
        meta.setLore(LoreList);
        item.setItemMeta(meta);
        inv.setItem(index,item);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.WHITE+"Товары за репутацию");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(39,back);

        ItemStack info = new ItemStack(Material.KNOWLEDGE_BOOK,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.GRAY+"< Нажмите, чтобы узнать подробнее. >");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);
        inv.setItem(41,info);

        ItemStack first = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player, PriceManager.getNeedReputation("LAPIS_LAZULI_R"),
                first,Material.LAPIS_LAZULI,"&fЛазурит",
                12,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("LAPIS_LAZULI_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("LAPIS_LAZULI_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        ItemStack second = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("BONE_R"),
                second,Material.BONE,"&fКости",
                13,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("BONE_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("BONE_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        ItemStack third = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("BAKED_POTATO_R"),
                third,Material.BAKED_POTATO,"&fЖаренный картофель",
                14,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("BAKED_POTATO_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("BAKED_POTATO_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        ItemStack fourth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("CACTUS_R"),
                fourth,Material.CACTUS,"&fКактус",
                21,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("CACTUS_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("CACTUS_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        ItemStack fifth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("SUGAR_CANE_R"),
                fifth,Material.SUGAR_CANE,"&fТростник",
                22,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("SUGAR_CANE_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("SUGAR_CANE_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        ItemStack sixth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("GUNPOWDER_R"),
                sixth,Material.GUNPOWDER,"&fПорох",
                23,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("GUNPOWDER_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("GUNPOWDER_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ",
                "&7Чтобы продать всё, кликните и зажмите Shift");

        return inv;
    }
}

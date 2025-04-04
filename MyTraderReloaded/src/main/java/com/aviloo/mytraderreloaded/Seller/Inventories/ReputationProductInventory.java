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
        Inventory inv = Bukkit.createInventory(player,45, ChatColor.GRAY+"Товары за репутацию");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(39,back);

        ItemStack info = new ItemStack(Material.PAPER,1);
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
        ReputationItemRedactor(inv,player, PriceManager.getNeedReputation("GOLD_NUGGET_R"),
                first,Material.GOLD_NUGGET,"&fЗолотой слиток",
                12,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("GOLD_NUGGET_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("GOLD_NUGGET_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        ItemStack second = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("WHEAT_R"),
                second,Material.WHEAT,"&fПшеница",
                13,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("WHEAT_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("WHEAT_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        ItemStack third = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("LAPIS_LAZULI_R"),
                third,Material.LAPIS_LAZULI,"&fЛазурит",
                14,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("LAPIS_LAZULI_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("LAPIS_LAZULI_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        ItemStack fourth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("TOTEM_OF_UNDYING_R"),
                fourth,Material.TOTEM_OF_UNDYING,"&fТотем",
                21,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("TOTEM_OF_UNDYING_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("TOTEM_OF_UNDYING_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        ItemStack fifth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("CAKE_R"),
                fifth,Material.CAKE,"&fТорт",
                22,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("CAKE_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("CAKE_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        ItemStack sixth = new ItemStack(Material.BARRIER,1);
        ReputationItemRedactor(inv,player,PriceManager.getNeedReputation("DIAMOND_ORE_R"),
                sixth,Material.DIAMOND_ORE,"&fАлмазная руда",
                23,"&eЦена за 1 штуку - "+PriceManager.getPriceReputation("DIAMOND_ORE_R"),
                "&eЦена за 64 штуки - "+PriceManager.getPriceReputation64("DIAMOND_ORE_R"),
                " ",
                "&7Чтобы продать 1 ед. , нажмите ПКМ",
                "&7Чтобы продать 64 ед. , нажмите ЛКМ");

        return inv;
    }
}

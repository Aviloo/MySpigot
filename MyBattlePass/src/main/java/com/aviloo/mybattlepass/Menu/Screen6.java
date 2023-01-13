package com.aviloo.mybattlepass.Menu;

import com.aviloo.mybattlepass.Utils.BPExp;
import com.aviloo.mybattlepass.Utils.BPLevel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Screen6 {
    public static Inventory inv(Player player){
        Inventory inv = Bukkit.createInventory(player,45,"Боевой пропуск (У вас 5 уровень)");

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack lvl6 = new ItemStack(Material.GOLD_BLOCK, 1);
        if(BPExp.getExp(player) < 1000) {
            lvl6.setType(Material.GOLD_BLOCK);
            ItemMeta lvl6meta = lvl6.getItemMeta();
            lvl6meta.setDisplayName(ChatColor.YELLOW + "Уровень 6");
            ArrayList<String> lore6 = new ArrayList<>();
            lore6.add(" ");
            lore6.add(ChatColor.GRAY+"Необходимо 1000 единиц опыта.");
            lore6.add(ChatColor.GRAY+"Не хватает " + ChatColor.BLUE + BPExp.getLack(player,1000));
            lore6.add(ChatColor.GRAY+"У вас сейчас " +ChatColor.LIGHT_PURPLE+ BPExp.getExp(player) +ChatColor.GRAY+" очков опыта.");
            lore6.add(" ");
            lore6.add(ChatColor.YELLOW+"Вы получите:");
            lore6.add(ChatColor.WHITE+"-"+ChatColor.LIGHT_PURPLE+" 50 Коинов");
            lore6.add(ChatColor.WHITE+"- 23 Алмаза");
            lore6.add(ChatColor.WHITE+"- 3 Слитка незерита");
            lvl6meta.setLore(lore6);
            lvl6.setItemMeta(lvl6meta);
        }
        if(BPExp.getExp(player) >= 1000){
            lvl6.setType(Material.EMERALD_BLOCK);
            ItemMeta lvl6meta = lvl6.getItemMeta();
            lvl6meta.setDisplayName(ChatColor.YELLOW + "Уровень 6");
            ArrayList<String> lore6 = new ArrayList<>();
            lore6.add(" ");
            lore6.add(ChatColor.GRAY+"Можно получить награду.");
            lore6.add(" ");
            lore6.add(ChatColor.YELLOW+"Вы получите:");
            lore6.add(ChatColor.WHITE+"-"+ChatColor.LIGHT_PURPLE+" 50 Коинов");
            lore6.add(ChatColor.WHITE+"- 23 Алмаза");
            lore6.add(ChatColor.WHITE+"- 3 Слитка незерита");
            lvl6meta.setLore(lore6);
            lvl6.setItemMeta(lvl6meta);
        }


        ItemStack lvl2 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl2meta = lvl2.getItemMeta();
        lvl2meta.setDisplayName(ChatColor.YELLOW + "Уровень 2");
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(" ");
        lore2.add(ChatColor.WHITE+"Вы уже выполнили это задание.");
        lvl2meta.setLore(lore2);
        lvl2.setItemMeta(lvl2meta);

        ItemStack lvl3 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl3meta = lvl3.getItemMeta();
        lvl3meta.setDisplayName(ChatColor.YELLOW + "Уровень 3");
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add(" ");
        lore3.add(ChatColor.WHITE+"Вы уже выполнили это задание.");
        lvl3meta.setLore(lore3);
        lvl3.setItemMeta(lvl3meta);

        ItemStack lvl4 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl4meta = lvl4.getItemMeta();
        lvl4meta.setDisplayName(ChatColor.YELLOW + "Уровень 4");
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add(" ");
        lore4.add(ChatColor.WHITE+"Вы уже выполнили это задание.");
        lvl4meta.setLore(lore4);
        lvl4.setItemMeta(lvl4meta);

        ItemStack lvl1 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl1meta = lvl1.getItemMeta();
        lvl1meta.setDisplayName(ChatColor.YELLOW + "Уровень 1");
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(" ");
        lore1.add(ChatColor.WHITE+"Вы уже выполнили это задание.");
        lvl1meta.setLore(lore1);
        lvl1.setItemMeta(lvl1meta);

        ItemStack lvl5 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl5meta = lvl5.getItemMeta();
        lvl5meta.setDisplayName(ChatColor.YELLOW + "Уровень 5");
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add(" ");
        lore5.add(ChatColor.WHITE+"Вы уже выполнили это задание.");
        lvl5meta.setLore(lore5);
        lvl5.setItemMeta(lvl5meta);

        ItemStack lvl7 = new ItemStack(Material.COAL_BLOCK,1);
        ItemMeta lvl7meta = lvl7.getItemMeta();
        lvl7meta.setDisplayName(ChatColor.YELLOW + "Уровень 7");
        ArrayList<String> lore7 = new ArrayList<>();
        lore7.add(" ");
        lore7.add(ChatColor.WHITE+"Чтобы получить доступ,");
        lore7.add(ChatColor.WHITE+"выполните предыдущее задание.");
        lvl7meta.setLore(lore7);
        lvl7.setItemMeta(lvl7meta);

        //Для топ игрока
        ItemStack top = new ItemStack(Material.PLAYER_HEAD,1);
        SkullMeta SkullMeta = (org.bukkit.inventory.meta.SkullMeta) top.getItemMeta();
        SkullMeta.setOwningPlayer(BPExp.getPlayerProfile());
        SkullMeta.setDisplayName(ChatColor.WHITE+"Лидер боевого пропуска");
        ArrayList<String> TopList = new ArrayList<>();
        TopList.add(" ");
        TopList.add(ChatColor.GRAY+"Имя: " +ChatColor.AQUA+ BPExp.getLeaderName());
        TopList.add(ChatColor.GRAY+"Уровень пропуска: "+ChatColor.AQUA+BPExp.getLeaderLevel());
        TopList.add(ChatColor.GRAY+"Очки опыта: " + ChatColor.AQUA+BPExp.getLeaderStats());
        TopList.add(" ");
        SkullMeta.setLore(TopList);
        top.setItemMeta(SkullMeta);
        //todo Добавить получение данных из бд о лучшем игроке
        //todo или попытаться сделать через хэшмапу

        //Донат уровни
        ItemStack lvl8 = new ItemStack(Material.IRON_BARS,1);
        if(player.hasPermission("BattlePass.8lvl")) {
            lvl8.setType(Material.COAL_BLOCK);
            ItemMeta lvl8meta = lvl8.getItemMeta();
            lvl8meta.setDisplayName(ChatColor.YELLOW + "Уровень 8");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add(" ");
            lore8.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore8.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl8meta.setLore(lore8);
            lvl8.setItemMeta(lvl8meta);
        }
        if(player.isOp()){
            lvl8.setType(Material.COAL_BLOCK);
            ItemMeta lvl8meta = lvl8.getItemMeta();
            lvl8meta.setDisplayName(ChatColor.YELLOW+"Уровень 8");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add(" ");
            lore8.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore8.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl8meta.setLore(lore8);
            lvl8.setItemMeta(lvl8meta);
        }
        if(!player.hasPermission("BattlePass.8lvl")){
            lvl8.setType(Material.IRON_BARS);
            ItemMeta lvl8meta = lvl8.getItemMeta();
            lvl8meta.setDisplayName(ChatColor.WHITE+"Недоступно");
            ArrayList<String> lore8 = new ArrayList<>();
            lore8.add(" ");
            lore8.add(ChatColor.YELLOW+"Данный уровень доступен только ");
            lore8.add(ChatColor.YELLOW+"игрокам имеющим статус - " +ChatColor.AQUA+"Riot");
            lore8.add(" ");
            lvl8meta.setLore(lore8);
            lvl8.setItemMeta(lvl8meta);
        }

        ItemStack lvl9 = new ItemStack(Material.IRON_BARS,1);
        if(player.hasPermission("BattlePass.9lvl")) {
            lvl9.setType(Material.COAL_BLOCK);
            ItemMeta lvl9meta = lvl9.getItemMeta();
            lvl9meta.setDisplayName(ChatColor.YELLOW + "Уровень 9");
            ArrayList<String> lore9 = new ArrayList<>();
            lore9.add(" ");
            lore9.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore9.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl9meta.setLore(lore9);
            lvl9.setItemMeta(lvl9meta);
        }
        if(player.isOp()){
            lvl9.setType(Material.COAL_BLOCK);
            ItemMeta lvl9meta = lvl9.getItemMeta();
            lvl9meta.setDisplayName(ChatColor.YELLOW+"Уровень 9");
            ArrayList<String> lore9 = new ArrayList<>();
            lore9.add(" ");
            lore9.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore9.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl9meta.setLore(lore9);
            lvl9.setItemMeta(lvl9meta);
        }
        if(!player.hasPermission("BattlePass.9lvl")){
            lvl9.setType(Material.IRON_BARS);
            ItemMeta lvl9meta = lvl9.getItemMeta();
            lvl9meta.setDisplayName(ChatColor.WHITE+"Недоступно");
            ArrayList<String> lore9 = new ArrayList<>();
            lore9.add(" ");
            lore9.add(ChatColor.YELLOW+"Данный уровень доступен только ");
            lore9.add(ChatColor.YELLOW+"игрокам имеющим статус - " +ChatColor.AQUA+"Miracle");
            lore9.add(" ");
            lvl9meta.setLore(lore9);
            lvl9.setItemMeta(lvl9meta);
        }

        ItemStack lvl10 = new ItemStack(Material.IRON_BARS,1);
        if(player.hasPermission("BattlePass.10lvl")) {
            lvl10.setType(Material.COAL_BLOCK);
            ItemMeta lvl10meta = lvl10.getItemMeta();
            lvl10meta.setDisplayName(ChatColor.YELLOW + "Уровень 10");
            ArrayList<String> lore10 = new ArrayList<>();
            lore10.add(" ");
            lore10.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore10.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl10meta.setLore(lore10);
            lvl10.setItemMeta(lvl10meta);
        }
        if(player.isOp()){
            lvl10.setType(Material.COAL_BLOCK);
            ItemMeta lvl10meta = lvl10.getItemMeta();
            lvl10meta.setDisplayName(ChatColor.YELLOW+"Уровень 10");
            ArrayList<String> lore10 = new ArrayList<>();
            lore10.add(" ");
            lore10.add(ChatColor.WHITE+"Чтобы получить доступ,");
            lore10.add(ChatColor.WHITE+"выполните предыдущее задание.");
            lvl10meta.setLore(lore10);
            lvl10.setItemMeta(lvl10meta);
        }
        if(!player.hasPermission("BattlePass.10lvl")){
            lvl10.setType(Material.IRON_BARS);
            ItemMeta lvl10meta = lvl10.getItemMeta();
            lvl10meta.setDisplayName(ChatColor.WHITE+"Недоступно");
            ArrayList<String> lore10 = new ArrayList<>();
            lore10.add(" ");
            lore10.add(ChatColor.YELLOW+"Данный уровень доступен только ");
            lore10.add(ChatColor.YELLOW+"игрокам имеющим статус - " +ChatColor.AQUA+"Сhaos");
            lore10.add(" ");
            lvl10meta.setLore(lore10);
            lvl10.setItemMeta(lvl10meta);
        }

        ItemStack quit = new ItemStack(Material.BARRIER,1);
        ItemMeta QuitMeta = quit.getItemMeta();
        QuitMeta.setDisplayName(ChatColor.RED+"Закрыть");
        ArrayList<String> QuitLore = new ArrayList<>();
        QuitLore.add(" ");
        QuitLore.add(ChatColor.WHITE+"Нажмите ЛКМ ,чтобы");
        QuitLore.add(ChatColor.WHITE+"закрыть из меню.");
        QuitLore.add(ChatColor.WHITE+"Нажмите ПКМ ,чтобы");
        QuitLore.add(ChatColor.WHITE+"вернуться в меню сервера.");
        QuitLore.add(" ");
        QuitMeta.setLore(QuitLore);
        quit.setItemMeta(QuitMeta);

        ItemStack[] inv_stack = {air,air,air,air,top,air,air,air,air,
                air,air,air,air,air,air,air,air,air,
                air,lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,air,
                air,air,air,lvl8,lvl9,lvl10,air,air,air,
                air,air,air,air,air,air,air,air,quit};

        inv.setContents(inv_stack);
        return inv;
    }
}

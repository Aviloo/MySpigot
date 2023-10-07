package com.aviloo.myscoreboard.Inventories;

import com.aviloo.myscoreboard.models.PlayerTags;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class StatisticInventory {

    public static void getSlotsLore(Player player,ArrayList<String> lore){
        lore.add(" ");
        lore.add(StatisticInteract.getSlotName(1,player));
        lore.add(StatisticInteract.getSlotName(2,player));
        lore.add(StatisticInteract.getSlotName(3,player));
        lore.add(" ");
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,54, ChatColor.WHITE+"Статистика");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(bMeta);
        inv.setItem(45,back);

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta cMeta = close.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED+"Закрыть");
        close.setItemMeta(cMeta);
        inv.setItem(53,close);

        ItemStack reset = new ItemStack(Material.STRUCTURE_VOID,1);
        ItemMeta rMeta = reset.getItemMeta();
        rMeta.setDisplayName(ChatColor.YELLOW+"Сбросить");
        ArrayList<String> rLore = new ArrayList<>();
        rLore.add(" ");
        rLore.add(ChatColor.GRAY+"Сбрасывает выбранные слоты");
        rLore.add(ChatColor.GRAY+"к стандартным.");
        rLore.add(" ");
        rMeta.setLore(rLore);
        reset.setItemMeta(rMeta);
        inv.setItem(49,reset);

        ItemStack sorting = new ItemStack(Material.TRAPPED_CHEST,1);
        ItemMeta sortMeta = sorting.getItemMeta();
        sortMeta.setDisplayName(ChatColor.YELLOW+"Сортировать");
        ArrayList<String> sortLore = new ArrayList<>();
        sortLore.add(" ");
        sortLore.add(ChatColor.GRAY+"Разделите тэги по группам.");
        sortLore.add(" ");
        sortMeta.setLore(sortLore);
        sorting.setItemMeta(sortMeta);
        inv.setItem(50,sorting);

        ItemStack info = new ItemStack(Material.PAPER,1);
        ItemMeta iMeta = info.getItemMeta();
        iMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> iLore = new ArrayList<>();
        iLore.add(" ");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Здесь можно редактировать");
        iLore.add(ChatColor.WHITE+"тэги в блоке статистики.");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Кнопка «Сортировать» - позволяет");
        iLore.add(ChatColor.WHITE+"разделить тэги по группам.");
        iLore.add(ChatColor.GREEN+"➤"+ChatColor.WHITE+" Кнопка «Сбросить» - сбрасывает");
        iLore.add(ChatColor.WHITE+"выбранные ранее тэги.");
        iLore.add(" ");
        iMeta.setLore(iLore);
        info.setItemMeta(iMeta);
        inv.setItem(48,info);

        ItemStack kills = new ItemStack(Material.CONDUIT,1);
        ItemMeta kMeta = kills.getItemMeta();
        kMeta.setDisplayName(ChatColor.DARK_AQUA+"Убийства");
        ArrayList<String> kLore = new ArrayList<>();
        kLore.add(" ");
        kLore.add(ChatColor.GRAY+"Отображает кол-во ваших убийств.");
        kLore.add(" ");
        kLore.add(ChatColor.GRAY+"Тип: Статистика");
        kLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        getSlotsLore(player,kLore);
        kMeta.setLore(kLore);
        kills.setItemMeta(kMeta);
        inv.setItem(11,kills);

        ItemStack deaths = new ItemStack(Material.CONDUIT,2);
        ItemMeta dMeta = deaths.getItemMeta();
        dMeta.setDisplayName(ChatColor.DARK_AQUA+"Смертей");
        ArrayList<String> dLore = new ArrayList<>();
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Отображает кол-во ваших смертей.");
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Тип: Статистика");
        dLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        getSlotsLore(player,dLore);
        dMeta.setLore(dLore);
        deaths.setItemMeta(dMeta);
        inv.setItem(12,deaths);

        ItemStack hours = new ItemStack(Material.CONDUIT,3);
        ItemMeta hMeta = hours.getItemMeta();
        hMeta.setDisplayName(ChatColor.DARK_AQUA+"Отыграно");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Отображает кол-во часов в игре.");
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Тип: Статистика");
        hLore.add(ChatColor.YELLOW+"Стоимость: "+ChatColor.DARK_GRAY+"Отсутствует.");
        getSlotsLore(player,hLore);
        hMeta.setLore(hLore);
        hours.setItemMeta(hMeta);
        inv.setItem(13,hours);

        ItemStack ping = new ItemStack(Material.CONDUIT,4);
        ItemMeta pMeta = ping.getItemMeta();
        pMeta.setDisplayName(ChatColor.DARK_AQUA+"Пинг");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(" ");
        pLore.add(ChatColor.GRAY+"Отображает ваш пинг.");
        pLore.add(" ");
        pLore.add(ChatColor.GRAY+"Тип: Прочее");
        pLore.add(getPriceLore(player,"ping"));
        getSlotsLore(player,pLore);
        pMeta.setLore(pLore);
        ping.setItemMeta(pMeta);
        inv.setItem(14,ping);

        ItemStack mobs_killed = new ItemStack(Material.CONDUIT,5);
        ItemMeta mkMeta = mobs_killed.getItemMeta();
        mkMeta.setDisplayName(ChatColor.DARK_AQUA+"Мобов Убито");
        ArrayList<String> mkLore = new ArrayList<>();
        mkLore.add(" ");
        mkLore.add(ChatColor.GRAY+"Отображает кол-во убитых вами мобов.");
        mkLore.add(" ");
        mkLore.add(ChatColor.GRAY+"Тип: Статистика");
        mkLore.add(getPriceLore(player,"mobs_killed"));
        getSlotsLore(player,mkLore);
        mkMeta.setLore(mkLore);
        mobs_killed.setItemMeta(mkMeta);
        inv.setItem(15,mobs_killed);

        ItemStack blocks_break = new ItemStack(Material.CONDUIT,6);
        ItemMeta bbMeta = blocks_break.getItemMeta();
        bbMeta.setDisplayName(ChatColor.DARK_AQUA+"Блоков Сломано");
        ArrayList<String> bbLore = new ArrayList<>();
        bbLore.add(" ");
        bbLore.add(ChatColor.GRAY+"Отображает кол-во сломанных блоков.");
        bbLore.add(" ");
        bbLore.add(ChatColor.GRAY+"Тип: Статистика");
        bbLore.add(getPriceLore(player,"blocks_break"));
        getSlotsLore(player,bbLore);
        bbMeta.setLore(bbLore);
        blocks_break.setItemMeta(bbMeta);
        inv.setItem(20,blocks_break);

        ItemStack coords = new ItemStack(Material.CONDUIT,7);
        ItemMeta cnMeta = coords.getItemMeta();
        cnMeta.setDisplayName(ChatColor.DARK_AQUA+"Координаты");
        ArrayList<String> cnLore = new ArrayList<>();
        cnLore.add(" ");
        cnLore.add(ChatColor.GRAY+"Отображает ваши координаты.");
        cnLore.add(" ");
        cnLore.add(ChatColor.GRAY+"Тип: Прочее");
        cnLore.add(getPriceLore(player,"coords"));
        getSlotsLore(player,cnLore);
        cnMeta.setLore(cnLore);
        coords.setItemMeta(cnMeta);
        inv.setItem(21,coords);

        ItemStack kd = new ItemStack(Material.CONDUIT,8);
        ItemMeta kdMeta = kd.getItemMeta();
        kdMeta.setDisplayName(ChatColor.DARK_AQUA+"KD");
        ArrayList<String> kdLore = new ArrayList<>();
        kdLore.add(" ");
        kdLore.add(ChatColor.GRAY+"Отображает соотношение убийств к смертям.");
        kdLore.add(" ");
        kdLore.add(ChatColor.GRAY+"Тип: Статистика");
        kdLore.add(getPriceLore(player,"kills_deaths"));
        getSlotsLore(player,kdLore);
        kdMeta.setLore(kdLore);
        kd.setItemMeta(kdMeta);
        inv.setItem(22,kd);

        ItemStack hand_durability = new ItemStack(Material.CONDUIT,9);
        ItemMeta hdMeta = hand_durability.getItemMeta();
        hdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность предмета в руке");
        ArrayList<String> hdLore = new ArrayList<>();
        hdLore.add(" ");
        hdLore.add(ChatColor.GRAY+"Отображает прочность предмета в вашей руке.");
        hdLore.add(" ");
        hdLore.add(ChatColor.GRAY+"Тип: ПВП");
        hdLore.add(getPriceLore(player,"hand_durability"));
        getSlotsLore(player,hdLore);
        hdMeta.setLore(hdLore);
        hand_durability.setItemMeta(hdMeta);
        inv.setItem(23,hand_durability);

        ItemStack totem_count = new ItemStack(Material.CONDUIT,10);
        ItemMeta tcMeta = totem_count.getItemMeta();
        tcMeta.setDisplayName(ChatColor.DARK_AQUA+"Количество тотемов");
        ArrayList<String> tcLore = new ArrayList<>();
        tcLore.add(" ");
        tcLore.add(ChatColor.GRAY+"Отображает кол-во тотемов в инвентаре.");
        tcLore.add(" ");
        tcLore.add(ChatColor.GRAY+"Тип: ПВП");
        tcLore.add(getPriceLore(player,"totem_count"));
        getSlotsLore(player,tcLore);
        tcMeta.setLore(tcLore);
        totem_count.setItemMeta(tcMeta);
        inv.setItem(24,totem_count);

        ItemStack helmet_durability = new ItemStack(Material.CONDUIT,11);
        ItemMeta hedMeta = helmet_durability.getItemMeta();
        hedMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность шлема");
        ArrayList<String> hedLore = new ArrayList<>();
        hedLore.add(" ");
        hedLore.add(ChatColor.GRAY+"Отображает прочность шлема.");
        hedLore.add(" ");
        hedLore.add(ChatColor.GRAY+"Тип: ПВП");
        hedLore.add(getPriceLore(player,"helmet_durability"));
        getSlotsLore(player,hedLore);
        hedMeta.setLore(hedLore);
        helmet_durability.setItemMeta(hedMeta);
        inv.setItem(29,helmet_durability);

        ItemStack chestplate_durability = new ItemStack(Material.CONDUIT,12);
        ItemMeta chdMeta = chestplate_durability.getItemMeta();
        chdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность нагрудника");
        ArrayList<String> chdLore = new ArrayList<>();
        chdLore.add(" ");
        chdLore.add(ChatColor.GRAY+"Отображает прочность нагрудника.");
        chdLore.add(" ");
        chdLore.add(ChatColor.GRAY+"Тип: ПВП");
        chdLore.add(getPriceLore(player,"chestplate_durability"));
        getSlotsLore(player,chdLore);
        chdMeta.setLore(chdLore);
        chestplate_durability.setItemMeta(chdMeta);
        inv.setItem(30,chestplate_durability);

        ItemStack leggings_durability = new ItemStack(Material.CONDUIT,13);
        ItemMeta ldMeta = leggings_durability.getItemMeta();
        ldMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность понож");
        ArrayList<String> ldLore = new ArrayList<>();
        ldLore.add(" ");
        ldLore.add(ChatColor.GRAY+"Отображает прочность понож.");
        ldLore.add(" ");
        ldLore.add(ChatColor.GRAY+"Тип: ПВП");
        ldLore.add(getPriceLore(player,"leggings_durability"));
        getSlotsLore(player,ldLore);
        ldMeta.setLore(ldLore);
        leggings_durability.setItemMeta(ldMeta);
        inv.setItem(31,leggings_durability);

        ItemStack boots_durability = new ItemStack(Material.CONDUIT,14);
        ItemMeta bdMeta = boots_durability.getItemMeta();
        bdMeta.setDisplayName(ChatColor.DARK_AQUA+"Прочность ботинок");
        ArrayList<String> bdLore = new ArrayList<>();
        bdLore.add(" ");
        bdLore.add(ChatColor.GRAY+"Отображает просность ботинок.");
        bdLore.add(" ");
        bdLore.add(ChatColor.GRAY+"Тип: ПВП");
        bdLore.add(getPriceLore(player,"boots_durability"));
        getSlotsLore(player,bdLore);
        bdMeta.setLore(bdLore);
        boots_durability.setItemMeta(bdMeta);
        inv.setItem(32,boots_durability);

        return inv;
    }

    public static String getPriceLore(Player player,String tag){
        if(Objects.equals(tag, "ping")){
            if(!PlayerTags.isPingTag()){
                return ChatColor.YELLOW+"Стоимость: 500 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "mobs_killed")){
            if(!PlayerTags.isMobs_killedTag()){
                return ChatColor.YELLOW+"Стоимость: 700 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "blocks_break")){
            if(!PlayerTags.isBlocks_breakTag()){
                return ChatColor.YELLOW+"Стоимость: 700 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "coords")){
            if(!PlayerTags.isCoordsTag()){
                return ChatColor.YELLOW+"Стоимость: 500 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "kills_deaths")){
            if(!PlayerTags.isKills_deathsTag()){
                return ChatColor.YELLOW+"Стоимость: 700 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "hand_durability")){
            if(!PlayerTags.isHand_durabilityTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "totem_count")){
            if(!PlayerTags.isTotem_countTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "helmet_durability")){
            if(!PlayerTags.isHelmet_durabilityTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "chestplate_durability")){
            if(!PlayerTags.isChestplate_durabilityTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "leggings_durability")){
            if(!PlayerTags.isLeggings_durabilityTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }
        if(Objects.equals(tag, "boots_durability")){
            if(!PlayerTags.isBoots_durabilityTag()){
                return ChatColor.YELLOW+"Стоимость: 900 монет.";
            }
            return ChatColor.YELLOW+"Стоимость: " + ChatColor.DARK_GRAY+"[Куплено]";
        }

        return "-";
    }

}

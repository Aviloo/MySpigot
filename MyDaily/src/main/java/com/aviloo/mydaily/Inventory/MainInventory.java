package com.aviloo.mydaily.Inventory;

import com.aviloo.mydaily.Quests.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainInventory {

    protected static void itemStackRedactor(@NotNull ItemStack item, String name,Boolean isComplete, String ... LoreLines){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+name);
        ArrayList<String> lore = new ArrayList<>();
        for(String str : LoreLines){
            lore.add(ChatColor.translateAlternateColorCodes('&',str));
        }
        if(!isComplete) {
            lore.add(ChatColor.WHITE + "Награды:");
            lore.add(ChatColor.GRAY + "- 150 Монет");
            lore.add(ChatColor.GRAY + "- 20 Боевого опыта");
            lore.add(" ");
        }
        if(isComplete){lore.add(" ");}
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public static Inventory getInv(Player player){
        Inventory inv = Bukkit.createInventory(player,36, ChatColor.WHITE+"Ежедневные задания");

        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW);
        itemStackRedactor(back,"Назад",true);
        inv.setItem(31,back);

        //Уголь
        ItemStack coal = new ItemStack(Material.COAL,1);
        itemStackRedactor(coal,"Угля мало не бывает...",false,
                " ",
                "&fВыкопайте 100 блоков угольной",
                "&fруды, чтобы получить награду.",
                "",
                "&7Прогресс: &b" + CoalQuest.getCoal(player) +"&f/100",
                "");
        ItemStack coalComplete = new ItemStack(Material.BARRIER,1);
        itemStackRedactor(coalComplete,"Выполнено",true," ");
        if(CoalQuest.isCoalQuestComplete(player)){
            inv.setItem(0,coalComplete);
        }
        if(!CoalQuest.isCoalQuestComplete(player)){
            inv.setItem(0,coal);
        }
        //Скелеты
        ItemStack skeleton = new ItemStack(Material.SKELETON_SKULL,1);
        itemStackRedactor(skeleton,"Кости, да кости",false,"",
                "&fУбейте 50 скелетов, чтобы",
                "&fполучить награду.",
                " ",
                "&7Прогресс: &b" + SkeletonQuest.getSkeleton(player) +"&f/50",
                " ");
        ItemStack skeletonComplete = new ItemStack(Material.BARRIER,2);
        itemStackRedactor(skeletonComplete,"Выполнено",true," ");
        if(SkeletonQuest.isSkeletonQuestComplete(player)){
            inv.setItem(1,skeletonComplete);
        }
        if(!SkeletonQuest.isSkeletonQuestComplete(player)){
            inv.setItem(1,skeleton);
        }
        //Камень
        ItemStack stone = new ItemStack(Material.STONE,1);
        itemStackRedactor(stone,"Каменный камень ?",false,
                " ",
                "&fВыкопайте 550 блоков камня,",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + StoneQuest.getStone(player) +"&f/550",
                "");
        ItemStack StoneComplete = new ItemStack(Material.BARRIER,3);
        itemStackRedactor(StoneComplete,"Выполнено",true," ");
        if(StoneQuest.isStoneQuestComplete(player)){
            inv.setItem(2,StoneComplete);
        }
        if(!StoneQuest.isStoneQuestComplete(player)){
            inv.setItem(2,stone);
        }
        //Золотые яблоки
        ItemStack golden = new ItemStack(Material.GOLDEN_APPLE,1);
        itemStackRedactor(golden,"Вкусно и дорого.",false,
                " ",
                "&fСъешьте 10 золотых яблок",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + GoldenAppleQuest.getGolden(player) +"&f/10",
                "");
        ItemStack GoldenComplete = new ItemStack(Material.BARRIER,4);
        itemStackRedactor(GoldenComplete,"Выполнено",true," ");
        if(GoldenAppleQuest.isGoldenQuestComplete(player)){
            inv.setItem(3,GoldenComplete);
        }
        if(!GoldenAppleQuest.isGoldenQuestComplete(player)){
            inv.setItem(3,golden);
        }
        /*
        //TNT
        ItemStack tnt = new ItemStack(Material.TNT,1);
        itemStackRedactor(tnt,"Взрыв - это бум...",false,
                " ",
                "&fПодожгите зажигалкой 5 TNT,",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + TNTQuest.getTNT(player) +"&f/5",
                "");
        ItemStack TNTComplete = new ItemStack(Material.BARRIER,5);
        itemStackRedactor(TNTComplete,"Выполнено",true," ");
        if(TNTQuest.isTNTQuestComplete(player)){
            inv.setItem(4,TNTComplete);
        }
        if(!TNTQuest.isTNTQuestComplete(player)){
            inv.setItem(4,tnt);
        }
         */
        //Убийств
        ItemStack players = new ItemStack(Material.PLAYER_HEAD,1);
        itemStackRedactor(players,"Имена павших.",false,
                " ",
                "&fУбейте 15 игроков",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + PlayerQuest.getPlayer(player) +"&f/15",
                "");
        ItemStack PlayerComplete = new ItemStack(Material.BARRIER,5);
        itemStackRedactor(PlayerComplete,"Выполнено",true," ");
        if(PlayerQuest.isPlayerQuestComplete(player)){
            inv.setItem(4,PlayerComplete);
        }
        if(!PlayerQuest.isPlayerQuestComplete(player)){
            inv.setItem(4,players);
        }
        //Кристалы
        /*
        ItemStack crystal = new ItemStack(Material.END_CRYSTAL,1);
        itemStackRedactor(crystal,"Взрыв - это бам...",false,
                " ",
                "&fСкрафтите 25 Кристалов Энда,",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + CrystalQuest.getCrystal(player) +"&f/25",
                "");
        ItemStack CrystalComplete = new ItemStack(Material.BARRIER,7);
        itemStackRedactor(CrystalComplete,"Выполнено",true," ");
        if(CrystalQuest.isCrystalQuestComplete(player)){
            inv.setItem(6,CrystalComplete);
        }
        if(!CrystalQuest.isCrystalQuestComplete(player)){
            inv.setItem(6,crystal);
        }
         */
        //Аксолотли
        ItemStack axolotl = new ItemStack(Material.AXOLOTL_BUCKET,1);
        itemStackRedactor(axolotl,"Ни рыба, ни мясо.",false,
                " ",
                "&fПоймайте 15 аксолотлей в ведро",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + AxolotlQuest.getAxolotl(player) +"&f/15",
                "");
        ItemStack AxolotlComplete = new ItemStack(Material.BARRIER,6);
        itemStackRedactor(AxolotlComplete,"Выполнено",true," ");
        if(AxolotlQuest.isAxolotlQuestComplete(player)){
            inv.setItem(5,AxolotlComplete);
        }
        if(!AxolotlQuest.isAxolotlQuestComplete(player)){
            inv.setItem(5,axolotl);
        }
        //Обсидиан
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN,1);
        itemStackRedactor(obsidian,"Как же это долго.",false,
                " ",
                "&fСломайте 40 блоков обсидиана,",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + ObsidianQuest.getObsidian(player) +"&f/40",
                "");
        ItemStack ObsidianComplete = new ItemStack(Material.BARRIER,7);
        itemStackRedactor(ObsidianComplete,"Выполнено",true," ");
        if(ObsidianQuest.isObsidianQuestComplete(player)){
            inv.setItem(6,ObsidianComplete);
        }
        if(!ObsidianQuest.isObsidianQuestComplete(player)){
            inv.setItem(6,obsidian);
        }
        //Тростник
        ItemStack cane = new ItemStack(Material.SUGAR_CANE,1);
        itemStackRedactor(cane,"Сахар, сахарочек.",false,
                " ",
                "&fПоставьте 84 блока тростника",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + CaneQuest.getCane(player) +"&f/84",
                "");
        ItemStack CaneComplete = new ItemStack(Material.BARRIER,8);
        itemStackRedactor(CaneComplete,"Выполнено",true," ");
        if(CaneQuest.isCaneQuestComplete(player)){
            inv.setItem(7,CaneComplete);
        }
        if(!CaneQuest.isCaneQuestComplete(player)){
            inv.setItem(7,cane);
        }
        //Визер
        ItemStack wither = new ItemStack(Material.WITHER_SKELETON_SKULL,1);
        itemStackRedactor(wither,"Три головы - лучше чем одна.",false,
                " ",
                "&fУбейте 3-х иссушителей,",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + WitherQuest.getWither(player) +"&f/4",
                "");
        ItemStack WitherComplete = new ItemStack(Material.BARRIER,9);
        itemStackRedactor(WitherComplete,"Выполнено",true," ");
        if(WitherQuest.isWitherQuestComplete(player)){
            inv.setItem(8,WitherComplete);
        }
        if(!WitherQuest.isWitherQuestComplete(player)){
            inv.setItem(8,wither);
        }
        //Дуб
        ItemStack oak = new ItemStack(Material.OAK_LOG,1);
        itemStackRedactor(oak,"Просто дуб",false,
                " ",
                "&fСломайте 150 блоков дуба",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + OakQuest.getOak(player) +"&f/150",
                "");
        ItemStack OakComplete = new ItemStack(Material.BARRIER,10);
        itemStackRedactor(OakComplete,"Выполнено",true," ");
        if(OakQuest.isOakQuestComplete(player)){
            inv.setItem(9,OakComplete);
        }
        if(!OakQuest.isOakQuestComplete(player)){
            inv.setItem(9,oak);
        }
        //Мотыга
        ItemStack hoe = new ItemStack(Material.IRON_HOE,1);
        itemStackRedactor(hoe,"Серьезно?",false,
                " ",
                "&fСломайте две мотыги,",
                "&fчтобы получить награду.",
                "&7(P.S:Мотыга должна быть железная",
                "&7или выше)",
                "",
                "&7Прогресс: &b" + HoeQuest.getHoe(player) +"&f/2",
                "");
        ItemStack HoeComplete = new ItemStack(Material.BARRIER,11);
        itemStackRedactor(HoeComplete,"Выполнено",true," ");
        if(HoeQuest.isHoeQuestComplete(player)){
            inv.setItem(10,HoeComplete);
        }
        if(!HoeQuest.isHoeQuestComplete(player)){
            inv.setItem(10,hoe);
        }
        //Locale
        ItemStack locale = new ItemStack(Material.MAP,1);
        itemStackRedactor(locale,"おるみい",false,
                " ",
                "&fПоиграйте на японском языке",
                "&f30 минут,",
                "&fчтобы получить награду.",
                "&7(P.S:Если вы выйдете с сервера",
                "&7или измените язык игры , то ",
                "&7таймер обнулиться.)",
                "",
                "&7Прогресс: &b0" +"&f/1",
                "");
        ItemStack LocaleComplete = new ItemStack(Material.BARRIER,12);
        itemStackRedactor(LocaleComplete,"Выполнено",true," ");
        if(LocaleQuest.isLocaleQuestComplete(player)){
            inv.setItem(11,LocaleComplete);
        }
        if(!LocaleQuest.isLocaleQuestComplete(player)){
            inv.setItem(11,locale);
        }
        //Дуб
        ItemStack sheep = new ItemStack(Material.WHITE_WOOL,1);
        itemStackRedactor(sheep,"Одна овечка. Две овечки...",false,
                " ",
                "&fПодстригите 35 овечек",
                "&fчтобы получить награду.",
                "",
                "&7Прогресс: &b" + SheepQuest.getSheep(player) +"&f/35",
                "");
        ItemStack SheepComplete = new ItemStack(Material.BARRIER,13);
        itemStackRedactor(SheepComplete,"Выполнено",true," ");
        if(SheepQuest.isSheepQuestComplete(player)){
            inv.setItem(12,SheepComplete);
        }
        if(!SheepQuest.isSheepQuestComplete(player)){
            inv.setItem(12,sheep);
        }

        return inv;
    }

}

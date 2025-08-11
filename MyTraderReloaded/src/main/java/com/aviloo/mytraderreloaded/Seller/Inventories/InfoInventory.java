package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InfoInventory implements Listener {

    private static int reward = MyTraderReloaded.getPlugin().reward;
    private static int hours = MyTraderReloaded.getPlugin().hours;
    private static int minutes = MyTraderReloaded.getPlugin().minutes;

    public static Inventory inventory = Bukkit.createInventory(null,54,
            ChatColor.WHITE+"Информация о скупщике");


    public static void setupInfoInventory(){
        setupButtons();
        setupInfo();
    }

    private static void setupButtons(){
        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(backMeta);
        inventory.setItem(48,back);

        ItemStack close = new ItemStack(Material.BARRIER,1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED+"Закрыть");
        close.setItemMeta(closeMeta);
        inventory.setItem(50,close);
    }

    private static void setupInfo(){
        ItemStack info = new ItemStack(Material.BOOK,1);
        ItemMeta iMeta = info.getItemMeta();
        iMeta.setDisplayName(" ");
        ArrayList<String> iLore = new ArrayList<>();
        setLore(iLore,"&fВ данном разделе мы постарались раскрыть",
                "&fосновные темы относительно работы скупщика.",
                "&fВ большенстве разделов, мы отвечаем на вопросы",
                "&fв формате FAQ.",
                "",
                "&7Если вас интересут информация не вощедшая в этот раздел",
                "&7или вы обнаружили ошибки, неточности просим вас",
                "&7связаться с нами. (/links)");
        iMeta.setLore(iLore);
        info.setItemMeta(iMeta);
        inventory.setItem(13,info);

        ItemStack first = new ItemStack(Material.PAPER,1);
        ItemMeta firstMeta = first.getItemMeta();
        firstMeta.setDisplayName(ChatColor.YELLOW+"Изменение цен.");
        ArrayList<String> firstLore = new ArrayList<>();
        setLore(firstLore,"&aПадение цен на товар:",
                "&fПадение цен зависит от кол-ва проданных",
                "&fе.д товара на всем сервере.",
                "&fИными словами, если товар часто продают,",
                "&fзначит цена на него упадет.",
                "&aБлокировка товара:",
                "&fЕсли цена на товар падала несколько раз,",
                "&fто товар будет заблокирован,",
                "&fт.к скупщик более не нуждается в нем.");
        firstMeta.setLore(firstLore);
        first.setItemMeta(firstMeta);
        inventory.setItem(21,first);

        ItemStack second = new ItemStack(Material.PAPER,1);
        ItemMeta secondMeta = second.getItemMeta();
        secondMeta.setDisplayName(ChatColor.YELLOW+"Эпический скупщик.");
        ArrayList<String> secondLore = new ArrayList<>();
        setLore(secondLore,"&aЧто это такое?:",
                "&fЭпический скупщик - это уникальный ивент.",
                "&fЕго особенность в том что цены на товары повышены,",
                "&fа скупщика интересуют особые товары.",
                "&aКак долго он длиться?:",
                "&fОт рестарта до рестарта.");
        secondMeta.setLore(secondLore);
        second.setItemMeta(secondMeta);
        inventory.setItem(30,second);

        ItemStack third = new ItemStack(Material.PAPER,1);
        ItemMeta thirdMeta = third.getItemMeta();
        thirdMeta.setDisplayName(ChatColor.YELLOW+"Товары за репутацию.");
        ArrayList<String> thirdLore = new ArrayList<>();
        setLore(thirdLore,"&aЧто это такое?:",
                "&fЭто особые товары, которые становяться",
                "&fдоступны игроку за очки репутации.",
                "&aВ чем их особенность?:",
                "&fОни отличаются от обычных товаров тем,",
                "&fчто не сбрасываются после рестарта.",
                "&aКак получить репутацию?:",
                "&fВыполняя ежедневные задания.");
        thirdMeta.setLore(thirdLore);
        third.setItemMeta(thirdMeta);
        inventory.setItem(23,third);

        ItemStack fourth = new ItemStack(Material.PAPER,1);
        ItemMeta fourthMeta = fourth.getItemMeta();
        fourthMeta.setDisplayName(ChatColor.YELLOW+"Лучший продавец.");
        ArrayList<String> fourthLore = new ArrayList<>();
        setLore(fourthLore,"&aКто это такой?",
                "&fЭто игрок, который продал товаров",
                "&fна наибольшую сумму.",
                "&aКакие бонусы он получит?",
                "&fОн получит в награду донат-валюту ",
                "&fв размере: "+reward+" донат-валюты",
                "&aКогда выдается награда?",
                "&fОбычно это "+hours+":"+minutes+" по МСК,",
                "&fно бывают исключения.",
                "&aЧто делать если не выдали награду?",
                "&fСообщить о проблеме администрации. &7(/links)",
                "&fЕсли вы не получили свою награду, необходимо",
                "&fбудет доказать, что аккаунт принадлежит вам.",
                " ");
        fourthMeta.setLore(fourthLore);
        fourth.setItemMeta(fourthMeta);
        inventory.setItem(31,fourth);

        ItemStack fifth = new ItemStack(Material.PAPER,1);
        ItemMeta fifthMeta = fifth.getItemMeta();
        fifthMeta.setDisplayName(ChatColor.YELLOW+"Обновление товаров.");
        ArrayList<String> fifthLore = new ArrayList<>();
        setLore(fifthLore,"&aКак часто обнавляются товары?:",
                "&fТовары обнавляются после рестарта.",
                "&aМожно ли узнать какие товары появяться?:",
                "&fНет, товары определяются рандомно.");
        fifthMeta.setLore(fifthLore);
        fifth.setItemMeta(fifthMeta);
        inventory.setItem(22,fifth);

        ItemStack sixth = new ItemStack(Material.PAPER,1);
        ItemMeta sixthMeta = sixth.getItemMeta();
        sixthMeta.setDisplayName(ColorUtils.translateColorCodes(
                "&eЭффект «Герой деревни». &4&lNEW"));
        ArrayList<String> sixthLore = new ArrayList<>();
        setLore(sixthLore,"&aКак он влияет на скупщика?:",
                "&fЭтот эффект позволяет продавать товары",
                "&fс выгодой +15% от стоимости товара.",
                "&aНа какие товары он работает?:",
                "&fТОЛЬКО НА ТОВАРЫ ЗА РЕПУТАЦИЮ!");
        sixthMeta.setLore(sixthLore);
        sixth.setItemMeta(sixthMeta);
        inventory.setItem(32,sixth);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() == null){return;}
        if(event.getView().getTitle().equals(ChatColor.WHITE+"Информация о скупщике")){
            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()){
                case SPECTRAL_ARROW:
                    player.openInventory(SellerInventory.inventory);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,3,0);
                    break;
                case BARRIER:
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,3,-3);
                    break;
            }
            event.setCancelled(true);
        }
    }

    private static void setLore(ArrayList<String> list,String ... lore){
        list.add(" ");
        for(String str: lore){
            list.add(ColorUtils.translateColorCodes(str));
        }
        list.add(" ");
    }

}

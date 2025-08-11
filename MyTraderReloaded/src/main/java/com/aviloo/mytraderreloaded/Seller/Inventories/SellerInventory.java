package com.aviloo.mytraderreloaded.Seller.Inventories;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import com.aviloo.mytraderreloaded.Seller.Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SellerInventory implements Listener {

    private static FileConfiguration iconConfig =
            MyTraderReloaded.getPlugin().iconsFileManager.getIconsConfig();

    public static Inventory inventory = Bukkit.createInventory(null,54,
            ChatColor.WHITE+"Скупщик");

    private static ArrayList<ItemStack> inventoryButtonsList = new ArrayList<>();

    public static void setButtonsSkull(){
        ItemStack back = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("back"));
        ItemMeta backMeta = back.getItemMeta();
        backMeta.addEnchant(Enchantment.ARROW_KNOCKBACK,1,true);
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        backMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        back.setItemMeta(backMeta);

        ItemStack close = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("close"));
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.addEnchant(Enchantment.ARROW_FIRE,1,true);
        closeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        close.setItemMeta(closeMeta);

        ItemStack leaders = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("leader"));
        ItemMeta leadersMeta = leaders.getItemMeta();
        leadersMeta.addEnchant(Enchantment.ARROW_INFINITE,1,true);
        leadersMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        leaders.setItemMeta(leadersMeta);

        ItemStack reputation = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("reputation"));
        ItemMeta repMeta = reputation.getItemMeta();
        repMeta.addEnchant(Enchantment.ARROW_DAMAGE,1,true);
        repMeta.setDisplayName(ChatColor.YELLOW+"Товары за репутацию");
        repMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        reputation.setItemMeta(repMeta);

        ItemStack multiplier = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("multiplier"));
        ItemMeta mulMeta = multiplier.getItemMeta();
        mulMeta.setDisplayName(ChatColor.YELLOW+"Множитель");
        mulMeta.addEnchant(Enchantment.DURABILITY,1,true);
        mulMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        multiplier.setItemMeta(mulMeta);

        ItemStack info = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("info"));
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.addEnchant(Enchantment.ARROW_FIRE,1,true);
        infoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.GRAY+"< Нажмите, чтобы узнать подробнее. >");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        ItemStack sellall = SkullUtils.getSkullByBase64EncodedTextureUrl(iconConfig.getString("sell-all"));
        ItemMeta sellMeta = sellall.getItemMeta();
        sellMeta.setDisplayName(ChatColor.YELLOW+"Продать всё");
        sellMeta.addEnchant(Enchantment.DIG_SPEED,1,true);
        sellMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sellall.setItemMeta(sellMeta);

        inventoryButtonsList.add(back);inventoryButtonsList.add(close);
        inventoryButtonsList.add(leaders);inventoryButtonsList.add(reputation);
        inventoryButtonsList.add(multiplier);inventoryButtonsList.add(info);
        inventoryButtonsList.add(sellall);

    }

    public static void setInventoryButtonsList(){
        ItemStack back = new ItemStack(Material.SPECTRAL_ARROW,1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.YELLOW+"Назад");
        back.setItemMeta(backMeta);
        inventoryButtonsList.add(back);

        ItemStack reputation = new ItemStack(Material.CHEST_MINECART,1);
        ItemMeta repMeta = reputation.getItemMeta();
        repMeta.setDisplayName(ChatColor.YELLOW+"Репутация скупщика");
        reputation.setItemMeta(repMeta);
        inventoryButtonsList.add(reputation);

        ItemStack info = new ItemStack(Material.KNOWLEDGE_BOOK,1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName(ChatColor.YELLOW+"Информация");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add(" ");
        infoLore.add(ChatColor.GRAY+"< Нажмите, чтобы узнать подробнее. >");
        infoLore.add(" ");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);
        inventoryButtonsList.add(info);

    }

    private static ArrayList<ItemStack> defaultSellerItemsList = new ArrayList<>();

    public static void setUpDefaultSellerItemsList(){
        ItemStack redStone = new ItemStack(Material.REDSTONE,1);
        ItemStack gunPowder = new ItemStack(Material.GUNPOWDER,1);
        ItemStack rose = new ItemStack(Material.ROSE_BUSH,1);
        ItemStack clay = new ItemStack(Material.CLAY_BALL);
        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemStack cane = new ItemStack(Material.SUGAR_CANE,1);
        ItemStack deadBrush = new ItemStack(Material.DEAD_BUSH,1);
        ItemStack wheat = new ItemStack(Material.WHEAT,1);
        ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER,1);
        ItemStack apple = new ItemStack(Material.APPLE,1);
        ItemStack sugar = new ItemStack(Material.SUGAR,1);
        ItemStack dragonBreath = new ItemStack(Material.DRAGON_BREATH,1);
        ItemStack membrane = new ItemStack(Material.PHANTOM_MEMBRANE,1);
        ItemStack melon = new ItemStack(Material.MELON_SLICE,1);
        ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE,1);
        ItemStack ink = new ItemStack(Material.INK_SAC,1);
        ItemStack sweet = new ItemStack(Material.SWEET_BERRIES,1);
        ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS,1);
        ItemStack RawCod = new ItemStack(Material.COOKED_COD,1);
        ItemStack spiderEye = new ItemStack(Material.SPIDER_EYE,1);
        ItemStack cobblestone = new ItemStack(Material.COBBLESTONE,1);
        ItemStack MagmaBlock = new ItemStack(Material.MAGMA_BLOCK,1);
        ItemStack String = new ItemStack(Material.STRING,1);
        ItemStack Sand = new ItemStack(Material.SAND,1);
        ItemStack Coal = new ItemStack(Material.COAL,1);
        ItemStack Arrow = new ItemStack(Material.ARROW,1);
        ItemStack Zombie = new ItemStack(Material.ROTTEN_FLESH,1);
        ItemStack Kelp = new ItemStack(Material.DRIED_KELP,1);
        ItemStack WarpedPlants = new ItemStack(Material.WARPED_PLANKS,1);
        ItemStack Honey = new ItemStack(Material.HONEY_BOTTLE,1);
        ItemStack Rail = new ItemStack(Material.RAIL,1);
        ItemStack Shell = new ItemStack(Material.SHULKER_SHELL,1);
        ItemStack Bone = new ItemStack(Material.BONE,1);
        ItemStack BlockCopper = new ItemStack(Material.COPPER_BLOCK,1);
        ItemStack Stairs = new ItemStack(Material.DIORITE_STAIRS,1);
        ItemStack salmon = new ItemStack(Material.SALMON,1);
        ItemStack PUFFERFISH = new ItemStack(Material.PUFFERFISH,1);
        ItemStack Tropical = new ItemStack(Material.TROPICAL_FISH,1);
        ItemStack Bowl = new ItemStack(Material.BOWL,1);
        ItemStack Leather = new ItemStack(Material.LEATHER,1);
        ItemStack MossBlock = new ItemStack(Material.MOSS_BLOCK,1);
        ItemStack TubeCoral = new ItemStack(Material.TUBE_CORAL,1);

        defaultSellerItemsList.add(redStone);
        defaultSellerItemsList.add(gunPowder);
        defaultSellerItemsList.add(rose);
        defaultSellerItemsList.add(clay);
        defaultSellerItemsList.add(quartz);
        defaultSellerItemsList.add(cane);
        defaultSellerItemsList.add(deadBrush);
        defaultSellerItemsList.add(wheat);
        defaultSellerItemsList.add(blazePowder);
        defaultSellerItemsList.add(apple);
        defaultSellerItemsList.add(sugar);
        defaultSellerItemsList.add(dragonBreath);
        defaultSellerItemsList.add(membrane);
        defaultSellerItemsList.add(melon);
        defaultSellerItemsList.add(bottle);
        defaultSellerItemsList.add(ink);
        defaultSellerItemsList.add(sweet);
        defaultSellerItemsList.add(seeds);
        defaultSellerItemsList.add(RawCod);
        defaultSellerItemsList.add(spiderEye);
        defaultSellerItemsList.add(cobblestone);
        defaultSellerItemsList.add(MagmaBlock);
        defaultSellerItemsList.add(String);
        defaultSellerItemsList.add(Sand);
        defaultSellerItemsList.add(Coal);
        defaultSellerItemsList.add(Arrow);
        defaultSellerItemsList.add(Zombie);
        defaultSellerItemsList.add(Kelp);
        defaultSellerItemsList.add(WarpedPlants);
        defaultSellerItemsList.add(Honey);
        defaultSellerItemsList.add(Rail);
        defaultSellerItemsList.add(Shell);
        defaultSellerItemsList.add(Bone);
        defaultSellerItemsList.add(BlockCopper);
        defaultSellerItemsList.add(Stairs);
        defaultSellerItemsList.add(salmon);
        defaultSellerItemsList.add(PUFFERFISH);
        defaultSellerItemsList.add(Tropical);
        defaultSellerItemsList.add(Bowl);
        defaultSellerItemsList.add(Leather);
        defaultSellerItemsList.add(MossBlock);
        defaultSellerItemsList.add(TubeCoral);
    }

    private static ArrayList<ItemStack> epicSellerItemsList = new ArrayList<>();

    public static void setUpEpicSellerItemsList(){
        ItemStack diamond = new ItemStack(Material.DIAMOND,1);
        ItemStack blaze = new ItemStack(Material.BLAZE_ROD,1);
        ItemStack tnt = new ItemStack(Material.TNT,1);
        ItemStack brick = new ItemStack(Material.BRICK,1);
        ItemStack nuggets = new ItemStack(Material.GOLD_NUGGET,1);
        ItemStack zHead = new ItemStack(Material.ZOMBIE_HEAD,1);
        ItemStack heart = new ItemStack(Material.HEART_OF_THE_SEA,1);
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemStack sculk = new ItemStack(Material.SCULK);

        epicSellerItemsList.add(diamond);
        epicSellerItemsList.add(blaze);
        epicSellerItemsList.add(tnt);
        epicSellerItemsList.add(brick);
        epicSellerItemsList.add(nuggets);
        epicSellerItemsList.add(zHead);
        epicSellerItemsList.add(heart);
        epicSellerItemsList.add(totem);
        epicSellerItemsList.add(sculk);
    }

    private static ArrayList<ItemStack> generatedSellerItems = new ArrayList<>();

    public static void generateSellerItems(){
        int attempts = 0;
        boolean success = false;
        while (attempts < 15 && !success) {
            try {
                if (MyTraderReloaded.getIsEpicType()) {
                    for (int i = 0; i < 9; i++) {
                        // Создаем генератор случайных чисел
                        Random random = new Random();

                        // Генерируем случайный индекс в пределах размера ArrayList
                        int randomIndex = random.nextInt(epicSellerItemsList.size());

                        generatedSellerItems.add(epicSellerItemsList.get(randomIndex));
                        epicSellerItemsList.remove(randomIndex);
                    }

                }
                if (!MyTraderReloaded.getIsEpicType()) {
                    for (int i = 0; i < 9; i++) {
                        // Создаем генератор случайных чисел
                        Random random = new Random();

                        // Генерируем случайный индекс в пределах размера ArrayList
                        int randomIndex = random.nextInt(defaultSellerItemsList.size());

                        generatedSellerItems.add(defaultSellerItemsList.get(randomIndex));
                        defaultSellerItemsList.remove(randomIndex);
                    }

                }
                success = true;
            }catch (IllegalArgumentException e){
                attempts++;
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Ошибка: "+ e.getMessage());
                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Попытка: "+attempts+"/15");
                if(attempts >= 15){
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED+
                            "Превышенно максимальное кол-во попыток перезагрузки метода." );
                    Bukkit.getServer().shutdown();
                }

            }
        }

    }

    public static void inventorySetUp(){
        int attempts = 0;
        boolean success = false;

        while(attempts < 15 &&!success) {
            try {
                //Buttons set up
                inventory.setItem(45 , inventoryButtonsList.get(0));
                inventory.setItem(47 , inventoryButtonsList.get(6));
                inventory.setItem(48,  LeaderUtils.traderItemHead());
                inventory.setItem(49 , inventoryButtonsList.get(5));
                inventory.setItem(50 , inventoryButtonsList.get(4));
                inventory.setItem(51 , inventoryButtonsList.get(3));
                inventory.setItem(53 , inventoryButtonsList.get(0));

                //Seller Items
                for (int i = 0; i < 3; i++) {
                    inventory.setItem(12 + i, generatedSellerItems.get(i));
                }
                for (int i = 3; i < 6; i++) {
                    inventory.setItem(21 + i - 3, generatedSellerItems.get(i));
                }
                for (int i = 6; i < 9; i++) {
                    inventory.setItem(30 + i - 6, generatedSellerItems.get(i));
                }

                if (!MyTraderReloaded.getIsEpicType()) {
                    loadMetaForGeneratedDefaultItems();
                }
                if (MyTraderReloaded.getIsEpicType()) {
                    loadMetaForGeneratedEpicItems();
                }

                success = true;
            } catch (IllegalArgumentException e) {
                attempts++;
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Ошибка: "+ e.getMessage());
                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"Попытка: "+attempts+"/15");
                if(attempts >= 15){
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED+
                            "Превышенно максимальное кол-во попыток перезагрузки метода." );
                    Bukkit.getServer().shutdown();
                }
            }
        }
    }

    //ItemMeta Part

    public static void loadMetaForGeneratedDefaultItems(){
        for(ItemStack items : inventory.getContents()){
            if(items == null){continue;}
            if(items.getType().equals(Material.REDSTONE)){
                updateRedStoneDefaultMeta(items);
            }
            if(items.getType().equals(Material.GUNPOWDER)){
                updateGunPowderDefaultMeta(items);
            }
            if(items.getType().equals(Material.ROSE_BUSH)){
                updateRoseDefaultMeta(items);
            }
            if(items.getType().equals(Material.CLAY_BALL)){
                updateClayDefaultMeta(items);
            }
            if(items.getType().equals(Material.QUARTZ)){
                updateQuartzDefaultMeta(items);
            }
            if(items.getType().equals(Material.SUGAR_CANE)){
                updateCaneDefaultMeta(items);
            }
            if(items.getType().equals(Material.DEAD_BUSH)){
                updateDeadBrushDefaultMeta(items);
            }
            if(items.getType().equals(Material.WHEAT)){
                updateWheatDefaultMeta(items);
            }
            if(items.getType().equals(Material.BLAZE_POWDER)){
                updateBlazePowderDefaultMeta(items);
            }
            if(items.getType().equals(Material.APPLE)){
                updateAppleDefaultMeta(items);
            }
            if(items.getType().equals(Material.SUGAR)){
                updateSugarDefaultMeta(items);
            }
            if(items.getType().equals(Material.DRAGON_BREATH)){
                updateDragonBreathDefaultMeta(items);
            }
            if(items.getType().equals(Material.PHANTOM_MEMBRANE)){
                updateMembraneDefaultMeta(items);
            }
            if(items.getType().equals(Material.MELON_SLICE)){
                updateMelonSliceDefaultMeta(items);
            }
            if(items.getType().equals(Material.GLASS_BOTTLE)){
                updateBottleDefaultMeta(items);
            }
            if(items.getType().equals(Material.INK_SAC)){
                updateIncDefaultMeta(items);
            }
            if(items.getType().equals(Material.SWEET_BERRIES)){
                updateSweetDefaultMeta(items);
            }
            if(items.getType().equals(Material.WHEAT_SEEDS)){
                updateSeedsDefaultMeta(items);
            }
            if(items.getType().equals(Material.COOKED_COD)){
                updateRawCodDefaultMeta(items);
            }
            if(items.getType().equals(Material.SPIDER_EYE)){
                updateSpiderEyeDefaultMeta(items);
            }
            if(items.getType().equals(Material.COBBLESTONE)){
                updateCobblestoneDefaultMeta(items);
            }
            if(items.getType().equals(Material.MAGMA_BLOCK)){
                updateMagmaDefaultMeta(items);
            }
            if(items.getType().equals(Material.STRING)){
                updateStringDefaultMeta(items);
            }
            if(items.getType().equals(Material.SAND)){
                updateSandDefaultMeta(items);
            }
            if(items.getType().equals(Material.COAL)){
                updateCoalDefaultMeta(items);
            }
            if(items.getType().equals(Material.ARROW)){
                updateArrowDefaultMeta(items);
            }
            if(items.getType().equals(Material.ROTTEN_FLESH)){
                updateZombieDefaultMeta(items);
            }
            if(items.getType().equals(Material.DRIED_KELP)){
                updateKelpDefaultMeta(items);
            }
            if(items.getType().equals(Material.WARPED_PLANKS)){
                updateWarpedPlantsDefaultMeta(items);
            }
            if(items.getType().equals(Material.HONEY_BOTTLE)){
                updateHoneyDefaultMeta(items);
            }
            if(items.getType().equals(Material.RAIL)){
                updateRailDefaultMeta(items);
            }
            if(items.getType().equals(Material.SHULKER_SHELL)){
                updateShellDefaultMeta(items);
            }
            if(items.getType().equals(Material.BONE)){
                updateBoneDefaultMeta(items);
            }
            if(items.getType().equals(Material.COPPER_BLOCK)){
                updateBlockCopperDefaultMeta(items);
            }
            if(items.getType().equals(Material.DIORITE_STAIRS)){
                updateStairsDefaultMeta(items);
            }
            if(items.getType().equals(Material.SALMON)){
                updateSalmonDefaultMeta(items);
            }
            if(items.getType().equals(Material.PUFFERFISH)){
                updatePUFFERFISHDefaultMeta(items);
            }
            if(items.getType().equals(Material.TROPICAL_FISH)){
                updateTropicalDefaultMeta(items);
            }
            if(items.getType().equals(Material.BOWL)){
                updateBowlDefaultMeta(items);
            }
            if(items.getType().equals(Material.LEATHER)){
                updateLeatherDefaultMeta(items);
            }
            if(items.getType().equals(Material.MOSS_BLOCK)){
                updateMossBlockDefaultMeta(items);
            }
            if(items.getType().equals(Material.TUBE_CORAL)){
                updateTubeCoralDefaultMeta(items);
            }

        }

    }

    public static void loadMetaForGeneratedEpicItems(){
        for(ItemStack items : inventory.getContents()){
            if(items == null){continue;}
            if(items.getType().equals(Material.DIAMOND)){
                updateDiamondEpicMeta(items);
            }
            if(items.getType().equals(Material.TNT)){
                updateTNTEpicMeta(items);
            }
            if(items.getType().equals(Material.BRICK)){
                updateBrickEpicMeta(items);
            }
            if(items.getType().equals(Material.GOLD_NUGGET)){
                updateNuggetEpicMeta(items);
            }
            if(items.getType().equals(Material.ZOMBIE_HEAD)){
                updateZombieHeadEpicMeta(items);
            }
            if(items.getType().equals(Material.HEART_OF_THE_SEA)){
                updateHeartEpicMeta(items);
            }
            if(items.getType().equals(Material.TOTEM_OF_UNDYING)){
                updateTotemEpicMeta(items);
            }
            if(items.getType().equals(Material.SCULK)){
                updateSculkEpicMeta(items);
            }
            if(items.getType().equals(Material.BLAZE_ROD)){
                updateBlazeEpicMeta(items);
            }

        }

    }

    private static void updateRedStoneDefaultMeta(@NotNull ItemStack item){
        ItemMeta redMeta = item.getItemMeta();
        redMeta.setDisplayName(ChatColor.WHITE+"Редстоун");
        if(PriceManager.isQuantityBlocked("REDSTONE")){
            item.setType(Material.BARRIER);
        }
        ArrayList<String> redLore = new ArrayList<>();
        redLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("REDSTONE"));
        redLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("REDSTONE"));
        redLore.add(" ");
        redLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        redLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        redLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        redMeta.setLore(redLore);
        item.setItemMeta(redMeta);
    }

    private static void updateGunPowderDefaultMeta(@NotNull ItemStack item){
        ItemMeta gunMeta = item.getItemMeta();
        gunMeta.setDisplayName(ChatColor.WHITE + "Порох");
        ArrayList<String> gunLore = new ArrayList<>();
        gunLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("GUNPOWDER"));
        gunLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("GUNPOWDER"));
        gunLore.add(" ");
        gunLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        gunLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        gunLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        gunMeta.setLore(gunLore);
        item.setItemMeta(gunMeta);
    }

    private static void updateRoseDefaultMeta(@NotNull ItemStack item){
        ItemMeta roseMeta = item.getItemMeta();
        roseMeta.setDisplayName(ChatColor.WHITE+"Роза");
        ArrayList<String> roseLore = new ArrayList<>();
        roseLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("ROSE_BUSH"));
        roseLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("ROSE_BUSH"));
        roseLore.add(" ");
        roseLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        roseLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        roseLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        roseMeta.setLore(roseLore);
        item.setItemMeta(roseMeta);
    }

    private static void updateClayDefaultMeta(@NotNull ItemStack item){
        ItemMeta clayMeta = item.getItemMeta();
        clayMeta.setDisplayName(ChatColor.WHITE+"Глина");
        ArrayList<String> clayLore = new ArrayList<>();
        clayLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("CLAY_BALL"));
        clayLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("CLAY_BALL"));
        clayLore.add(" ");
        clayLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        clayLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        clayLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        clayMeta.setLore(clayLore);
        item.setItemMeta(clayMeta);
    }

    private static void updateQuartzDefaultMeta(@NotNull ItemStack item){
        ItemMeta quartzMeta = item.getItemMeta();
        quartzMeta.setDisplayName(ChatColor.WHITE+"Квартц");
        ArrayList<String> quartzLore = new ArrayList<>();
        quartzLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("QUARTZ"));
        quartzLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("QUARTZ"));
        quartzLore.add(" ");
        quartzLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        quartzLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        quartzLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        quartzMeta.setLore(quartzLore);
        item.setItemMeta(quartzMeta);
    }

    private static void updateCaneDefaultMeta(@NotNull ItemStack item){
        ItemMeta caneMeta = item.getItemMeta();
        caneMeta.setDisplayName(ChatColor.WHITE+"Тростник");
        ArrayList<String> caneLore = new ArrayList<>();
        caneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SUGAR_CANE"));
        caneLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("SUGAR_CANE"));
        caneLore.add(" ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        caneLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        caneMeta.setLore(caneLore);
        item.setItemMeta(caneMeta);
    }

    private static void updateDeadBrushDefaultMeta(@NotNull ItemStack item){
        ItemMeta deadMeta = item.getItemMeta();
        deadMeta.setDisplayName(ChatColor.WHITE+"Мёртвый куст");
        ArrayList<String> deadLore = new ArrayList<>();
        deadLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("DEAD_BUSH"));
        deadLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("DEAD_BUSH"));
        deadLore.add(" ");
        deadLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        deadLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        deadLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        deadMeta.setLore(deadLore);
        item.setItemMeta(deadMeta);
    }

    private static void updateWheatDefaultMeta(@NotNull ItemStack item){
        ItemMeta wheatMeta = item.getItemMeta();
        wheatMeta.setDisplayName(ChatColor.WHITE+"Пшеница");
        ArrayList<String> wheatLore = new ArrayList<>();
        wheatLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("WHEAT"));
        wheatLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("WHEAT"));
        wheatLore.add(" ");
        wheatLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        wheatLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        wheatLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        wheatMeta.setLore(wheatLore);
        item.setItemMeta(wheatMeta);
    }

    private static void updateBlazePowderDefaultMeta(@NotNull ItemStack item){
        ItemMeta blazeMeta = item.getItemMeta();
        blazeMeta.setDisplayName(ChatColor.WHITE+"Порошок блейза");
        ArrayList<String> blazeLore = new ArrayList<>();
        blazeLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("BLAZE_POWDER"));
        blazeLore.add(ChatColor.YELLOW+"Цена за 64 штуки - "+PriceManager.getCurrentPriceFor64String("BLAZE_POWDER"));
        blazeLore.add(" ");
        blazeLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        blazeLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        blazeLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        blazeMeta.setLore(blazeLore);
        item.setItemMeta(blazeMeta);
    }

    private static void updateAppleDefaultMeta(@NotNull ItemStack item){
        ItemMeta appleMeta = item.getItemMeta();
        appleMeta.setDisplayName(ChatColor.WHITE+ "Яблоко");
        ArrayList<String> appleLore = new ArrayList<>();
        appleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("APPLE"));
        appleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("APPLE"));
        appleLore.add(" ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        appleLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        appleMeta.setLore(appleLore);
        item.setItemMeta(appleMeta);
    }

    private static void updateSugarDefaultMeta(@NotNull ItemStack item){
        ItemMeta sugarMeta = item.getItemMeta();
        sugarMeta.setDisplayName(ChatColor.WHITE+"Сахар");
        ArrayList<String> sugarLore = new ArrayList<>();
        sugarLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SUGAR"));
        sugarLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SUGAR"));
        sugarLore.add(" ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sugarLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        sugarMeta.setLore(sugarLore);
        item.setItemMeta(sugarMeta);
    }

    private static void updateDragonBreathDefaultMeta(@NotNull ItemStack item){
        ItemMeta dragonMeta = item.getItemMeta();
        dragonMeta.setDisplayName(ChatColor.WHITE + "Дыхание дракона");
        ArrayList<String> dragonLore = new ArrayList<>();
        dragonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("DRAGON_BREATH"));
        dragonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("DRAGON_BREATH"));
        dragonLore.add(" ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        dragonLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        dragonMeta.setLore(dragonLore);
        item.setItemMeta(dragonMeta);
    }

    private static void updateMembraneDefaultMeta(@NotNull ItemStack item){
        ItemMeta membraneMeta = item.getItemMeta();
        membraneMeta.setDisplayName(ChatColor.WHITE+"Чешуя фантома");
        ArrayList<String> membraneLore = new ArrayList<>();
        membraneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("PHANTOM_MEMBRANE"));
        membraneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("PHANTOM_MEMBRANE"));
        membraneLore.add(" ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        membraneLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        membraneMeta.setLore(membraneLore);
        item.setItemMeta(membraneMeta);
    }

    private static void updateMelonSliceDefaultMeta(@NotNull ItemStack item){
        ItemMeta melonMeta = item.getItemMeta();
        melonMeta.setDisplayName(ChatColor.WHITE+"Долька арбуза");
        ArrayList<String> melonLore = new ArrayList<>();
        melonLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("MELON_SLICE"));
        melonLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("MELON_SLICE"));
        melonLore.add(" ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        melonLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        melonMeta.setLore(melonLore);
        item.setItemMeta(melonMeta);
    }

    private static void updateBottleDefaultMeta(@NotNull ItemStack item){
        ItemMeta bottleMeta = item.getItemMeta();
        bottleMeta.setDisplayName(ChatColor.WHITE+"Пузырёк");
        ArrayList<String> bottleLore = new ArrayList<>();
        bottleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("GLASS_BOTTLE"));
        bottleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("GLASS_BOTTLE"));
        bottleLore.add(" ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        bottleLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        bottleMeta.setLore(bottleLore);
        item.setItemMeta(bottleMeta);
    }

    private static void updateIncDefaultMeta(@NotNull ItemStack item){
        ItemMeta inkMeta = item.getItemMeta();
        inkMeta.setDisplayName(ChatColor.WHITE+"Чернила");
        ArrayList<String> inkLore = new ArrayList<>();
        inkLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("INK_SAC"));
        inkLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("INK_SAC"));
        inkLore.add(" ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        inkLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        inkMeta.setLore(inkLore);
        item.setItemMeta(inkMeta);
    }

    private static void updateSweetDefaultMeta(@NotNull ItemStack item){
        ItemMeta sweetMeta = item.getItemMeta();
        sweetMeta.setDisplayName(ChatColor.WHITE+"Сладкие ягоды");
        ArrayList<String> sweetLore = new ArrayList<>();
        sweetLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SWEET_BERRIES"));
        sweetLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SWEET_BERRIES"));
        sweetLore.add(" ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sweetLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        sweetMeta.setLore(sweetLore);
        item.setItemMeta(sweetMeta);
    }

    private static void updateSeedsDefaultMeta(@NotNull ItemStack item){
        ItemMeta seedsMeta = item.getItemMeta();
        seedsMeta.setDisplayName(ChatColor.WHITE+"Семена пшеницы");
        ArrayList<String> seedsLore = new ArrayList<>();
        seedsLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("WHEAT_SEEDS"));
        seedsLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("WHEAT_SEEDS"));
        seedsLore.add(" ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        seedsLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        seedsMeta.setLore(seedsLore);
        item.setItemMeta(seedsMeta);
    }

    private static void updateRawCodDefaultMeta(@NotNull ItemStack item){
        ItemMeta RawMeta = item.getItemMeta();
        RawMeta.setDisplayName(ChatColor.WHITE+"Приготовленная треска");
        ArrayList<String> RawLore = new ArrayList<>();
        RawLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("COOKED_COD"));
        RawLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("COOKED_COD"));
        RawLore.add(" ");
        RawLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        RawLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        RawLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        RawMeta.setLore(RawLore);
        item.setItemMeta(RawMeta);
    }

    private static void updateSpiderEyeDefaultMeta(@NotNull ItemStack item){
        ItemMeta EyeMeta = item.getItemMeta();
        EyeMeta.setDisplayName(ChatColor.WHITE+"Глаз паука");
        ArrayList<String> EyeLore = new ArrayList<>();
        EyeLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SPIDER_EYE"));
        EyeLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SPIDER_EYE"));
        EyeLore.add(" ");
        EyeLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        EyeLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        EyeLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        EyeMeta.setLore(EyeLore);
        item.setItemMeta(EyeMeta);
    }

    private static void updateCobblestoneDefaultMeta(@NotNull ItemStack item){
        ItemMeta cobleMeta = item.getItemMeta();
        cobleMeta.setDisplayName(ChatColor.WHITE+"Булыжник");
        ArrayList<String> cobleLore = new ArrayList<>();
        cobleLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("COBBLESTONE"));
        cobleLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("COBBLESTONE"));
        cobleLore.add(" ");
        cobleLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        cobleLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        cobleLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        cobleMeta.setLore(cobleLore);
        item.setItemMeta(cobleMeta);
    }

    private static void updateMagmaDefaultMeta(@NotNull ItemStack item){
        ItemMeta magmaMeta = item.getItemMeta();
        magmaMeta.setDisplayName(ChatColor.WHITE+"Магма");
        ArrayList<String> magmaLore = new ArrayList<>();
        magmaLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("MAGMA_BLOCK"));
        magmaLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("MAGMA_BLOCK"));
        magmaLore.add(" ");
        magmaLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        magmaLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        magmaLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        magmaMeta.setLore(magmaLore);
        item.setItemMeta(magmaMeta);
    }

    private static void updateStringDefaultMeta(@NotNull ItemStack item){
        ItemMeta strMeta = item.getItemMeta();
        strMeta.setDisplayName(ChatColor.WHITE+"Нить");
        ArrayList<String> strLore = new ArrayList<>();
        strLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("STRING"));
        strLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("STRING"));
        strLore.add(" ");
        strLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        strLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        strLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        strMeta.setLore(strLore);
        item.setItemMeta(strMeta);
    }

    private static void updateSandDefaultMeta(@NotNull ItemStack item){
        ItemMeta sandMeta = item.getItemMeta();
        sandMeta.setDisplayName(ChatColor.WHITE+"Песок");
        ArrayList<String> sandLore = new ArrayList<>();
        sandLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("SAND"));
        sandLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("SAND"));
        sandLore.add(" ");
        sandLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        sandLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        sandLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        sandMeta.setLore(sandLore);
        item.setItemMeta(sandMeta);
    }

    private static void updateCoalDefaultMeta(@NotNull ItemStack item){
        ItemMeta coalMeta = item.getItemMeta();
        coalMeta.setDisplayName(ChatColor.WHITE+"Уголь");
        ArrayList<String> coalLore = new ArrayList<>();
        coalLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("COAL"));
        coalLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("COAL"));
        coalLore.add(" ");
        coalLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        coalLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        coalLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        coalMeta.setLore(coalLore);
        item.setItemMeta(coalMeta);
    }

    private static void updateArrowDefaultMeta(@NotNull ItemStack item){
        ItemMeta arrowMeta = item.getItemMeta();
        arrowMeta.setDisplayName(ChatColor.WHITE+"Стрела");
        ArrayList<String> arrowLore = new ArrayList<>();
        arrowLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+PriceManager.getCurrentPriceString("ARROW"));
        arrowLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("ARROW"));
        arrowLore.add(" ");
        arrowLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        arrowLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        arrowLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        arrowMeta.setLore(arrowLore);
        item.setItemMeta(arrowMeta);
    }

    private static void updateZombieDefaultMeta(@NotNull ItemStack item){
        ItemMeta zombieMeta = item.getItemMeta();
        zombieMeta.setDisplayName(ChatColor.WHITE+"Гнилая плоть");
        ArrayList<String> zombieLore = new ArrayList<>();
        zombieLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("ROTTEN_FLESH"));
        zombieLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("ROTTEN_FLESH"));
        zombieLore.add(" ");
        zombieLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        zombieLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        zombieLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        zombieMeta.setLore(zombieLore);
        item.setItemMeta(zombieMeta);
    }

    private static void updateKelpDefaultMeta(@NotNull ItemStack item){
        ItemMeta kelpMeta = item.getItemMeta();
        kelpMeta.setDisplayName(ChatColor.WHITE+"Ламинария");
        ArrayList<String> kelpLore = new ArrayList<>();
        kelpLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DRIED_KELP"));
        kelpLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("DRIED_KELP"));
        kelpLore.add(" ");
        kelpLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        kelpLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        kelpLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        kelpMeta.setLore(kelpLore);
        item.setItemMeta(kelpMeta);
    }

    private static void updateWarpedPlantsDefaultMeta(@NotNull ItemStack item){
        ItemMeta plantsMeta = item.getItemMeta();
        plantsMeta.setDisplayName(ChatColor.WHITE+"Искажённые доски");
        ArrayList<String> plantsLore = new ArrayList<>();
        plantsLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("WARPED_PLANKS"));
        plantsLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("WARPED_PLANKS"));
        plantsLore.add(" ");
        plantsLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        plantsLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        plantsLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        plantsMeta.setLore(plantsLore);
        item.setItemMeta(plantsMeta);
    }

    private static void updateHoneyDefaultMeta(@NotNull ItemStack item){
        ItemMeta HoneyMeta = item.getItemMeta();
        HoneyMeta.setDisplayName(ChatColor.WHITE+"Бутылочка Мёда");
        ArrayList<String> HoneyLore = new ArrayList<>();
        HoneyLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("HONEY_BOTTLE"));
        HoneyLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("HONEY_BOTTLE"));
        HoneyLore.add(" ");
        HoneyLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        HoneyLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        HoneyLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        HoneyMeta.setLore(HoneyLore);
        item.setItemMeta(HoneyMeta);
    }

    private static void updateRailDefaultMeta(@NotNull ItemStack item){
        ItemMeta railMeta = item.getItemMeta();
        railMeta.setDisplayName(ChatColor.WHITE+"Рельса");
        ArrayList<String> railLore = new ArrayList<>();
        railLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("RAIL"));
        railLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "+PriceManager.getCurrentPriceFor64String("RAIL"));
        railLore.add(" ");
        railLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        railLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        railLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        railMeta.setLore(railLore);
        item.setItemMeta(railMeta);
    }

    private static void updateShellDefaultMeta(@NotNull ItemStack item){
        ItemMeta shellMeta = item.getItemMeta();
        shellMeta.setDisplayName(ChatColor.WHITE+"Панцирь шалкера");
        ArrayList<String> shellLore = new ArrayList<>();
        shellLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SHULKER_SHELL"));
        shellLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SHULKER_SHELL"));
        shellLore.add(" ");
        shellLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        shellLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        shellLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        shellMeta.setLore(shellLore);
        item.setItemMeta(shellMeta);
    }

    private static void updateBoneDefaultMeta(@NotNull ItemStack item){
        ItemMeta boneMeta = item.getItemMeta();
        boneMeta.setDisplayName(ChatColor.WHITE+"Кость");
        ArrayList<String> boneLore = new ArrayList<>();
        boneLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BONE"));
        boneLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BONE"));
        boneLore.add(" ");
        boneLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        boneLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        boneLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        boneMeta.setLore(boneLore);
        item.setItemMeta(boneMeta);
    }

    private static void updateBlockCopperDefaultMeta(@NotNull ItemStack item){
        ItemMeta copperMeta = item.getItemMeta();
        copperMeta.setDisplayName(ChatColor.WHITE+"Блок меди");
        ArrayList<String> copperLore = new ArrayList<>();
        copperLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("COPPER_BLOCK"));
        copperLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("COPPER_BLOCK"));
        copperLore.add(" ");
        copperLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        copperLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        copperLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        copperMeta.setLore(copperLore);
        item.setItemMeta(copperMeta);
    }

    private static void updateStairsDefaultMeta(@NotNull ItemStack item){
        ItemMeta stMeta = item.getItemMeta();
        stMeta.setDisplayName(ChatColor.WHITE+"Ступеньки");
        ArrayList<String> stLore = new ArrayList<>();
        stLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DIORITE_STAIRS"));
        stLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("DIORITE_STAIRS"));
        stLore.add(" ");
        stLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        stLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        stLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        stMeta.setLore(stLore);
        item.setItemMeta(stMeta);
    }

    private static void updateSalmonDefaultMeta(@NotNull ItemStack item){
        ItemMeta saMeta = item.getItemMeta();
        saMeta.setDisplayName(ChatColor.WHITE+"Лосось");
        ArrayList<String> saLore = new ArrayList<>();
        saLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SALMON"));
        saLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SALMON"));
        saLore.add(" ");
        saLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        saLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        saLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        saMeta.setLore(saLore);
        item.setItemMeta(saMeta);
    }

    private static void updatePUFFERFISHDefaultMeta(@NotNull ItemStack item){
        ItemMeta puMeta = item.getItemMeta();
        puMeta.setDisplayName(ChatColor.WHITE+"Фуга");
        ArrayList<String> puLore = new ArrayList<>();
        puLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("PUFFERFISH"));
        puLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("PUFFERFISH"));
        puLore.add(" ");
        puLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        puLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        puLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        puMeta.setLore(puLore);
        item.setItemMeta(puMeta);
    }

    private static void updateTropicalDefaultMeta(@NotNull ItemStack item){
        ItemMeta trMeta = item.getItemMeta();
        trMeta.setDisplayName(ChatColor.WHITE+"Тропическая рыба");
        ArrayList<String> trLore = new ArrayList<>();
        trLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TROPICAL_FISH"));
        trLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TROPICAL_FISH"));
        trLore.add(" ");
        trLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        trLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        trLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        trMeta.setLore(trLore);
        item.setItemMeta(trMeta);
    }

    private static void updateBowlDefaultMeta(@NotNull ItemStack item){
        ItemMeta boMeta = item.getItemMeta();
        boMeta.setDisplayName(ChatColor.WHITE+"Миска");
        ArrayList<String> boLore = new ArrayList<>();
        boLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BOWL"));
        boLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BOWL"));
        boLore.add(" ");
        boLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        boLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        boLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        boMeta.setLore(boLore);
        item.setItemMeta(boMeta);
    }

    private static void updateLeatherDefaultMeta(@NotNull ItemStack item){
        ItemMeta leMeta = item.getItemMeta();
        leMeta.setDisplayName(ChatColor.WHITE+"Кожа");
        ArrayList<String> leLore = new ArrayList<>();
        leLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("LEATHER"));
        leLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("LEATHER"));
        leLore.add(" ");
        leLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        leLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        leLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        leMeta.setLore(leLore);
        item.setItemMeta(leMeta);
    }

    private static void updateMossBlockDefaultMeta(@NotNull ItemStack item){
        ItemMeta moMeta = item.getItemMeta();
        moMeta.setDisplayName(ChatColor.WHITE+"Мох");
        ArrayList<String> moLore = new ArrayList<>();
        moLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("MOSS_BLOCK"));
        moLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("MOSS_BLOCK"));
        moLore.add(" ");
        moLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        moLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        moLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        moMeta.setLore(moLore);
        item.setItemMeta(moMeta);
    }

    private static void updateTubeCoralDefaultMeta(@NotNull ItemStack item){
        ItemMeta tuMeta = item.getItemMeta();
        tuMeta.setDisplayName(ChatColor.WHITE+tuMeta.getDisplayName());
        ArrayList<String> tuLore = new ArrayList<>();
        tuLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TUBE_CORAL"));
        tuLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TUBE_CORAL"));
        tuLore.add(" ");
        tuLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        tuLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        tuLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        tuMeta.setLore(tuLore);
        item.setItemMeta(tuMeta);
    }

    //Epic Meta

    private static void updateDiamondEpicMeta(@NotNull ItemStack item){
        ItemMeta dMeta = item.getItemMeta();
        dMeta.setDisplayName(ChatColor.WHITE+"Алмаз");
        ArrayList<String> dLore = new ArrayList<>();
        dLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("DIAMOND"));
        dLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("DIAMOND"));
        dLore.add(" ");
        dLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        dLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        dLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        dMeta.setLore(dLore);
        item.setItemMeta(dMeta);
    }

    private static void updateBlazeEpicMeta(@NotNull ItemStack item){
        ItemMeta bMeta = item.getItemMeta();
        bMeta.setDisplayName(ChatColor.WHITE+"Стержень блейза");
        ArrayList<String> bLore = new ArrayList<>();
        bLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BLAZE_ROD"));
        bLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BLAZE_ROD"));
        bLore.add(" ");
        bLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        bLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        bLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        bMeta.setLore(bLore);
        item.setItemMeta(bMeta);
    }

    private static void updateTNTEpicMeta(@NotNull ItemStack item){
        ItemMeta tMeta = item.getItemMeta();
        tMeta.setDisplayName(ChatColor.WHITE+"Динамит");
        ArrayList<String> tLore = new ArrayList<>();
        tLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TNT"));
        tLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TNT"));
        tLore.add(" ");
        tLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        tLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        tLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        tMeta.setLore(tLore);
        item.setItemMeta(tMeta);
    }

    private static void updateBrickEpicMeta(@NotNull ItemStack item){
        ItemMeta briMeta = item.getItemMeta();
        briMeta.setDisplayName(ChatColor.WHITE+"Кирпич");
        ArrayList<String> briLore = new ArrayList<>();
        briLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("BRICK"));
        briLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("BRICK"));
        briLore.add(" ");
        briLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        briLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        briLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        briMeta.setLore(briLore);
        item.setItemMeta(briMeta);
    }

    private static void updateNuggetEpicMeta(@NotNull ItemStack item){
        ItemMeta nMeta = item.getItemMeta();
        nMeta.setDisplayName(ChatColor.WHITE+"Кусочек золота");
        ArrayList<String> nLore = new ArrayList<>();
        nLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("GOLD_NUGGET"));
        nLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("GOLD_NUGGET"));
        nLore.add(" ");
        nLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        nLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        nLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        nMeta.setLore(nLore);
        item.setItemMeta(nMeta);
    }

    private static void updateZombieHeadEpicMeta(@NotNull ItemStack item){
        ItemMeta zMeta = item.getItemMeta();
        zMeta.setDisplayName(ChatColor.WHITE+"Голова зомби");
        ArrayList<String> zLore = new ArrayList<>();
        zLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("ZOMBIE_HEAD"));
        zLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("ZOMBIE_HEAD"));
        zLore.add(" ");
        zLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        zLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        zLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        zMeta.setLore(zLore);
        item.setItemMeta(zMeta);
    }

    private static void updateHeartEpicMeta(@NotNull ItemStack item){
        ItemMeta hMeta = item.getItemMeta();
        hMeta.setDisplayName(ChatColor.WHITE+"Сердце моря");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("HEART_OF_THE_SEA"));
        hLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("HEART_OF_THE_SEA"));
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        hLore.add(" ");
        hLore.add(ChatColor.GOLD+"Это особенный товар!");
        hLore.add(ChatColor.WHITE+"Снижение цены произойдет после 3-х");
        hLore.add(ChatColor.WHITE+"проданных ед. этого товара!");
        hLore.add(ChatColor.WHITE+"Продать можно "+ChatColor.RED+"только "+ChatColor.WHITE+"9 ед. этого товара.");
        hLore.add(ChatColor.WHITE+"Поспешите ;)");
        hLore.add(" ");
        hMeta.setLore(hLore);
        item.setItemMeta(hMeta);
    }

    private static void updateTotemEpicMeta(@NotNull ItemStack item){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE+"Тотем бессмертия");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("TOTEM_OF_UNDYING"));
        hLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("TOTEM_OF_UNDYING"));
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        meta.setLore(hLore);
        item.setItemMeta(meta);
    }

    private static void updateSculkEpicMeta(@NotNull ItemStack item){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE+"Скалк");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.YELLOW+"Цена за 1 штуку - "+ PriceManager.getCurrentPriceString("SCULK"));
        hLore.add(ChatColor.YELLOW+"Цена за 64 штуку - "
                +PriceManager.getCurrentPriceFor64String("SCULK"));
        hLore.add(" ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 1 ед. , нажмите ПКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать 64 ед. , нажмите ЛКМ");
        hLore.add(ChatColor.GRAY+"Чтобы продать всё, кликните и зажмите Shift");
        meta.setLore(hLore);
        item.setItemMeta(meta);
    }

    public static void setupStroke(){
        // item part
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
        if(MyTraderReloaded.getPlugin().StrokeMaterial() != null){
            try{
                item.setType(Material.valueOf(MyTraderReloaded.getPlugin().StrokeMaterial()));
            }catch (IllegalArgumentException lae){
                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                MyTraderReloaded.getPlugin().getLogger().
                        severe("Обводка не может быть выполнена," +
                                " т.к. вы указали не существующий материал.");
            }catch (NullPointerException npe){
                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                MyTraderReloaded.getPlugin().getLogger().
                        severe("Материал обводки не может отсутствовать!");
            }
        }
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        //List part
        List<Integer> ignore_list = new ArrayList<>();
        ignore_list.add(12);ignore_list.add(13);ignore_list.add(14);ignore_list.add(21);
        ignore_list.add(23);ignore_list.add(30);ignore_list.add(31);ignore_list.add(32);
        ignore_list.add(48);ignore_list.add(52);ignore_list.add(50);ignore_list.add(22);
        ignore_list.add(46);
        // cycle part
        for(int i = 0; i < 53; i++){
            if(ignore_list.contains(i)){continue;}

            inventory.setItem(i,item);
        }
    }

}

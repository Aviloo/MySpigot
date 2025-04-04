package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.concurrent.ConcurrentHashMap;

public class PriceManager {

    private static FileConfiguration settings =
            MyTraderReloaded.getPlugin().sellerSettingsFileManager.getSettingsSellerConfig();

    private static final ConcurrentHashMap<String,Integer> SoldQuantity = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Integer> BlockQuantity = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Double> CurrentPrice = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Double> StartingPrice = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Integer> StepQuantity = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Double> BlockTradePrice= new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Boolean> ProductBlockedBool = new ConcurrentHashMap<>();

    public static Boolean isProductBlocked(String ProductType){
        return ProductBlockedBool.get(ProductType);
    }

    public static Double getCurrentPrice(String ProductType){
        return CurrentPrice.get(ProductType);
    }

    public static String getCurrentPriceString(String ProductType){
        return String.format("%.3f",CurrentPrice.get(ProductType));
    }

    public static Double getCurrentPriceFor64(String ProductType){
        return (CurrentPrice.get(ProductType) * 64) + 9;
    }

    public static String getCurrentPriceFor64String(String ProductType){
        return String.format("%.3f",CurrentPrice.get(ProductType) * 64) + ChatColor.AQUA + "(+9)";
    }

    public static Boolean isQuantityBlocked(String ProductType){
        return SoldQuantity.get(ProductType) >= BlockQuantity.get(ProductType);
    }

    public static void addSoldQuantity(String ProductType,Integer count){
        SoldQuantity.put(ProductType,SoldQuantity.getOrDefault(ProductType,0)+count);
    }

    private static void priceSetUp(String ProductType,Double StartPrice,Integer NextStepQuantity,Integer StopTreadingQuantity){
        SoldQuantity.put(ProductType,0);
        StartingPrice.put(ProductType,StartPrice);
        CurrentPrice.put(ProductType,StartPrice);
        StepQuantity.put(ProductType,NextStepQuantity);
        BlockQuantity.put(ProductType,StopTreadingQuantity);
        ProductBlockedBool.put(ProductType,false);
        CurrentQuantityStage.put(ProductType,0);
    }

    public static void allProductSetUp(){ // todo использовать метод priceSetUp здесь
        //todo
        // Правила пользования методом:
        //1. NextStepQuantity при делении на StopTreadingQuantity НЕ ДОЛЖНО превышать 6 , иначе будут ошибки.
        //2. Быть внимательным с дублированием товаров , во избежание ошибок
        //3. Если ставить цену меньше 1 , то уменьшать кол-во продаж ,так как после 0.1 Vault перестанет
        // выдавать валюту!

        // тестовая версия
        priceSetUp("REDSTONE",settings.getDouble("REDSTONE.StartPrice"),settings.getInt("REDSTONE.NextStepQuantity"),settings.getInt("REDSTONE.StopTreadingQuantity"));
        priceSetUp("GUNPOWDER",settings.getDouble("GUNPOWDER.StartPrice"),settings.getInt("GUNPOWDER.NextStepQuantity"),settings.getInt("GUNPOWDER.StopTreadingQuantity"));
        priceSetUp("ROSE_BUSH",settings.getDouble("ROSE_BUSH.StartPrice"),settings.getInt("ROSE_BUSH.NextStepQuantity"),settings.getInt("ROSE_BUSH.StopTreadingQuantity"));
        priceSetUp("CLAY_BALL",settings.getDouble("CLAY_BALL.StartPrice"),settings.getInt("CLAY_BALL.NextStepQuantity"),settings.getInt("CLAY_BALL.StopTreadingQuantity"));
        priceSetUp("QUARTZ",settings.getDouble("QUARTZ.StartPrice"),settings.getInt("QUARTZ.NextStepQuantity"),settings.getInt("QUARTZ.StopTreadingQuantity"));
        priceSetUp("SUGAR_CANE",settings.getDouble("SUGAR_CANE.StartPrice"),settings.getInt("SUGAR_CANE.NextStepQuantity"),settings.getInt("SUGAR_CANE.StopTreadingQuantity"));
        priceSetUp("DEAD_BUSH",settings.getDouble("DEAD_BUSH.StartPrice"),settings.getInt("DEAD_BUSH.NextStepQuantity"),settings.getInt("DEAD_BUSH.StopTreadingQuantity"));
        priceSetUp("WHEAT",settings.getDouble("WHEAT.StartPrice"),settings.getInt("WHEAT.NextStepQuantity"),settings.getInt("WHEAT.StopTreadingQuantity"));
        priceSetUp("BLAZE_POWDER",settings.getDouble("BLAZE_POWDER.StartPrice"),settings.getInt("BLAZE_POWDER.NextStepQuantity"),settings.getInt("BLAZE_POWDER.StopTreadingQuantity"));

        priceSetUp("APPLE",settings.getDouble("APPLE.StartPrice"),settings.getInt("APPLE.NextStepQuantity"),settings.getInt("APPLE.StopTreadingQuantity"));
        priceSetUp("SUGAR",settings.getDouble("SUGAR.StartPrice"),settings.getInt("SUGAR.NextStepQuantity"),settings.getInt("SUGAR.StopTreadingQuantity"));
        priceSetUp("DRAGON_BREATH",settings.getDouble("DRAGON_BREATH.StartPrice"),settings.getInt("DRAGON_BREATH.NextStepQuantity"),settings.getInt("DRAGON_BREATH.StopTreadingQuantity"));
        priceSetUp("PHANTOM_MEMBRANE",settings.getDouble("PHANTOM_MEMBRANE.StartPrice"),settings.getInt("PHANTOM_MEMBRANE.NextStepQuantity"),settings.getInt("PHANTOM_MEMBRANE.StopTreadingQuantity"));
        priceSetUp("MELON_SLICE",settings.getDouble("MELON_SLICE.StartPrice"),settings.getInt("MELON_SLICE.NextStepQuantity"),settings.getInt("MELON_SLICE.StopTreadingQuantity"));
        priceSetUp("GLASS_BOTTLE",settings.getDouble("GLASS_BOTTLE.StartPrice"),settings.getInt("GLASS_BOTTLE.NextStepQuantity"),settings.getInt("GLASS_BOTTLE.StopTreadingQuantity"));
        priceSetUp("INK_SAC",settings.getDouble("INK_SAC.StartPrice"),settings.getInt("INK_SAC.NextStepQuantity"),settings.getInt("INK_SAC.StopTreadingQuantity"));
        priceSetUp("SWEET_BERRIES",settings.getDouble("SWEET_BERRIES.StartPrice"),settings.getInt("SWEET_BERRIES.NextStepQuantity"),settings.getInt("SWEET_BERRIES.StopTreadingQuantity"));
        priceSetUp("WHEAT_SEEDS",settings.getDouble("WHEAT_SEEDS.StartPrice"),settings.getInt("WHEAT_SEEDS.NextStepQuantity"),settings.getInt("WHEAT_SEEDS.StopTreadingQuantity"));

        priceSetUp("COOKED_COD",settings.getDouble("COOKED_COD.StartPrice"),settings.getInt("COOKED_COD.NextStepQuantity"),settings.getInt("COOKED_COD.StopTreadingQuantity"));
        priceSetUp("SPIDER_EYE",settings.getDouble("SPIDER_EYE.StartPrice"),settings.getInt("SPIDER_EYE.NextStepQuantity"),settings.getInt("SPIDER_EYE.StopTreadingQuantity"));
        priceSetUp("COBBLESTONE",settings.getDouble("COBBLESTONE.StartPrice"),settings.getInt("COBBLESTONE.NextStepQuantity"),settings.getInt("COBBLESTONE.StopTreadingQuantity"));
        priceSetUp("MAGMA_BLOCK",settings.getDouble("MAGMA_BLOCK.StartPrice"),settings.getInt("MAGMA_BLOCK.NextStepQuantity"),settings.getInt("MAGMA_BLOCK.StopTreadingQuantity"));
        priceSetUp("STRING",settings.getDouble("STRING.StartPrice"),settings.getInt("STRING.NextStepQuantity"),settings.getInt("STRING.StopTreadingQuantity"));
        priceSetUp("SAND",settings.getDouble("SAND.StartPrice"),settings.getInt("SAND.NextStepQuantity"),settings.getInt("SAND.StopTreadingQuantity"));
        priceSetUp("COAL",settings.getDouble("COAL.StartPrice"),settings.getInt("COAL.NextStepQuantity"),settings.getInt("COAL.StopTreadingQuantity"));
        priceSetUp("ARROW",settings.getDouble("ARROW.StartPrice"),settings.getInt("ARROW.NextStepQuantity"),settings.getInt("ARROW.StopTreadingQuantity"));

        priceSetUp("ROTTEN_FLESH",settings.getDouble("ROTTEN_FLESH.StartPrice"),settings.getInt("ROTTEN_FLESH.NextStepQuantity"),settings.getInt("ROTTEN_FLESH.StopTreadingQuantity"));
        priceSetUp("DRIED_KELP",settings.getDouble("DRIED_KELP.StartPrice"),settings.getInt("DRIED_KELP.NextStepQuantity"),settings.getInt("DRIED_KELP.StopTreadingQuantity"));
        priceSetUp("WARPED_PLANKS",settings.getDouble("WARPED_PLANKS.StartPrice"),settings.getInt("WARPED_PLANKS.NextStepQuantity"),settings.getInt("WARPED_PLANKS.StopTreadingQuantity"));
        priceSetUp("HONEY_BOTTLE",settings.getDouble("HONEY_BOTTLE.StartPrice"),settings.getInt("HONEY_BOTTLE.NextStepQuantity"),settings.getInt("HONEY_BOTTLE.StopTreadingQuantity"));
        priceSetUp("RAIL",settings.getDouble("RAIL.StartPrice"),settings.getInt("RAIL.NextStepQuantity"),settings.getInt("RAIL.StopTreadingQuantity"));
        priceSetUp("SHULKER_SHELL",settings.getDouble("SHULKER_SHELL.StartPrice"),settings.getInt("SHULKER_SHELL.NextStepQuantity"),settings.getInt("SHULKER_SHELL.StopTreadingQuantity"));
        priceSetUp("BONE",settings.getDouble("BONE.StartPrice"),settings.getInt("BONE.NextStepQuantity"),settings.getInt("BONE.StopTreadingQuantity"));
        priceSetUp("COPPER_BLOCK",settings.getDouble("COPPER_BLOCK.StartPrice"),settings.getInt("COPPER_BLOCK.NextStepQuantity"),settings.getInt("COPPER_BLOCK.StopTreadingQuantity"));

        priceSetUp("DIORITE_STAIRS",settings.getDouble("DIORITE_STAIRS.StartPrice"),settings.getInt("DIORITE_STAIRS.NextStepQuantity"),settings.getInt("DIORITE_STAIRS.StopTreadingQuantity"));
        priceSetUp("SALMON",settings.getDouble("SALMON.StartPrice"),settings.getInt("SALMON.NextStepQuantity"),settings.getInt("SALMON.StopTreadingQuantity"));
        priceSetUp("PUFFERFISH",settings.getDouble("PUFFERFISH.StartPrice"),settings.getInt("PUFFERFISH.NextStepQuantity"),settings.getInt("PUFFERFISH.StopTreadingQuantity"));
        priceSetUp("TROPICAL_FISH",settings.getDouble("TROPICAL_FISH.StartPrice"),settings.getInt("TROPICAL_FISH.NextStepQuantity"),settings.getInt("TROPICAL_FISH.StopTreadingQuantity"));
        priceSetUp("BOWL",settings.getDouble("BOWL.StartPrice"),settings.getInt("BOWL.NextStepQuantity"),settings.getInt("BOWL.StopTreadingQuantity"));
        priceSetUp("LEATHER",settings.getDouble("LEATHER.StartPrice"),settings.getInt("LEATHER.NextStepQuantity"),settings.getInt("LEATHER.StopTreadingQuantity"));
        priceSetUp("MOSS_BLOCK",settings.getDouble("MOSS_BLOCK.StartPrice"),settings.getInt("MOSS_BLOCK.NextStepQuantity"),settings.getInt("MOSS_BLOCK.StopTreadingQuantity"));
        priceSetUp("TUBE_CORAL",settings.getDouble("TUBE_CORAL.StartPrice"),settings.getInt("TUBE_CORAL.NextStepQuantity"),settings.getInt("TUBE_CORAL.StopTreadingQuantity"));

        priceSetUp("DIAMOND",settings.getDouble("DIAMOND.StartPrice"),settings.getInt("DIAMOND.NextStepQuantity"),settings.getInt("DIAMOND.StopTreadingQuantity"));
        priceSetUp("BLAZE_ROD",settings.getDouble("BLAZE_ROD.StartPrice"),settings.getInt("BLAZE_ROD.NextStepQuantity"),settings.getInt("BLAZE_ROD.StopTreadingQuantity"));
        priceSetUp("TNT",settings.getDouble("TNT.StartPrice"),settings.getInt("TNT.NextStepQuantity"),settings.getInt("TNT.StopTreadingQuantity"));
        priceSetUp("BRICK",settings.getDouble("BRICK.StartPrice"),settings.getInt("BRICK.NextStepQuantity"),settings.getInt("BRICK.StopTreadingQuantity"));
        priceSetUp("GOLD_NUGGET",settings.getDouble("GOLD_NUGGET.StartPrice"),settings.getInt("GOLD_NUGGET.NextStepQuantity"),settings.getInt("GOLD_NUGGET.StopTreadingQuantity"));
        priceSetUp("ZOMBIE_HEAD",settings.getDouble("ZOMBIE_HEAD.StartPrice"),settings.getInt("ZOMBIE_HEAD.NextStepQuantity"),settings.getInt("ZOMBIE_HEAD.StopTreadingQuantity"));
        priceSetUp("HEART_OF_THE_SEA",settings.getDouble("HEART_OF_THE_SEA.StartPrice"),settings.getInt("HEART_OF_THE_SEA.NextStepQuantity"),settings.getInt("HEART_OF_THE_SEA.StopTreadingQuantity"));
        priceSetUp("TOTEM_OF_UNDYING",settings.getDouble("TOTEM_OF_UNDYING.StartPrice"),settings.getInt("TOTEM_OF_UNDYING.NextStepQuantity"),settings.getInt("TOTEM_OF_UNDYING.StopTreadingQuantity"));
        priceSetUp("SCULK",settings.getDouble("SCULK.StartPrice"),settings.getInt("SCULK.NextStepQuantity"),settings.getInt("SCULK.StopTreadingQuantity"));
    }

    public static void priceChecker(String ProductType){
        checkSteps(ProductType,StepQuantity.get(ProductType));
        //Проверка! SoldQuantity делиться на StepQuantity без остатка
        /*
        if(SoldQuantity.get(ProductType) % StepQuantity.get(ProductType) == 0){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
        }
         */
    }

    //Показывает этап на котором находиться товар
    private final static ConcurrentHashMap<String,Integer> CurrentQuantityStage = new ConcurrentHashMap<>();

    private static void checkSteps(String ProductType,Integer OneStepQuantity){
        //Проверка! Достигла ли цена минимума
        if(SoldQuantity.get(ProductType).equals(BlockQuantity.get(ProductType))){
            ProductBlockedBool.put(ProductType,true);
            return;
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity && SoldQuantity.get(ProductType) < OneStepQuantity*2){
            if(CurrentQuantityStage.get(ProductType) == 0){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,1);
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*2 && SoldQuantity.get(ProductType) < OneStepQuantity*3){
            if(CurrentQuantityStage.get(ProductType) == 1){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,2);
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*3 && SoldQuantity.get(ProductType) < OneStepQuantity*4){
            if(CurrentQuantityStage.get(ProductType) == 2){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,3);
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*4 && SoldQuantity.get(ProductType) < OneStepQuantity*5){
            if(CurrentQuantityStage.get(ProductType) == 3){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,4);
                return;
            }
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*5 && SoldQuantity.get(ProductType) < OneStepQuantity*6){
            if(CurrentQuantityStage.get(ProductType) == 4){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,5);
            }
        }
    }

    public static int getProductAmountLeft(String ProductType){
        return BlockQuantity.get(ProductType) - SoldQuantity.get(ProductType);
    }

    // Товары за репутацию
    private static ConcurrentHashMap<String,Double> PriceReputation = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Integer> NeedReputation = new ConcurrentHashMap<>();

    private static void setReputationProduct(String ProductType,Double Price,Integer reputation){
        PriceReputation.put(ProductType,Price);
        NeedReputation.put(ProductType,reputation);
    }

    public static void allReputationProductsSetUp(){
        setReputationProduct("GOLD_NUGGET_R",settings.getDouble("GOLD_NUGGET_R.Price"),settings.getInt("GOLD_NUGGET_R.NeedRep"));
        setReputationProduct("WHEAT_R",settings.getDouble("WHEAT_R.Price"),settings.getInt("WHEAT_R.NeedRep"));
        setReputationProduct("LAPIS_LAZULI_R",settings.getDouble("LAPIS_LAZULI_R.Price"),settings.getInt("LAPIS_LAZULI_R.NeedRep"));
        setReputationProduct("TOTEM_OF_UNDYING_R",settings.getDouble("TOTEM_OF_UNDYING_R.Price"),settings.getInt("TOTEM_OF_UNDYING_R.NeedRep"));
        setReputationProduct("CAKE_R",settings.getDouble("CAKE_R.Price"),settings.getInt("CAKE_R.NeedRep"));
        setReputationProduct("DIAMOND_ORE_R",settings.getDouble("DIAMOND_ORE_R.Price"),settings.getInt("DIAMOND_ORE_R.NeedRep"));
    }

    public static double getPriceReputation(String ProductType){
        return PriceReputation.get(ProductType);
    }
    public static double getPriceReputation64(String ProductType){
        return PriceReputation.get(ProductType) * 64;
    }
    public static int getNeedReputation(String ProductType){
        return NeedReputation.get(ProductType);
    }
}

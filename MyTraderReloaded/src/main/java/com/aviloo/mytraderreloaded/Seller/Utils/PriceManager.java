package com.aviloo.mytraderreloaded.Seller.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.concurrent.ConcurrentHashMap;

public class PriceManager {

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
        // screen 1
        priceSetUp("REDSTONE",3.0,100,150);
        priceSetUp("GUNPOWDER",5.0,100,150);
        priceSetUp("ROSE_BUSH",3.5,100,150);
        priceSetUp("CLAY_BALL",2.4,100,150);
        priceSetUp("QUARTZ",1.5,100,150);
        priceSetUp("SUGAR_CANE",2.1,100,150);
        priceSetUp("DEAD_BUSH",5.1,100,150);
        priceSetUp("WHEAT",2.1,100,150);
        priceSetUp("BLAZE_POWDER",7.3,100,150);
        //screen 2
        priceSetUp("APPLE",4.3,100,150);
        priceSetUp("SUGAR",5.1,100,150);
        priceSetUp("DRAGON_BREATH",24.0,100,150);
        priceSetUp("PHANTOM_MEMBRANE",15.0,40,109);
        priceSetUp("MELON_SLICE",3.3,100,150);
        priceSetUp("GLASS_BOTTLE",2.5,100,150);
        priceSetUp("INK_SAC",2.7,100,150);
        priceSetUp("SWEET_BERRIES",2.4,100,150);
        priceSetUp("WHEAT_SEEDS",2.4,100,150);
        //screen 3
        priceSetUp("COOKED_COD",3.3,100,150);
        priceSetUp("SPIDER_EYE",5.1,100,150);
        priceSetUp("COBBLESTONE",0.5,100,150);
        priceSetUp("MAGMA_BLOCK",1.5,100,150);
        priceSetUp("STRING",1.9,100,150);
        priceSetUp("SAND",0.4,100,150);
        priceSetUp("COAL",1.0,100,150);
        priceSetUp("ARROW",4.3,100,150);
        //screen 4
        priceSetUp("ROTTEN_FLESH",1.9,100,150);
        priceSetUp("DRIED_KELP",2.5,100,150);
        priceSetUp("WARPED_PLANKS",1.9,100,150);
        priceSetUp("HONEY_BOTTLE",5.0,100,150);
        priceSetUp("RAIL",2.7,100,150);
        priceSetUp("SHULKER_SHELL",6.0,100,150);
        priceSetUp("BONE",1.1,100,150);
        priceSetUp("COPPER_BLOCK",3.3,100,150);
        //screen 5
        priceSetUp("DIORITE_STAIRS",1.8,100,150);
        priceSetUp("SALMON",2.7,100,150);
        priceSetUp("PUFFERFISH",3.1,100,150);
        priceSetUp("TROPICAL_FISH",3.9,100,150);
        priceSetUp("BOWL",0.5,40,90);
        priceSetUp("LEATHER",2.9,100,150);
        priceSetUp("MOSS_BLOCK",1.6,100,150);
        priceSetUp("TUBE_CORAL",3.0,100,150);
        //screen E
        priceSetUp("DIAMOND",7.0,100,150);
        priceSetUp("BLAZE_ROD",4.1,100,150);
        priceSetUp("TNT",5.8,100,150);
        priceSetUp("DRAGON_BREATH",30.0,30,100);//TODO Есть дубликат
        priceSetUp("BRICK",3.1,100,150);
        priceSetUp("GOLD_NUGGET",2.5,100,150);
        priceSetUp("ZOMBIE_HEAD",51.5,100,150);
        priceSetUp("SHULKER_SHELL",17.1,100,150);// TODO Есть дубликат
        priceSetUp("HEART_OF_THE_SEA",330.0,3,9);
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
                //debug
                Bukkit.getConsoleSender().sendMessage("1");
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*2 && SoldQuantity.get(ProductType) < OneStepQuantity*3){
            if(CurrentQuantityStage.get(ProductType) == 1){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,2);
                //debug
                Bukkit.getConsoleSender().sendMessage("2");
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*3 && SoldQuantity.get(ProductType) < OneStepQuantity*4){
            if(CurrentQuantityStage.get(ProductType) == 2){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,3);
                //debug
                Bukkit.getConsoleSender().sendMessage("3");
                return;
            }

        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*4 && SoldQuantity.get(ProductType) < OneStepQuantity*5){
            if(CurrentQuantityStage.get(ProductType) == 3){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,4);
                //debug
                Bukkit.getConsoleSender().sendMessage("4");
                return;
            }
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*5 && SoldQuantity.get(ProductType) < OneStepQuantity*6){
            if(CurrentQuantityStage.get(ProductType) == 4){
                double NewPrice = CurrentPrice.get(ProductType) * 0.6;
                CurrentPrice.put(ProductType,NewPrice);
                CurrentQuantityStage.put(ProductType,5);
                //debug
                Bukkit.getConsoleSender().sendMessage("5");
                return;
            }
        }
    }

}

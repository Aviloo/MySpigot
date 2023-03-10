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

    public static Double getCurrentPriceFor64(String ProductType){
        return (CurrentPrice.get(ProductType) * 64) + 9;
    }

    public static String getCurrentPriceFor64String(String ProductType){
        String price = String.valueOf(CurrentPrice.get(ProductType) * 64);
        return price + ChatColor.AQUA + "(+9)";
    }

    public static Boolean isQuantityBlocked(String ProductType){
        if(SoldQuantity.get(ProductType).equals(BlockQuantity.get(ProductType))){
            return true;
        }
        return false;
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

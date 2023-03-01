package com.aviloo.mytraderreloaded.Seller.Utils;

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
    }

    public static void allProductSetUp(){ // todo использовать метод priceSetUp здесь
        priceSetUp("REDSTONE",3.0,500,1100); // тестовая версия
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
        //Проверка! Достигла ли цена минимума
        if(SoldQuantity.get(ProductType).equals(BlockQuantity.get(ProductType))){
            ProductBlockedBool.put(ProductType,true);
        }
    }

    private static void checkSteps(String ProductType,Integer OneStepQuantity){
        if(SoldQuantity.get(ProductType) >= OneStepQuantity && SoldQuantity.get(ProductType) < OneStepQuantity*2){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
            return;
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*2 && SoldQuantity.get(ProductType) < OneStepQuantity*3){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
            return;
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*3 && SoldQuantity.get(ProductType) < OneStepQuantity*4){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
            return;
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*4 && SoldQuantity.get(ProductType) < OneStepQuantity*5){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
            return;
        }
        if(SoldQuantity.get(ProductType) >= OneStepQuantity*5 && SoldQuantity.get(ProductType) < OneStepQuantity*6){
            double NewPrice = CurrentPrice.get(ProductType) * 0.6;
            CurrentPrice.put(ProductType,NewPrice);
            return;
        }
    }
}

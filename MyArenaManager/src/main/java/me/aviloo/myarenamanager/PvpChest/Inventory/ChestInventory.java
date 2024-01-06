package me.aviloo.myarenamanager.PvpChest.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class ChestInventory {



    private static int InventorySlotsCount = 45;

    private static ArrayList<ItemStack> loot = new ArrayList<>();

    public static Inventory inv = Bukkit.createInventory(null,InventorySlotsCount,
            ChatColor.DARK_GRAY+"Сундук арены");

    public static Inventory getInv(){

        addLootInChest(inv);

        return inv;
    }

    public static ArrayList<ItemStack> generatedLoot = new ArrayList<>();

    public static void generateLootForInventory(){
        for (int i = 0; i < InventorySlotsCount; i++) {
            // Создаем генератор случайных чисел
            Random random = new Random();

            // Генерируем случайный индекс в пределах размера ArrayList
            int randomIndex = random.nextInt(loot.size());

            generatedLoot.add(loot.get(randomIndex));
        }
    }

    public static void clearGeneratedLoot(){
        generatedLoot.clear();
    }

    public static void addLootInChest(Inventory inv){
        for (int i = 0; i < InventorySlotsCount; i++) {
            inv.setItem(i,generatedLoot.get(i));
        }
    }

    public static void clearChestInventory(Inventory inv){
        for(int i = 0; i < InventorySlotsCount; i++){
            inv.setItem(i,new ItemStack(Material.AIR));
        }
    }


    public static void addLootInStaticList(){
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));

        loot.add(new ItemStack(Material.DIAMOND,9));
        loot.add(new ItemStack(Material.NETHERITE_INGOT,1));
        loot.add(new ItemStack(Material.WHEAT,64));
        loot.add(new ItemStack(Material.EMERALD_ORE,1));
        loot.add(new ItemStack(Material.BOOKSHELF,9));
        loot.add(new ItemStack(Material.NETHERITE_HELMET,1));
        loot.add(new ItemStack(Material.AXOLOTL_SPAWN_EGG,1));
        loot.add(new ItemStack(Material.CREEPER_SPAWN_EGG,1));
        loot.add(new ItemStack(Material.DIAMOND,17));
        loot.add(new ItemStack(Material.VILLAGER_SPAWN_EGG,1));
        loot.add(new ItemStack(Material.EXPERIENCE_BOTTLE,41));
        loot.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,3));
        loot.add(new ItemStack(Material.TOTEM_OF_UNDYING,1));
        loot.add(new ItemStack(Material.ANVIL,1));
        loot.add(new ItemStack(Material.SHIELD,1));
        loot.add(new ItemStack(Material.ENDER_CHEST,1));
        loot.add(new ItemStack(Material.DIAMOND,5));
        loot.add(new ItemStack(Material.DIAMOND,31));
        loot.add(new ItemStack(Material.DIAMOND,1));
        loot.add(new ItemStack(Material.ANCIENT_DEBRIS,5));
        loot.add(new ItemStack(Material.ANCIENT_DEBRIS,3));
        loot.add(new ItemStack(Material.ANCIENT_DEBRIS,7));
        loot.add(new ItemStack(Material.LEATHER,60));
        loot.add(new ItemStack(Material.COOKED_BEEF,35));
        loot.add(new ItemStack(Material.COOKED_CHICKEN,17));
        loot.add(new ItemStack(Material.GOLDEN_APPLE,9));
        loot.add(new ItemStack(Material.EMERALD,18));
        loot.add(new ItemStack(Material.EMERALD_BLOCK,3));
        loot.add(new ItemStack(Material.DEEPSLATE_EMERALD_ORE,5));

        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));


        //Special items
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL,4,false);
        swordMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS,1,true);
        swordMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        sword.setItemMeta(swordMeta);
        loot.add(sword);

        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE,1);
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED,5,true);
        pickaxeMeta.addEnchant(Enchantment.SILK_TOUCH,1,false);
        pickaxeMeta.addEnchant(Enchantment.DURABILITY,3,true);
        pickaxe.setItemMeta(pickaxeMeta);
        loot.add(pickaxe);

        ItemStack axe = new ItemStack(Material.DIAMOND_AXE,1);
        ItemMeta axeMeta = axe.getItemMeta();
        axeMeta.addEnchant(Enchantment.DURABILITY,3,true);
        axeMeta.addEnchant(Enchantment.DIG_SPEED,3,true);
        axeMeta.addEnchant(Enchantment.DAMAGE_ALL,3,true);
        axe.setItemMeta(axeMeta);
        loot.add(axe);

        ItemStack hoe = new ItemStack(Material.NETHERITE_HOE,1);
        ItemMeta hoeMeta = hoe.getItemMeta();
        hoeMeta.addEnchant(Enchantment.KNOCKBACK,3,true);
        hoeMeta.addEnchant(Enchantment.DURABILITY,3,true);
        hoeMeta.addEnchant(Enchantment.LUCK,3,true);
        hoeMeta.addEnchant(Enchantment.DIG_SPEED,5,true);
        hoe.setItemMeta(hoeMeta);
        loot.add(hoe);

        //Potion
        ItemStack speed = new ItemStack(Material.POTION,3);
        PotionMeta speedMeta = (PotionMeta) speed.getItemMeta();
        speedMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED,3900,3),true);
        speed.setItemMeta(speedMeta);
        loot.add(speed);

        ItemStack resist = new ItemStack(Material.POTION,1);
        PotionMeta resistMeta = (PotionMeta) resist.getItemMeta();
        resistMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,6000,1),true);
        resistMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION,1000,1),true);
        resistMeta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION,700,1),true);
        resist.setItemMeta(resistMeta);
        loot.add(resist);

        ItemStack vision = new ItemStack(Material.POTION,1);
        PotionMeta visionMeta = (PotionMeta) speed.getItemMeta();
        visionMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,7000,1),true);
        visionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY,7000,1),true);
        visionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,7000,1),true);
        vision.setItemMeta(visionMeta);
        loot.add(vision);

        //Donate Coins
        ItemStack DonateThree = new ItemStack(Material.GOLD_NUGGET,3);
        ItemMeta donateThreeMeta = DonateThree.getItemMeta();
        donateThreeMeta.setDisplayName(ChatColor.GOLD+"+3 донат-валюты");
        DonateThree.setItemMeta(donateThreeMeta);
        loot.add(DonateThree);

        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
        loot.add(new ItemStack(Material.AIR));
    }

}


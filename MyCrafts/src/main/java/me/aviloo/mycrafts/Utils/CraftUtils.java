package me.aviloo.mycrafts.Utils;

import me.aviloo.mycrafts.Items.EnchantedManager;
import me.aviloo.mycrafts.Items.SphereManager;
import me.aviloo.mycrafts.Items.TNTManager;
import me.aviloo.mycrafts.Items.TotemsManager;
import me.aviloo.mycrafts.Items.Trap.TrapManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class CraftUtils {

    public static void init(){
        setUpChanceOfCraft();
        setUpPriceOfCraft();
        setUpIngredientsOfItems();
    }

    private static final LinkedHashMap<UUID, ItemStack> selectedItems = new LinkedHashMap<>();

    public static void setSelectedItem(Player player, ItemStack item) {
        selectedItems.put(player.getUniqueId(), item);
    }

    public static ItemStack getSelectedItem(Player player) {
        return selectedItems.getOrDefault(player.getUniqueId(), null);
    }

    public static String getSelectedItemName(Player player) {
        if(selectedItems.get(player.getUniqueId()) == null){return "Отсутствует";}
        return selectedItems.get(player.getUniqueId()).getItemMeta().getDisplayName();
    }

    private static final HashMap<Material, Double> priceOfCraft = new HashMap<>();

    public static double getPriceOfCraft(Material material) {
        return priceOfCraft.getOrDefault(material, 0.0);
    }
    public static void setUpPriceOfCraft() {
        priceOfCraft.put(Material.TOTEM_OF_UNDYING,1000.0);
        priceOfCraft.put(Material.PLAYER_HEAD,2000.0);
        priceOfCraft.put(Material.ENCHANTED_BOOK,700.0);
        priceOfCraft.put(Material.NETHERITE_SCRAP,500.0);
        priceOfCraft.put(Material.TNT,500.0);
    }

    private static final HashMap<Material, Integer> chancesOfCrafts = new HashMap<>();

    public static int getChanceOfCraft(Material material) {
        return chancesOfCrafts.getOrDefault(material, 0);
    }

    private static void setUpChanceOfCraft() {
        chancesOfCrafts.put(Material.TOTEM_OF_UNDYING, 1);
        chancesOfCrafts.put(Material.PLAYER_HEAD, 1);
        chancesOfCrafts.put(Material.ENCHANTED_BOOK,5);
        chancesOfCrafts.put(Material.NETHERITE_SCRAP,50);
        chancesOfCrafts.put(Material.TNT,60);
    }

    private static final HashMap<ItemStack, Set<ItemStack>> ingredientsOfItems = new HashMap<>();
    private static Set<ItemStack> getIngredientsOfItems(ItemStack item) {
        return ingredientsOfItems.getOrDefault(item, null);
    }


    public static void craft(Player player) {
        if(selectedItems.get(player.getUniqueId()) == null){
            player.closeInventory();
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&7[&6Крафты&7] &fВы не выбрали предмет, который хотите скрафтить."));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,5,0);
            return;
        }
        if(getPriceOfCraft(getSelectedItem(player).getType()) >
                EconomyManager.getMoney(player)){
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&7[&6Крафты&7] &fУ вас недостаточно средств."));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,5,0);
            player.closeInventory();
            return;
        }
        if(!isPlayerHasIngredients(player)){
            player.sendMessage(ColorUtils.translateColorCodes(
                    "&7[&6Крафты&7] &fУ вас недостаточно ресурсов."));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,5,0);
            player.closeInventory();
            return;
        }

        removeIngredientsFromInventory(player);
        EconomyManager.takeMoney(player,getPriceOfCraft(getSelectedItem(player).getType()));
        if(!player.hasPermission("mycrafts.chancex2")) {
            if (Math.random() < 1.0 - getChanceOfCraft(
                    selectedItems.get(player.getUniqueId()).getType()) * 0.01) {
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&7[&6Крафты&7] &cНеудача"));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT,
                        5, 0);
                return;
            } else {
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&7[&6Крафты&7] &aУспешно!"));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES,
                        5, 0);
                player.getInventory().addItem(selectedItems.get(player.getUniqueId()));
            }
        }
        if(player.hasPermission("mycrafts.chancex2")) {
            if (Math.random() < 1.0 - getChanceOfCraft(
                    selectedItems.get(player.getUniqueId()).getType()) * 0.02) {
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&7[&6Крафты&7] &cНеудача"));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT,
                        5, 0);
            } else {
                player.sendMessage(ColorUtils.translateColorCodes(
                        "&7[&6Крафты&7] &aУспешно!"));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES,
                        5, 0);
                player.getInventory().addItem(selectedItems.get(player.getUniqueId()));
            }
        }

    }

    public static void getCraftLore(Player player, ArrayList<String> lore) {
        lore.add(" ");
        lore.add(ColorUtils.translateColorCodes("&7Выбранный предмет: "
                + getSelectedItem(player).getItemMeta().getDisplayName()));
        lore.add(ColorUtils.translateColorCodes("&7Шанс крафта: &6" +
                getChanceOfCraft(getSelectedItem(player).getType()) + "&f%"));
        lore.add(ColorUtils.translateColorCodes("&7Стоимость: &6" +
                getPriceOfCraft(getSelectedItem(player).getType()) + "&f Монет"));
        lore.add(" ");
    }

    private static boolean isPlayerHasIngredients(Player player) {
       for(ItemStack items : ingredientsOfItems.get(getSelectedItem(player))) {
           if(!player.getInventory().contains(items.getType(),items.getAmount())) {
               return false;
           }

       }
        return true;
    }
    private static void removeIngredientsFromInventory(Player player) {
        for(ItemStack items : ingredientsOfItems.get(getSelectedItem(player))) {
            player.getInventory().removeItem(items);
        }
    }

    private static void setUpIngredientsOfItems() {
        //TotemOfAgility
        Set<ItemStack> ingredientsTotemOfAgility = new HashSet<>();
        ingredientsTotemOfAgility.add(new ItemStack(Material.TOTEM_OF_UNDYING,1));
        ingredientsTotemOfAgility.add(new ItemStack(Material.RABBIT_FOOT,5));
        ingredientsTotemOfAgility.add(new ItemStack(Material.SUGAR,16));
        ingredientsTotemOfAgility.add(new ItemStack(Material.ECHO_SHARD,3));
        ingredientsOfItems.put(TotemsManager.getTotemOfAgility(), ingredientsTotemOfAgility);
        //TotemOfStrength
        Set<ItemStack> ingredientsTotemOfStrength = new HashSet<>();
        ingredientsTotemOfStrength.add(new ItemStack(Material.TOTEM_OF_UNDYING,1));
        ingredientsTotemOfStrength.add(new ItemStack(Material.REDSTONE,21));
        ingredientsTotemOfStrength.add(new ItemStack(Material.IRON_INGOT,7));
        ingredientsTotemOfStrength.add(new ItemStack(Material.FERMENTED_SPIDER_EYE,2));
        ingredientsTotemOfStrength.add(new ItemStack(Material.SUGAR,8));
        ingredientsOfItems.put(TotemsManager.getTotemOfStrength(), ingredientsTotemOfStrength);
        //TotemOfPower
        Set<ItemStack> ingredientsTotemOfPower = new HashSet<>();
        ingredientsTotemOfPower.add(new ItemStack(Material.TOTEM_OF_UNDYING,1));
        ingredientsTotemOfPower.add(new ItemStack(Material.IRON_INGOT,7));
        ingredientsTotemOfPower.add(new ItemStack(Material.SLIME_BALL,3));
        ingredientsTotemOfPower.add(new ItemStack(Material.EGG,6));
        ingredientsOfItems.put(TotemsManager.getTotemOfPower(), ingredientsTotemOfPower);
        //SphereOfOcean
        Set<ItemStack> ingredientsSphereOfOcean = new HashSet<>();
        ingredientsSphereOfOcean.add(new ItemStack(Material.HEART_OF_THE_SEA,1));
        ingredientsSphereOfOcean.add(new ItemStack(Material.IRON_INGOT,3));
        ingredientsSphereOfOcean.add(new ItemStack(Material.GLISTERING_MELON_SLICE,4));
        ingredientsSphereOfOcean.add(new ItemStack(Material.FERMENTED_SPIDER_EYE,5));
        ingredientsSphereOfOcean.add(new ItemStack(Material.SLIME_BALL,7));
        ingredientsSphereOfOcean.add(new ItemStack(Material.GLOW_INK_SAC,4));
        ingredientsOfItems.put(SphereManager.getSphereOcean(), ingredientsSphereOfOcean);
        //SphereOfNether
        Set<ItemStack> ingredientsSphereOfNether = new HashSet<>();
        ingredientsSphereOfNether.add(new ItemStack(Material.NETHERITE_INGOT,1));
        ingredientsSphereOfNether.add(new ItemStack(Material.BLAZE_POWDER,9));
        ingredientsSphereOfNether.add(new ItemStack(Material.SLIME_BALL,3));
        ingredientsSphereOfNether.add(new ItemStack(Material.GHAST_TEAR,1));
        ingredientsSphereOfNether.add(new ItemStack(Material.SUGAR,3));
        ingredientsSphereOfNether.add(new ItemStack(Material.RABBIT_FOOT,1));
        ingredientsOfItems.put(SphereManager.getSphereNether(), ingredientsSphereOfNether);
        //SphereOfEnd
        Set<ItemStack> ingredientsSphereOfEnd = new HashSet<>();
        ingredientsSphereOfEnd.add(new ItemStack(Material.ENDER_EYE,3));
        ingredientsSphereOfEnd.add(new ItemStack(Material.CHORUS_FRUIT,6));
        ingredientsSphereOfEnd.add(new ItemStack(Material.AMETHYST_SHARD,7));
        ingredientsSphereOfEnd.add(new ItemStack(Material.GLOWSTONE_DUST,6));
        ingredientsSphereOfEnd.add(new ItemStack(Material.SUGAR,15));
        ingredientsSphereOfEnd.add(new ItemStack(Material.FERMENTED_SPIDER_EYE,3));
        ingredientsOfItems.put(SphereManager.getSphereEnd(), ingredientsSphereOfEnd);
        //Trap
        Set<ItemStack> ingredientsTrap = new HashSet<>();
        ingredientsTrap.add(new ItemStack(Material.OBSIDIAN,8));
        ingredientsTrap.add(new ItemStack(Material.IRON_INGOT,5));
        ingredientsTrap.add(new ItemStack(Material.ENDER_PEARL,2));
        ingredientsTrap.add(new ItemStack(Material.BLAZE_ROD,1));
        ingredientsOfItems.put(TrapManager.Trap, ingredientsTrap);
        //DamageBook
        Set<ItemStack> ingredientsDamageBook = new HashSet<>();
        ingredientsDamageBook.add(new ItemStack(Material.BOOKSHELF,3));
        ingredientsDamageBook.add(new ItemStack(Material.EMERALD,2));
        ingredientsDamageBook.add(new ItemStack(Material.LAPIS_LAZULI,7));
        ingredientsDamageBook.add(new ItemStack(Material.DIAMOND,8));
        ingredientsOfItems.put(EnchantedManager.getDamageBook(), ingredientsDamageBook);
        //DigSpeedBook
        Set<ItemStack> ingredientsDigSpeedBook = new HashSet<>();
        ingredientsDigSpeedBook.add(new ItemStack(Material.BOOKSHELF,3));
        ingredientsDigSpeedBook.add(new ItemStack(Material.EMERALD,2));
        ingredientsDigSpeedBook.add(new ItemStack(Material.LAPIS_LAZULI,7));
        ingredientsDigSpeedBook.add(new ItemStack(Material.REDSTONE_BLOCK,5));
        ingredientsOfItems.put(EnchantedManager.getDigSpeedBook(), ingredientsDigSpeedBook);
        //DurabilityBook
        Set<ItemStack> ingredientsDurabilityBook = new HashSet<>();
        ingredientsDurabilityBook.add(new ItemStack(Material.BOOKSHELF,3));
        ingredientsDurabilityBook.add(new ItemStack(Material.EMERALD,2));
        ingredientsDurabilityBook.add(new ItemStack(Material.LAPIS_LAZULI,7));
        ingredientsDurabilityBook.add(new ItemStack(Material.OBSIDIAN,8));
        ingredientsOfItems.put(EnchantedManager.getDurabilityBook(), ingredientsDurabilityBook);
        //ProtectionBook
        Set<ItemStack> ingredientsProtectionBook = new HashSet<>();
        ingredientsProtectionBook.add(new ItemStack(Material.BOOKSHELF,3));
        ingredientsProtectionBook.add(new ItemStack(Material.EMERALD,2));
        ingredientsProtectionBook.add(new ItemStack(Material.LAPIS_LAZULI,7));
        ingredientsProtectionBook.add(new ItemStack(Material.IRON_BLOCK,3));
        ingredientsOfItems.put(EnchantedManager.getProtectionBook(), ingredientsProtectionBook);
        //ArrowDamageBook
        Set<ItemStack> ingredientsArrowDamageBook = new HashSet<>();
        ingredientsArrowDamageBook.add(new ItemStack(Material.BOOKSHELF,3));
        ingredientsArrowDamageBook.add(new ItemStack(Material.EMERALD,2));
        ingredientsArrowDamageBook.add(new ItemStack(Material.LAPIS_LAZULI,7));
        ingredientsArrowDamageBook.add(new ItemStack(Material.ARROW,10));
        ingredientsOfItems.put(EnchantedManager.getPowerBook(), ingredientsArrowDamageBook);
        //RedTNT
        Set<ItemStack> ingredientsRedTNT = new HashSet<>();
        ingredientsRedTNT.add(new ItemStack(Material.TNT,10));
        ingredientsRedTNT.add(new ItemStack(Material.FLINT_AND_STEEL,1));
        ingredientsRedTNT.add(new ItemStack(Material.GUNPOWDER,3));
        ingredientsOfItems.put(TNTManager.itemRed,ingredientsRedTNT);
        //BlackTNT
        Set<ItemStack> ingredientsBlackTNT = new HashSet<>();
        ingredientsBlackTNT.add(new ItemStack(Material.TNT,5));
        ingredientsBlackTNT.add(new ItemStack(Material.OBSIDIAN,1));
        ingredientsBlackTNT.add(new ItemStack(Material.GUNPOWDER,10));
        ingredientsOfItems.put(TNTManager.itemBlack,ingredientsBlackTNT);
    }

}

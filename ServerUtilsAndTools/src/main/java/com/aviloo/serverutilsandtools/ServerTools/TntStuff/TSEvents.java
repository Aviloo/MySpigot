package com.aviloo.serverutilsandtools.ServerTools.TntStuff;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.TileState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class TSEvents implements Listener {

    private static void removeBlocks(Block ... blocks){
        for(Block block : blocks){
            block.setType(Material.AIR);
        }
    }

    private JavaPlugin plugin;

    public TSEvents(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static ItemStack blackStack(){
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED+"TNT -"+ChatColor.YELLOW+"Крушитель");
        meta.addEnchant(Enchantment.LUCK,1,true);
        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void putBlack(BlockPlaceEvent event){
        /*
        if(!event.getBlock().getType().equals(Material.TNT)){return;}
        if(!event.getPlayer().getInventory().getItemInMainHand().equals(blackStack()) &&
        !event.getPlayer().getInventory().getItemInOffHand().equals(blackStack())){return;}
         */
        Block block = event.getBlockPlaced();
        BlockState state = block.getState();
        if(block instanceof TileState) {
            TileState tileState = (TileState) state;
            PersistentDataContainer container = tileState.getPersistentDataContainer();
            container.set(new NamespacedKey(plugin,"tnt-type"),PersistentDataType.STRING,"black");

            //Hologram Path
            Location bLocation = block.getLocation().add(0,1,0);
            ArmorStand Hologram = (ArmorStand) bLocation.getWorld().spawnEntity(bLocation, EntityType.ARMOR_STAND);
            Hologram.setVisible(false);
            Hologram.setGravity(false);
            Hologram.setInvisible(true);
            Hologram.setCustomNameVisible(true);
            Hologram.setCustomName(ChatColor.GRAY+String.valueOf(ChatColor.RED+"TNT -"+ChatColor.YELLOW+"Крушитель"));

        }

    }

    @EventHandler
    public void onBlowUp(BlockExplodeEvent event){
        if(!event.getBlock().getType().equals(Material.TNT)){return;}
        Block block = event.getBlock();
        BlockState state = block.getState();
        if(block instanceof TileState) {
            TileState tileState = (TileState) state;
            PersistentDataContainer container = tileState.getPersistentDataContainer();
            if(Objects.equals(container.get(new NamespacedKey(plugin, "tnt-type"), PersistentDataType.STRING), "black")){
                Location bLocation = block.getLocation();
                //Low blocks
                Block block1 = bLocation.add(0,-1,0).getBlock();
                Block block2 = bLocation.add(1,-1,0).getBlock();
                Block block3 = bLocation.add(1,-1,1).getBlock();
                Block block4 = bLocation.add(0,-1,1).getBlock();
                Block block5 = bLocation.add(-1,-1,1).getBlock();
                Block block6 = bLocation.add(-1,-1,0).getBlock();
                Block block7 = bLocation.add(-1,-1,-1).getBlock();
                Block block8 = bLocation.add(0,-1,-1).getBlock();
                Block block9 = bLocation.add(1,-1,-1).getBlock();
                //At same level blocks
                Block block10 = bLocation.add(1,0,0).getBlock();
                Block block11 = bLocation.add(1,0,1).getBlock();
                Block block12= bLocation.add(0,0,1).getBlock();
                Block block13 = bLocation.add(-1,0,1).getBlock();
                Block block14 = bLocation.add(-1,0,0).getBlock();
                Block block15 = bLocation.add(-1,0,-1).getBlock();
                Block block16 = bLocation.add(0,0,-1).getBlock();
                Block block17 = bLocation.add(1,0,-1).getBlock();
                //High blocks
                Block block18 = bLocation.add(0,1,0).getBlock();
                Block block19 = bLocation.add(1,1,0).getBlock();
                Block block20 = bLocation.add(1,1,1).getBlock();
                Block block21 = bLocation.add(0,1,1).getBlock();
                Block block22 = bLocation.add(-1,1,1).getBlock();
                Block block23 = bLocation.add(-1,1,0).getBlock();
                Block block24 = bLocation.add(-1,1,-1).getBlock();
                Block block25 = bLocation.add(0,1,-1).getBlock();
                Block block26 = bLocation.add(1,1,-1).getBlock();
                //Remove Path
                removeBlocks(block1,block2,block3,block4,block5,block6,block7,block8,block9,block10,block11,block12,
                        block13,block14,block15,block16,block17,block18,block19,block20,block21,block22,
                        block23,block24,block25,block26);
            }
        }
    }
}

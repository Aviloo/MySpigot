package com.aviloo.rewardchests;

import com.aviloo.rewardchests.Commands.ForDonate.giveChest;
import com.aviloo.rewardchests.Commands.ForDonate.giveChestCompleter;
import com.aviloo.rewardchests.Commands.ForQuest.giveQuestChest;
import com.aviloo.rewardchests.Commands.Inventory.getChestStackInteract;
import com.aviloo.rewardchests.Commands.Inventory.getItemStackInteract;
import com.aviloo.rewardchests.Commands.getChest;
import com.aviloo.rewardchests.Commands.getChestCompleter;
import com.aviloo.rewardchests.Events.ItemsEvents.headEvent;
import com.aviloo.rewardchests.Events.OpenChest.openEvent;
import com.aviloo.rewardchests.Events.Protection.dontDropSpecialItems;
import com.aviloo.rewardchests.Events.Protection.opProtection;
import com.aviloo.rewardchests.Events.fishingEvent;
import com.aviloo.rewardchests.Events.huntingEvent;
import com.aviloo.rewardchests.Utils.getPlayerOnline;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RewardChests extends JavaPlugin {

    @Override
    public void onEnable() {
        //Methods
        loadConfig();

        // Events
        Bukkit.getServer().getPluginManager().registerEvents(new fishingEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new huntingEvent(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new openEvent(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new getChestStackInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new headEvent(this),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new opProtection(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new getPlayerOnline(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new dontDropSpecialItems(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new getItemStackInteract(),this);

        //Commands
        Bukkit.getServer().getPluginCommand("rewardchest").setExecutor(new getChest(this));
        Bukkit.getServer().getPluginCommand("givechest").setExecutor(new giveChest(this));
        Bukkit.getServer().getPluginCommand("givequestchestsecretcommand").setExecutor(new giveQuestChest());

        //TabCompleter`s
        Bukkit.getServer().getPluginCommand("rewardchest").setTabCompleter(new getChestCompleter());
        Bukkit.getServer().getPluginCommand("givechest").setTabCompleter(new giveChestCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public  void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}

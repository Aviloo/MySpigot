package com.aviloo.mydaily;

import com.aviloo.mydaily.Commands.OpenMain;
import com.aviloo.mydaily.GlobalEvents.NotNullHashMap;
import com.aviloo.mydaily.Inventory.Events.MainInteract;
import com.aviloo.mydaily.Quests.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyDaily extends JavaPlugin {
    @Override
    public void onEnable() {
        //Events
        Bukkit.getServer().getPluginManager().registerEvents(new CoalQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new NotNullHashMap(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new SkeletonQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new StoneQuest(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new TNTQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new GoldenAppleQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuest(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new CrystalQuest(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new AxolotlQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ObsidianQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new CaneQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new WitherQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new OakQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new HoeQuest(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new LocaleQuest(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new SheepQuest(),this);

        Bukkit.getServer().getPluginManager().registerEvents(new MainInteract(),this);
        //Commands
        getCommand("secretopendailycommand").setExecutor(new OpenMain());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

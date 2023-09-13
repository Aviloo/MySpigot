package com.aviloo.myscoreboard;

import com.aviloo.myscoreboard.Boards.BoardManager;
import com.aviloo.myscoreboard.Commands.EventBoardsEnable;
import com.aviloo.myscoreboard.Commands.Settings;
import com.aviloo.myscoreboard.Inventories.CustomInteract;
import com.aviloo.myscoreboard.Inventories.MainInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyScoreboard extends JavaPlugin {

    @Override
    public void onEnable() {
        //Methods
        new BoardManager(this).Scoreboard(this);

        //Events
        Bukkit.getServer().getPluginManager().registerEvents(new BoardManager(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new MainInteract(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new CustomInteract(),this);

        //Commands
        getCommand("myscoreboard").setExecutor(new Settings());
        getCommand("seteventboard").setExecutor(new EventBoardsEnable());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

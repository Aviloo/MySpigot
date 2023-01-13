package me.aviloo.updateinformation;

import me.aviloo.updateinformation.Commands.Information;
import me.aviloo.updateinformation.Commands.UpdateBook;
import me.aviloo.updateinformation.Commands.UpdateReload;
import me.aviloo.updateinformation.Commands.UpdatesCompleter;
import me.aviloo.updateinformation.Utils.HoverText;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class UpdateInformation extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new HoverText(this),this);
        Bukkit.getServer().getPluginCommand("update").setExecutor(new Information(this));
        Bukkit.getServer().getPluginCommand("updates").setExecutor(new UpdateReload(this));
        Bukkit.getServer().getPluginCommand("updates").setTabCompleter(new UpdatesCompleter());
        //Bukkit.getServer().getPluginCommand("updatebook").setExecutor(new UpdateBook());


    }
    public  void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}

package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigManager{

    private MyTraderReloaded plugin;
    public ConfigManager(MyTraderReloaded plugin){
        this.plugin = plugin;
        saveDefaultFile();
    }

    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public void reloadCustomConfig(){
        if(this.configFile == null){
            this.configFile = new File(this.plugin.getDataFolder(),"database.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("database.yml");
        if(defaultStream != null){
            YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfiguration);
        }
    }

    public FileConfiguration getConfig(){
        if(this.dataConfig == null){
            reloadCustomConfig();
        }
        return this.dataConfig;
    }

    public void saveConfig(){
        if(this.dataConfig == null || this.configFile == null){
            return;
        }
        try{
            this.getConfig().save(this.configFile);
        }catch (IOException e){
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&7[MyTraderReloaded] &fКастомный конфиг не загрузился!"));
        }
    }

    public void saveDefaultFile(){
        if(configFile == null){
            this.configFile = new File(this.plugin.getDataFolder(),"database.yml");
        }
        if(!this.configFile.exists()){
            this.plugin.saveResource("database.yml",false);
        }
    }

}

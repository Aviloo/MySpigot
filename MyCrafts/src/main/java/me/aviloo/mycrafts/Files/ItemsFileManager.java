package me.aviloo.mycrafts.Files;

import me.aviloo.mycrafts.MyCrafts;
import me.aviloo.mycrafts.Utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ItemsFileManager {


    private MyCrafts plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyCrafts.getPlugin().getLogger();

    public void ItemsFileManager(MyCrafts plugin){
        this.plugin = plugin;
        saveDefaultItemsConfig();
    }

    public void reloadItemsConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "items.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("items.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getItemsConfig(){
        if (this.dataConfig == null){
            this.reloadItemsConfig();
        }
        return this.dataConfig;
    }

    public void saveItemsConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getItemsConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6MyCrafts: &4Could not save items.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6MyCrafts: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultItemsConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "items.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("items.yml", false);
        }
    }

}

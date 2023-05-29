package me.aviloo.myclans.files;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ClanGUIFileManager {

    private MyClans plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = MyClans.getPlugin().getLogger();

    public void ClanGUIFileManager(MyClans plugin){
        this.plugin = plugin;
        saveDefaultClanGUIConfig();
    }

    public void reloadClanGUIConfig(){

        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "clangui.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("clangui.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getClanGUIConfig(){
        if (this.dataConfig == null){
            this.reloadClanGUIConfig();
        }
        return this.dataConfig;
    }

    public void saveClanGUIConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getClanGUIConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&6ClansLite: &4Could not save clangui.yml"));
            logger.severe(ColorUtils.translateColorCodes("&6ClansLite: &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultClanGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "clangui.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("clangui.yml", false);
        }
    }
}
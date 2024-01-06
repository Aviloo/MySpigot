package me.aviloo.myarenamanager.Files;

import me.aviloo.myarenamanager.MyArenaManager;
import me.aviloo.myarenamanager.Utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class LocationFileManager {

        private MyArenaManager plugin;
        private FileConfiguration dataConfig = null;
        private File configFile = null;

        Logger logger = MyArenaManager.getPlugin().getLogger();

        public void LocationFileManager(MyArenaManager plugin){
            this.plugin = plugin;
            saveDefaultLocationConfig();
        }

        public void reloadLocationConfig(){
            if (this.configFile == null){
                this.configFile = new File(plugin.getDataFolder(), "location.yml");
            }
            this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
            InputStream defaultStream = this.plugin.getResource("location.yml");
            if (defaultStream != null){
                YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
                this.dataConfig.setDefaults(defaultConfig);
            }
        }

        public FileConfiguration getLocationConfig(){
            if (this.dataConfig == null){
                this.reloadLocationConfig();
            }
            return this.dataConfig;
        }

        public void saveLocationConfig() {
            if (this.dataConfig == null||this.configFile == null){
                return;
            }
            try {
                this.getLocationConfig().save(this.configFile);
            }catch (IOException e){
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4Could not save clans.yml"));
                logger.severe(ColorUtils.translateColorCodes("&6MyArenaManager: &4Check the below message for the reasons!"));
                e.printStackTrace();
            }
        }

        public void saveDefaultLocationConfig() {
            if (this.configFile == null) {
                this.configFile = new File(plugin.getDataFolder(), "location.yml");
            }
            if (!this.configFile.exists()) {
                this.plugin.saveResource("location.yml", false);
            }
        }
}

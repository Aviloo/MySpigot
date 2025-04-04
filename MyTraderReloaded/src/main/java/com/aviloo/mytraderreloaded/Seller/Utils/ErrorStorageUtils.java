package com.aviloo.mytraderreloaded.Seller.Utils;

import com.aviloo.mytraderreloaded.MyTraderReloaded;
import org.bukkit.configuration.file.FileConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class ErrorStorageUtils {
    private static Logger logger = MyTraderReloaded.getPlugin().getLogger();
    private static FileConfiguration errorConfig = MyTraderReloaded.getPlugin().errorFileManager.getErrorConfig();

    public static void saveError(String msg) {
        errorConfig.set(getCurrentTime(),msg);
    }

    private static String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[ "+now.format(formatter)+" ]";
    }
}

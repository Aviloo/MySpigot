package me.aviloo.myAdmins.Utils.StorageUtils;

import me.aviloo.myAdmins.MyAdmins;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class RulesStorageUtil {

    private static Logger logger = MyAdmins.getPlugin().getLogger();

    private static Map<Integer, String> rulemap = new HashMap<>();

    private static FileConfiguration rulemapConfig = MyAdmins.getPlugin().rulesFileManager.getRulesConfig();

    public static void loadData() {

        // Получим все ключи как Set<String>
        Set<String> keys = rulemapConfig.getKeys(false);

        for (String keyStr : keys) {
            try {
                // Преобразуем ключ из String в Double
                Integer key = Integer.parseInt(keyStr);
                // Получаем значение как String
                String value = rulemapConfig.getString(keyStr);
                if (value != null) {
                    rulemap.put(key, value);
                }
            } catch (NumberFormatException e) {
                // Обработка ошибок преобразования
                logger.warning("Некорректный ключ: " + keyStr);
            }
        }
    }

    public static String getValue(String number) {
        int key = Integer.parseInt(number);
        return rulemap.get(key);
    }

}

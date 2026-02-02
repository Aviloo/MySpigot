package me.aviloo.myAdmins.Utils;

public class DateManager {

    public static long parseDuration(String timeStr) {
        try {
            if (timeStr.endsWith("s")) {
                long seconds = Long.parseLong(timeStr.replace("s", ""));
                return seconds * 1000;
            } else if (timeStr.endsWith("m")) {
                long minutes = Long.parseLong(timeStr.replace("m", ""));
                return minutes * 60 * 1000;
            } else if (timeStr.endsWith("h")) {
                long hours = Long.parseLong(timeStr.replace("h", ""));
                return hours * 60 * 60 * 1000;
            } else if (timeStr.endsWith("d")) {
                long days = Long.parseLong(timeStr.replace("d", ""));
                return days * 24 * 60 * 60 * 1000;
            } else {
                // по умолчанию - секунды
                return Long.parseLong(timeStr) * 1000;
            }
        } catch (NumberFormatException e) {
            return -1; // ошибка парсинга
        }
    }

}

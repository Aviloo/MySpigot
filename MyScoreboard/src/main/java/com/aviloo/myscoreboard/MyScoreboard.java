package com.aviloo.myscoreboard;

import com.aviloo.myscoreboard.Boards.BoardManager;
import com.aviloo.myscoreboard.Commands.Settings;
import com.aviloo.myscoreboard.Inventories.*;
import com.aviloo.myscoreboard.Utils.StatisticManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyScoreboard extends JavaPlugin {

    //todo Дописать все новые тэги
    //todo Перенастроить старые инвентари (Добавить новые фишечки: звуки,кнопки,возвращения в меню и т.д.)
    //todo Создать Скорборд для ивентов
    //todo Настроить инвентари для сортировки
    //todo Создать скорборт для оповещений от администрации
    //todo Сделать однородный дизайн
    //todo Добавить всем предметам лор
    //todo Убрать устаревшие части кода
    //todo Создать конфиг для гибкой настройки плагина
    //todo Создать конфиг для сохранения выбранных стилей и тегов у игроков
    //todo Добавить или покупку тэгов, стилей за монеты или выдавать донат группам (или все сразу)

    @Override
    public void onEnable() {
        //Methods
        new BoardManager(this).Scoreboard(this);

        //Events
        getServer().getPluginManager().registerEvents(new BoardManager(this),this);
        getServer().getPluginManager().registerEvents(new MainInteract(),this);
        getServer().getPluginManager().registerEvents(new StyleInteract(),this);
        getServer().getPluginManager().registerEvents(new StatisticManager(),this);
        getServer().getPluginManager().registerEvents(new CustomInteract(),this);
        getServer().getPluginManager().registerEvents(new StatisticInteract(),this);
        getServer().getPluginManager().registerEvents(new SortingInteract(),this);

        //Commands
        getCommand("myscoreboard").setExecutor(new Settings());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

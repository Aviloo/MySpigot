package com.aviloo.myscoreboard;

import com.aviloo.myscoreboard.Boards.BoardManager;
import com.aviloo.myscoreboard.Commands.Settings;
import com.aviloo.myscoreboard.Inventories.*;
import com.aviloo.myscoreboard.Inventories.ShoppingInventories.Interact.FiveHundredInteract;
import com.aviloo.myscoreboard.Inventories.ShoppingInventories.Interact.NineHundredInteract;
import com.aviloo.myscoreboard.Inventories.ShoppingInventories.Interact.SevenHundredInteract;
import com.aviloo.myscoreboard.Inventories.SortingInventories.Interacts.SortingOtherInteract;
import com.aviloo.myscoreboard.Inventories.SortingInventories.Interacts.SortingPvpInteract;
import com.aviloo.myscoreboard.Inventories.SortingInventories.Interacts.SortingStatisticInteract;
import com.aviloo.myscoreboard.Utils.*;
import com.aviloo.myscoreboard.Utils.GlobalEvents.GlobalConnectionEvent;
import com.aviloo.myscoreboard.Utils.GlobalEvents.GlobalDisconnectEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public final class MyScoreboard extends JavaPlugin {

    //todo Дописать все новые тэги (+)
    //todo Перенастроить старые инвентари (Добавить новые фишечки: звуки,кнопки,возвращения в меню и т.д.) (+)
    //todo Настроить инвентари для сортировки (+)
    //todo Сделать однородный дизайн
    //todo Добавить всем предметам лор (+)
    //todo Убрать устаревшие части кода
    //todo Создать конфиг для гибкой настройки плагина
    //todo Создать конфиг для сохранения выбранных стилей и тегов у игроков
    //todo Добавить или покупку тэгов, стилей за монеты или выдавать донат группам (или все сразу)

    public UsermapFileManager usermapFileManager;

    public static HashMap<Player, String> connectedPlayers = new HashMap<>();

    public Economy eco;

    Logger logger = this.getLogger();

    private static MyScoreboard plugin;

    public static MyScoreboard getPlugin() {
        return plugin;
    }

    private boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economy != null) eco = economy.getProvider();

        return (eco != null);
    }

    @Override
    public void onEnable() {
        //Plugin startup logic
        plugin = this;

        //Methods
        new BoardManager(this).Scoreboard(this);
        setupEconomy();

        //Load usermap.yml
        this.usermapFileManager = new UsermapFileManager();
        usermapFileManager.UsermapFileManager(this);
        if (usermapFileManager.getUsermapConfig().contains("users.data")){
            try {
                UsermapStorageUtil.restoreUsermap();
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4Failed to load data from usermap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4See below for errors!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4Disabling Plugin!"));
                e.printStackTrace();
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }

        //Events
        getServer().getPluginManager().registerEvents(new BoardManager(this),this);
        getServer().getPluginManager().registerEvents(new MainInteract(),this);
        getServer().getPluginManager().registerEvents(new StyleInteract(),this);
        getServer().getPluginManager().registerEvents(new StatisticManager(),this);
        getServer().getPluginManager().registerEvents(new CustomInteract(),this);
        getServer().getPluginManager().registerEvents(new StatisticInteract(),this);
        getServer().getPluginManager().registerEvents(new SortingInteract(),this);
        getServer().getPluginManager().registerEvents(new SortingOtherInteract(),this);
        getServer().getPluginManager().registerEvents(new SortingPvpInteract(),this);
        getServer().getPluginManager().registerEvents(new SortingStatisticInteract(),this);
        getServer().getPluginManager().registerEvents(new FiveHundredInteract(),this);
        getServer().getPluginManager().registerEvents(new SevenHundredInteract(),this);
        getServer().getPluginManager().registerEvents(new NineHundredInteract(),this);

        getServer().getPluginManager().registerEvents(new GlobalConnectionEvent(),this);
        getServer().getPluginManager().registerEvents(new GlobalDisconnectEvent(),this);

        getServer().getPluginManager().registerEvents(new EconomyManager(this),this);

        //Commands
        getCommand("myscoreboard").setExecutor(new Settings());

    }

    @Override
    public void onDisable() {
        //Saver usermap to usermap.yml
        if (!UsermapStorageUtil.getRawUsermapList().isEmpty()) {
            try {
                UsermapStorageUtil.saveUsermap();
                logger.info(ColorUtils.translateColorCodes("&6MyScoreboard: &3All users saved to usermap.yml successfully!"));
            } catch (IOException e) {
                logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4Failed to save usermap to usermap.yml!"));
                logger.severe(ColorUtils.translateColorCodes("&6MyScoreboard: &4See below error for reason!"));
                e.printStackTrace();
            }
        }
    }

}

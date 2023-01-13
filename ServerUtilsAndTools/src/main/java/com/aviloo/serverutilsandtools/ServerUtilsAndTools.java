package com.aviloo.serverutilsandtools;

import com.aviloo.serverutilsandtools.AdminTools.AdminChat.AdminChat;
import com.aviloo.serverutilsandtools.AdminTools.AdminChat.Utils.AdminsList;
import com.aviloo.serverutilsandtools.AdminTools.AdminDamage.ADmgCommand;
import com.aviloo.serverutilsandtools.AdminTools.AdminDamage.ADmgEvent;
import com.aviloo.serverutilsandtools.AdminTools.AdminMode.AMCommands;
import com.aviloo.serverutilsandtools.AdminTools.AdminMode.AMCompleter;
import com.aviloo.serverutilsandtools.AdminTools.AdminMode.AMEvents;
import com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats.ASCommands;
import com.aviloo.serverutilsandtools.AdminTools.AdminMode.Stats.ASEvents;
import com.aviloo.serverutilsandtools.AdminTools.Maintenance.MTCommand;
import com.aviloo.serverutilsandtools.AdminTools.Maintenance.MTEvents;
import com.aviloo.serverutilsandtools.AdminTools.PunishmentHistory.PHEvent;
import com.aviloo.serverutilsandtools.AdminTools.PunishmentHistory.PHNoNullHashMaps;
import com.aviloo.serverutilsandtools.AdminTools.Suspect.Commands.setSuspect;
import com.aviloo.serverutilsandtools.AdminTools.Suspect.Commands.setSuspectCompleter;
import com.aviloo.serverutilsandtools.AdminTools.Suspect.Suspect;
import com.aviloo.serverutilsandtools.AdminTools.Suspect.notNullSuspectHash;
import com.aviloo.serverutilsandtools.ServerTools.AntiMultiAccount.AMA;
import com.aviloo.serverutilsandtools.ServerTools.BanEnchants.InfinityBan;
import com.aviloo.serverutilsandtools.ServerTools.NoAddPermsByPlayers.NAPBPEvents;
import com.aviloo.serverutilsandtools.ServerTools.NoAucOnEnd.NoAucOnEnd;
import com.aviloo.serverutilsandtools.ServerTools.NoBanWord.NBW;
import com.aviloo.serverutilsandtools.ServerTools.TntStuff.TSCommands;
import com.aviloo.serverutilsandtools.ServerTools.TntStuff.TSEvents;
import com.aviloo.serverutilsandtools.SmallServerFunc.AuctionShortCut.ASCCommands;
import com.aviloo.serverutilsandtools.SmallServerFunc.DamageHolograms.DamageHolograms;
import com.aviloo.serverutilsandtools.SmallServerFunc.FixBetterRTP.FBRTPEvents;
import com.aviloo.serverutilsandtools.SmallServerFunc.JoinItems.JIEvents;
import com.aviloo.serverutilsandtools.SmallServerFunc.LinksCommand.LKCommand;
import com.aviloo.serverutilsandtools.SmallServerFunc.PotionDupe.PoisonDupe;
import com.aviloo.serverutilsandtools.SmallServerFunc.PotionDupe.PotionDupeCommand;
import com.aviloo.serverutilsandtools.SmallServerFunc.RewardSwords.SwordEvent;
import com.aviloo.serverutilsandtools.SmallServerFunc.RewardSwords.SwordsCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerUtilsAndTools extends JavaPlugin {

    @Override
    public void onEnable() {
        //Methods
        loadConfig();
        //Events
        Bukkit.getServer().getPluginManager().registerEvents(new InfinityBan(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new Suspect(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new AdminsList(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new notNullSuspectHash(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new NoAucOnEnd(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new AMA(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new NBW(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new NAPBPEvents(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new PHEvent(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new PHNoNullHashMaps(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new PoisonDupe(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new SwordEvent(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new DamageHolograms(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new MTEvents(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new ADmgCommand(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new ADmgEvent(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new JIEvents(),this);
        if(getConfig().getBoolean("AdminModeStatus")){
            Bukkit.getServer().getPluginManager().registerEvents(new AMEvents(this),this);
        }
        Bukkit.getServer().getPluginManager().registerEvents(new ASEvents(),this);
        //Bukkit.getServer().getPluginManager().registerEvents(new TSEvents(this),this);
        Bukkit.getServer().getPluginManager().registerEvents(new FBRTPEvents(),this);

        //Commands
        getCommand("serverutilsandtools").setExecutor(new ReloadThisConfigCommand(this));
        Bukkit.getServer().getPluginCommand("suspect").setExecutor(new setSuspect(this));
        Bukkit.getServer().getPluginCommand("adc").setExecutor(new AdminChat());
        //Bukkit.getServer().getPluginCommand("ultrapotion").setExecutor(new PotionDupeCommand());
        //Bukkit.getServer().getPluginCommand("giverewardsword").setExecutor(new SwordsCommand());
        Bukkit.getServer().getPluginCommand("maintenance").setExecutor(new MTCommand());
        //Bukkit.getServer().getPluginCommand("admin-damage").setExecutor(new ADmgCommand());
        if(getConfig().getBoolean("AdminModeStatus")){
            Bukkit.getServer().getPluginCommand("adminmode").setExecutor(new AMCommands());
            getCommand("getadminstats").setExecutor(new ASCommands());
        }
        getCommand("auc").setExecutor(new ASCCommands());
        //getCommand("getcustomtnt").setExecutor(new TSCommands());
        getCommand("links").setExecutor(new LKCommand());

        //Completer`s
        Bukkit.getServer().getPluginCommand("suspect").setTabCompleter(new setSuspectCompleter());
        Bukkit.getServer().getPluginCommand("adminmode").setTabCompleter(new AMCompleter());
        getCommand("serverutilsandtools").setTabCompleter(new ReloadThisConfigCommand(this));

    }

    @Override
    public void onDisable() {
    }

    public  void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}

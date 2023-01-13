package com.aviloo.mydaily.GlobalEvents;

import com.aviloo.mydaily.Quests.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NotNullHashMap implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(CoalQuest.hasPlayedToday(player)){return;}


        CoalQuest.setCoalQuestDefault(player);
        SkeletonQuest.setSkeletonDefault(player);
        StoneQuest.setStoneQuestDefault(player);
        TNTQuest.setTNTQuestDefault(player);
        GoldenAppleQuest.setGoldenDefault(player);
        PlayerQuest.setPlayerDefault(player);
        CrystalQuest.setCrystalQuestDefault(player);
        AxolotlQuest.setAxolotlQuestDefault(player);
        ObsidianQuest.setObsidianQuestDefault(player);
        CaneQuest.setCaneQuestDefault(player);
        WitherQuest.setWitherDefault(player);
        OakQuest.setOakQuestDefault(player);
        HoeQuest.setHoeQuestDefault(player);
        LocaleQuest.setDefaultLocaleQuest(player);
        SheepQuest.setSheepQuestDefault(player);
    }
}

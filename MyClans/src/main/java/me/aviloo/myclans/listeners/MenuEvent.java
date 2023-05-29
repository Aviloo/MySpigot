package me.aviloo.myclans.listeners;

import com.tcoded.folialib.wrapper.WrappedTask;
import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.menuSystem.Menu;
import me.aviloo.myclans.menuSystem.paginatedMenu.ClanListGUI;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.logging.Logger;

public class MenuEvent implements Listener {

    FileConfiguration guiConfig = MyClans.getPlugin().clanGUIFileManager.getClanGUIConfig();
    FileConfiguration clansConfig = MyClans.getPlugin().getConfig();
    Logger logger = MyClans.getPlugin().getLogger();

    @EventHandler
    public void onMenuClick(InventoryClickEvent event){

        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            Menu menu = (Menu) holder;
            menu.handleMenu(event);
        }
    }

    @EventHandler
    public void onMenuClose(InventoryCloseEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu){
            if (((Menu) holder).getMenuName().equalsIgnoreCase(ColorUtils.translateColorCodes(guiConfig.getString("clan-list.name")))){
                WrappedTask wrappedTask = ClanListGUI.task5;
                if (!wrappedTask.isCancelled()){
                    wrappedTask.cancel();
                    if (clansConfig.getBoolean("general.developer-debug-mode.enabled")){
                        logger.info(ColorUtils.translateColorCodes("&6ClansLite-Debug: &aAuto refresh task cancelled"));
                    }
                }
            }
        }
    }
}

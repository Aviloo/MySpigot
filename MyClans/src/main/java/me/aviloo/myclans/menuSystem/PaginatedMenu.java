package me.aviloo.myclans.menuSystem;

import me.aviloo.myclans.MyClans;
import me.aviloo.myclans.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class PaginatedMenu extends Menu {

    FileConfiguration guiConfig = MyClans.getPlugin().clanGUIFileManager.getClanGUIConfig();

    protected int page = 0;
    protected int maxItemsPerPage = 45;
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuControls(){
        inventory.setItem(48, makeItem(Material.STONE_BUTTON, ColorUtils.translateColorCodes(guiConfig.getString("clan-list.menu-controls.previous-page-icon-name"))));
        inventory.setItem(49, makeItem(Material.SPECTRAL_ARROW, ColorUtils.translateColorCodes(guiConfig.getString("clan-list.menu-controls.close-go-back-icon-name"))));
        inventory.setItem(50, makeItem(Material.STONE_BUTTON, ColorUtils.translateColorCodes(guiConfig.getString("clan-list.menu-controls.next-page-icon-name"))));
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}

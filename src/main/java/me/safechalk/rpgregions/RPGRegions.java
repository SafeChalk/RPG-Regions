package me.safechalk.rpgregions;

import me.safechalk.rpgregions.commands.RegionCommand;
import me.safechalk.rpgregions.listeners.EventListener;
import me.safechalk.rpgregions.managers.RegionManager;
import me.safechalk.rpgregions.menus.ToolSelectMenu;
import org.mineacademy.fo.plugin.SimplePlugin;

public class RPGRegions extends SimplePlugin {

    public ToolSelectMenu toolSelectMenu;

    public RegionManager regionManager;

    @Override
    protected void onPluginStart() {
        registerCommand(new RegionCommand());

        registerEvents(new EventListener());

        toolSelectMenu = new ToolSelectMenu();

        regionManager = new RegionManager();


    }

    @Override
    protected void onPluginStop() {

    }


    public static RPGRegions getPlugin() {
        return (RPGRegions) SimplePlugin.getInstance();
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public ToolSelectMenu getToolSelectMenu() {
        return toolSelectMenu;
    }
}

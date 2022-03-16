package me.safechalk.rpgregions;

import me.safechalk.rpgregions.commands.RegionCommand;
import me.safechalk.rpgregions.listeners.EventListener;
import me.safechalk.rpgregions.menus.ToolSelectMenu;
import org.mineacademy.fo.plugin.SimplePlugin;

public class RPGRegions extends SimplePlugin {

    public ToolSelectMenu toolSelectMenu;

    @Override
    protected void onPluginStart() {

        registerCommand(new RegionCommand());

        registerEvents(new EventListener(this));

        toolSelectMenu = new ToolSelectMenu(this);


    }

    @Override
    protected void onPluginStop() {

    }

    public static RPGRegions getPlugin() {
        return (RPGRegions) SimplePlugin.getInstance();
    }


}

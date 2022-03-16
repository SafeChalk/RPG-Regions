package me.safechalk.rpgregions.commands;

import me.safechalk.rpgregions.RPGRegions;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class RegionCommand extends SimpleCommand {


    public RegionCommand() {
        super("region|r");
    }

    @Override
    protected void onCommand() {
        checkConsole();
        Player player = (Player) sender;

        RPGRegions.getPlugin().toolSelectMenu.displayTo(player);

    }
}

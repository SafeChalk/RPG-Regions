package me.safechalk.rpgregions.listeners;

import me.safechalk.rpgregions.RPGRegions;
import me.safechalk.rpgregions.components.Bound;
import me.safechalk.rpgregions.menus.ToolSelectMenu;
import me.safechalk.rpgregions.messages.MessageManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class EventListener implements Listener {

    private final Map<UUID, Bound> regionSetup = new HashMap<>();

    public EventListener(RPGRegions rpgRegions) {

    }


    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().equals(ToolSelectMenu.getBlueBlock())) {
            event.setCancelled(true);
            MessageManager.infoPlayer(player, "&aPlayer is holding Blue Concrete");
            regionSetup.put(player.getUniqueId(), new Bound());
            MessageManager.infoPlayer(player, "Player is now in Setup mode!");

        }

    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
//        Player player = event.getPlayer();
//        if (!regionSetup.containsKey(player.getUniqueId()))
//            return;
//        Bound bound = regionSetup.get(player.getUniqueId());
//        Block block = event.getClickedBlock();
//        if (block == null) return;
//        switch (event.getAction()){
//            case LEFT_CLICK_BLOCK:
//                event.setCancelled(true);
//                bound.setLocation1(block.getLocation());
//                MessageManager.infoPlayer(player, "&aLocation #1 set!");
//                break;
//            case RIGHT_CLICK_BLOCK:
//                event.setCancelled(true);
//                bound.setLocation2(block.getLocation());
//                MessageManager.infoPlayer(player, "&6Location #2 set!");
//                break;
//        }

    }

}
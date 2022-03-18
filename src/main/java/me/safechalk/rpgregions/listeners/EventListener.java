package me.safechalk.rpgregions.listeners;

import me.safechalk.rpgregions.components.Bound;
import me.safechalk.rpgregions.menus.ToolSelectMenu;
import me.safechalk.rpgregions.messages.MessageManager;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.remain.Remain;

import java.util.Map;
import java.util.UUID;


public class EventListener implements Listener {

    private final Map<UUID, Bound> regionSetup;

    public EventListener() {
        regionSetup = ToolSelectMenu.getRegionSetup();
    }


    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
//        if (player.getInventory().getItemInMainHand().equals(ToolSelectMenu.getBlueBlock())) {
//            event.setCancelled(true);
//            MessageManager.infoPlayer(player, "&aPlayer is holding Blue Concrete");
//            regionSetup.put(player.getUniqueId(), new Bound());
//            MessageManager.infoPlayer(player, "Player is now in Setup mode!");
//
//        }

    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!regionSetup.containsKey(player.getUniqueId()))
            return;
        Bound bound = regionSetup.get(player.getUniqueId());
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (player.getItemInHand().getItemMeta() == null) return;

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Create Town")) {
            switch (event.getAction()) {
                case LEFT_CLICK_BLOCK:
                    bound.setLocation1(block.getLocation());
                    MessageManager.infoPlayer(player, "&aLocation #1 set!");
                    event.setCancelled(true);
                    break;
                case RIGHT_CLICK_BLOCK:
                    bound.setLocation2(block.getLocation());
                    MessageManager.infoPlayer(player, "&6Location #2 set!");
                    event.setCancelled(true);

                    bound.assignCorrectBounds();

                    Remain.sendTitle(player, 0, 20 * 60 * 2, 0, "&l&6Completed!", "&7Type &etown &7name");
                    break;
            }

//        String regionName = Region.regionName;
//        String regionDescription = Region.regionDescription;
//        if (RegionManager.getRegions().containsKey(MessageManager.deColor(regionName).toLowerCase())){
//            MessageManager.errorPlayer(player, "&fRegion " + regionName + " &falready exists!");
//        }
//        RegionManager.createNewRegion(regionName,regionDescription, bound);
//        regionSetup.remove(player.getUniqueId());
//        MessageManager.messageXP(player,"&fCreated new region " + regionName + "!");
        }
        /**
         *
         * Code here to open chat line to give Region a name
         *
         */

    }

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Bound bound = regionSetup.get(player.getUniqueId());
        if (regionSetup.containsKey(player.getUniqueId())) {
            if (bound.isComplete()) {
                MessageManager.consoleInfo("The town name is: " + event.getMessage());
                Remain.sendTitle(player, "", "");

                Remain.sendActionBar(player, "&3Town name set to " + event.getMessage());
                event.setCancelled(true);
            }
        }


    }


}
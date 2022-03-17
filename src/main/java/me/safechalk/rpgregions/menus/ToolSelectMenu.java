package me.safechalk.rpgregions.menus;

import me.safechalk.rpgregions.RPGRegions;
import me.safechalk.rpgregions.components.Bound;
import me.safechalk.rpgregions.managers.RegionManager;
import me.safechalk.rpgregions.messages.MessageManager;
import me.safechalk.rpgregions.region.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ToolSelectMenu extends Menu {

    private final Button regionTool;
    private RegionManager regionManager;

    private static final Map<UUID, Bound> regionSetup = new HashMap<>();

    public ItemStack blueBlock;

    public ToolSelectMenu(RPGRegions rpgRegions) {

        setTitle("&6RPG Regions");
        setSize(9 * 3);

        regionTool = new Button() {


            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                if (click.isLeftClick()) {
                    blueBlock = ItemCreator.of(CompMaterial.BLUE_CONCRETE, "&eCreate Town").build().make();
                    if (!player.getInventory().contains(blueBlock)) {
                        MessageManager.infoPlayer(player, "You got a blue block");
                        player.getInventory().addItem(blueBlock);
                        if (!regionSetup.containsKey(player.getUniqueId())) {
                            //Player wants to go in setup mode
                            regionSetup.put(player.getUniqueId(), new Bound());
                            MessageManager.infoPlayer(player, "Player is now in Setup mode!");
                        } else {
                            MessageManager.errorPlayer(player, "You already have that item in your inventory!");
                        }
                    }
                }
            }


            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.GOLDEN_AXE, "Town Create",
                        "",
                        "Selects a region for a town and",
                        "gives a name to the area"
                ).glow(true).build().make();
            }
        };
    }

        @Override
        public ItemStack getItemAt(int slot) {
            if (slot == 10) {
                return regionTool.getItem();
            }


            if (slot >= 0 && slot <= 3)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            if (slot >= 5 && slot <= 8)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            if (slot >= 18 && slot <= 21)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            if (slot >= 23 && slot <= 26)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            if (slot == 9)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            if (slot == 17)
                return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, "").build().make();
            return null;
        }


    public ItemStack getBlueBlock() {
        return blueBlock;
    }

    public static Map<UUID, Bound> getRegionSetup() {
        return regionSetup;
    }
}

package me.safechalk.rpgregions.menus;

import me.safechalk.rpgregions.RPGRegions;
import me.safechalk.rpgregions.messages.MessageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class ToolSelectMenu extends Menu {

    private final Button regionTool;

    public static ItemStack blueBlock;

    public ToolSelectMenu(RPGRegions rpgRegions) {

        setTitle("RPG Regions");
        setSize(9 * 3);

        regionTool = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                if (click.isLeftClick()) {
                    blueBlock = ItemCreator.of(CompMaterial.BLUE_CONCRETE, "&eCreate Town").build().make();
                    MessageManager.infoPlayer(player, "You got a blue block");

                    player.getInventory().addItem(blueBlock);
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


    public static ItemStack getBlueBlock() {
        return blueBlock;
    }
}

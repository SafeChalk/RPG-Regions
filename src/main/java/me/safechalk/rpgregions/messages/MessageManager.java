package me.safechalk.rpgregions.messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.Remain;

public class MessageManager {

    private MessageManager() {
    }

    private static String convertChatColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String deColor(String message) {
        return ChatColor.stripColor(convertChatColor(message));
    }
    public static void goodPlayer(Player player, String message) {
        player.sendMessage(convertChatColor("&a# &7" + message));
    }

    public static void infoPlayer(Player player, String message) {
        player.sendMessage(convertChatColor("&e# &7" + message));
    }

    public static void errorPlayer(Player player, String message) {
        player.sendMessage(convertChatColor("&c# &7" + message));
    }

    public static void messageXP(Player player, String message) {
        Remain.sendActionBar(player, "&a# &7" + message + " &a#");
    }

    public static void questCompleted(Player player, String message, Material material) {
        Remain.sendToast(player, message, CompMaterial.fromMaterial(material));
    }

    public static void consoleGood(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + message);
    }

    public static void consoleError(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + message);
    }

    public static void consoleInfo(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + message);
    }


}

package me.safechalk.rpgregions.settings;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerCache extends YamlSectionConfig {

    private static Map<UUID, PlayerCache> cacheMap = new HashMap<>();

    /**
     * Create a new section config with a section prefix,
     * for example Players for storing player data.
     */
    protected PlayerCache(final String uuid) {
        super(uuid);

        loadConfiguration(null, "data.db");

    }

    public static PlayerCache getCache(final Player player) {
        PlayerCache cache = cacheMap.get(player.getUniqueId());

        if (cache == null) {
            cache = new PlayerCache(player.getUniqueId().toString());

            cacheMap.put(player.getUniqueId(), cache);
        }
        return cache;
    }


}

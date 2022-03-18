package me.safechalk.rpgregions.managers;

import me.safechalk.rpgregions.components.Bound;
import me.safechalk.rpgregions.messages.MessageManager;
import me.safechalk.rpgregions.region.Region;

import java.util.HashMap;
import java.util.Map;

public class RegionManager {

    public static Map<String, Region> regions = new HashMap<>();

    public static void createNewRegion(String regionName, String regionDescription, Bound bound) {
        Region region = new Region(regionName, regionDescription, bound);
        regions.put(MessageManager.deColor(regionName).toLowerCase(), region);

    }


    public static Map<String, Region> getRegions() {
        return regions;
    }
}

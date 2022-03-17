package me.safechalk.rpgregions.region;

import me.safechalk.rpgregions.components.Bound;
import me.safechalk.rpgregions.messages.MessageManager;

public class Region {

    public static String regionName;
    public static String regionDescription;
    public String rawName;
    public Bound bound;

    public Region(String regionName, String regionDescription, Bound bound) {
        this.regionName = regionName;
        this.regionDescription = regionDescription;
        rawName = MessageManager.deColor(regionName);
        this.bound = bound;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public String getRawName() {
        return rawName;
    }

    public Bound getBound() {
        return bound;
    }

}

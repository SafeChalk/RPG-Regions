package me.safechalk.rpgregions.components;

import org.bukkit.Location;

public class Bound {

    private Location location1, location2;

    public Bound() {
    }

    public Bound(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public boolean isComplete() {
        return location1 != null && location2 != null;
    }

    public void assignCorrectBounds() {
        int location1X = location1.getBlockX(), location1Y = location1.getBlockY(), location1Z = location1.getBlockZ();
        int location2X = location2.getBlockX(), location2Y = location2.getBlockY(), location2Z = location2.getBlockZ();

        if (location1X > location2X) {
            int tempX = location1X;
            location1X = location2X;
            location2X = tempX;
        }
        if (location1Y > location2Y) {
            int tempY = location1Y;
            location1Y = location2Y;
            location2Y = tempY;
        }
        if (location1Z > location2Z) {
            int tempZ = location1Z;
            location1Z = location2Z;
            location2Z = tempZ;
        }
        location1 = new Location(location1.getWorld(), location1X, location1Y, location1Z);
        location2 = new Location(location2.getWorld(), location2X, location2Y, location2Z);

    }

    public Location getLocation1() {
        return location1;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }
}

package com.zhuzhuyi.castleV1;

public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description)
    {
        this.description = description;
    }

    public void setExits(Room north,Room east,Room south,Room west)
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    @Override
    public String toString()
    {
        return description;
    }

    public void southExit(Object object, Room lobby, Room study, Room pub) {
        // TODO Auto-generated method stub

    }
}

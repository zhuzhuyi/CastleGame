package com.zhuzhuyi.CastleV2;
import java.util.*;

public class Room {
    private String description;
    /**
     * 第三：可扩展性
     */
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description)
    {
        this.description = description;
    }

    void setExit( String dir, Room room) {
        exits.put(dir, room);
    }

    @Override
    public String toString()
    {
        return description;
    }

    /**
     *改进二：解耦合
     * @return
     */
    /**
     * 改进三：接口增加扩展性
     */
    public  String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet() ) {
            sb.append(dir);
            sb.append(' ');
        }
        return sb.toString();
    }

    public  Room getExit(String direction) {
        Room ret = null;
        ret = exits.get(direction) ;
        return ret;
    }
    public void southExit(Object object, Room lobby, Room study, Room pub) {
        // TODO Auto-generated method stub

    }
}

package com.github.tartaricacid.touhoulittlemaid.client.model.pojo;

import com.google.gson.annotations.SerializedName;
import net.minecraft.util.EnumFacing;

public class FaceUVsItem {
    @SerializedName("down")
    private FaceItem down;
    @SerializedName("east")
    private FaceItem east;
    @SerializedName("north")
    private FaceItem north;
    @SerializedName("south")
    private FaceItem south;
    @SerializedName("up")
    private FaceItem up;
    @SerializedName("west")
    private FaceItem west;

    public FaceItem getFace(EnumFacing facing) {
        switch (facing) {
            case EAST:
                return west;
            case WEST:
                return east;
            case NORTH:
                return north;
            case SOUTH:
                return south;
            case UP:
                return down;
            case DOWN:
            default:
                return up;
        }
    }
}

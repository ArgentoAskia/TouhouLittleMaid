package com.github.tartaricacid.touhoulittlemaid.client.model.pojo;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;
import java.util.List;


public class BonesItem {
    @SerializedName("cubes")
    private List<CubesItem> cubes;

    @SerializedName("name")
    private String name;

    @SerializedName("pivot")
    private List<Float> pivot;

    @SerializedName("rotation")
    private List<Float> rotation;

    @SerializedName("parent")
    private String parent;

    @SerializedName("mirror")
    private boolean mirror = false;

    @Nullable
    public List<CubesItem> getCubes() {
        return cubes;
    }

    public String getName() {
        return name;
    }

    public List<Float> getPivot() {
        return pivot;
    }

    public List<Float> getRotation() {
        return rotation;
    }

    public String getParent() {
        return parent;
    }

    public boolean isMirror() {
        return mirror;
    }
}
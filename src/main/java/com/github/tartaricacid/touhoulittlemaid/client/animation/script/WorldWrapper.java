package com.github.tartaricacid.touhoulittlemaid.client.animation.script;

import net.minecraft.world.World;

public class WorldWrapper {
    private final World world;

    public WorldWrapper(World world) {
        this.world = world;
    }

    public long getWorldTime() {
        return world.getDayTime();
    }

    public boolean isDay() {
        return world.getDayTime() < 13000;
    }

    public boolean isNight() {
        return world.getDayTime() >= 13000;
    }

    public boolean isRaining() {
        return world.isRaining();
    }

    public boolean isThundering() {
        return world.isThundering();
    }
}

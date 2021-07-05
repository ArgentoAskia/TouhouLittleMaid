package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.client.animation.inner.InnerAnimation;
import com.github.tartaricacid.touhoulittlemaid.client.resource.CustomPackLoader;
import com.github.tartaricacid.touhoulittlemaid.client.resource.models.PlayerMaidModels;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;


@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ReloadResourceEvent {
    public static final ResourceLocation EMPTY_BAUBLE_SLOT = new ResourceLocation(TouhouLittleMaid.MOD_ID, "items/empty_bauble_slot");
    public static final ResourceLocation EMPTY_MAINHAND_SLOT = new ResourceLocation(TouhouLittleMaid.MOD_ID, "items/empty_mainhand_slot");
    public static final ResourceLocation BLOCK_ATLAS_TEXTURE = new ResourceLocation("textures/atlas/blocks.png");

    @SubscribeEvent
    public static void onTextureStitchEventPost(TextureStitchEvent.Post event) {
        if (BLOCK_ATLAS_TEXTURE.equals(event.getMap().location())) {
            StopWatch watch = StopWatch.createStarted();
            InnerAnimation.init();
            CustomPackLoader.reloadPacks();
            PlayerMaidModels.reload();
            watch.stop();
            TouhouLittleMaid.LOGGER.info("Model loading time: {} ms", watch.getTime(TimeUnit.MICROSECONDS) / 1000.0);
        }
    }

    @SubscribeEvent
    public static void onTextureStitchEventPre(TextureStitchEvent.Pre event) {
        if (BLOCK_ATLAS_TEXTURE.equals(event.getMap().location())) {
            event.addSprite(EMPTY_BAUBLE_SLOT);
            event.addSprite(EMPTY_MAINHAND_SLOT);
        }
    }
}

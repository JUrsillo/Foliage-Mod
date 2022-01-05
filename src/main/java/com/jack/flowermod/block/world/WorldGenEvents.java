package com.jack.flowermod.block.world;


import com.google.common.eventbus.Subscribe;
import com.jack.flowermod.FlowerMod;
import com.jack.flowermod.block.world.gen.FlowerGen;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlowerMod.MOD_ID)
public class WorldGenEvents {

    @SubscribeEvent
    public static void WorldGen(final BiomeLoadingEvent event) {

        FlowerGen.genFlowers(event);

    }


}

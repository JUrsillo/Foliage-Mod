package com.jack.flowermod.block.world.gen;

import com.jack.flowermod.block.world.features.ConfigFeatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class FlowerGen {

    public static void genFlowers(final BiomeLoadingEvent event) {

        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.DRY)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(() -> ConfigFeatures.FIRE_FLOWER_CONFIG);
        }
        if(types.contains(BiomeDictionary.Type.PLAINS)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(() -> ConfigFeatures.NULLIFYING_FLOWER_CONFIG);
        }
        if(types.contains(BiomeDictionary.Type.JUNGLE)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(() -> ConfigFeatures.POISON_FLOWER_CONFIG);
        }
        if(types.contains(BiomeDictionary.Type.MOUNTAIN)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(() -> ConfigFeatures.WARP_FLOWER_CONFIG);
        }

    }
}

package com.jack.flowermod.block.world.features;

import com.jack.flowermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class ConfigFeatures {

    public static final ConfiguredFeature<?, ?> FIRE_FLOWER_CONFIG = Feature.FLOWER.configured((new RandomPatchConfiguration
            .GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.FIRE_FLOWER.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE))
            .tries(1).build()).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).count(2);
    public static final ConfiguredFeature<?, ?> POISON_FLOWER_CONFIG = Feature.FLOWER.configured((new RandomPatchConfiguration
            .GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.POISON_FLOWER.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE))
            .tries(10).build()).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).count(2);
    public static final ConfiguredFeature<?, ?> WARP_FLOWER_CONFIG = Feature.FLOWER.configured((new RandomPatchConfiguration
            .GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.WARP_FLOWER.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE))
            .tries(3).build()).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).count(1);
    public static final ConfiguredFeature<?, ?> NULLIFYING_FLOWER_CONFIG = Feature.FLOWER.configured((new RandomPatchConfiguration
            .GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.NULLIFYING_FLOWER.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE))
            .tries(1).build()).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).count(1);




    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register (String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }


}

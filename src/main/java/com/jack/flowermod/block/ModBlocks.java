package com.jack.flowermod.block;

import com.jack.flowermod.FlowerMod;
import com.jack.flowermod.block.custom.FireFlower;
import com.jack.flowermod.block.custom.NullifyingFlower;
import com.jack.flowermod.block.custom.PoisonFlower;
import com.jack.flowermod.block.custom.WarpFlower;
import com.jack.flowermod.item.ModItems;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WitherRoseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.Flow;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FlowerMod.MOD_ID);

    public static final RegistryObject<Block> POISON_FLOWER = registerBlock("poison_flower",
            () -> new PoisonFlower(MobEffects.POISON, 120, BlockBehaviour.Properties.of(Material.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> FIRE_FLOWER = registerBlock("fire_flower",
            () -> new FireFlower(DamageSource.ON_FIRE, 120, BlockBehaviour.Properties.of(Material.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));


    public static final RegistryObject<Block> WARP_FLOWER = registerBlock("warp_flower",
            () -> new WarpFlower(MobEffects.BLINDNESS, 120, BlockBehaviour.Properties.of(Material.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> NULLIFYING_FLOWER = registerBlock("nullifying_flower",
            () -> new NullifyingFlower(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {

        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }
    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus);}
}

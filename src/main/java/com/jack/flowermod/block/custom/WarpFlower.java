package com.jack.flowermod.block.custom;


import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;

public class WarpFlower extends FlowerBlock {

    public WarpFlower(MobEffect pSuspiciousStewEffect, int pEffectDuration, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);

    }

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return super.mayPlaceOn(pState, pLevel, pPos) || pState.is(Blocks.GRASS_BLOCK) || pState.is(Blocks.DIRT);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
        VoxelShape voxelshape = this.getShape(pState, pLevel, pPos, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double) pPos.getX() + vec3.x;
        double d1 = (double) pPos.getZ() + vec3.z;

        for (int i = 0; i < 3; ++i) {
            if (pRandom.nextBoolean()) {
                pLevel.addParticle(ParticleTypes.PORTAL, d0 + pRandom.nextDouble() / 5.0D, (double) pPos.getY() + (1.0D - pRandom.nextDouble()), d1 + pRandom.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }

    }


    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide()) {
            if (pHand == InteractionHand.OFF_HAND) {


                double a = pPlayer.getRandomX(50);
                double b = pPlayer.getRandomY();
                double c = pPlayer.getRandomZ(50);


                Vec3 vec3 = new Vec3(pPlayer.getX(), pPlayer.getY(), pPlayer.getZ());
                BlockPos blockPos = pPlayer.blockPosition();

                if (pPlayer.randomTeleport(a, b, c, false)) {
                    pPlayer.sendMessage(new TextComponent("§5Wooosh"), Util.NIL_UUID);
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120));

                }

            }


        }


        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}







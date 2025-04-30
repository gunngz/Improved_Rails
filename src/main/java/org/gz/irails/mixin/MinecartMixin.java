package org.gz.irails.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.math.BlockPos;
import org.gz.irails.irails_registry.IrailsTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.util.math.MathHelper.floor;

@Mixin(AbstractMinecartEntity.class)
public class MinecartMixin {
    @WrapOperation(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    boolean irails$minecartOnPoweredRails(BlockState state, Block block, Operation<Boolean> original) {
        return original.call(state, block) || state.isIn(IrailsTags.POWERED_RAILS);
    }

    @WrapOperation(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;isTouchingWater()Z"))
    boolean irails$minecartOnUnderwaterRails(AbstractMinecartEntity instance, Operation<Boolean> original, BlockPos pos, BlockState state) {
        return original.call(instance) && !state.isIn(IrailsTags.UNDERWATER_RAILS);
    }

    @WrapOperation(method = "getMaxSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;isTouchingWater()Z"))
    boolean irails$minecartOnUnderwaterRailsSpeed(AbstractMinecartEntity instance, Operation<Boolean> original) {
        BlockState state = getState(instance.getX(), instance.getY(), instance.getZ(), instance);
        return original.call(instance) &&
                !state.isIn(IrailsTags.UNDERWATER_RAILS);
    }

    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    boolean irails$minecartOnActivatorRails(BlockState state, Block block, Operation<Boolean> original) {
        return original.call(state, block) || state.isIn(IrailsTags.ACTIVATOR_RAILS);
    }

    @Unique
    private static BlockState getState(double x, double y, double z, AbstractMinecartEntity instance) {
        BlockPos pos = new BlockPos(floor(x), floor(y), floor(z));
        return instance.getWorld().getBlockState(pos);
    }
}

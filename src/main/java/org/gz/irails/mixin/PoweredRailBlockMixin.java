package org.gz.irails.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.RailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.gz.irails.irails_registry.irails_customs.RailUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashSet;
import java.util.Set;

@Mixin(PoweredRailBlock.class)
public class PoweredRailBlockMixin {
    @Unique private static final Set<RailShape> NORTH_SOUTH = new HashSet<>(Set.of(RailShape.NORTH_SOUTH, RailShape.ASCENDING_NORTH, RailShape.ASCENDING_SOUTH));
    @Unique private static final Set<RailShape> EAST_WEST = new HashSet<>(Set.of(RailShape.EAST_WEST, RailShape.ASCENDING_EAST, RailShape.ASCENDING_WEST));

    /**
     * @author gunngz
     * @reason To make the powered rail work with the powered turnable rail.
     */
    @Overwrite
    public boolean isPoweredByOtherRails(World world, BlockPos pos, BlockState state, boolean bl, int distance) {
        Direction direction;
        try {
            if (NORTH_SOUTH.contains(state.get(PoweredRailBlock.SHAPE))) {
                direction = bl ? Direction.SOUTH : Direction.NORTH;
            } else if (EAST_WEST.contains(state.get(PoweredRailBlock.SHAPE))) {
                direction = bl ? Direction.EAST : Direction.WEST;
            } else {
                throw new IllegalStateException("Unexpected value: " + state.get(PoweredRailBlock.SHAPE));
            }
        } catch (IllegalArgumentException e) {
            if (NORTH_SOUTH.contains(state.get(RailBlock.SHAPE))) {
                direction = bl ? Direction.SOUTH : Direction.NORTH;
            } else if (EAST_WEST.contains(state.get(RailBlock.SHAPE))) {
                direction = bl ? Direction.EAST : Direction.WEST;
            } else {
                throw new IllegalStateException("Unexpected value: " + state.get(RailBlock.SHAPE));
            }
        }

        return RailUtils.isPoweredByOtherRails(world, pos, state, distance, direction);
    }


}

package org.gz.irails.irails_registry.irails_customs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class PoweredTurnableRail extends RailBlock {
    private static final Map<RailShape, Pair<Direction, Direction>> SHAPE_TO_DIRECTION = new HashMap<>(Map.of(
            RailShape.NORTH_SOUTH, new Pair<>(Direction.NORTH, Direction.SOUTH),
            RailShape.EAST_WEST, new Pair<>(Direction.EAST, Direction.WEST),
            RailShape.NORTH_EAST, new Pair<>(Direction.NORTH, Direction.EAST),
            RailShape.NORTH_WEST, new Pair<>(Direction.NORTH, Direction.WEST),
            RailShape.SOUTH_EAST, new Pair<>(Direction.SOUTH, Direction.EAST),
            RailShape.SOUTH_WEST, new Pair<>(Direction.SOUTH, Direction.WEST),
            RailShape.ASCENDING_NORTH, new Pair<>(Direction.NORTH, Direction.UP),
            RailShape.ASCENDING_SOUTH, new Pair<>(Direction.SOUTH, Direction.UP),
            RailShape.ASCENDING_EAST, new Pair<>(Direction.EAST, Direction.UP),
            RailShape.ASCENDING_WEST, new Pair<>(Direction.WEST, Direction.UP)
    ));
    
    public static final BooleanProperty POWERED = Properties.POWERED;
    public PoweredTurnableRail(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(POWERED, false)
                .with(SHAPE, RailShape.NORTH_SOUTH)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, POWERED, WATERLOGGED);
    }

    @Override
    protected void updateBlockState(BlockState state, World world, BlockPos pos, Block neighbor) {
        boolean bl = state.get(POWERED);
        Pair<Direction, Direction> directions = SHAPE_TO_DIRECTION.get(state.get(SHAPE));
        boolean bl2 = world.isReceivingRedstonePower(pos)
                || RailUtils.isPoweredByOtherRails(world, pos, state, 0, directions.getLeft())
                || RailUtils.isPoweredByOtherRails(world, pos, state, 0, directions.getRight());
        if (bl2 != bl) {
            world.setBlockState(pos, state.with(POWERED, bl2), Block.NOTIFY_ALL);
            world.updateNeighborsAlways(pos.down(), this);
            if (state.get(SHAPE).isAscending()) {
                world.updateNeighborsAlways(pos.up(), this);
            }
        }
    }
}

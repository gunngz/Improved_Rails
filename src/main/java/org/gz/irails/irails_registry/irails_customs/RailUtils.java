package org.gz.irails.irails_registry.irails_customs;

import net.minecraft.block.BlockState;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.RailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.IrailsTags;

public class RailUtils {
    public static boolean isPoweredByOtherRails(World world, BlockPos pos, BlockState state, int distance, Direction direction) {
        if (state.isIn(IrailsTags.ALWAYS_POWERED_RAILS)) {
            return true;
        }
        if (distance >= 8) {
            return false;
        }

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        boolean bl2 = true;
        RailShape railShape = RailShape.NORTH_SOUTH;
        try {
            try {
                railShape = state.get(PoweredRailBlock.SHAPE);
            } catch (IllegalArgumentException e) {
                railShape = state.get(RailBlock.SHAPE);
            }
        } catch (IllegalArgumentException e) {
            Irails.LOGGER.error("Failed to get the \"Shape\" property : ", e);
        }

        // To find the next rail.
        switch (railShape) {
            case NORTH_SOUTH:
                if (direction == Direction.SOUTH) {
                    z++;
                } else {
                    z--;
                }
                break;
            case EAST_WEST:
                if (direction == Direction.WEST) {
                    x--;
                } else {
                    x++;
                }
                break;
            case ASCENDING_EAST:
                if (direction == Direction.WEST) {
                    x--;
                } else {
                    x++;
                    y++;
                    bl2 = false;
                }

                railShape = RailShape.EAST_WEST;
                break;
            case ASCENDING_WEST:
                if (direction == Direction.WEST) {
                    x--;
                    y++;
                    bl2 = false;
                } else {
                    x++;
                }

                railShape = RailShape.EAST_WEST;
                break;
            case ASCENDING_NORTH:
                if (direction == Direction.SOUTH) {
                    z++;
                } else {
                    z--;
                    y++;
                    bl2 = false;
                }

                railShape = RailShape.NORTH_SOUTH;
                break;
            case ASCENDING_SOUTH:
                if (direction == Direction.SOUTH) {
                    z++;
                    y++;
                    bl2 = false;
                } else {
                    z--;
                }

                railShape = RailShape.NORTH_SOUTH;
                break;
            case SOUTH_EAST:
                if (direction == Direction.SOUTH) {
                    z++;
                    railShape = RailShape.NORTH_SOUTH;
                } else {
                    x++;
                    railShape = RailShape.EAST_WEST;
                }
                break;
            case SOUTH_WEST:
                if (direction == Direction.SOUTH) {
                    z++;
                    railShape = RailShape.NORTH_SOUTH;
                } else {
                    x--;
                    railShape = RailShape.EAST_WEST;
                }
                break;
            case NORTH_EAST:
                if (direction == Direction.NORTH) {
                    z--;
                    railShape = RailShape.NORTH_SOUTH;
                } else {
                    x++;
                    railShape = RailShape.EAST_WEST;
                }
                break;
            case NORTH_WEST:
                if (direction == Direction.NORTH) {
                    z--;
                    railShape = RailShape.NORTH_SOUTH;
                } else {
                    x--;
                    railShape = RailShape.EAST_WEST;
                }
                break;
        }

        // if the rail is powered by the target rail (next one)
        // Or if it's both ascending and the block 1 block below is powered (next one)
        return isPoweredByOtherRails(world, new BlockPos(x, y, z), direction, distance, railShape)
                || bl2 && isPoweredByOtherRails(world, new BlockPos(x, y - 1, z), direction, distance, railShape);
    }


    protected static boolean isPoweredByOtherRails(World world, BlockPos pos, Direction direction, int distance, RailShape prevShape) {
        BlockState state = world.getBlockState(pos);
        if (!state.isIn(IrailsTags.POWERED_RAILS)) {
            return false;
        } else {
            RailShape currShape;
            try {
                currShape = state.get(PoweredRailBlock.SHAPE);
            } catch (IllegalArgumentException e) {
                currShape = state.get(RailBlock.SHAPE);
            }
            if ((prevShape != RailShape.EAST_WEST || currShape != RailShape.NORTH_SOUTH && currShape != RailShape.ASCENDING_NORTH && currShape != RailShape.ASCENDING_SOUTH)
                && (prevShape != RailShape.NORTH_SOUTH || currShape != RailShape.EAST_WEST && currShape != RailShape.ASCENDING_EAST && currShape != RailShape.ASCENDING_WEST)
                && state.get(Properties.POWERED)) {
                switch (currShape) {
                    case NORTH_EAST :
                        if (direction == Direction.WEST) {
                            direction = Direction.NORTH;
                        } else {
                            direction = Direction.EAST;
                        }
                        break;
                    case SOUTH_EAST :
                        if (direction == Direction.WEST) {
                            direction = Direction.SOUTH;
                        } else {
                            direction = Direction.EAST;
                        }
                        break;
                    case NORTH_WEST :
                        if (direction == Direction.EAST) {
                            direction = Direction.NORTH;
                        } else {
                            direction = Direction.WEST;
                        }
                        break;
                    case SOUTH_WEST :
                        if (direction == Direction.NORTH) {
                            direction = Direction.WEST;
                        } else {
                            direction = Direction.SOUTH;
                        }
                        break;
                }
                return world.isReceivingRedstonePower(pos)
                        || isPoweredByOtherRails(world, pos, state, distance + 1, direction);
            } else {
                return false;
            }
        }
    }
}

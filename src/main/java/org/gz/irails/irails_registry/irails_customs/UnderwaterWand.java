package org.gz.irails.irails_registry.irails_customs;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UnderwaterWand extends Item {
    public UnderwaterWand(Settings settings) {
        super(settings);
    }

    private static final Map<Block, Block> BLOCK_MAP = new HashMap<>();

    static {
        BLOCK_MAP.put(Blocks.POWERED_RAIL, IrailsBlocks.UNDERWATER_POWERED_RAIL);
        BLOCK_MAP.put(Blocks.ACTIVATOR_RAIL, IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL);
        BLOCK_MAP.put(Blocks.RAIL, IrailsBlocks.UNDERWATER_RAIL);
        BLOCK_MAP.put(Blocks.DETECTOR_RAIL, IrailsBlocks.UNDERWATER_DETECTOR_RAIL);

        BLOCK_MAP.put(IrailsBlocks.ALWAYS_POWERED_RAIL, IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL);
        BLOCK_MAP.put(IrailsBlocks.POWERED_RAIL_WITH_REDSTONE, IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE);
        BLOCK_MAP.put(IrailsBlocks.ACTIVATOR_RAIL_WITH_DETECTOR, IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR);

        BLOCK_MAP.put(IrailsBlocks.LIGHT_POWERED_RAIL, IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL);
        BLOCK_MAP.put(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL, IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);
        BLOCK_MAP.put(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE, IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient) {
            super.useOnBlock(context);
            return ActionResult.SUCCESS;
        }

        BlockPos pos = context.getBlockPos();
        Block currBlock = context.getWorld().getBlockState(pos).getBlock();
        Block newBlock = BLOCK_MAP.get(currBlock);

        PlayerEntity player = context.getPlayer();
        PlayerInventory inv = Objects.requireNonNull(player).getInventory();

        if (newBlock == null) {
            player.sendMessage(Text.translatable("text.irails.underwater_wand.no_corresponding_underwater_rail"), true);
            return ActionResult.PASS;
        }

        if (player.getAbilities().creativeMode) {
            context.getWorld().setBlockState(pos, newBlock.getDefaultState());
            return ActionResult.SUCCESS;
        }

        for (int i = 0; i < inv.size(); i++) {
            ItemStack stack = inv.getStack(i);
            if (stack.isOf(Items.PRISMARINE_SHARD)) {
                stack.decrement(1);
                context.getWorld().setBlockState(pos, newBlock.getDefaultState());
                return ActionResult.SUCCESS;
            }
        }

        player.sendMessage(Text.translatable("text.irails.underwater_wand.no_prismarine_shard"), true);
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("text.irails.underwater_wand.tooltip1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("text.irails.underwater_wand.tooltip2").formatted(Formatting.GRAY));
    }
}

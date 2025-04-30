package org.gz.irails.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AbstractRailBlock;
import org.gz.irails.irails_registry.IrailsTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractRailBlock.class)
public class AbstractRailBlockMixin {
    @ModifyExpressionValue(
            method = "updateCurves",
            at = @At(value = "FIELD", target = "Lnet/minecraft/block/AbstractRailBlock;forbidCurves:Z")
    )
    private boolean updateCurves(boolean original) {
        return ((AbstractRailBlock) (Object) this).getRegistryEntry().isIn(IrailsTags.POWERED_TURNABLE_RAILS) || original;
    }

    @ModifyExpressionValue(
            method = "onStateReplaced",
            at = @At(value = "FIELD", target = "Lnet/minecraft/block/AbstractRailBlock;forbidCurves:Z")
    )
    private boolean onStateReplaced(boolean original) {
        return ((AbstractRailBlock) (Object) this).getRegistryEntry().isIn(IrailsTags.POWERED_TURNABLE_RAILS) || original;
    }
}

package dev.erdragh.erdragh.spoutingfix;

import com.simibubi.create.compat.rei.category.sequencedAssembly.ReiSequencedAssemblySubCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = ReiSequencedAssemblySubCategory.AssemblySpouting.class, remap = false)
public abstract class AssemblySpoutingMixin extends ReiSequencedAssemblySubCategory {
    public AssemblySpoutingMixin(int width) {
        super(width);
    }

    @ModifyArg(method = "addFluidIngredients", at = @At(value = "INVOKE", target = "Ljava/util/List;get(I)Ljava/lang/Object;"))
    public int spoutingfix$overrideFluidIngredientIndex(int i) {
        return 0;
    }
}

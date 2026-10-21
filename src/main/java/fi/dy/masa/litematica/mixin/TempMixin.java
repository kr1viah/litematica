package fi.dy.masa.litematica.mixin;

import fi.dy.masa.malilib.MaLiLibReference;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MaLiLibReference.class)
public class TempMixin {
	@Inject(method = "isRunningInIde", at =@At("HEAD"), cancellable = true)
	private static void dont(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}

package fi.dy.masa.litematica.mixin.render;

import com.llamalad7.mixinextras.sugar.Local;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import fi.dy.masa.litematica.render.LitematicaRenderer;

@Mixin(value = GameRenderer.class, priority = 600)
public abstract class MixinGameRenderer
{
	@Shadow @Final private Camera mainCamera;

	@Inject(method = "extractCamera", at = @At("TAIL"))
	private void litematica_updateCameraState(DeltaTracker deltaTracker, float worldPartialTicks, CallbackInfo ci,
	                                          @Local(name = "cameraState") CameraRenderState cameraState)
	{
		// Why Iris?
//		if (IrisCompat.isShaderActive()) { return; }
		LitematicaRenderer.getInstance().updateCameraState(this.mainCamera, deltaTracker.getGameTimeDeltaPartialTick(true), cameraState);
	}

	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/renderpearl/api/commands/CommandEncoder;clearDepthTexture(Lcom/mojang/renderpearl/api/textures/GpuTexture;D)V"))
	private void beforeClearDepth(CallbackInfo ci)
	{
		LitematicaRenderer.getInstance().beforeClearDepth();
	}

	@Inject(method = "resize", at = @At("TAIL"))
	private void onResize(int width, int height, CallbackInfo ci) {
		LitematicaRenderer.getInstance().onResize(width, height);
	}
}

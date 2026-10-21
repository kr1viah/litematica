package fi.dy.masa.litematica.render;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;

public class LitematicaTarget extends RenderTarget {
	public LitematicaTarget(int width, int height) {
		super("Litematica", GpuFormat.RGBA8_UNORM, GpuFormat.D32_FLOAT);

		assert this.colorFormat != null;
		assert this.depthFormat != null;

		this.colorTexture = RenderSystem.getDevice().createTexture(() -> this.label + " / Color", 15, this.colorFormat, width, height, 1, 1);
		this.depthTexture = RenderSystem.getDevice().createTexture(() -> this.label + " / Depth", 15, this.depthFormat, width, height, 1, 1);

		this.colorTextureView = RenderSystem.getDevice().createTextureView(this.colorTexture);
		this.depthTextureView = RenderSystem.getDevice().createTextureView(this.depthTexture);

		this.width = width;
		this.height = height;
	}
}

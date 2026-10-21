package fi.dy.masa.litematica.render;

import com.mojang.renderpearl.api.pipeline.*;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class LitematicaPipelines
{
	public static BindGroupLayout COMBINE_LAYOUT;
	public static RenderPipeline COMBINE_PIPELINE;

	// todo LEGACY_TERRAIN Snippet
    public static BindGroupLayout LEGACY_TERRAIN_GROUP;
	public static RenderPipeline.Snippet LEGACY_TERRAIN_STAGE;
	public static RenderPipeline.Snippet LEGACY_TERRAIN_TRANSLUCENT_STAGE;

	// LEGACY_TERRAIN
	public static RenderPipeline LEGACY_SOLID_TERRAIN;
	public static RenderPipeline LEGACY_WIREFRAME;
	public static RenderPipeline LEGACY_CUTOUT_TERRAIN;

	// LEGACY_TERRAIN_OFFSET
	public static RenderPipeline LEGACY_SOLID_TERRAIN_OFFSET;
	public static RenderPipeline LEGACY_WIREFRAME_OFFSET;
	public static RenderPipeline LEGACY_CUTOUT_TERRAIN_OFFSET;

	// LEGACY_TERRAIN_TRANSLUCENT
	public static RenderPipeline LEGACY_TRANSLUCENT;
	public static RenderPipeline LEGACY_TRANSLUCENT_OFFSET;
}

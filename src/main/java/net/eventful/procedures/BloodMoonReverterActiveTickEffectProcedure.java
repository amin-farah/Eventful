package net.eventful.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class BloodMoonReverterActiveTickEffectProcedure {
	public static void execute(LevelAccessor world) {
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().release(new ResourceLocation("minecraft:textures/environment/moon_phases.png"));
		}
	}
}

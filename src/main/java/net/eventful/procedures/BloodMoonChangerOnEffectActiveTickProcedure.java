package net.eventful.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class BloodMoonChangerOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world) {
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().bindForSetup(new ResourceLocation("blood_moon:textures/blood_moon_phases.png"));
			Minecraft.getInstance().getTextureManager().register(new ResourceLocation("minecraft:textures/environment/moon_phases.png"),
					Minecraft.getInstance().getTextureManager().getTexture(new ResourceLocation("blood_moon:textures/blood_moon_phases.png")));
		}
	}
}

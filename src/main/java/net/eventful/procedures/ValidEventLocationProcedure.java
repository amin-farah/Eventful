package net.eventful.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ValidEventLocationProcedure {
	public static void execute(LevelAccessor world, Entity target_ent) {
		if (target_ent == null)
			return;
		double chosen_x = 0;
		double chosen_y = 0;
		double chosen_z = 0;
		double temp_y = 0;
		chosen_x = target_ent.getX() + Mth.nextInt(RandomSource.create(), -400, 400);
		chosen_z = target_ent.getZ() + Mth.nextInt(RandomSource.create(), -400, 400);
		temp_y = target_ent.getY() - 150;
		while (!world.canSeeSkyFromBelowWater(BlockPos.containing(chosen_x, temp_y, chosen_z))) {
			temp_y = temp_y + 1;
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(chosen_x, temp_y, chosen_z))) {
				break;
			}
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Target Coordinates at x: " + Math.round(chosen_x) + " y: " + Math.round(temp_y) + " z: " + Math.round(chosen_z))), false);
	}
}

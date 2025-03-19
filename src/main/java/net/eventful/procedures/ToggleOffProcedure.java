package net.eventful.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.eventful.network.EventfulModVariables;

public class ToggleOffProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (EventfulModVariables.MapVariables.get(world).blood_moon_active) {
			EventfulModVariables.MapVariables.get(world).blood_moon_active = false;
			EventfulModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Toggled Off"), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Toggled On"), false);
			EventfulModVariables.MapVariables.get(world).blood_moon_active = true;
			EventfulModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7c\u00A7lA Blood Moon is Now Active"), false);
		}
	}
}

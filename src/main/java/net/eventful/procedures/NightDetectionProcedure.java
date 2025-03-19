package net.eventful.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.eventful.network.EventfulModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NightDetectionProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double random = 0;
		if (world.dayTime() % 24000 >= 13000) {
			if (!EventfulModVariables.MapVariables.get(world).night_checked) {
				EventfulModVariables.MapVariables.get(world).night_checked = true;
				EventfulModVariables.MapVariables.get(world).syncData(world);
				random = Math.random();
				if (random <= 0.99) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7c\u00A7lA Blood Moon is Now Active"), false);
					EventfulModVariables.MapVariables.get(world).blood_moon_active = true;
					EventfulModVariables.MapVariables.get(world).syncData(world);
				}
			}
		} else if (world.dayTime() % 24000 < 13000) {
			EventfulModVariables.MapVariables.get(world).night_checked = false;
			EventfulModVariables.MapVariables.get(world).syncData(world);
			EventfulModVariables.MapVariables.get(world).blood_moon_active = false;
			EventfulModVariables.MapVariables.get(world).syncData(world);
		}
	}
}

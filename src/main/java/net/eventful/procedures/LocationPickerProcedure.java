package net.eventful.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class LocationPickerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double counter = 0;
		double random_player_num = 0;
		double alt_counter = 0;
		Entity target_entity = null;
		counter = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			counter = counter + 1;
		}
		random_player_num = Mth.nextInt(RandomSource.create(), 1, (int) counter);
		alt_counter = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			alt_counter = alt_counter + 1;
			if (random_player_num == alt_counter) {
				target_entity = entityiterator;
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Your target entity is: " + target_entity.getDisplayName().getString())), false);
				ValidEventLocationProcedure.execute(world, entityiterator);
			}
		}
	}
}

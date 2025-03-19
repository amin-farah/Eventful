package net.eventful.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.eventful.init.EventfulModMobEffects;
import net.eventful.entity.AbominationSporeEntity;
import net.eventful.EventfulMod;

import java.util.List;
import java.util.Comparator;

public class AbominationSporeExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean done_once = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if (entity instanceof AbominationSporeEntity) {
						((AbominationSporeEntity) entity).setAnimation("weirdo.explodes");
					}
					if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(EventfulModMobEffects.PRIMED.get()))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.imitate.creeper")), SoundSource.NEUTRAL, 1, -1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.imitate.creeper")), SoundSource.NEUTRAL, 1, -1, false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EventfulModMobEffects.PRIMED.get(), 60, 1, false, false));
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.7), (entity.getDeltaMovement().z())));
						EventfulMod.queueServerWork(15, () -> {
							if (!entity.level().isClientSide())
								entity.discard();
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.MOB);
						});
					}
				}
			}
		}
	}
}

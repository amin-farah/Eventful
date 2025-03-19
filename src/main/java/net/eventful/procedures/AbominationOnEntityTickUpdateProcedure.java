package net.eventful.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.eventful.init.EventfulModMobEffects;
import net.eventful.init.EventfulModEntities;
import net.eventful.entity.AbominationEntity;
import net.eventful.EventfulMod;

import java.util.List;
import java.util.Comparator;

public class AbominationOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean done_once = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
					if (entity instanceof AbominationEntity) {
						((AbominationEntity) entity).setAnimation("abomination.creeper.aggro");
					}
					if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(EventfulModMobEffects.PRIMED.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EventfulModMobEffects.PRIMED.get(), 60, 1, false, true));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						EventfulMod.queueServerWork(28, () -> {
							for (int index0 = 0; index0 < 5; index0++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EventfulModEntities.ABOMINATION_SPORE.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y, z + Mth.nextInt(RandomSource.create(), -1, 1)),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 30, 1, 2, 1, 0.2);
							}
						});
						EventfulMod.queueServerWork(30, () -> {
							if (!entity.level().isClientSide())
								entity.discard();
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
						});
					}
				}
			}
		}
	}
}

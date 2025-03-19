
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eventful.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.eventful.entity.ArmoredSkeletonEntityProjectile;
import net.eventful.entity.ArmoredSkeletonEntity;
import net.eventful.entity.AbominationSporeEntity;
import net.eventful.entity.AbominationEntity;
import net.eventful.EventfulMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventfulModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EventfulMod.MODID);
	public static final RegistryObject<EntityType<AbominationEntity>> ABOMINATION = register("abomination",
			EntityType.Builder.<AbominationEntity>of(AbominationEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AbominationEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AbominationSporeEntity>> ABOMINATION_SPORE = register("abomination_spore",
			EntityType.Builder.<AbominationSporeEntity>of(AbominationSporeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AbominationSporeEntity::new)

					.sized(0.2f, 0.4f));
	public static final RegistryObject<EntityType<ArmoredSkeletonEntity>> ARMORED_SKELETON = register("armored_skeleton",
			EntityType.Builder.<ArmoredSkeletonEntity>of(ArmoredSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArmoredSkeletonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArmoredSkeletonEntityProjectile>> ARMORED_SKELETON_PROJECTILE = register("projectile_armored_skeleton",
			EntityType.Builder.<ArmoredSkeletonEntityProjectile>of(ArmoredSkeletonEntityProjectile::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1)
					.setCustomClientFactory(ArmoredSkeletonEntityProjectile::new).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AbominationEntity.init();
			AbominationSporeEntity.init();
			ArmoredSkeletonEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ABOMINATION.get(), AbominationEntity.createAttributes().build());
		event.put(ABOMINATION_SPORE.get(), AbominationSporeEntity.createAttributes().build());
		event.put(ARMORED_SKELETON.get(), ArmoredSkeletonEntity.createAttributes().build());
	}
}

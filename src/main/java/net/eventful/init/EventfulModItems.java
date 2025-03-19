
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eventful.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.eventful.EventfulMod;

public class EventfulModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EventfulMod.MODID);
	public static final RegistryObject<Item> ABOMINATION_SPAWN_EGG = REGISTRY.register("abomination_spawn_egg", () -> new ForgeSpawnEggItem(EventfulModEntities.ABOMINATION, -16764109, -16737895, new Item.Properties()));
	public static final RegistryObject<Item> ABOMINATION_SPORE_SPAWN_EGG = REGISTRY.register("abomination_spore_spawn_egg", () -> new ForgeSpawnEggItem(EventfulModEntities.ABOMINATION_SPORE, -16737895, -16764109, new Item.Properties()));
	public static final RegistryObject<Item> ARMORED_SKELETON_SPAWN_EGG = REGISTRY.register("armored_skeleton_spawn_egg", () -> new ForgeSpawnEggItem(EventfulModEntities.ARMORED_SKELETON, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}

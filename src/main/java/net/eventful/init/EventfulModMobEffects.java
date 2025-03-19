
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.eventful.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.eventful.potion.PrimedMobEffect;
import net.eventful.potion.BloodMoonReverterMobEffect;
import net.eventful.potion.BloodMoonChangerMobEffect;
import net.eventful.EventfulMod;

public class EventfulModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EventfulMod.MODID);
	public static final RegistryObject<MobEffect> BLOOD_MOON_CHANGER = REGISTRY.register("blood_moon_changer", () -> new BloodMoonChangerMobEffect());
	public static final RegistryObject<MobEffect> BLOOD_MOON_REVERTER = REGISTRY.register("blood_moon_reverter", () -> new BloodMoonReverterMobEffect());
	public static final RegistryObject<MobEffect> PRIMED = REGISTRY.register("primed", () -> new PrimedMobEffect());
}

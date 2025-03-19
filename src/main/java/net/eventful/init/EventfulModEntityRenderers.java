
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.eventful.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.eventful.client.renderer.ArmoredSkeletonRenderer;
import net.eventful.client.renderer.AbominationSporeRenderer;
import net.eventful.client.renderer.AbominationRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EventfulModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EventfulModEntities.ABOMINATION.get(), AbominationRenderer::new);
		event.registerEntityRenderer(EventfulModEntities.ABOMINATION_SPORE.get(), AbominationSporeRenderer::new);
		event.registerEntityRenderer(EventfulModEntities.ARMORED_SKELETON.get(), ArmoredSkeletonRenderer::new);
		event.registerEntityRenderer(EventfulModEntities.ARMORED_SKELETON_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}

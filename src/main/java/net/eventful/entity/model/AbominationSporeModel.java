package net.eventful.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.eventful.entity.AbominationSporeEntity;

public class AbominationSporeModel extends GeoModel<AbominationSporeEntity> {
	@Override
	public ResourceLocation getAnimationResource(AbominationSporeEntity entity) {
		return new ResourceLocation("eventful", "animations/abomination_spore.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AbominationSporeEntity entity) {
		return new ResourceLocation("eventful", "geo/abomination_spore.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AbominationSporeEntity entity) {
		return new ResourceLocation("eventful", "textures/entities/" + entity.getTexture() + ".png");
	}

}

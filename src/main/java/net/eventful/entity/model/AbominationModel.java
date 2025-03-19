package net.eventful.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.eventful.entity.AbominationEntity;

public class AbominationModel extends GeoModel<AbominationEntity> {
	@Override
	public ResourceLocation getAnimationResource(AbominationEntity entity) {
		return new ResourceLocation("eventful", "animations/creeper_abomination.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AbominationEntity entity) {
		return new ResourceLocation("eventful", "geo/creeper_abomination.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AbominationEntity entity) {
		return new ResourceLocation("eventful", "textures/entities/" + entity.getTexture() + ".png");
	}

}

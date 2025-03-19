package net.eventful.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.eventful.entity.ArmoredSkeletonEntity;

public class ArmoredSkeletonModel extends GeoModel<ArmoredSkeletonEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArmoredSkeletonEntity entity) {
		return new ResourceLocation("eventful", "animations/armor_skeleton.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArmoredSkeletonEntity entity) {
		return new ResourceLocation("eventful", "geo/armor_skeleton.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArmoredSkeletonEntity entity) {
		return new ResourceLocation("eventful", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ArmoredSkeletonEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}

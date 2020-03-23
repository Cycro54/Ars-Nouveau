package com.hollingsworth.arsnouveau.spell.effect;

import com.hollingsworth.arsnouveau.ModConfig;
import com.hollingsworth.arsnouveau.api.spell.AbstractAugment;
import com.hollingsworth.arsnouveau.api.spell.AbstractEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.ArrayList;

public class EffectHaste extends AbstractEffect {

    public EffectHaste() {
        super(ModConfig.EffectHasteID, "Haste");
    }

    @Override
    public void onResolve(RayTraceResult rayTraceResult, World world, LivingEntity shooter, ArrayList<AbstractAugment> augments) {
        if(rayTraceResult instanceof EntityRayTraceResult && ((EntityRayTraceResult) rayTraceResult).getEntity() instanceof LivingEntity){
            applyPotion(((LivingEntity) ((EntityRayTraceResult) rayTraceResult).getEntity()), Effects.SPEED, augments);
        }
    }

    @Override
    public boolean dampenIsAllowed() {
        return true;
    }

    @Override
    public int getManaCost() {
        return 30;
    }


    @Override
    public Tier getTier() {
        return Tier.ONE;
    }
}
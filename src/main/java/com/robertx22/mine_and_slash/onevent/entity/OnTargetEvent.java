package com.robertx22.mine_and_slash.onevent.entity;

import com.robertx22.mine_and_slash.potion_effects.rogue.StealthEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnTargetEvent {

    @SubscribeEvent
    public static void onTarget(LivingSetAttackTargetEvent event) {

        try {

            if (event.getTarget() == null || event.getEntityLiving() == null) {
                return;
            }

            LivingEntity en = event.getEntityLiving();
            if (en instanceof MobEntity) {
                LivingEntity target = event.getTarget();
                MobEntity mob = (MobEntity) en;

                if (target.getActivePotionEffect(StealthEffect.getInstance()) != null) {
                    mob.setAttackTarget(null);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
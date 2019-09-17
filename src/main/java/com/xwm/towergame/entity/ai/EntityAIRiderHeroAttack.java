package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityRiderHero.EntityRiderHero;
import com.xwm.towergame.proxy.CommonProxy;
import com.xwm.towergame.util.ParticlePacket;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.Random;

public class EntityAIRiderHeroAttack extends EntityAIBase
{
    private EntityRiderHero hero;
    private int tick;
    private Random rand;

    public EntityAIRiderHeroAttack(EntityRiderHero hero)
    {
        this.hero = hero;
        tick = 0;
        rand = new Random();
    }

    @Override
    public boolean shouldExecute()
    {

        if (hero.getAttackTarget() != null)
            return true;

        return false;
    }

    @Override
    public void resetTask()
    {
        tick = 0;
    }

    @Override
    public void updateTask()
    {
        tick++;

        World world = hero.getEntityWorld();
        if (tick % 20 == 0)
        {
            for (int i = 0; i < 10; i++)
            {
                ParticlePacket.setParticleTypes(EnumParticleTypes.HEART);
                ParticlePacket particlePacket = new ParticlePacket(this.hero.posX+rand.nextDouble(), this.hero.posY+rand.nextDouble(), this.hero.posZ+rand.nextDouble());
                NetworkRegistry.TargetPoint target = new NetworkRegistry.TargetPoint(world.provider.getDimension(), this.hero.posX, this.hero.posY, this.hero.posZ, 20.0d);
                CommonProxy.simpleNetworkWrapper.sendToAllAround(particlePacket, target);
            }
            hero.heal(5+rand.nextInt(15));
            tick = 0;
        }
    }
}

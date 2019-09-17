package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityMagicianHero.EntityMagicianHero;
import com.xwm.towergame.entity.EntityShadowHero.EntityShadowHero;
import com.xwm.towergame.proxy.CommonProxy;
import com.xwm.towergame.util.ParticlePacket;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.List;
import java.util.Random;

public class EntityAIShadowHeroAttack extends EntityAIBase
{
    private EntityShadowHero hero;

    public EntityAIShadowHeroAttack(EntityShadowHero hero)
    {
        this.hero = hero;
    }

    @Override
    public boolean shouldExecute() {
        if (hero.getAttackTarget() != null){
            return  true;
        }
        return false;
    }

    @Override
    public void startExecuting()
    {
    }

    @Override
    public void updateTask()
    {
        BlockPos pos = hero.getAttackTarget().getPosition();
        int x, z;
        Random rand = new Random();

        x = rand.nextInt(1);
        z = rand.nextInt(1);
        BlockPos tpos = new BlockPos(pos.getX()+x, pos.getY(), pos.getZ()+z);
        BlockPos tpos1 = new BlockPos(tpos.getX(), tpos.getY()+1, tpos.getZ());
        BlockPos tpos2 = hero.getPosition();
        World world = hero.getAttackTarget().getEntityWorld();
        if (world.getBlockState(tpos).getBlock() == Blocks.AIR && world.getBlockState(tpos1).getBlock() == Blocks.AIR)
        {
            hero.setPosition(tpos.getX(), tpos.getY(), tpos.getZ());
            hero.getAttackTarget().addPotionEffect(new PotionEffect(MobEffects.POISON, 400, 1));
        }
        for (int i = 0; i < 10; i++)
        {
            ParticlePacket.setParticleTypes(EnumParticleTypes.CRIT_MAGIC);
            ParticlePacket particlePacket1 = new ParticlePacket(tpos.getX()+rand.nextDouble(), tpos.getY()+rand.nextDouble(), tpos.getZ()+rand.nextDouble());
            NetworkRegistry.TargetPoint target1 = new NetworkRegistry.TargetPoint(world.provider.getDimension(), tpos.getX(), tpos.getY(), tpos.getZ(), 20.0D);
            CommonProxy.simpleNetworkWrapper.sendToAllAround(particlePacket1, target1);

            ParticlePacket particlePacket2 = new ParticlePacket(tpos2.getX()+rand.nextDouble(), tpos2.getY()+rand.nextDouble(), tpos2.getZ()+rand.nextDouble());
            NetworkRegistry.TargetPoint target2 = new NetworkRegistry.TargetPoint(world.provider.getDimension(), tpos2.getX(), tpos2.getY(), tpos2.getZ(), 20.0D);
            CommonProxy.simpleNetworkWrapper.sendToAllAround(particlePacket2, target2);
        }

        double targetDistance = hero.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue();
        List<EntityMagicianHero> list = hero.getEntityWorld().getEntitiesWithinAABB(EntityMagicianHero.class, hero.getEntityBoundingBox().grow(targetDistance, 15.0D, targetDistance));

        for (EntityMagicianHero targetHero: list)
        {
            if (targetHero.team != hero.team)
            {
                hero.setAttackTarget(targetHero);
                break;
            }
        }
    }
}

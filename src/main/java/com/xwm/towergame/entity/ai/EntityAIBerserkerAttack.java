package com.xwm.towergame.entity.ai;

import com.xwm.towergame.Main;
import com.xwm.towergame.entity.EntityBerserker;
import com.xwm.towergame.proxy.CommonProxy;
import com.xwm.towergame.util.ParticlePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.ParticleCloud;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.lwjgl.Sys;
import sun.nio.ch.Net;

import java.util.List;
import java.util.Random;

public class EntityAIBerserkerAttack extends EntityAIBase
{

    private EntityBerserker berserker;

    public EntityAIBerserkerAttack(EntityBerserker berserker)
    {
        this.berserker = berserker;
    }

    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entityLivingBase = this.berserker.getAttackTarget();
        if (entityLivingBase == null)
            return  false;

        double d0 = this.berserker.getDistance(entityLivingBase);

        if (d0 < 2.0D)
            return true;

        return false;
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
        World world = this.berserker.getEntityWorld();
        BlockPos pos = this.berserker.getPosition();
        double d0 = 0;
        try {
            d0 = this.berserker.getDistance(this.berserker.getAttackTarget());
        } catch (Exception e) {
            d0 = 0;
        }
        AxisAlignedBB bb = new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX()+1, pos.getY()+1, pos.getZ()+1).grow(d0);
        List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        for (EntityLivingBase entity : list)
        {
            entity.setPosition(pos.getX(), pos.getY()+5, pos.getZ());
            if (entity instanceof EntityBerserker)
                continue;
            entity.setHealth(entity.getHealth() - (float)berserker.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
        }
        //if (world.isRemote) {
        //    System.out.println("enter send particle packet");
    }

    @Override
    public void updateTask()
    {
        World world = this.berserker.getEntityWorld();
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
        {
            ParticlePacket.setParticleTypes(EnumParticleTypes.LAVA);
            ParticlePacket particlePacket = new ParticlePacket(this.berserker.posX+rand.nextDouble(), this.berserker.posY+rand.nextDouble(), this.berserker.posZ+rand.nextDouble());
            NetworkRegistry.TargetPoint target = new NetworkRegistry.TargetPoint(world.provider.getDimension(), this.berserker.posX, this.berserker.posY, this.berserker.posZ, 20.0D);
            CommonProxy.simpleNetworkWrapper.sendToAllAround(particlePacket, target);
        }
    }
}

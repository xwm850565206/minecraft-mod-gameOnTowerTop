package com.xwm.towergame.object.item;

import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ItemMeteoriteBall extends ItemBallBase
{
    public ItemMeteoriteBall(String name)
    {
        super(name);

    }

    @Override
    public void use(World worldIn, BlockPos pos) {

        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            int x = rand.nextInt(4) - 2;
            int y = 20;
            int z = rand.nextInt(4) - 2;

            int hx = rand.nextInt(4) - 2;
            int hy = 0;
            int hz = rand.nextInt(4) - 2;

            BlockPos temppos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
            BlockPos hitPos = new BlockPos(pos.getX() + hx, pos.getY() + hy, pos.getZ() + hz);


            if (!worldIn.isAreaLoaded(temppos, 10))
                continue;

            double d2 = temppos.getX() - (hitPos.getX() + 1 * 4.0D);
            double d3 = rand.nextInt(20) - 100;//double d3 = temppos.getY() + (double)(1 / 2.0F) - (0.5D + hitPos.getY() + (double)(1 / 2.0F));
            double d4 = temppos.getZ() - (hitPos.getZ() + 1 * 4.0D);

            EntityLargeFireball entitylargefireball = new EntityLargeFireball(worldIn, temppos.getX(), temppos.getY(), temppos.getZ(), d2, d3, d4);
            entitylargefireball.explosionPower = 1;
            worldIn.spawnEntity(entitylargefireball);

        }
    }

}

package com.xwm.towergame.entity.ai;

import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.init.GameInit;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

public class EntityAIEmperorMove extends EntityAIBase
{
    private EntityTowerEmperor emperor;

    public EntityAIEmperorMove(EntityTowerEmperor emperor)
    {
        this.emperor = emperor;
    }

    @Override
    public boolean shouldExecute() {

        if (!GameInit.isGame)
            return false;

        BlockPos pos = emperor.getPosition();
        if (emperor.team == 1 && !(pos.getX() == GameInit.rEpos.getX() && pos.getY() == GameInit.rEpos.getY() && pos.getZ() == GameInit.rEpos.getZ()))
        {
            emperor.setPosition(GameInit.rEpos.getX(), GameInit.rEpos.getY(), GameInit.rEpos.getZ());
            return true;
        }
        else if (emperor.team == 2 && !(pos.getX() == GameInit.bEpos.getX() && pos.getY() == GameInit.bEpos.getY() && pos.getZ() == GameInit.bEpos.getZ()))
        {
            emperor.setPosition(GameInit.bEpos.getX(), GameInit.bEpos.getY(), GameInit.bEpos.getZ());
            return true;
        }

        return false;
    }
}

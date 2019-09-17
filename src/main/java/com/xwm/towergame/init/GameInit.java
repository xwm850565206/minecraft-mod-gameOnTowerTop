package com.xwm.towergame.init;

import com.xwm.towergame.entity.EntityTowerEmperor;
import com.xwm.towergame.entity.EntityTowerEmperorBlue;
import com.xwm.towergame.entity.EntityTowerEmperorRed;
import com.xwm.towergame.entity.EntityTowerMobBase;
import com.xwm.towergame.util.handlers.SoundsHandler;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameInit
{
    public static boolean isGame = false;
    public static int heightoff = 80;
    public static int redplayer = 0;
    public static int blueplayer = 0;
    public static int gameTime = 0;

    public static EntityTowerEmperorRed entityTowerEmperorRed;
    public static EntityTowerEmperorBlue entityTowerEmperorBlue;

    public static BlockPos redPos; // 卡牌位置
    public static BlockPos bluePos;

    public static BlockPos rEpos;  //国王位置
    public static BlockPos bEpos;

    public static BlockPos tpRedPos1, tpRedPos2;  //传送点
    public static BlockPos tpBluePos1, tpBluePos2;

    public static List<EntityPlayer> playerList = new ArrayList<EntityPlayer>();
    private static World world;
    private static BlockPos pos;

    public static void initGame(List playerList, World worldIn, BlockPos pos)
    {
        GameInit.isGame = false;
        GameInit.redplayer = 0;
        GameInit.blueplayer = 0;
        GameInit.gameTime = 0;
        GameInit.playerList = playerList;
        GameInit.pos = pos;
        if (pos.getY() + heightoff < 220)
            GameInit.pos = GameInit.pos.add(0, heightoff, 0);
        else
            GameInit.pos.add(0, 220 - heightoff, 0);

        redPos = new BlockPos(GameInit.pos.getX()+5.5, GameInit.pos.getY()+9, GameInit.pos.getZ());
        bluePos = new BlockPos(GameInit.pos.getX()+5.5, GameInit.pos.getY()+9, GameInit.pos.getZ()+29);

        tpRedPos1 = new BlockPos(GameInit.pos.getX()+3, GameInit.pos.getY()+9, GameInit.pos.getZ()+3);
        tpBluePos1 = new BlockPos(GameInit.pos.getX()+3, GameInit.pos.getY()+9, GameInit.pos.getZ()+26);

        tpRedPos2 = new BlockPos(GameInit.pos.getX()+3, GameInit.pos.getY()+1, GameInit.pos.getZ()+5);
        tpBluePos2 = new BlockPos(GameInit.pos.getX()+3, GameInit.pos.getY()+1, GameInit.pos.getZ()+24);

        GameInit.world = worldIn;

        for(Entity entity : GameInit.world.loadedEntityList)
        {
            if (entity instanceof EntityTowerEmperor)
                entity.setDead();
        }
    }

    public static void setWorld(World worldIn)
    {
        GameInit.world = worldIn;
    }

    public static void setPlayerList(List<EntityPlayer> playerListIn)
    {
        GameInit.playerList = playerListIn;
        GameInit.setWorld(((EntityPlayer)playerListIn.get(0)).getEntityWorld());
    }

    public static void setPos(BlockPos posIn)
    {
        GameInit.pos = posIn;
    }

    public static void init()
    {
        if (GameInit.isGame)
        {
            return;
        }

        /*if (GameInit.world.isRemote)
        {*/
            createCompitionGround();
            Random rand = new Random();
            BlockPos rpos = new BlockPos(pos.getX() + 2, pos.getY() + 9, pos.getZ() + 1);
            BlockPos bpos = new BlockPos(pos.getX() + 2, pos.getY() + 9, pos.getZ() + 28);

            for (EntityPlayer player : playerList) {
                if (rand.nextDouble() < 0.5) {
                    player.setPosition(rpos.getX(), rpos.getY(), rpos.getZ());
                    redplayer++;
                } else {
                    player.setPosition(bpos.getX(), bpos.getY(), bpos.getZ());
                    blueplayer++;
                }
            }
            if (blueplayer == 0) {
                EntityPlayer player = (EntityPlayer) playerList.get(rand.nextInt(redplayer));
                player.setPosition(bpos.getX(), bpos.getY(), bpos.getZ());
                blueplayer++;
                redplayer--;
            } else if (redplayer == 0) {
                EntityPlayer player = (EntityPlayer) playerList.get(rand.nextInt(blueplayer));
                player.setPosition(rpos.getX(), rpos.getY(), rpos.getZ());
                blueplayer--;
                redplayer++;
            }

            for (EntityPlayer player : GameInit.playerList) {
                player.sendMessage(new TextComponentString("游戏开始，所有人，为了自己的国家而战！"));
            }
            rEpos = new BlockPos(pos.getX() + 5, pos.getY() + 1, pos.getZ() + 5);
            bEpos = new BlockPos(pos.getX() + 5, pos.getY() + 1, pos.getZ() + 25);

            GameInit.entityTowerEmperorRed = new EntityTowerEmperorRed(world);
            GameInit.entityTowerEmperorRed.setPosition(rEpos.getX(), rEpos.getY(), rEpos.getZ());
            GameInit.entityTowerEmperorBlue = new EntityTowerEmperorBlue(world);
            GameInit.entityTowerEmperorBlue.setPosition(bEpos.getX(), bEpos.getY(), bEpos.getZ());

            if (!GameInit.world.isRemote) {
                world.spawnEntity(entityTowerEmperorRed);
                world.spawnEntity(entityTowerEmperorBlue);
            }
       // }

        world.playSound(redPos.getX(), redPos.getY(), redPos.getZ(), SoundsHandler.ON_GAME, SoundCategory.BLOCKS, 1, 1, false);
        world.playSound(bluePos.getX(), bluePos.getY(), bluePos.getZ(), SoundsHandler.ON_GAME, SoundCategory.BLOCKS, 1, 1, false);

        isGame = true;
    }

    public static void gameOver(String winner)
    {
        if (!GameInit.isGame)
            return;

        GameInit.isGame = false;
        for(EntityPlayer player : GameInit.playerList)
        {
            player.sendMessage(new TextComponentString("游戏结束，胜利者是" + winner));
        }
        if (entityTowerEmperorRed != null && !entityTowerEmperorRed.isDead)
            entityTowerEmperorRed.setDead();
        if (entityTowerEmperorBlue != null && !entityTowerEmperorBlue.isDead)
            entityTowerEmperorBlue.setDead();

        List<Entity> list =  GameInit.world.loadedEntityList;
        for (Entity entity : list)
        {
            if(entity instanceof EntityTowerMobBase)
            {
                entity.setDead();
            }
        }

        for (int i = -2; i < 11; i++)
            for (int j = -2; j < 33; j++)
                for (int k = -1; k <= 16; k++)
                {
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    GameInit.world.setBlockState(tpos, Blocks.AIR.getDefaultState());
                }

        //把玩家放回地面
        if (GameInit.world.isRemote)
            return;
        for(EntityPlayer player : GameInit.playerList)
        {
            player.setPosition(pos.getX(), pos.getY()-heightoff, pos.getZ());
            //System.out.println(pos.getY()-heightoff);
        }
    }


    private static void createCompitionGround()
    {
        if (world.isRemote)
            return;

        //floor 0~8
        for (int k = -1; k < 8; k++)
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 30; j++)
            {
                if (i == 0 || j <= 3 || i == 9 || j >= 26 || k == 0 || k == -1)
                {
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }

            }
        for (int i = 3; i < 7; i++)
        {
            for (int j = -1; j >= -2; j--)
            {
                int k = 7;
                BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
            }

            for (int j = 30; j <= 31; j++)
            {
                int k = 7;
                BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
            }

        }

        //floor 9
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 30; j++)
            {
                if (j < 4 || j >= 26)
                {
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+8, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }
            }
        }

        for (int i = 3; i < 7; i++)
        {
            for (int j = -1; j >= -2; j--)
            {
                int k = 8;
                BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
            }

            for (int j = 30; j <= 31; j++)
            {
                int k = 8;
                BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
            }
        }


        //floor 10
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 30; j++)
            {
                if ((j == 0 && i != 4 && i != 5) || (i == 0 && j == 1) || (i == 0 && j == 2) || (j == 3 && i != 3) || (i == 9 && j == 1) || (i == 9 && j == 2))
                {
                    int k = 9;
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.SPRUCE_FENCE.getDefaultState());
                }

                if ((j == 29 && i != 4 && i != 5 )|| (i == 0 && j == 28) || (i == 0 && j == 27) || (j == 26 && i != 3) || (i == 9 && j == 28) || (i == 9 && j == 27))
                {
                    int k = 9;
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.SPRUCE_FENCE.getDefaultState());
                }
            }
        }

        for (int i = 3; i < 7; i++)
        {
            for (int j = -1; j >= -2; j--)
            {
                if (i == 3 || i == 6 || j == -2)
                {
                    int k = 9;
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }

            }
            for (int j = 30; j <= 31; j++)
            {

                if (i == 3 || i == 6 || j == 31)
                {
                    int k = 9;
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }
            }

        }

        for (int i = 6; i < 9; i++)
        {
            int k = 9;
            int j = 2;
            BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
            if (i == 6)
                world.setBlockState(tpos, BlockInit.MOBALTAR_RED.getDefaultState());
            else if (i == 7)
                world.setBlockState(tpos, BlockInit.MAGICALTAR_RED.getDefaultState());
            else
                world.setBlockState(tpos, BlockInit.HEROALTAR_RED.getDefaultState());

            j = 27;
            tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
            if (i == 6)
                world.setBlockState(tpos, BlockInit.MOBALTAR_BLUE.getDefaultState());
            else if (i == 7)
                world.setBlockState(tpos, BlockInit.MAGICALTAR_BLUE.getDefaultState());
            else
                world.setBlockState(tpos, BlockInit.HEROALTAR_BLUE.getDefaultState());
        }

        //floor 11~12
        for (int k = 10; k <= 11; k++)
        for (int i = 3; i < 7; i++)
        {
            for (int j = -1; j >= -2; j--)
            {
                if (i == 3 || i == 6 || j == -2 || k == 11)
                {
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }

            }
            for (int j = 30; j <= 31; j++)
            {

                if (i == 3 || i == 6 || j == 31 || k == 11)
                {
                    BlockPos tpos = new BlockPos(pos.getX()+i, pos.getY()+k, pos.getZ()+j);
                    world.setBlockState(tpos, Blocks.BEDROCK.getDefaultState());
                }
            }
        }

        world.setBlockState(tpRedPos1.add(0, -1, 0), Blocks.REDSTONE_BLOCK.getDefaultState());
        world.setBlockState(tpRedPos2.add(0, -1, 0), Blocks.REDSTONE_BLOCK.getDefaultState());
        world.setBlockState(tpBluePos1.add(0, -1, 0), Blocks.DIAMOND_BLOCK.getDefaultState());
        world.setBlockState(tpBluePos2.add(0, -1, 0), Blocks.DIAMOND_BLOCK.getDefaultState());
    }
}

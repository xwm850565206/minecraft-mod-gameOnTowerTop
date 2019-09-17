package com.xwm.towergame.object.block;


import com.xwm.towergame.entity.render.RenderRiderHero;
import com.xwm.towergame.init.ItemInit;
import com.xwm.towergame.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockAltar extends BlockBase
{

    public EnumLEVEL level;
    public String team;

    protected static final AxisAlignedBB AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.125D);
    protected static final AxisAlignedBB AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_EAST = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 1.0D, 1.0D);

    
    public BlockAltar(String name, EnumLEVEL level, String team)
    {
        super(name, Material.IRON);
        this.setLightLevel(1.0F);
        this.setHardness(500.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.level = level;
        this.team = team;

    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEGS);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_WEST);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_NORTH);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_EAST);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_SOUTH);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FULL_BLOCK_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public ItemStack getItemFromIronAltar(Random rand)
    {
        double num = rand.nextDouble();

        Item gift;
        ItemStack temp = new ItemStack(Items.SPAWN_EGG, 1);

        ResourceLocation resourceLocation;

        if(num < 0.25)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"tower_zombie_" + team);
        }
        else if(num < 0.5)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"tower_skeleton_" + team);
        }
        else if (num < 0.75)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"tower_spider_" + team);
        }
        else
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"sword_skeleton_" + team);
        }
        ItemMonsterPlacer.applyEntityIdToItemStack(temp, resourceLocation);
        return temp;
    }
    public ItemStack getItemFromGoalAltar(Random rand)
    {
        double num = rand.nextDouble();
        if (num < 0.20)
        {
            return new ItemStack(ItemInit.BRIGHT_BALL, 1);
        }
        else if (num < 0.30)
        {
            return new ItemStack(ItemInit.METEORITE_BALL, 1);
        }
        else if (num < 0.90)
        {
            return new ItemStack(ItemInit.MOB_CARD, 1);
        }
        else
            return new ItemStack(ItemInit.HERO_CARD, 1);

    }
    public ItemStack getItemFromDiamondAltar(Random rand)
    {
        double num = rand.nextDouble();
        Item gift;
        ItemStack temp = new ItemStack(Items.SPAWN_EGG, 1);

        ResourceLocation resourceLocation;
        if(num < 0.25)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"rider_hero_" + team);
        }
        else if (num < 0.5)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"magician_hero_" + team);
        }
        else if (num < 0.75)
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"shadow_hero_" + team);
        }
        else
        {
            resourceLocation = new ResourceLocation(Reference.MODID+":"+"berserker");
        }
        ItemMonsterPlacer.applyEntityIdToItemStack(temp, resourceLocation);
        return temp;
    }

    public void doIronFunction(ArrayList<EntityItem> dropItems, World worldIn, BlockPos pos, ItemStack item, int playEventId)
    {
        Random random = new Random();
        for (int j = 0; j < item.getCount(); j++)
        {
            worldIn.playEvent(playEventId, pos, 10);

            if (!worldIn.isRemote)
            {
                ItemStack stack = getItemFromIronAltar(random);
                EntityItem gift = new EntityItem(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                gift.setDefaultPickupDelay();
                dropItems.add(gift);
            }
        }
    }

    public void doGoldFunction(ArrayList<EntityItem> dropItems, World worldIn, BlockPos pos, ItemStack item, int playEventId)
    {
        Random random = new Random();
        for (int j = 0; j < item.getCount(); j++)
        {
            worldIn.playEvent(playEventId, pos, 10);

            if (!worldIn.isRemote)
            {
                ItemStack stack = getItemFromGoalAltar(random);
                EntityItem gift = new EntityItem(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                gift.setDefaultPickupDelay();
                dropItems.add(gift);
            }
        }
    }

    public void doDiamondFunction(ArrayList<EntityItem> dropItems, World worldIn, BlockPos pos, ItemStack item, int playEventId)
    {
        Random random = new Random();
        for (int j = 0; j < item.getCount(); j++)
        {
            worldIn.playEvent(playEventId, pos, 10);

            if (!worldIn.isRemote)
            {
                ItemStack stack = getItemFromDiamondAltar(random);
                EntityItem gift = new EntityItem(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                gift.setDefaultPickupDelay();
                dropItems.add(gift);
            }
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        boolean flag = false;


        /** 生成物品 **/
       int cnt = 0;

        int playEventId = 2007;
        if (level == EnumLEVEL.IRON)
            playEventId = 2004;
        else if (level == EnumLEVEL.GOAL)
            playEventId = 2005;
        else if (level == EnumLEVEL.DIAMOND)
            playEventId = 2006;

        AxisAlignedBB bb = new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX()+1.0D, pos.getY()+2.0D, pos.getZ()+1.0D);
        List<EntityItem> list = worldIn.getEntitiesWithinAABB(EntityItem.class, bb);
        ArrayList<EntityItem> dropItems = new ArrayList<EntityItem>();

        for (int i = 0; i < list.size(); i++) {
            EntityItem item = list.get(i);
            Item entityItem = item.getItem().getItem();

            if (entityItem == ItemInit.MOB_CARD && level == EnumLEVEL.IRON) {
                doIronFunction(dropItems, worldIn, pos, item.getItem(), playEventId);
                item.setDead();
            }
            else if (entityItem == ItemInit.MAGIC_CARD && level == EnumLEVEL.GOAL) {
                doGoldFunction(dropItems, worldIn, pos, item.getItem(), playEventId);
                item.setDead();
            }
            else if (entityItem == ItemInit.HERO_CARD && level == EnumLEVEL.DIAMOND) {
                doDiamondFunction(dropItems, worldIn, pos, item.getItem(), playEventId);
                item.setDead();
            }

        }

        if (!worldIn.isRemote)
        {
            for (EntityItem drop : dropItems)
            {
                worldIn.spawnEntity(drop);
            }
        }

        return true;
    }

    /*public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (hasTileEntity(state) && !((Block)this instanceof BlockContainer))
        {
            worldIn.removeTileEntity(pos);
        }
        EntityPlayer player = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);

        player.sendMessage(new TextComponentString("§c[神的惩罚!]幸运祭坛遭到破坏，幸运值降为0!"));
        player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.POISON, 400, 1));

        worldIn.playEvent(3000, pos, 10);

    }*/

    /*
    public IBlockState getStateFromMeta(int meta)
    {
        if (meta == 0)
            return this.getDefaultState().withProperty(LEVEL, EnumLEVEL.IRON);
        else if (meta == 1)
            return this.getDefaultState().withProperty(LEVEL, EnumLEVEL.GOAL);
        else if (meta == 2)
            return this.getDefaultState().withProperty(LEVEL, EnumLEVEL.DIAMOND);
        else
            return this.getDefaultState().withProperty(LEVEL, EnumLEVEL.IRON);
    }
    */
    /**
     * Convert the BlockState into the correct metadata value
     */
    /*
    public int getMetaFromState(IBlockState state)
    {
        EnumLEVEL level = ((EnumLEVEL)state.getValue(LEVEL));
        if (level == EnumLEVEL.IRON)
            return 0;
        else if (level == EnumLEVEL.GOAL)
            return  1;
        else if (level == EnumLEVEL.DIAMOND)
            return 2;
        else
            return 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LEVEL});
    }

    */
    public static enum EnumLEVEL implements IStringSerializable
    {
        IRON,
        GOAL,
        DIAMOND;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            if (this == IRON)
                return "iron";
            else if (this == GOAL)
                return "goal";
            else
                return "diamond";
        }

    }
}

package com.crashbox.tanglermod;

import net.minecraft.block.BlockWeb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import java.util.Random;

// BlockWeb gives us the behaviors of falling through etc.

// NOTE: I've tried subclassing IShearable, but it doens't seem to do anything
//public class TanglerBlock extends Block // implements IShearable
//public class TanglerBlock extends BlockLeavesBase // implements IShearable
public class BlockTangler extends BlockWeb // implements IShearable
{
    // Lots taken from
    // http://www.minecraftforge.net/forum/index.php?topic=26596.0

    public static String NAME = "tanglerWeb";

    public BlockTangler()
    {
        //super(Material.web);              // Block
        super();                          // BlockWeb
        //super(Material.web, true);       // BlockLeavesBase

        // This makes it get updates like leaves and so they go away.
        // TODO: Make this faster.
        setTickRandomly(true);

        // HARDNESS - We do this manually through the resistance
        //setHardness(4F);
        //setHardness(0.5F);
        // Zero is any level of tool
        // classes:  pickaxe, axe, shovel, hoe, sword
        // setHarvestLevel("shovel", 0);

        setCreativeTab(CreativeTabs.tabDecorations);

        setBlockName(NAME);
        setBlockTextureName("tanglermod:tanglerWeb");

        //setStepSound(Block.soundTypeGravel);
        //setResistance();
    }

    // This is called when someone actually places the block in the world
//    @Override
//    public int onBlockPlaced(World world, int x, int y, int z, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
//    {
//        int retVal = super.onBlockPlaced(world, x, y, z, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
//        world.scheduleBlockUpdate(x, y, z, this, 30);
//        return retVal;
//    }

    // This is called when it is constructed in the world, not loaded
//    @Override
//    public void onBlockAdded(World world, int x, int y, int z)
//    {
//        super.onBlockAdded(world, x, y, z);
//        world.scheduleBlockUpdate(x, y, z, this, 30);
//    }

    // We get this for free because we are using BlockWeb
//    @Override
//    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
//    {
//        entity.setInWeb();
//    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        // If we don't set this and isn't opaque it is a "window" through the ground
        // http://www.minecraftforum.net/forums/archive/tutorials/928513-creating-mods-mcp-getrendertype
        return 1;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return null;
    }

    // SHEARS SUPPORT
    // We do this manually because setHarvestLevel doesn't support shears

    @Override
    public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        boolean canHarvest = super.canHarvestBlock(player, meta);
        System.out.println(">>>> CanHarvest super says: " + canHarvest);
        return canHarvest;

//        ItemStack stack = player.inventory.getCurrentItem();
//        if (stack != null && stack.getItem() == Items.shears)
//        {
//            System.out.println(">>>>>>>>> canHarvestBlock returning TRUE");
//            return true;
//        }
//
//        System.out.println(">>>>>>>>> canHarvestBlock returning FALSE");
//        return false;
    }

    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer player, World world, int x, int y, int z)
    {
        // NOTE:  This seems to be opposite of normal hardness in that lower is slower...

        ItemStack stack = player.inventory.getCurrentItem();

        // I got this number from calling super hardness on a normal block
        float hardness = 0.0025F;
        if (stack != null && (stack.getItem() == Items.shears || stack.getItem() instanceof ItemSword))
        {
            hardness = getAcceptableToolRelativeHardness();
        }

        //System.out.println(">>>>>>>>> relativeHardness returning " + hardness);
        return hardness;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        // Seems to NOT work if I used the registry...
        // Make it go away as soon as it calls us.
        world.setBlockToAir(x, y, z);
    }

    // We have variations that are harder to break with tools.
    protected float getAcceptableToolRelativeHardness()
    {
        return 0.1F;
    }

    //--------------------------------------

    // ISHEARABLE - Doesn't seem to do anything

//    @Override
//    public boolean isShearable(ItemStack itemStack, IBlockAccess iBlockAccess, int x, int y, int z)
//    {
//        if (itemStack != null && itemStack.getItem() == Items.shears)
//        {
//            System.out.println(">>>>>>>>> isShearable returning TRUE");
//            return true;
//        }
//
//        System.out.println(">>>>>>>>> isShearable returning FALSE");
//        return false;
//    }
//
//    @Override
//    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess iBlockAccess, int x, int y, int z, int fortune)
//    {
//        return new ArrayList<ItemStack>(0);
//    }



}



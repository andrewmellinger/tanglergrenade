package com.crashbox.tanglermod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by andrew on 2/14/15.
 */
public abstract class ItemTanglerGrenadeBase extends Item
{
    public ItemTanglerGrenadeBase()
    {
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer entityPlayer)
    {
        if (!entityPlayer.capabilities.isCreativeMode)
        {
            par1ItemStack.stackSize--;
        }

        //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(makeEntity(world, entityPlayer));
        }


        return par1ItemStack;
    }

    /* Creates the specific entity to throw. */
    abstract protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer);
}

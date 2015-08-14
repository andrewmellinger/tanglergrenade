package com.crashbox.tanglermod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class EntityTanglerGrenadeTorch extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadeTorch(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeTorch(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeTorch(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public int getRadius()
    {
        return 1;
    }

    @Override
    public Block getBlockType()
    {
        return TanglerMod.BLOCK_TANGLER_TORCH;
    }
}

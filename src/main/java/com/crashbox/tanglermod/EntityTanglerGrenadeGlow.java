package com.crashbox.tanglermod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class EntityTanglerGrenadeGlow extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadeGlow(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeGlow(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeGlow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public int getRadius()
    {
        return 2;
    }

    @Override
    public Block getBlockType()
    {
        return TanglerMod.BLOCK_TANGLER_GLOW;
    }
}

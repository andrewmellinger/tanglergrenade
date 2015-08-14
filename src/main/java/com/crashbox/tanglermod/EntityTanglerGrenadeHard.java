package com.crashbox.tanglermod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class EntityTanglerGrenadeHard extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadeHard(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeHard(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeHard(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public Block getBlockType()
    {
        return TanglerMod.BLOCK_TANGLER_HARD;
    }
}

package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class EntityTanglerGrenadeBig extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadeBig(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeBig(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeBig(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public int getRadius()
    {
        return 3;
    }
}

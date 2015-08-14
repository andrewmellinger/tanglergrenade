package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15.
 */
public class EntityTanglerGrenadePlain extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadePlain(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadePlain(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadePlain(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }
}

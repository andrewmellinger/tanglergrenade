package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class EntityTanglerGrenadeBoom extends EntityTanglerGrenadeBase
{
    public EntityTanglerGrenadeBoom(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeBoom(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeBoom(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }


    @Override
    public boolean doesBreak()
    {
        return true;
    }

    @Override
    public float getBreakPower()
    {
        return 2.0F;
    }
}

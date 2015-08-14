package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadeBig extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenadeBig";

    public ItemTanglerGrenadeBig()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenadeBig");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadeBig(world, entityPlayer);
    }
}

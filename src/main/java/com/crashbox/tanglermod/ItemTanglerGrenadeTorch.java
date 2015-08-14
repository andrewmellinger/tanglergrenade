package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadeTorch extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenadeTorch";

    public ItemTanglerGrenadeTorch()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenadeTorch");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadeTorch(world, entityPlayer);
    }
}

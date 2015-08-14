package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadePlain extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenade";

    public ItemTanglerGrenadePlain()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenade");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadePlain(world, entityPlayer);
    }
}

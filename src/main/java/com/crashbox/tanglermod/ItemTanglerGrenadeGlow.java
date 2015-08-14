package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadeGlow extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenadeGlow";

    public ItemTanglerGrenadeGlow()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenadeGlow");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadeGlow(world, entityPlayer);
    }
}

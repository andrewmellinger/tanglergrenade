package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadeHard extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenadeHard";

    public ItemTanglerGrenadeHard()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenadeHard");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadeHard(world, entityPlayer);
    }

}

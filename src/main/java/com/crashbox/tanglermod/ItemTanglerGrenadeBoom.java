package com.crashbox.tanglermod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class ItemTanglerGrenadeBoom extends ItemTanglerGrenadeBase
{
    public static String ID = "tanglerGrenadeBoom";

    public ItemTanglerGrenadeBoom()
    {
        setUnlocalizedName(ID);
        setTextureName("tanglermod:tanglerGrenadeBoom");
    }

    @Override
    protected EntityTanglerGrenadeBase makeEntity(World world, EntityPlayer entityPlayer)
    {
        return new EntityTanglerGrenadeBoom(world, entityPlayer);
    }
}

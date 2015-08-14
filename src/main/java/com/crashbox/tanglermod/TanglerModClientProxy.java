package com.crashbox.tanglermod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;


public class TanglerModClientProxy extends TanglerModCommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);

        // Add renderers.
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadePlain.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_PLAIN));
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadeBig.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_BIG));
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadeGlow.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_GLOW));
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadeTorch.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_TORCH));
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadeHard.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_HARD));
        RenderingRegistry.registerEntityRenderingHandler(EntityTanglerGrenadeBoom.class, new RenderSnowball(TanglerMod.ITEM_TANGLER_GRENADE_BOOM));

        //System.out.println("ClientModProxy.init");
    }

    @Override
    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
    }
}

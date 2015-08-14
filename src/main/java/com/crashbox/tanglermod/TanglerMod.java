package com.crashbox.tanglermod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid= TanglerMod.MODID, name= TanglerMod.NAME, version= TanglerMod.VERSION)
public class TanglerMod
{
    // TODO:  Set SidedProxy

    // This guy talks about what each event handler does
    // http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
    public static final String MODID = "tanglerMod";
    public static final String NAME = "TanglerMod";
    public static final String VERSION = "0.1.0";

    // These are the blocks and items we load that other parts need to use.
    public static Block BLOCK_TANGLER_PLAIN;
    public static Block BLOCK_TANGLER_GLOW;
    public static Block BLOCK_TANGLER_TORCH;
    public static Block BLOCK_TANGLER_HARD;

    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_PLAIN;
    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_BIG;
    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_GLOW;
    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_TORCH;
    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_HARD;
    public static ItemTanglerGrenadeBase ITEM_TANGLER_GRENADE_BOOM;


    @Instance(value = TanglerMod.MODID)
    public static TanglerMod instance;

    @SidedProxy(clientSide = "com.crashbox.tanglermod.TanglerModClientProxy",
                serverSide = "com.crashbox.tanglermod.TanglerModCommonProxy")
    public static TanglerModCommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Load config, create blocks, items, etc and register them
        // System.out.println(">>> In Mod PreInit");
        initBlocksAndItems();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Do your mod setup. Build whatever data structures you care about. Register recipes.
        //System.out.println(">>> In Mod Init");
        int entityID = 0;
        EntityRegistry.registerModEntity(EntityTanglerGrenadePlain.class, "Tangler Grenade",
                ++entityID, TanglerMod.instance, 80, 10, true);
        EntityRegistry.registerModEntity(EntityTanglerGrenadeBig.class, "Tangler Grenade Big",
                ++entityID, TanglerMod.instance, 80, 10, true);
        EntityRegistry.registerModEntity(EntityTanglerGrenadeGlow.class, "Tangler Grenade Glow",
                ++entityID, TanglerMod.instance, 80, 10, true);
        EntityRegistry.registerModEntity(EntityTanglerGrenadeTorch.class, "Tangler Grenade Torch",
                ++entityID, TanglerMod.instance, 80, 10, true);
        EntityRegistry.registerModEntity(EntityTanglerGrenadeHard.class, "Tangler Grenade Hard",
                ++entityID, TanglerMod.instance, 80, 10, true);
        EntityRegistry.registerModEntity(EntityTanglerGrenadeBoom.class, "Tangler Grenade Boom",
                ++entityID, TanglerMod.instance, 80, 10, true);

        initRecipes();

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Handle interaction with other mods, complete your setup based on this.
        //System.out.println(">>> In Mod Post-Init");

        proxy.postInit(event);
    }

    // ========================================================================

    private void initBlocksAndItems()
    {
        // NOTE:  Don't forget to register things in the client proxy

        // Blocks
        BLOCK_TANGLER_PLAIN = new BlockTangler();
        GameRegistry.registerBlock(BLOCK_TANGLER_PLAIN, BlockTangler.NAME);

        BLOCK_TANGLER_GLOW = new BlockTanglerGlow();
        GameRegistry.registerBlock(BLOCK_TANGLER_GLOW, BlockTanglerGlow.NAME);

        BLOCK_TANGLER_TORCH = new BlockTanglerTorch();
        GameRegistry.registerBlock(BLOCK_TANGLER_TORCH, BlockTanglerTorch.NAME);

        BLOCK_TANGLER_HARD = new BlockTanglerHard();
        GameRegistry.registerBlock(BLOCK_TANGLER_HARD, BlockTanglerHard.NAME);

        // Items
        ITEM_TANGLER_GRENADE_PLAIN = new ItemTanglerGrenadePlain();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_PLAIN, ItemTanglerGrenadePlain.ID);

        ITEM_TANGLER_GRENADE_BIG = new ItemTanglerGrenadeBig();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_BIG, ItemTanglerGrenadeBig.ID);

        ITEM_TANGLER_GRENADE_GLOW = new ItemTanglerGrenadeGlow();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_GLOW, ItemTanglerGrenadeGlow.ID);

        ITEM_TANGLER_GRENADE_TORCH = new ItemTanglerGrenadeTorch();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_TORCH, ItemTanglerGrenadeTorch.ID);

        ITEM_TANGLER_GRENADE_HARD = new ItemTanglerGrenadeHard();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_HARD, ItemTanglerGrenadeHard.ID);

        ITEM_TANGLER_GRENADE_BOOM = new ItemTanglerGrenadeBoom();
        GameRegistry.registerItem(ITEM_TANGLER_GRENADE_BOOM, ItemTanglerGrenadeBoom.ID);
    }

    //--------------------------

    private void initRecipes()
    {
        // Basic tangler grenade
        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_PLAIN),
                "-S-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball
                );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_BIG),
                "SSS",
                "SRS",
                "SSS",
                'R', Items.redstone,
                'S', Items.slime_ball
        );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_TORCH),
                "CS-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball,
                'C', Items.coal
        );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_TORCH),
                "CS-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball,
                'C', new ItemStack(Items.coal, 1, 1)
        );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_GLOW),
                "GS-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball,
                'G', Items.glowstone_dust
        );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_HARD),
                "IS-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball,
                'I', Items.iron_ingot
        );

        GameRegistry.addRecipe(new ItemStack(ITEM_TANGLER_GRENADE_BOOM),
                "GS-",
                "SRS",
                "-S-",
                'R', Items.redstone,
                'S', Items.slime_ball,
                'G', Items.gunpowder
        );
    }



}

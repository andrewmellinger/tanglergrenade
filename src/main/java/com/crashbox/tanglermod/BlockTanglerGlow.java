package com.crashbox.tanglermod;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class BlockTanglerGlow extends BlockTangler
{
    public static String NAME = "tanglerWebGlow";

    public BlockTanglerGlow()
    {
        super();

        // It looks like 1 is 15.
        setLightLevel(1);

        setBlockName(NAME);
        setBlockTextureName("tanglermod:tanglerWebGlow");
    }
}

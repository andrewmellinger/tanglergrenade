package com.crashbox.tanglermod;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class BlockTanglerTorch extends BlockTangler
{
    public static String NAME = "tanglerWebTorch";

    public BlockTanglerTorch()
    {
        super();

        // It looks like 1 is 15.
        setLightLevel(0.75F);

        setBlockName(NAME);
        setBlockTextureName("tanglermod:tanglerWebGlow");
    }
}

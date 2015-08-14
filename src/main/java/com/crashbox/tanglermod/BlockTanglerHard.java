package com.crashbox.tanglermod;

/**
 * Created by andrew on 2/21/15. YAy!
 */
public class BlockTanglerHard extends BlockTangler
{
    public static String NAME = "tanglerWebHard";

    public BlockTanglerHard()
    {
        super();

        setBlockName(NAME);
        setBlockTextureName("tanglermod:tanglerWebHard");
    }

    @Override
    protected float getAcceptableToolRelativeHardness()
    {
        return 0.04F;
    }
}

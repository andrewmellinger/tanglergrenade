package com.crashbox.tanglermod;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by andrew on 2/21/15.
 */
public class EntityTanglerGrenadeBase extends EntityThrowable
{
    // TODO: What should be in config file?
    public enum Shape { BOX, DIAMOND };

    public EntityTanglerGrenadeBase(World world)
    {
        super(world);
    }

    public EntityTanglerGrenadeBase(World world, EntityPlayer playerEntity)
    {
        super(world, playerEntity);
    }

    public EntityTanglerGrenadeBase(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    // ========================================================================
    public int getRadius()
    {
        return 2;
    }

    public Shape getShape()
    {
        return Shape.DIAMOND;
    }

    public Block getBlockType()
    {
        return TanglerMod.BLOCK_TANGLER_PLAIN;
    }

    /* Does this destroy blocks when thrown. */
    public boolean doesBreak()
    {
        return false;
    }

    /* Breaking power - in terms of blast resistance.  Breaks blocks and replaces with web. */
    public float getBreakPower()
    {
        return 0.0F;
    }

    // ========================================================================


    @Override
    protected void onImpact(MovingObjectPosition mop)
    {
        // isRemote true on client, false on server
        // We ONLY want to do the creation part on the server.  We could do particles locally,
        // but since we are creating blocks we really should let the server creat them.

        int x, y, z;

        if (!worldObj.isRemote)
        {
            //System.out.printf(">>>> MOP: %d, %d, %d \n", mop.blockX, mop.blockY, mop.blockZ);
            // Fill area with webs
            if (mop.entityHit != null)
            {
                // Entities come in floats so we need to find the proper center.
                Entity entity = mop.entityHit;
                x = (int) entity.posX;
                y = (int) entity.posY;

                if (!doesBreak())
                {
                    y = y + 1;
                }

                z = (int) entity.posZ;

                if (x < 0)
                    x = x - 1;
                if (z < 0)
                    z = z - 1;
            }
            else
            {
                x = mop.blockX;
                y = mop.blockY;
                z = mop.blockZ;

                // We want to move to the side based on the hit.
                switch (mop.sideHit)
                {
                    case 0:
                        // Bottom
                        y = y - 1;
                        break;
                    case 1:
                        // Top
                        y = y + 1;
                        break;
                    case 2:
                        // North (neg Z)
                        z = z - 1;
                        break;
                    case 3:
                        // South
                        z = z + 1;
                        break;
                    case 4:
                        // West
                        x = x - 1;
                        break;
                    case 5:
                        // East
                        x = x + 1;
                        break;
                }
            }

            // Invoke the proper shape.
            switch (getShape())
            {
                case DIAMOND:
                    fillDiamond(x, y, z, getRadius());
                    break;
                case BOX:
                    fillBox(x, y, z);
            }

            setDead();
        }
    }


    // ========================================================================
    // 3x3 box
    private void fillBox(int x, int y, int z)
    {
        System.out.printf(">>>> FillBox: %d, %d, %d \n", x, y, z);
        // Var all three.
        for (int tmpX = x - 1; tmpX <= x + 1; ++tmpX)
        {
            for (int tmpY = y - 1; tmpY <= y + 1; ++tmpY)
            {
                for (int tmpZ = z - 1; tmpZ <= z + 1; ++tmpZ)
                {
                    placeWeb(tmpX, tmpY, tmpZ);
                }
            }
        }
    }

    private void fillDiamond(int x, int y, int z, int radius)
    {
        //System.out.printf(">>>> AREA: Filling: %d, %d, %d, %d \n", x, y, z, radius);

        // Traverse Z's.
        fillDiamondLayer(x, y, z, radius);
        for (int i = 1; i <= radius; ++i)
        {
            fillDiamondLayer(x, y, z - i, radius - i);
            fillDiamondLayer(x, y, z + i, radius - i);
        }
    }

    private void fillDiamondLayer(int x, int y, int z, int radius)
    {
        //System.out.printf(">>>> LAYER: Filling: %d, %d, %d, %d \n", x, y, z, radius);

        // Traverse Y's.
        fillDiamondRow(x, y, z, radius);
        for (int i = 1; i <= radius; ++i)
        {
            fillDiamondRow(x, y - i, z, radius - i);
            fillDiamondRow(x, y + i, z, radius - i);
        }
    }

    private void fillDiamondRow(int x, int y, int z, int radius)
    {
        //System.out.printf(">>>> ROW Filling: %d, %d, %d, %d \n", x, y, z, radius);

        // Z and y are fixed.  Do x.
        int start = x - radius;
        int stop = x + radius;
        for (int i = start; i <= stop; ++i)
        {
            placeWeb(i, y, z);
        }
    }

    private void placeWeb(int x, int y, int z)
    {
        boolean placeIt = false;

        // If we have air, just place the thing.  Otherwise, we might break the block.
        if (worldObj.isAirBlock(x, y, z))
        {
            placeIt = true;
        }
        else if (doesBreak())
        {
            // Check power against block resistance
            Block target = worldObj.getBlock(x, y, z);
            if (target.getExplosionResistance(this) <= getBreakPower())
            {
                // This is destroy block.  The true is "drop".  This makes it drop the contents.
                worldObj.func_147480_a(x, y, z, true);
                placeIt = true;
            }
        }

        if (placeIt)
        {
            //System.out.printf(">>>> Filling: %d, %d, %d \n", x, y, z);
            worldObj.setBlock(x, y, z, getBlockType());
        }

    }

}

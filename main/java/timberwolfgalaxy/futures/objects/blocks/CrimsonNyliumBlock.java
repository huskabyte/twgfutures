package timberwolfgalaxy.futures.objects.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrimsonNyliumBlock extends BlockBase
{
	public CrimsonNyliumBlock(String name, Material material) 
	{
		super(name, material);
		
		setHardness(0.4F);
		setResistance(1.0F);
		setHarvestLevel("spade", 0);
		setSoundType(SoundType.GROUND);
		setCreativeTab(CreativeTabs.DECORATIONS);
		
	}
}

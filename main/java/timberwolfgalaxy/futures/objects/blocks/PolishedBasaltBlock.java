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

public class PolishedBasaltBlock extends BlockBase
{
	public PolishedBasaltBlock(String name, Material material) 
	{
		super(name, material);
		
		setHardness(1.25F);
		setResistance(4.2F);
		setHarvestLevel("pickaxe", 1);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.DECORATIONS);
		
	}
}
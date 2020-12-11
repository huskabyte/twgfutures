package timberwolfgalaxy.futures.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NetherGoldOreBlock extends BlockBase
{
	public NetherGoldOreBlock(String name, Material material) 
	{
		super(name, material);
		
		setHardness(3.0F);
		setResistance(3.0F);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
	}
	
	@Override
	public int quantityDropped(Random random) {	

	    return 2 + random.nextInt(6);
	} 
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {

	    return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}	
}

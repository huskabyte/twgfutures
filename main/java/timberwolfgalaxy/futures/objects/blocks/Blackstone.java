package timberwolfgalaxy.futures.objects.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Blackstone extends BlockBase
{
	public Blackstone(String name, Material material) 
	{
		super(name, material);
		
		setHardness(1.5F);
		setResistance(6.0F);
		setHarvestLevel("pickaxe", 1);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.DECORATIONS);
		
	}
}

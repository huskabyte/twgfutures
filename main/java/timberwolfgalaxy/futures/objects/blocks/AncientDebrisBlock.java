package timberwolfgalaxy.futures.objects.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AncientDebrisBlock extends BlockBase{

	public AncientDebrisBlock(String name, Material material) {
		super(name, material);
		
		setHardness(30.0F);
		setResistance(1200.0F);
		setHarvestLevel("pickaxe", 3);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}

}

package timberwolfgalaxy.futures.objects.blocks;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.futures.Main;
import timberwolfgalaxy.futures.init.BlockInit;
import timberwolfgalaxy.futures.init.ItemInit;
import timberwolfgalaxy.futures.util.IHasModel;
import timberwolfgalaxy.futures.util.IMetaName;

public class BlockWoodenButton extends BlockButtonWood implements IHasModel, IMetaName{
	
	public BlockWoodenButton(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.REDSTONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}

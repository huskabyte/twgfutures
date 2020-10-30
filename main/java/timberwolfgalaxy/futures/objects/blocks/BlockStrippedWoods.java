package timberwolfgalaxy.futures.objects.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.futures.Main;
import timberwolfgalaxy.futures.init.BlockInit;
import timberwolfgalaxy.futures.init.ItemInit;
import timberwolfgalaxy.futures.util.IHasModel;
import timberwolfgalaxy.futures.util.IMetaName;

public class BlockStrippedWoods extends BlockLog implements IHasModel, IMetaName {

	public BlockStrippedWoods(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();

		switch (meta & 0b1100) {
		case 0b0000:
			state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
			break;

		case 0b0100:
			state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			break;

		case 0b1000:
			state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			break;

		case 0b1100:
			state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
			break;
		}

		return state;
	}

	public int getMetaFromState(IBlockState state) {
		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
		case X:
			return 0b0100;
		case Y:
			return 0b0000;
		case Z:
			return 0b1000;
		case NONE:
			return 0b1100;
		}
		return 0b1100;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
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

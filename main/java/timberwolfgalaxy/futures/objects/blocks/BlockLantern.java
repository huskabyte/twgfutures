package timberwolfgalaxy.futures.objects.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.futures.Main;
import timberwolfgalaxy.futures.init.BlockInit;
import timberwolfgalaxy.futures.init.ItemInit;
import timberwolfgalaxy.futures.util.IHasModel;
import timberwolfgalaxy.futures.util.IMetaName;

public class BlockLantern extends Block implements IHasModel, IMetaName {
	
	protected static final AxisAlignedBB UP_AABB = new AxisAlignedBB(0.3125, 0.0D, 0.3125, 0.6875, 0.65, 0.6875);
	protected static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(0.3125, 0.00005D, 0.3125, 0.6875, 1D, 0.6875);

	public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>() {

		@Override
		public boolean apply(@Nullable EnumFacing input) {
			return input != EnumFacing.EAST && input != EnumFacing.WEST && input != EnumFacing.NORTH
					&& input != EnumFacing.SOUTH;
		}

	});

	public BlockLantern(String name, int lightLevel) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setLightLevel(lightLevel / 16F);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		switch ((EnumFacing)blockState.getValue(FACING))
        {
            case DOWN:
            	return DOWN_AABB;
            default:
                return UP_AABB;
        }
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumFacing)state.getValue(FACING))
        {
            case DOWN:
            	return DOWN_AABB;
            default:
                return UP_AABB;
        }
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : FACING.getAllowedValues()) {
			if (this.canPlaceAt(worldIn, pos, enumfacing)) {
				return true;
			}
		}

		return false;
	}

	private boolean canPlaceOn(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
	}

	private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {
		BlockPos blockpos = pos.offset(facing.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);
		if (facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
			return blockfaceshape == BlockFaceShape.SOLID || block instanceof BlockWall || block instanceof BlockFence;
		} else {
			return false;
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getValue(FACING).equals(EnumFacing.UP)) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING, EnumFacing.UP);
		case 1:
			return this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
		default:
			return this.getDefaultState().withProperty(FACING, EnumFacing.UP);
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		if (this.canPlaceAt(worldIn, pos, facing)) {
			return this.getDefaultState().withProperty(FACING, facing);
		} else {
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
				if (this.canPlaceAt(worldIn, pos, enumfacing)) {
					return this.getDefaultState().withProperty(FACING, enumfacing);
				}
			}

			return this.getDefaultState();
		}
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
	    return BlockRenderLayer.TRANSLUCENT;
	}
}
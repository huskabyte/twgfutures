package timberwolfgalaxy.futures.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import timberwolfgalaxy.futures.objects.blocks.BasaltBlock;
import timberwolfgalaxy.futures.objects.blocks.BlockLantern;
import timberwolfgalaxy.futures.objects.blocks.BlockStrippedWoods;
import timberwolfgalaxy.futures.objects.blocks.BlockWoodenButton;
import timberwolfgalaxy.futures.objects.blocks.BlockWoodenTrapdoor;
import timberwolfgalaxy.futures.objects.blocks.PolishedBasaltBlock;
import timberwolfgalaxy.futures.objects.blocks.WarpedNyliumBlock;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block ACACIA_BUTTON = new BlockWoodenButton("acacia_button");
	public static final Block SPRUCE_BUTTON = new BlockWoodenButton("spruce_button");
	public static final Block JUNGLE_BUTTON = new BlockWoodenButton("jungle_button");
	public static final Block DARK_OAK_BUTTON = new BlockWoodenButton("dark_oak_button");
	public static final Block BIRCH_BUTTON = new BlockWoodenButton("birch_button");
	
	public static final Block ACACIA_TRAPDOOR = new BlockWoodenTrapdoor("acacia_trapdoor");
	public static final Block SPRUCE_TRAPDOOR = new BlockWoodenTrapdoor("spruce_trapdoor");
	public static final Block JUNGLE_TRAPDOOR = new BlockWoodenTrapdoor("jungle_trapdoor");
	public static final Block DARK_OAK_TRAPDOOR = new BlockWoodenTrapdoor("dark_oak_trapdoor");
	public static final Block BIRCH_TRAPDOOR = new BlockWoodenTrapdoor("birch_trapdoor");
	
	public static final Block STRIPPED_OAK_LOG = new BlockStrippedWoods("stripped_oak_log");
	public static final Block STRIPPED_BIRCH_LOG = new BlockStrippedWoods("stripped_birch_log");
	public static final Block STRIPPED_SPRUCE_LOG = new BlockStrippedWoods("stripped_spruce_log");
	public static final Block STRIPPED_JUNGLE_LOG = new BlockStrippedWoods("stripped_jungle_log");
	public static final Block STRIPPED_DARK_OAK_LOG = new BlockStrippedWoods("stripped_dark_oak_log");
	public static final Block STRIPPED_ACACIA_LOG = new BlockStrippedWoods("stripped_acacia_log");
	
	public static final Block STRIPPED_OAK_WOOD = new BlockStrippedWoods("stripped_oak_wood");
	public static final Block STRIPPED_BIRCH_WOOD = new BlockStrippedWoods("stripped_birch_wood");
	public static final Block STRIPPED_SPRUCE_WOOD = new BlockStrippedWoods("stripped_spruce_wood");
	public static final Block STRIPPED_JUNGLE_WOOD = new BlockStrippedWoods("stripped_jungle_wood");
	public static final Block STRIPPED_DARK_OAK_WOOD = new BlockStrippedWoods("stripped_dark_oak_wood");
	public static final Block STRIPPED_ACACIA_WOOD = new BlockStrippedWoods("stripped_acacia_wood");
	
	public static final Block LANTERN = new BlockLantern("lantern", 15);
	public static final Block SOUL_LANTERN = new BlockLantern("soul_lantern", 10);
	
	public static final Block BASALT_BLOCK = new BasaltBlock("basalt_block", Material.ROCK);
	public static final Block POLISHED_BASALT_BLOCK = new PolishedBasaltBlock("polished_basalt_block", Material.ROCK);
	public static final Block WARPED_Nylium_BLOCK = new WarpedNyliumBlock("warped_nylium_block", Material.GRASS);
}

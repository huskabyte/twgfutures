package timberwolfgalaxy.futures.world;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import timberwolfgalaxy.futures.init.BlockInit;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator nether_gold_ore_block;
	//private WorldGenerator copper_ore_nether, copper_ore_end;
	
	public WorldGenCustomOres() 
	{
		nether_gold_ore_block = new WorldGenMinable(BlockInit.NETHER_GOLD_ORE_BLOCK.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 0:
			
			//runGenerator(copper_ore_nether, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case -1:
			
			runGenerator(nether_gold_ore_block, world, random, chunkX, chunkZ, 75, 1, 256);
			
			break;
			
		case 1:
			
			//runGenerator(copper_ore_end, world, random, chunkX, chunkZ, 50, 0, 256);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}
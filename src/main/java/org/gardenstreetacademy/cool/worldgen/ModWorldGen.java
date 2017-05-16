package org.gardenstreetacademy.cool.worldgen;

import java.util.Random;

import org.gardenstreetacademy.cool.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {
	private WorldGenerator gen_example;
	
	public ModWorldGen() {
		this.gen_example = new WorldGenMinable(ModBlocks.example_block.getDefaultState(),12);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.getDimension()) {
		case 0: //Overworld
			//this.modOreGenerator(this.gen_example, world, random, chunkX, chunkZ, 100, 0, 128);
			break;
		case -1: //Nether
			
			break;
		case 1: //End
			
			break;
		}
	}

	
	private void modOreGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}

	public static int getGroundFromAbove(World world, int x, int z){
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >=0){
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
		}
		return y;
	}

}

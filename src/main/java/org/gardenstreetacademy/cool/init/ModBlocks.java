package org.gardenstreetacademy.cool.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block example_block;
	
	public static void init(){
		example_block = new Block(Material.ANVIL).setUnlocalizedName("example_block").setRegistryName("block_example");
	}
	
	public static void register(){
		registerBlock(example_block);
	}
	
	public static void registerRenders(){
		registerRender(example_block);
	}
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}

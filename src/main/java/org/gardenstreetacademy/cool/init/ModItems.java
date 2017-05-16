package org.gardenstreetacademy.cool.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item example_item;
	
	public static void init(){
		example_item = new Item().setUnlocalizedName("example_item").setRegistryName("item_example");
	}
	
	public static void register(){
		GameRegistry.register(example_item);
	}
	
	public static void registerRenders(){
		registerRender(example_item);
	}

	private static void registerRender(Item item)
	{
		//Method used to register item with texture
		//There is no need to add to this method
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}

package org.gardenstreetacademy.cool.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	
	public static void register(){
		
		//Shaped Recipe
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.example_item), "Y Y", "B B", "B B", 'Y', Items.APPLE, 'B', Items.BONE);
		
		//Shapeless Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.example_item, 2), new Object[] {Items.APPLE, Items.BONE});
		
		//Smelting Recipe
		GameRegistry.addSmelting(ModBlocks.example_block, new ItemStack(ModItems.example_item, 2),1.2F);
	}
	
}

package org.gardenstreetacademy.cool.init;

import org.gardenstreetacademy.cool.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
	
	public static Item.ToolMaterial example_tool_material;
	public static ItemArmor.ArmorMaterial example_armor_material;
	
	public static void init(){
		example_tool_material = toolHelper("example_tool", 3, 2000, 10.0F, 3.0F, 50);
		example_armor_material = armorHelper("example_armor", "example_tex", 40, new int[]{3,3,3,3}, 90, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.5F);
	}
	
	public static Item.ToolMaterial toolHelper(String name, int harvest, int uses, float strength, float damage, int enchant){
		return EnumHelper.addToolMaterial(name, harvest, uses, strength, damage, enchant);
	}
	
	public static ItemArmor.ArmorMaterial armorHelper(String name, String textureName, int durability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness){
		return EnumHelper.addArmorMaterial(name, Reference.MOD_ID + ":" + textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
	}
}

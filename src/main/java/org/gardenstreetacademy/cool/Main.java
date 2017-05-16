package org.gardenstreetacademy.cool;

import org.gardenstreetacademy.cool.init.ModBlocks;
import org.gardenstreetacademy.cool.init.ModCrafting;
import org.gardenstreetacademy.cool.init.ModItems;
import org.gardenstreetacademy.cool.init.ModMaterials;
import org.gardenstreetacademy.cool.proxy.ICommonProxy;
import org.gardenstreetacademy.cool.worldgen.ModWorldGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static ICommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("preInit");
		
		ModMaterials.init();
		
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println("Init");
		
		proxy.init();
		ModCrafting.register();
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("postInit");
	}
}

package org.educraft.cool;


import org.educraft.cool.proxy.ICommonProxy;

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
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println("Init");
		
		proxy.init();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("postInit");
	}
}

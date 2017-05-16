package org.gardenstreetacademy.cool.proxy;

import org.gardenstreetacademy.cool.init.ModBlocks;
import org.gardenstreetacademy.cool.init.ModItems;

public class ClientProxy implements ICommonProxy {
	
	@Override
	public void init(){
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}

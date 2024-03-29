package timberwolfgalaxy.futures;

import java.io.File;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import timberwolfgalaxy.futures.proxy.CommonProxy;
import timberwolfgalaxy.futures.util.Reference;
import timberwolfgalaxy.futures.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	public static File config;
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegistryHandler.otherRegistries();}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}

package com.ccxia.cbcraft;

import com.ccxia.cbcraft.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CbCraft.MODID, name = CbCraft.NAME, version = CbCraft.VERSION, acceptedMinecraftVersions = "1.12.2")
public class CbCraft {
	public static final String MODID = "cbcraft";
	public static final String NAME = "Cocoa Bean Craft";
	public static final String VERSION = "1.0.0";
	@SidedProxy(clientSide = "com.ccxia.cbcraft.client.ClientProxy", serverSide = "com.ccxia.cbcraft.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance(CbCraft.MODID)
	public static CbCraft instance;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
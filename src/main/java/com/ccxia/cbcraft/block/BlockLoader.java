package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class BlockLoader {
	public static Block[] blocks = { new BlockFermentationBaker(), new BlockCrushingGrindingMachine(),
			new BlockSeparator() };

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for (Block block : blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
			event.getRegistry().register(block);
		}
	}

	public static Block getByName(String name) {
		for (Block block : blocks)
			if (block.getUnlocalizedName().equals(name))
				return block;
		return Blocks.AIR;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Block block : blocks) {
			Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
			ModelLoader.setCustomModelResourceLocation(itemBlock, 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
			event.getRegistry().register(itemBlock);
		}
	}

}
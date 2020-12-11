package timberwolfgalaxy.futures.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import timberwolfgalaxy.futures.init.BlockInit;
import timberwolfgalaxy.futures.init.EntityInit;
import timberwolfgalaxy.futures.init.ItemInit;
import timberwolfgalaxy.futures.util.IHasModel;
import timberwolfgalaxy.futures.world.WorldGenCustomOres;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
			
		}
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	@SubscribeEvent
	public static void removeRecipes(RegistryEvent.Register<IRecipe> event){
		ResourceLocation button = new ResourceLocation("minecraft:wooden_button");
		ResourceLocation trapdoor = new ResourceLocation("minecraft:trapdoor");
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		modRegistry.remove(button);
		modRegistry.remove(trapdoor);
	}
	
	public static void otherRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		EntityInit.registerEntities();
	}
}

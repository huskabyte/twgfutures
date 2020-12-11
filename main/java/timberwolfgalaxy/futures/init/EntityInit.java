package timberwolfgalaxy.futures.init;

import java.lang.ref.Reference;

import akka.Main;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("phantom", EntityPhantom.class, timberwolfgalaxy.futures.util.Reference.ENTITY_PHANTOM, 10, 3093160, 8401576);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) 
	{
		EntityRegistry.registerModEntity(new ResourceLocation(timberwolfgalaxy.futures.util.Reference.MODID + ":" + name), entity, name, id, timberwolfgalaxy.futures.Main.instance, range, 1, true, color1, color2);
	}
}

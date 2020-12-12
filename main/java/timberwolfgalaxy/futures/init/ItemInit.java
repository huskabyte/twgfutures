package timberwolfgalaxy.futures.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import timberwolfgalaxy.futures.items.NetheriteIngot;
import timberwolfgalaxy.futures.items.NetheriteScrap;
import timberwolfgalaxy.futures.objects.blocks.BlockWoodenTrapdoor;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final Item NETHERITE_SCRAP = new NetheriteScrap("netherite_scrap");
	public static final Item NETHERITE_INGOT = new NetheriteIngot("netherite_ingot");
}


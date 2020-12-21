package timberwolfgalaxy.futures.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import timberwolfgalaxy.futures.objects.items.ArmorBase;
import timberwolfgalaxy.futures.objects.items.NetheriteIngot;
import timberwolfgalaxy.futures.objects.items.NetheriteScrap;
import timberwolfgalaxy.futures.objects.items.tools.ToolAxe;
import timberwolfgalaxy.futures.objects.items.tools.ToolPickaxe;
import timberwolfgalaxy.futures.objects.items.tools.ToolSpade;
import timberwolfgalaxy.futures.objects.items.tools.ToolSword;
import timberwolfgalaxy.futures.util.Reference;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Items
	public static final Item NETHERITE_SCRAP = new NetheriteScrap("netherite_scrap");
	public static final Item NETHERITE_INGOT = new NetheriteIngot("netherite_ingot");
	
	
	//Material
	public static final ToolMaterial MATERIAL_NETHERITE_INGOT = EnumHelper.addToolMaterial("material_netherite_ingot", 4, 2031, 17.0F, 4.5F, 150);
	public static final ArmorMaterial ARMOR_MATERIAL_NETHERITE_INGOT = EnumHelper.addArmorMaterial("armor_material_netherite_ingot", Reference.MODID + ":netherite_ingot", 37, 
			new int[] {4, 9, 7, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0F);
	
	//Tools
	public static final ItemSword NETHERITE_SWORD = new ToolSword("netherite_sword", MATERIAL_NETHERITE_INGOT);
	public static final ItemPickaxe NETHERITE_PICKAXE = new ToolPickaxe("netherite_pickaxe", MATERIAL_NETHERITE_INGOT);
	public static final ItemSpade NETHERITE_SPADE = new ToolSpade("netherite_spade", MATERIAL_NETHERITE_INGOT);
	public static final ItemAxe NETHERITE_AXE = new ToolAxe("netherite_axe", MATERIAL_NETHERITE_INGOT);
	
	//Armor
	public static final Item NETHERITE_HELMET = new ArmorBase("netherite_helmet", ARMOR_MATERIAL_NETHERITE_INGOT, 1, EntityEquipmentSlot.HEAD);
	public static final Item NETHERITE_CHESTPLATE = new ArmorBase("netherite_chestplate", ARMOR_MATERIAL_NETHERITE_INGOT, 1, EntityEquipmentSlot.CHEST);
	public static final Item NETHERITE_LEGGINGS = new ArmorBase("netherite_leggings", ARMOR_MATERIAL_NETHERITE_INGOT, 2, EntityEquipmentSlot.LEGS);
	public static final Item NETHERITE_BOOTS = new ArmorBase("netherite_boots", ARMOR_MATERIAL_NETHERITE_INGOT, 1, EntityEquipmentSlot.FEET);
	
}
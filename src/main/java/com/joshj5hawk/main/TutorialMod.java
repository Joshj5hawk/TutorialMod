package com.joshj5hawk.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.joshj5hawk.block.MetalBlock;
import com.joshj5hawk.block.OreBlock;
import com.joshj5hawk.item.TMItem;
import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.recipies.TMCraftingRecipies;
import com.joshj5hawk.recipies.TMSmeltingRecipies;
import com.joshj5hawk.worldgen.TMWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Strings.modid, version = Strings.version)
public class TutorialMod 
{
	//Items
	public static Item itemTinCog;
	//Ingots
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemZincIngot;
	//Blocks
	//Ores
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreZincOre;
	//Blocks
	public static Block blockCopperBlock;
	public static Block blockTinBlock;
	public static Block blockZincBlock;
	
	TMWorldGen eventWorldGen = new TMWorldGen();
	
	public static CreativeTabs tabTutorialMod;
	
	@EventHandler
	public void PreInti(FMLPreInitializationEvent preEvent)
	{
		//CreativeTabInit
		tabTutorialMod = new CreativeTabs("TutorialMod")
		{
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem()
				{
					return Item.getItemFromBlock(TutorialMod.oreCopperOre);
				}
		};
		
		//ItemInit
		itemCopperIngot = new TMItem().setUnlocalizedName("copperIngot");
		itemTinIngot = new TMItem().setUnlocalizedName("tinIngot");
		itemZincIngot = new TMItem().setUnlocalizedName("zincIngot");
		itemTinCog = new TMItem().setUnlocalizedName("tinCog");
		//ItemRegister
		GameRegistry.registerItem(itemCopperIngot, "copperIngot");
		GameRegistry.registerItem(itemTinIngot, "tinIngot");
		GameRegistry.registerItem(itemZincIngot, "zincIngot");	
		GameRegistry.registerItem(itemTinCog, "tinCog");
		
		
		//BlockInit
		//Ores
		oreCopperOre = new OreBlock(Material.rock).setBlockName("copperOre").setBlockTextureName(Strings.modid + ":" + "copperOre");
		oreTinOre = new OreBlock(Material.rock).setBlockName("tinOre").setBlockTextureName(Strings.modid + ":" + "tinOre");
		oreZincOre = new OreBlock(Material.rock).setBlockName("zincOre").setBlockTextureName(Strings.modid + ":" + "zincOre");
		/*oreManganeseOre = new OreBlock(Material.rock).setBlockName("manganeseOre").setBlockTextureName(Strings.modid + ":" + "manganeseOre");
		oreVanadiumOre = new OreBlock(Material.rock).setBlockName("vanadiumOre").setBlockTextureName(Strings.modid + ":" + "vanadiumOre");
		oreRhodiumOre = new OreBlock(Material.rock).setBlockName("rhodiumOre").setBlockTextureName(Strings.modid + ":" + "rhodiumOre");*/
		
		//Metal Blocks
		blockCopperBlock = new MetalBlock(Material.iron).setBlockName("copperBlock").setBlockTextureName(Strings.modid + ":" + "copperBlock");
		blockTinBlock = new MetalBlock(Material.iron).setBlockName("tinBlock").setBlockTextureName(Strings.modid + ":" + "tinBlock");
		blockZincBlock = new MetalBlock(Material.iron).setBlockName("zincBlock").setBlockTextureName(Strings.modid + ":" + "zincBlock");
		//BlockRegister
		GameRegistry.registerBlock(oreCopperOre, "copperOre");
		GameRegistry.registerBlock(oreTinOre, "tinOre");
		GameRegistry.registerBlock(oreZincOre, "zincOre");
		GameRegistry.registerBlock(blockCopperBlock, "copperBlock");
		GameRegistry.registerBlock(blockTinBlock, "tinBlock");
		GameRegistry.registerBlock(blockZincBlock, "zincBlock");
		
		//Spawning
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		TMCraftingRecipies.mainRegistry();
		TMSmeltingRecipies.mainRegistry();
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}

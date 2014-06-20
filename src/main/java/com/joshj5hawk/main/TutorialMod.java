package com.joshj5hawk.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.joshj5hawk.block.OreBlock;
import com.joshj5hawk.block.SlipperyStone;
import com.joshj5hawk.block.TMBlock;
import com.joshj5hawk.block.TutOven;
import com.joshj5hawk.handler.TMCrafting;
import com.joshj5hawk.handler.TMFuelHandler;
import com.joshj5hawk.handler.TMGUIHandler;
import com.joshj5hawk.handler.TMWorldGen;
import com.joshj5hawk.item.CopperAxe;
import com.joshj5hawk.item.CopperHoe;
import com.joshj5hawk.item.CopperPickaxe;
import com.joshj5hawk.item.CopperShovel;
import com.joshj5hawk.item.CopperSword;
import com.joshj5hawk.item.IronHammer;
import com.joshj5hawk.item.IronPunch;
import com.joshj5hawk.item.TMItem;
import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.recipies.TMCraftingRecipies;
import com.joshj5hawk.recipies.TMSmeltingRecipies;
import com.joshj5hawk.tileentity.TileEntityTutOven;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Strings.modid, version = Strings.version)
public class TutorialMod 
{
	
	@Instance(Strings.modid)
	public static TutorialMod instance;
	//ToolMat
	public static ToolMaterial copperMat = EnumHelper.addToolMaterial("copperMat", 2, 750, 6.0F, 2.0F, 10);
	
	//Items
	public static Item itemTinCog;
	public static Item itemIronDisk;
	public static Item itemIronWasher;
	public static Item itemIronHammer;
	public static Item itemIronPunch;
	public static Item itemTreePitch;
	//Ingots
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemZincIngot;
	public static Item itemTopazGem;
	//Tools
	public static Item itemCopperSword;
	public static Item itemCopperAxe;
	public static Item itemCopperShovel;
	public static Item itemCopperHoe;
	public static Item itemCopperPickaxe;
	
	//Blocks
	public static Block blockSlipperyStone;
	
	public static Block blockTutOvenIdle;
	public static Block blockTutOvenActive;
	public static final int guiIDTutOven = 0;
	//Ores
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreZincOre;
	public static Block oreTopazOre;
	//Blocks
	public static Block blockCopperBlock;
	public static Block blockTinBlock;
	public static Block blockZincBlock;
	public static Block blockTopazBlock;
	
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
		itemTopazGem = new TMItem().setUnlocalizedName("topazGem");
		
		itemTinCog = new TMItem().setUnlocalizedName("tinCog");
		
		itemIronDisk = new TMItem().setUnlocalizedName("ironDisk");
		itemIronWasher = new TMItem().setUnlocalizedName("ironWasher");
		itemIronHammer = new IronHammer().setUnlocalizedName("ironHammer");
		itemIronPunch = new IronPunch().setUnlocalizedName("ironPunch");
		itemTreePitch = new TMItem().setUnlocalizedName("treePitch");
		//Tools
		 itemCopperSword = new CopperSword(copperMat).setUnlocalizedName("copperSword");
		 itemCopperAxe = new CopperAxe(copperMat).setUnlocalizedName("copperAxe");
		 itemCopperShovel = new CopperShovel(copperMat).setUnlocalizedName("copperShovel");
		 itemCopperHoe = new CopperHoe(copperMat).setUnlocalizedName("copperHoe");
		 itemCopperPickaxe = new CopperPickaxe(copperMat).setUnlocalizedName("copperPickaxe");
		//ItemRegister
		GameRegistry.registerItem(itemCopperIngot, "copperIngot");
		GameRegistry.registerItem(itemTinIngot, "tinIngot");
		GameRegistry.registerItem(itemZincIngot, "zincIngot");	
		GameRegistry.registerItem(itemTopazGem, "topazGem");
		GameRegistry.registerItem(itemTinCog, "tinCog");
		GameRegistry.registerItem(itemIronDisk, "ironDisk");
		GameRegistry.registerItem(itemIronWasher, "ironWasher");
		GameRegistry.registerItem(itemIronHammer, "ironHammer");
		GameRegistry.registerItem(itemIronPunch, "ironPunch");
		GameRegistry.registerItem(itemTreePitch, "treePitch");
		GameRegistry.registerItem(itemCopperSword, "copperSword");
		GameRegistry.registerItem(itemCopperAxe, "copperAxe");
		GameRegistry.registerItem(itemCopperShovel, "copperShovel");
		GameRegistry.registerItem(itemCopperHoe, "copperHoe");
		GameRegistry.registerItem(itemCopperPickaxe, "copperPickaxe");
		
		
		//BlockInit
		//Machines
		blockTutOvenIdle = new TutOven(false).setBlockName("tutOvenIdle")/*.setBlockTextureName(Strings.modid + ":" + "tutOvenIdle")*/.setCreativeTab(tabTutorialMod);
		blockTutOvenActive = new TutOven(true).setBlockName("tutOvenActive")/*.setBlockTextureName(Strings.modid + ":" + "tutOvenActive")*/.setLightLevel(0.625F);
		blockSlipperyStone = new SlipperyStone(Material.rock).setBlockName("slipperyStone").setBlockTextureName(Strings.modid + ":" + "slipperyStone");
		//Ores
		oreCopperOre = new OreBlock(Material.rock).setBlockName("copperOre").setBlockTextureName(Strings.modid + ":" + "copperOre");
		oreTinOre = new OreBlock(Material.rock).setBlockName("tinOre").setBlockTextureName(Strings.modid + ":" + "tinOre");
		oreZincOre = new OreBlock(Material.rock).setBlockName("zincOre").setBlockTextureName(Strings.modid + ":" + "zincOre");
		oreTopazOre = new OreBlock(Material.rock).setBlockName("topazOre").setBlockTextureName(Strings.modid + ":" + "topazOre");
		/*oreManganeseOre = new OreBlock(Material.rock).setBlockName("manganeseOre").setBlockTextureName(Strings.modid + ":" + "manganeseOre");
		oreVanadiumOre = new OreBlock(Material.rock).setBlockName("vanadiumOre").setBlockTextureName(Strings.modid + ":" + "vanadiumOre");
		oreRhodiumOre = new OreBlock(Material.rock).setBlockName("rhodiumOre").setBlockTextureName(Strings.modid + ":" + "rhodiumOre");*/
		
		//Metal Blocks
		blockCopperBlock = new TMBlock(Material.iron).setBlockName("copperBlock").setBlockTextureName(Strings.modid + ":" + "copperBlock");
		blockTinBlock = new TMBlock(Material.iron).setBlockName("tinBlock").setBlockTextureName(Strings.modid + ":" + "tinBlock");
		blockZincBlock = new TMBlock(Material.iron).setBlockName("zincBlock").setBlockTextureName(Strings.modid + ":" + "zincBlock");
		blockTopazBlock = new TMBlock(Material.iron).setBlockName("topazBlock").setBlockTextureName(Strings.modid + ":" + "topazBlock");
		//BlockRegister
		GameRegistry.registerBlock(oreCopperOre, "copperOre");
		GameRegistry.registerBlock(oreTinOre, "tinOre");
		GameRegistry.registerBlock(oreZincOre, "zincOre");
		GameRegistry.registerBlock(oreTopazOre, "topazOre");
		GameRegistry.registerBlock(blockCopperBlock, "copperBlock");
		GameRegistry.registerBlock(blockTinBlock, "tinBlock");
		GameRegistry.registerBlock(blockZincBlock, "zincBlock");
		GameRegistry.registerBlock(blockTopazBlock, "topazBlock");
		GameRegistry.registerBlock(blockSlipperyStone, "slipperyStone");
		GameRegistry.registerBlock(blockTutOvenIdle, "tutOvenIdle");
		GameRegistry.registerBlock(blockTutOvenActive, "tutOvenActive");
		
		//Spawning
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);

		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
		GameRegistry.registerTileEntity(TileEntityTutOven.class, "tutOven");
		
		FMLCommonHandler.instance().bus().register(new TMCrafting());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new TMGUIHandler());
		//Crafting
		TMCraftingRecipies.mainRegistry();
		TMSmeltingRecipies.mainRegistry();
		//Fuel Handler
		GameRegistry.registerFuelHandler(new TMFuelHandler());
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}

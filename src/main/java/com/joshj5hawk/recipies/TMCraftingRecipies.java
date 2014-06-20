package com.joshj5hawk.recipies;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class TMCraftingRecipies 
{
	
	public static void mainRegistry()
	{
		shapedRecipies();
		shapelessRecipies();
	}
	
	public static void shapedRecipies()
	{
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockCopperBlock), new Object[] {"CCC", "CCC", "CCC", 'C', TutorialMod.itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockTinBlock), new Object[] {"CCC", "CCC", "CCC", 'C', TutorialMod.itemTinIngot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockZincBlock), new Object[] {"CCC", "CCC", "CCC", 'C', TutorialMod.itemZincIngot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockTopazBlock), new Object[] {"CCC", "CCC", "CCC", 'C', TutorialMod.itemTopazGem});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemTinCog, 4), new Object[] {" X ", "X X", " X ", 'X', TutorialMod.itemTinIngot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemIronHammer), new Object[]{"ISI", "ISI", " S ", 'S', Items.stick, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemIronPunch), new Object[]{"SI ", "SII", "S  ", 'S', Items.stick, 'I', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemCopperSword), new Object[]{" C ", " C ", " S ", 'C', TutorialMod.itemCopperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemCopperAxe), new Object[]{" CC", " SC", " S ", 'C', TutorialMod.itemCopperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemCopperShovel), new Object[]{" C ", " S ", " S ", 'C', TutorialMod.itemCopperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemCopperHoe), new Object[]{" CC", " S ", " S ", 'C', TutorialMod.itemCopperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemCopperPickaxe), new Object[]{"CCC", " S ", " S ", 'C', TutorialMod.itemCopperIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockSlipperyStone, 8), new Object[]{"SIS", "ISI", "SIS", 'S', Blocks.stone, 'I', Blocks.ice});
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockSlipperyStone, 8), new Object[]{"ISI", "SIS", "ISI", 'S', Blocks.stone, 'I', Blocks.ice});
		
	}
	
	public static void shapelessRecipies()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreCopperOre), new Object[]{TutorialMod.itemCopperIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreTinOre), new Object[]{TutorialMod.itemTinIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreZincOre), new Object[]{TutorialMod.itemZincIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreTopazOre), new Object[]{TutorialMod.itemTopazGem, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemCopperIngot, 9), new Object[]{TutorialMod.blockCopperBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemTinIngot, 9), new Object[]{TutorialMod.blockTinBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemZincIngot, 9), new Object[]{TutorialMod.blockZincBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemTopazGem, 9), new Object[]{TutorialMod.blockTopazBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemIronDisk, 2), new Object[]{new ItemStack(TutorialMod.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE), Items.iron_ingot});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemIronWasher, 2), new Object[]{new ItemStack(TutorialMod.itemIronPunch, 1, OreDictionary.WILDCARD_VALUE), TutorialMod.itemIronDisk});
	}
}

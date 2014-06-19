package com.joshj5hawk.recipies;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

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
		GameRegistry.addRecipe(new ItemStack(TutorialMod.itemTinCog, 4), new Object[] {" X ", "X X", " X ", 'X', TutorialMod.itemTinIngot});
	}
	
	public static void shapelessRecipies()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreCopperOre), new Object[]{TutorialMod.itemCopperIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreTinOre), new Object[]{TutorialMod.itemTinIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.oreZincOre), new Object[]{TutorialMod.itemZincIngot, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemCopperIngot, 9), new Object[]{TutorialMod.blockCopperBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemTinIngot, 9), new Object[]{TutorialMod.blockTinBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(TutorialMod.itemZincIngot, 9), new Object[]{TutorialMod.blockZincBlock});
	}
}

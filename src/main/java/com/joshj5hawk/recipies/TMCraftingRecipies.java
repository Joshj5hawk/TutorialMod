package com.joshj5hawk.recipies;

import net.minecraft.item.ItemStack;

import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class TMCraftingRecipies 
{
	public static void mainRegistry()
	{
		craftingRecipies();
	}
	
	public static void craftingRecipies()
	{
		GameRegistry.addRecipe(new ItemStack(TutorialMod.blockCopperBlock), new Object[] {"CCC", "CCC", "CCC", 'C', TutorialMod.itemCopperIngot});
	}
}

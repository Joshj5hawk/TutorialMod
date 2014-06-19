package com.joshj5hawk.recipies;

import net.minecraft.item.ItemStack;

import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class TMSmeltingRecipies 
{
	public static void mainRegistry()
	{
		smeltingRecipies();
	}
	
	public static void smeltingRecipies()
	{
		GameRegistry.addSmelting(TutorialMod.oreCopperOre, new ItemStack(TutorialMod.itemCopperIngot), 0.0F);
	}
}

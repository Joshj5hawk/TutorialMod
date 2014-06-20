package com.joshj5hawk.handler;

import com.joshj5hawk.main.TutorialMod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class TMFuelHandler implements IFuelHandler 
{

	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		if(fuel.getItem() == TutorialMod.itemTreePitch) return 800;
		
		return 0;
	}
	
}

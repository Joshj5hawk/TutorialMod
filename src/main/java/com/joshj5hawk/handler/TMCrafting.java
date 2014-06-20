package com.joshj5hawk.handler;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class TMCrafting 
{
	@SubscribeEvent
	public void onCafting(ItemCraftedEvent event)
	{
		@SuppressWarnings("unused")
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++)
		{
			if(event.craftMatrix.getStackInSlot(i) != null)
			{
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
					if(item0 != null && item0.getItem() == TutorialMod.itemIronHammer)
					{
						ItemStack k = new ItemStack(TutorialMod.itemIronHammer, 2, (item0.getItemDamage() + 1));
						
						if (k.getItemDamage() >= k.getMaxDamage())
						{
							k.stackSize--;
						}
					event.craftMatrix.setInventorySlotContents(i, k);
					}
				ItemStack item1 = event.craftMatrix.getStackInSlot(i);
					if(item1 != null && item1.getItem() == TutorialMod.itemIronPunch)
					{
						ItemStack k = new ItemStack(TutorialMod.itemIronPunch, 2, (item0.getItemDamage() + 1));
						
						if (k.getItemDamage() >= k.getMaxDamage())
						{
							k.stackSize--;
						}
					event.craftMatrix.setInventorySlotContents(i, k);
					}
			}
		}
	}
	
}

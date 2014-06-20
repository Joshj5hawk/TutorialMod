package com.joshj5hawk.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.joshj5hawk.tileentity.TileEntityTutOven;

public class ContainerTutOven extends Container
{

	private TileEntityTutOven  tutOven;
	
	public ContainerTutOven(InventoryPlayer inventoryPlayer, TileEntityTutOven entity)
	{
		this.tutOven = entity;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return false;
	}

}

package com.joshj5hawk.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.tileentity.TileEntityTutOven;

public class GuiTutOven extends GuiContainer
{
	public static final ResourceLocation bground = new ResourceLocation(Strings.modid, "textures/gui/GuiTutOven.png");
	
	public TileEntityTutOven tutOven;
	
	public GuiTutOven(InventoryPlayer inventoryPlayer, TileEntityTutOven entity) 
	{
		super(ContainerTutOven(inventoryPlayer, entity));
		
		this.tutOven = entity;
	}
	
	

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		
	}
	
}

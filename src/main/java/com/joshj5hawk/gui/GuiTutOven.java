package com.joshj5hawk.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.tileentity.TileEntityTutOven;
import com.joshj5hawk.container.ContainerTutOven;

public class GuiTutOven extends GuiContainer
{
	public static final ResourceLocation bground = new ResourceLocation(Strings.modid + ":" + "textures/gui/guiTutOven.png");
	
	public TileEntityTutOven tutOven;
	
	public GuiTutOven(InventoryPlayer inventory, TileEntityTutOven tileentity) 
	{
		super(new ContainerTutOven(inventory, tileentity));
		
		this.tutOven = tileentity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = this.tutOven.hasCustomInventoryName() ? this.tutOven.getInventoryName() : I18n.format(this.tutOven.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 119, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.tutOven.isBurning())
		{
			int k = this.tutOven.getBurnTimeRemainingScaled(32);
			int j = 32 - k;
			drawTexturedModalRect(guiLeft + 28, guiTop + 71, 176, 0, 32 - j, 6);
		}
		
		int k = this.tutOven.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 35, 176, 6, k + 1, 16);
	}
	
}

//X Size = 176 Y Size = 166

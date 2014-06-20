package com.joshj5hawk.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.joshj5hawk.container.ContainerTutOven;
import com.joshj5hawk.gui.GuiTutOven;
import com.joshj5hawk.main.TutorialMod;
import com.joshj5hawk.tileentity.TileEntityTutOven;

import cpw.mods.fml.common.network.IGuiHandler;

public class TMGUIHandler implements IGuiHandler 
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
			if(entity != null)
			{
				switch(ID)
				{
					case TutorialMod.guiIDTutOven:
						if(entity instanceof TileEntityTutOven)
						{
							return new ContainerTutOven(player.inventory, (TileEntityTutOven) entity);
						}
				}
			}
			
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
		{
			switch(ID)
			{
				case TutorialMod.guiIDTutOven:
					if(entity instanceof TileEntityTutOven)
					{
						return new GuiTutOven(player.inventory, (TileEntityTutOven) entity);
					}
			}
		}
		
		return null;
	}

}

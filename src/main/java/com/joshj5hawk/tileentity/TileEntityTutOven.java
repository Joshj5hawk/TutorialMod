package com.joshj5hawk.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityTutOven extends TileEntity
{
	private String localizedName;
	
	public void setGuiDisplayName(String name)
	{
		this.localizedName = name;
	}
}

package com.joshj5hawk.item;

import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.main.TutorialMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TMItem extends Item 
{
	public TMItem()
	{
		this.setCreativeTab(TutorialMod.tabTutorialMod);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Strings.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}

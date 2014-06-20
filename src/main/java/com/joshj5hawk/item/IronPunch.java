package com.joshj5hawk.item;

import com.joshj5hawk.lib.Strings;
import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class IronPunch extends Item
{

	public IronPunch()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setNoRepair();
		this.setCreativeTab(TutorialMod.tabTutorialMod);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iR)
	{
		this.itemIcon = iR.registerIcon(Strings.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}

package com.joshj5hawk.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.joshj5hawk.main.TutorialMod;

public class SlipperyStone extends Block
{
	public SlipperyStone(Material mat) 
	{
		super(mat);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(TutorialMod.tabTutorialMod);
		this.slipperiness = 0.98F;
	}
	
}
package com.joshj5hawk.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.joshj5hawk.main.TutorialMod;

public class OreBlock extends Block
{

	public OreBlock(Material material) 
	{
		super(material);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(TutorialMod.tabTutorialMod);
	}
}


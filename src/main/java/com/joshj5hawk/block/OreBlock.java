package com.joshj5hawk.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

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
	
	public int quantityDropped(Random random)
	{
		return this == TutorialMod.oreTopazOre ? 2 + random.nextInt(3) : 1;
	}
	
	public Item getItemDropped(int i, Random random, int j)
	{
		return this == TutorialMod.oreTopazOre ? TutorialMod.itemTopazGem : Item.getItemFromBlock(this);
	}
}


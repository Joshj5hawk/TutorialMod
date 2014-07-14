package com.joshj5hawk.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

import com.joshj5hawk.block.TutOven;
import com.joshj5hawk.main.TutorialMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityTutOven extends TileEntity implements ISidedInventory
{
	private String localizedName;
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{0};
	
	private ItemStack[] slots = new ItemStack [3];
	
	public int furnaceSpeed = 150;
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;
	
	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}
	
	
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.localizedName : "container.tutOven";
	}


	public boolean hasCustomInventoryName() 
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public int getSizeInventory()
	{
		return this.slots.length;
	}


	@Override
	public ItemStack getStackInSlot(int var1) 
	{
		return this.slots[var1];
	}


	@Override
	public ItemStack decrStackSize(int var1, int var2) 
	{
		if(this.slots[var1] != null)
		{
			ItemStack is;
			if(this.slots[var1].stackSize <= var2)
			{
				is = this.slots[var1];
				this.slots[var1] = null;
				return is;
			}
			else
			{
				is = this.slots[var1].splitStack(var2);
				
				if(this.slots[var1].stackSize == 0)
				{
					this.slots[var1] = null;
				}
			}
		}
		
		return null;
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int i) 
	{
		if(this.slots[i] != null)
		{
			ItemStack is = this.slots[i];
			this.slots[i] = null;
			return is;
		}
		return null;
	}


	@Override
	public void setInventorySlotContents(int i, ItemStack is) 
	{
		this.slots[i] = is;
		
		if(is != null && is.stackSize > this.getInventoryStackLimit())
		{
			is.stackSize = this.getInventoryStackLimit();
		}
	}


	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}


	
	public void openInventory() 
	{
		
	}

	public void closeInventory() 
	{
		
	}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) 
	{
		return i == 2 ? false : (i == 1 ? isItemFuel(is) : true);
	}
	
	public static boolean isItemFuel(ItemStack is)
	{
		return getItemBurnTime(is) > 0;
	}
	
	private static int getItemBurnTime(ItemStack is)
	{
		if(is == null)
		{
			return 0;
		}
		else
		{
			Item item = is.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
				{
					Block block = Block.getBlockFromItem(item);

					if(block == Blocks.sapling) return 100;
					if(block == Blocks.coal_block) return 14400;
				}
				
			if(item == TutorialMod.itemTreePitch) return 800;
			if(item == Items.coal) return 1600;
			if(item == Items.stick) return 100;
			if(item == Items.lava_bucket) return 20000;
			if(item == Items.blaze_rod) return 2400;
			if(item == Items.blaze_powder) return 800;
		}
				return GameRegistry.getFuelValue(is);
	}
	
	public boolean isBurning()
	{
		return this.burnTime > 0;
	}
	
	public void updateEntity()
	{
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if(this.isBurning())
		{
			this.burnTime--;
		}
		if(!this.worldObj.isRemote)
		{
			if(this.burnTime == 0 && this.canSmelt())
			{
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if(this.isBurning())
				{
					flag1 = true;
					
					if(this.slots[1] != null)
					{
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0)
						{
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}if(this.isBurning() && this.canSmelt())
			{
				this.cookTime++;
				
				if(this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if(flag != this.isBurning())
			{
				flag1 = true;
				TutOven.updateTutOvenBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag1)
		{
			this.markDirty();
		}
	}
	
	public boolean canSmelt()
	{
		if(this.slots[0] == null)
		{
			return false;
		}
		else
		{
			//Do I want 'Nilla recipes? (Comment out for No)
			ItemStack is = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(is == null) return false;
			if(this.slots[2] == null) return true;
			if(this.slots[2].isItemEqual(is)) return false;
			
			int result = this.slots[2].stackSize + is.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= is.getMaxStackSize());
			
		}
	}
	
	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack is = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
		
			if(this.slots[2] == null)
			{
				this.slots[2] = is.copy();
			}
			else if(this.slots[2].isItemEqual(is))
			{
				this.slots[2].stackSize += is.stackSize;
			}
		
			this.slots[0].stackSize--;
		
			if(this.slots[0].stackSize <= 0)
			{
				this.slots[0] = null;
			}
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) 
	{
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}


	@Override
	public boolean canInsertItem(int i, ItemStack is, int var3) 
	{
		return this.isItemValidForSlot(i, is);
	}


	@Override
	public boolean canExtractItem(int i, ItemStack is, int j) 
	{
		return j != 0 || i != 1 || is.getItem() == Items.bucket;
	}
	
	public int getBurnTimeRemainingScaled(int i)
	{
		if(this.currentItemBurnTime == 0)
		{
			this.currentItemBurnTime = this.furnaceSpeed;
		}
		return this.burnTime * i / this.currentItemBurnTime;
	}
	
	public int getCookProgressScaled(int i)
	{
		return this.cookTime * i / this.furnaceSpeed;
	}
}

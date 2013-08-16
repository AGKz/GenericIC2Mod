package tutorial.generic;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricItemBase extends Item implements IElectricItem {

	public int maxCharge;
	public int transferLimit;
	public int tier;
	
	public ElectricItemBase(int id) {
		super(id);
		setMaxDamage(27);
		setMaxStackSize(1);
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		return this.itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return this.maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return this.tier;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return this.transferLimit;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List itemList)
	{
		ItemStack itemStack = new ItemStack(this, 1);

	    if (getChargedItemId(itemStack) == this.itemID) {
	      ItemStack charged = new ItemStack(this, 1);
	      ElectricItem.manager.charge(charged, 2147483647, 2147483647, true, false);
	      itemList.add(charged);
	    }

	    if (getEmptyItemId(itemStack) == this.itemID) itemList.add(new ItemStack(this, 1, getMaxDamage()));
	  }

}

package tutorial.generic;

import ic2.api.item.ElectricItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricFood extends ElectricItemBase {
	
	public ElectricFood(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName("electricfood");
		this.maxCharge = 2000;
		this.transferLimit = 100;
		this.tier = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
	    if (ElectricItem.manager.use(itemstack, 500, player))
	    {
	    	if(!world.isRemote)
	    		player.addChatMessage(EnumChatFormatting.AQUA + "How did that taste?");
	    	
	    	if(player.isSneaking()) {
	    		player.getFoodStats().addStats(-2, 2.4F);
	    		return itemstack;
	    	} else {
	    		player.getFoodStats().addStats(2, 2.4F);
	    		return itemstack;
	    	}
	    } else {
	    	if(!world.isRemote)
	    		player.addChatMessage(EnumChatFormatting.RED + "Opps. Out of power");
	    }

	    return itemstack;
	  }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.itemIcon = icon.registerIcon(Generic.modid.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}
}
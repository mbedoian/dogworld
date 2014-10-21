package tutorial.generic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NylaBone extends Item {
	public NylaBone(int maxStackSize, CreativeTabs tab, int texture,
			String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}

	public NylaBone() {
		super();
		// Constructor Configuration
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("nylaBone");
	}

}
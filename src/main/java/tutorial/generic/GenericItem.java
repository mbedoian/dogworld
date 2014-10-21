package tutorial.generic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item {
	public GenericItem(int maxStackSize, CreativeTabs tab, int texture,
			String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}

	public GenericItem() {
		super();
		// Constructor Configuration
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("nyla");
	}

}
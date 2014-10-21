package tutorial.generic;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.PostInit;
//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance; //1.6.X
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Generic", name = "Generic", version = "0.0.0")
// @NetworkMod(clientSideRequired = true, serverSideRequired = false, channels =
// { "GenericRandom" })
public class Generic {
//	public static Item item1;
	public static NylaItem nyla;
	public static NylaBone nylaBone;
	public final static Block nylaBlock = new NylaOre(Material.rock)
			.setHardness(1.0F).setStepSound(Block.soundTypeGravel)
			.setBlockName("nylaOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setBlockTextureName("generic:nylaOre");

	@Instance("Generic")
	public static Generic instance;

	@SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		nyla = new NylaItem();
		nyla.setTextureName("generic:nyla");
		nylaBone = new NylaBone();
		nylaBone.setTextureName("generic:nylaBone");
		GameRegistry.registerItem(nyla, "nyla");
		GameRegistry.registerItem(nylaBone, "nylaBone");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

		ItemStack nylaStack = new ItemStack(nyla);
		ItemStack boneStack = new ItemStack(Items.bone);
		GameRegistry.registerBlock(nylaBlock, "NylaBlock");
		GameRegistry.addSmelting(nylaBlock, new ItemStack(nyla), 0.1f);
		GameRegistry.addRecipe(new ItemStack(nylaBone), 
								"xxx",
								"xyx",
								"xxx", 'x', nylaStack, 'y', boneStack);
								

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
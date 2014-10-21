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
	public static Item nyla;
	public final static Block nylaBlock = new NylaBlock(Material.ground)
			.setHardness(1.0F).setStepSound(Block.soundTypeGravel)
			.setBlockName("nylaBlock")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setBlockTextureName("generic:nylaBlock");

	@Instance("Generic")
	public static Generic instance;

	@SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		nyla = new GenericItem();
		nyla.setTextureName("generic:nyla");
		GameRegistry.registerItem(nyla, "nyla");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

		ItemStack dirtStack = new ItemStack(Blocks.dirt);
		ItemStack diamondsStack = new ItemStack(Items.diamond, 64);
		ItemStack blackWoolStack = new ItemStack(Blocks.wool, 42, 15);

		GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);
		GameRegistry.registerBlock(nylaBlock, "NylaBlock");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
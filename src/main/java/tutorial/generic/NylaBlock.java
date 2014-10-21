package tutorial.generic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class NylaBlock extends Block {

	public NylaBlock(Material material) {
		super(material);
		setHarvestLevel("pickaxe",5);
	}

	 @Override
     public Item getItemDropped(int metadata, Random random, int fortune) {
         return Generic.nyla;
     }
}
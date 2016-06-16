package com.squaresuits.magicalpotionsandbrews.crafting;

import com.squaresuits.magicalpotionsandbrews.init.MPBBlocks;
import com.squaresuits.magicalpotionsandbrews.init.MPBItems;
import com.squaresuits.magicalpotionsandbrews.registry.MPBRecipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import scala.Console;

public class MPBRecipes {
	
	public static void initRecipes(){
		
		//Pyrite Block
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBBlocks.pyrite_block),
				new Object [] {
						"###",
						"###",
						"###",
						'#', "ingotPyrite"
				}));
		//Pyrite Infused Glass
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBBlocks.pyrite_glass_block, 4),
				new Object [] {
						"###",
						"#@#",
						"###",
						'#', "blockGlass",
						'@', "ingotPyrite"
				}));
		//Pyrite Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(MPBItems.pyrite_ingot, 9),
				new Object [] {
				MPBBlocks.pyrite_block
				});
		// Flask Component
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBItems.iron_flask_component),
				new Object [] {
						" o ",
						"oxo",
						"   ",
						'o', "ingotIron",
						'x', "ingotPyrite"
				}));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBItems.gold_flask_component),
				new Object [] {
						" o ",
						"oxo",
						"   ",
						'o', "ingotGold",
						'x', "ingotPyrite"
				}));
    	
    	//Potion Flask
    	GameRegistry.addRecipe(new MPBRecipe(new ItemStack(MPBItems.potion_flask),
				new Object [] {
						" o ",
						"x x",
						"xxx",
						'o', MPBItems.iron_flask_component,
						'x', MPBBlocks.pyrite_glass_block
				}));
    	GameRegistry.addRecipe(new MPBRecipe(new ItemStack(MPBItems.potion_flask),
				new Object [] {
						" o ",
						"x x",
						"xxx",
						'o', MPBItems.gold_flask_component,
						'x', MPBBlocks.pyrite_glass_block
				}));
		 if (Loader.isModLoaded("basemetals")) {
	            try {
	            	//Copper Flask Component
	            	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBItems.copper_flask_component),
	        				new Object [] {
	        						" o ",
	        						"oxo",
	        						"   ",
	        						'o', "ingotCopper",
	        						'x', "ingotPyrite"
	        				}));
	            	//Copper Flask Component
	            	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MPBItems.starsteel_flask_component),
	        				new Object [] {
	        						" o ",
	        						"oxo",
	        						"   ",
	        						'o', "ingotStarsteel",
	        						'x', "ingotPyrite"
	        				}));
	            	
	            	GameRegistry.addRecipe(new MPBRecipe(new ItemStack(MPBItems.potion_flask),
	        				new Object [] {
	        						" o ",
	        						"x x",
	        						"xxx",
	        						'o', MPBItems.copper_flask_component,
	        						'x', MPBBlocks.pyrite_glass_block
	        				}));
	            	GameRegistry.addRecipe(new MPBRecipe(new ItemStack(MPBItems.potion_flask),
	        				new Object [] {
	        						" o ",
	        						"x x",
	        						"xxx",
	        						'o', MPBItems.starsteel_flask_component,
	        						'x', MPBBlocks.pyrite_glass_block
	        				}));
	                Console.out().println("Base Metals found - recipes added!");
	            }
	            catch (Exception e) {
	            	Console.out().println("Base Metals not found!");
	                e.printStackTrace(System.err);
	            }
	        }
	}

}
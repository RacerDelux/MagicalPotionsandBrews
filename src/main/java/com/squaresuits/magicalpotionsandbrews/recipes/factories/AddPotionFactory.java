package com.squaresuits.magicalpotionsandbrews.recipes.factories;

import com.google.gson.JsonObject;
import com.squaresuits.magicalpotionsandbrews.recipes.PABShapedOreRecipe;
import com.squaresuits.magicalpotionsandbrews.recipes.PotionAdditionFlaskRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class AddPotionFactory implements IRecipeFactory {
    @Override
    public IRecipe parse(JsonContext context, JsonObject json) {
        ShapedOreRecipe recipe = ShapedOreRecipe.factory(context, json);

        CraftingHelper.ShapedPrimer primer = new CraftingHelper.ShapedPrimer();
        primer.width = recipe.getRecipeWidth();
        primer.height = recipe.getRecipeHeight();
        primer.mirrored = JsonUtils.getBoolean(json, "mirrored", true);
        primer.input = recipe.getIngredients();

        return new PotionAdditionFlaskRecipe(recipe.getRecipeOutput(), primer);
    }
}
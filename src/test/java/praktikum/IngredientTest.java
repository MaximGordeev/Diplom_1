package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data: {0} {1} {2}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88.0f},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000.0f},
        };
    }
    @Before
    public void initIngredient() {
        ingredient = new Ingredient(ingredientType, name, price);
    }
    @Test
    public void getPriceReturnIngredientPrice() {
        Assert.assertEquals("Error! Expected - " + price, price, ingredient.getPrice(), 0);
    }
    @Test
    public void getNameReturnIngredientName() {
        Assert.assertEquals("Error! Expected - " + name, name, ingredient.getName());
    }
    @Test
    public void getTypeReturnIngredientsType() {
        Assert.assertEquals("Error! Not expected ingredient type - " + ingredientType, ingredientType, ingredient.getType());
    }
}

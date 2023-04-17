package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingrOne;
    @Mock
    Ingredient ingrTwo;
    @Mock
    Ingredient ingrThree;
    @Mock
    Ingredient ingrFour;

    Burger burger;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingrOne);
        burger.addIngredient(ingrTwo);
        burger.addIngredient(ingrThree);

        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(ingrOne.getPrice()).thenReturn(90.0f);
        Mockito.when(ingrTwo.getPrice()).thenReturn(300.0f);
        Mockito.when(ingrThree.getPrice()).thenReturn(424.0f);

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingrOne.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(ingrTwo.getName()).thenReturn("Хрустящие минеральные кольца");
        Mockito.when(ingrThree.getName()).thenReturn("Биокотлета из марсианской Магнолии");

        Mockito.when(ingrOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingrTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingrThree.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunInBurger() {
        burger.setBuns(bun);
        Assert.assertNotNull("Error", burger.bun);
    }
    @Test
    public void addIngredientFromBurger() {
        burger.addIngredient(ingrFour);
        Assert.assertEquals("Error, expected 4 ingredients", 4, burger.ingredients.size());
    }
    @Test
    public void removeIngredientFromBurger() {
        burger.removeIngredient(0);
        Assert.assertEquals("Error, expected 2 ingredients", 2, burger.ingredients.size());
    }
    @Test
    public void moveIngredientsInBurger() {
        burger.moveIngredient(0, 2);
        Assert.assertEquals("Error, expected index ingrOne = 2", 2, burger.ingredients.indexOf(ingrOne));
    }
    @Test
    public void getPriceAllBurger() {
        float ingredientsSum = bun.getPrice() * 2 + ingrOne.getPrice() + ingrTwo.getPrice() + ingrThree.getPrice();
        Assert.assertEquals("Error", ingredientsSum, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptReturnsAllIngredientsString() {
        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n" +
                "= sauce Соус Spicy-X =\r\n" +
                "= filling Хрустящие минеральные кольца =\r\n" +
                "= filling Биокотлета из марсианской Магнолии =\r\n" +
                "(==== Краторная булка N-200i ====)\r\n" +
                "\r\n" +
                "Price: 2790,000000\r\n";
        burger.setBuns(bun);
        Assert.assertEquals("Error, not expected receipt", expectedReceipt, burger.getReceipt());
    }
}

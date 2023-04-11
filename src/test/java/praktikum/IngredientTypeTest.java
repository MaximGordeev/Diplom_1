package praktikum;

import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void checkSauceTest() {
        IngredientType.valueOf("SAUCE");
    }
    @Test
    public void checkFillingTest() {
        IngredientType.valueOf("FILLING");
    }
}

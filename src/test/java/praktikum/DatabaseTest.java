package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DatabaseTest {

    @Test
    public void initDatabaseTest() {
        Database database = new Database();
        assertFalse(database.availableBuns().isEmpty());
        assertFalse(database.availableIngredients().isEmpty());
    }
}
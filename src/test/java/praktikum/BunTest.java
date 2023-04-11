package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testGetName() {
        Bun bun = new Bun("same", 0);
        String actual = bun.getName();
        assertEquals("same", actual);
    }
    @Test
    public void testGetPrice() {
        Bun bun = new Bun("same", 1.5f);
        Float actual = bun.getPrice();
        assertEquals(1.5f, actual, 0.0f);
    }
}

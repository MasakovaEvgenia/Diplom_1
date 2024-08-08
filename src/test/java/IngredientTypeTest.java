import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeValues() {
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};
        assertArrayEquals(expectedTypes, IngredientType.values());
    }

    @Test
    public void testIngredientTypeValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}

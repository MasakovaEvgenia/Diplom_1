import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    // Поля для хранения параметров
    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;


    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100 },
                { IngredientType.FILLING, "cutlet", 100 },
                { IngredientType.SAUCE, "chili sauce", 300 },
                { IngredientType.FILLING, "sausage", 300 }
        });
    }


    @Test
    public void testIngredientProperties() {
        // новый объект Ingredient с параметрами, которые передаю в конструктор
        ingredient = new Ingredient(type, name, price);

        // метод  возвращает ожидаемый тип ингредиента
        assertEquals(type, ingredient.getType());

        //  возвращает ожидаемое название ингредиента
        assertEquals(name, ingredient.getName());

        //  метод  возвращает ожидаемую цену ингредиента
        // точность проверки  в 0.01 - это для учета возможных  погрешностей в расчетах
        assertEquals(price, ingredient.getPrice(), 0.01);
    }
}

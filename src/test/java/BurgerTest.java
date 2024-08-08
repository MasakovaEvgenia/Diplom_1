import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

public class BurgerTest {
    @Mock
    private Bun mockBun; // Мок для класса Bun

    @Mock
    private Ingredient mockIngredient1; //Мок для первого ингредиента

    @Mock
    private Ingredient mockIngredient2; //Мок для второго ингредиента

    private Burger burger; // Экземпляр класса Burger, который тестирую

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // инициализировала мок
        burger = new Burger(); // создала экземпляр но не уверена что нужно
    }

    @Test
    public void testSetBuns() {
        when(mockBun.getName()).thenReturn("red bun");  // Настройка поведения мока для получения имени булочек

        when(mockBun.getPrice()).thenReturn(300.0f); // Настройка поведения мока для получения цены булочек

        burger.setBuns(mockBun); // кладем булки в бургер

        assertEquals(mockBun, burger.bun); // проверяю, что булочки нормально зашли
    }

    @Test
    public void testAddIngredient() {
        when(mockIngredient1.getName()).thenReturn("cutlet"); // Настройка поведения мока для получения имени ингридиента
        when(mockIngredient1.getPrice()).thenReturn(100.0f);// Настройка поведения мока для получения цены ингридиента

        burger.addIngredient(mockIngredient1);// положила ингридиент в бургер

        assertTrue(burger.ingredients.contains(mockIngredient1)); // проверяю, что булочки нормально зашли
    }

    @Test
    public void testRemoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("cutlet"); // Настройка поведения мока для получения имени ингридиента
        when(mockIngredient1.getPrice()).thenReturn(100.0f);// Настройка поведения мока для получения цены ингридиента
        burger.addIngredient(mockIngredient1); // положила ингридиент в бургер

        burger.removeIngredient(0); // удаляю ингридиент

        assertFalse(burger.ingredients.contains(mockIngredient1)); // смотрю удалился ли ингридиент
    }

    @Test
    public void testMoveIngredient() {
        when(mockIngredient1.getName()).thenReturn("cutlet");
        when(mockIngredient1.getPrice()).thenReturn(100.0f);
        when(mockIngredient2.getName()).thenReturn("dinosaur");
        when(mockIngredient2.getPrice()).thenReturn(200.0f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1); //Перемещаю первый ингредиент на второе место

        List<Ingredient> ingredients = burger.ingredients; // тут список ингридиентов и их порядок
        assertEquals(mockIngredient2, ingredients.get(0)); // тут динозавр
        assertEquals(mockIngredient1, ingredients.get(1)); // тут котлета
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(300.0f);
        when(mockIngredient1.getPrice()).thenReturn(100.0f);
        when(mockIngredient2.getPrice()).thenReturn(200.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 2 * 300.0f + 100.0f + 200.0f; //Рассчитываю ожидаемую стоимость: 2 * цена булочек + цена ингредиентов
        assertEquals(expectedPrice, burger.getPrice(), 0.01); //стоимость бургера соответствует ожидаемой
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("red bun");
        when(mockBun.getPrice()).thenReturn(300.0f);
        when(mockIngredient1.getName()).thenReturn("cutlet");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(100.0f);
        when(mockIngredient2.getName()).thenReturn("dinosaur");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getPrice()).thenReturn(200.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = "(==== red bun ====)\r\n" //Ожидаемый формат чека с корректной стоимостью
                + "= filling cutlet =\r\n"
                + "= filling dinosaur =\r\n"
                + "(==== red bun ====)\r\n"
                + "\r\nPrice: 900,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt()); //чек соответсвует ожидаемому
    }
}
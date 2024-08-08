import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Database;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BunTest {

    private Database mockDatabase;

    @Before
    public void setUp() {
        mockDatabase = Mockito.mock(Database.class);


        Mockito.when(mockDatabase.availableBuns()).thenReturn(
                Arrays.asList(
                        new Bun("black bun", 100.0f),
                        new Bun("white bun", 200.0f)
                )
        );
    }

    @Test
    public void testBunFromDatabase() {
        List<Bun> buns = mockDatabase.availableBuns();
        Bun bun = buns.get(0);

        assertEquals("black bun", bun.getName());
        assertEquals(100.0f, bun.getPrice(), 0.01);
    }
}

package basePage;

import controllers.basePageController.BasePageController;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static configuration.Configuration.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * // Описание класса
 */
public class BasePageTest {

    private BasePageController bpc;


    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    @BeforeClass
    public static void init() {
        // Запустить некоторую логику единожды для всех автотестов
    }

    @Before
    public void setUp() {
        this.bpc = new BasePageController();
        this.bpc.start();
        // Инициировать тестовое окружение для очередного теста
    }

    @After
    public void tearDown() {
        // Закрыть браузер и завершить работу теста
    }

    @AfterClass
    public static void close() {
        // закрыть все тестовое окружение и завершить работу
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *
     *
     *
     *
     *
     *
     * // Описание теста
     */
    @Test
    public void test() {
        this.bpc.searchHotels(TEST_CITY, DAYS);
        WebElement webElement = this.bpc.getDriver().findElement(By.xpath("//*[@id='qf-0q-nights']/span[1]/span"));
        assertEquals(String.valueOf(DAYS), webElement.getText());

        // тест собственно :)
        // Здесь только проверка результата Asset()!
    }

}
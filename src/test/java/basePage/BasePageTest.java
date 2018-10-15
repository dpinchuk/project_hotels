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
        this.bpc.getDriver().close();
    }

    @AfterClass
    public static void close() {
        // закрыть все тестовое окружение и завершить работу
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * @Author Nataliya Nagibina
     * Positive test
     * test-001_p
     *
     * Тест проверяет отображение количества ночей, указанных в Check in и Check out выбранного города
     *
     */
    @Test
    public void test_001_p() {
        this.bpc.searchHotels(TEST_CITY, DAYS);
        WebElement webElement = this.bpc.getDriver().findElement(By.xpath("//*[@id='qf-0q-nights']/span[1]/span"));
        assertEquals(String.valueOf(DAYS), webElement.getText());
    }

}
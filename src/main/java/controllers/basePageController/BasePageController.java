package controllers.basePageController;

import controllers.MainController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import services.basePageService.BasePageService;

import static configuration.Configuration.*;

public class BasePageController extends MainController {

    private MainController mainController;

    public void start() {
        this.mainController = new MainController();
        this.mainController.initTestEnvironment();
    }

    public void searchHotels(String city, int days) {
        // Найти на странице элемент с xpath="//*[@id='qf-0q-destination']" (строка поиска по городу в блоке Search Hotels)
        WebElement webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-destination']"));

        // Очистить данное поле
        webElement.clear();

        // В данное поле ввести значения города
        webElement.sendKeys(city);

        // Найти на странице элемент с xpath = "//*[@id='qf-0q-localised-check-in']"
        webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));

        // Очистить данное поле
        webElement.clear();

        // Ввести текущую дату
        BasePageService bps = new BasePageService();
        String date = bps.getDate(CHECK_IN, 0);
        webElement.sendKeys(date);

        // Найти на странице элемент с xpath = "//*[@id='qf-0q-localised-check-out']"
        webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));

        // Очистить данное поле
        webElement.clear();

        // Ввести дату на N дней позже
        date = bps.getDate(CHECK_IN, DAYS);
        webElement.sendKeys(date);
        webElement.sendKeys(Keys.TAB);
    }

}
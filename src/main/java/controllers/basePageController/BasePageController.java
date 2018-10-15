package controllers.basePageController;

import controllers.MainController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.basePageService.BasePageService;

import java.util.List;

import static configuration.Configuration.*;

public class BasePageController extends MainController {

    private MainController mainController;
    private WebElement webElement;

    public void start() {
        this.mainController = new MainController();
        this.mainController.initTestEnvironment();
    }

    public void searchHotels(String city, int days) {
        // Найти на странице элемент с xpath="//*[@id='qf-0q-destination']" (строка поиска по городу в блоке Search Hotels)
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-destination']"));

        // Очистить данное поле
        this.webElement.clear();

        // В данное поле ввести значения города
        this.webElement.sendKeys(city);

        // Найти на странице элемент с xpath = "//*[@id='qf-0q-localised-check-in']"
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));

        // Очистить данное поле
        this.webElement.clear();

        // Ввести текущую дату
        BasePageService bps = new BasePageService();
        String date = bps.getDate(CHECK_IN, 0);
        this.webElement.sendKeys(date);

        // Найти на странице элемент с xpath = "//*[@id='qf-0q-localised-check-out']"
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));

        // Очистить данное поле
        this.webElement.clear();

        // Ввести дату на N дней позже
        date = bps.getDate(CHECK_IN, DAYS);
        this.webElement.sendKeys(date);
        this.webElement.sendKeys(Keys.TAB);
    }

    public void searchHotelsWithRooms(String city, int days, int rooms, int adults, int children, int[] childAge) {
        searchHotels(city, days);

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-compact-occupancy']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-compact-occupancy']/option[3]"));
        this.webElement.click();

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-rooms']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-rooms']/option[" + rooms + "]"));
        this.webElement.click();

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-adults']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-adults']/option[" + adults + "]"));
        this.webElement.click();

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-children']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-children']/option[" + (children + 1) + "]"));
        this.webElement.click();

        switch (children) {
            case 1: {
                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']"));
                this.webElement.click();
                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']/option[" + (childAge[0] + 2) + "]"));
                this.webElement.click();
                break;
            }
            case 2: {
                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']"));
                this.webElement.click();
                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']/option[" + (childAge[0] + 2) + "]"));
                this.webElement.click();

                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-1-age']"));
                this.webElement.click();
                this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-1-age']/option[" + (childAge[1] + 2) + "]"));
                this.webElement.click();
                break;
            }
            default: {
            }
        }
        this.webElement.click();

        // Дожидаемся, пока драйвер не найдет на странице элемент с xpath = "//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[5]/button"
        WebDriverWait wait = new WebDriverWait(this.mainController.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[5]/button")));

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[5]/button"));
        this.webElement.click();

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='listings']/ol"));
        List<WebElement> elements = this.webElement.findElements(By.xpath("//li"));
        elements.forEach(System.out::println);

        this.webElement.click();

    }

}
package controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import static configuration.Configuration.*;

public class MainController {

    private WebDriver driver;

    public void initTestEnvironment() {
        /*Настройка тестовой среды*/
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);

        /*Настройка тестового окружения*/
        System.setProperty(PROPERTY_CHROM_DRIVER, PATH_TO_WEB_DRIVER);
        this.driver = new ChromeDriver();
        System.out.println("WEB-Driver: [" + WEB_DRIVER + "] initialization success!");

        /*Настройки страницы браузера*/
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(TIME_OUT_WAIT, TimeUnit.SECONDS);

        /*В коммандную строку браузера ввести URL*/
        this.driver.get(URL);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
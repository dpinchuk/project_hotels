package controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import static configuration.Configuration.*;

public class MainController {

    public static void initTestEnvironment() {
        /*Настройка тестовой среды*/
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);

        /*Настройка тестового окружения*/
        System.setProperty(PROPERTY_CHROM_DRIVER, PATH_TO_WEB_DRIVER);
        WebDriver driver = new ChromeDriver();
        System.out.println("WEB-Driver: [" + WEB_DRIVER + "] initialization success!");

        /*Настройки страницы браузера*/
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMI_OUT_WAIT, TimeUnit.SECONDS);

        /*В коммандную строку браузера ввести URL*/
        driver.get(URL);
    }

}
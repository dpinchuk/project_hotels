package configuration;

public interface Configuration {

    String URL = "https://www.hotels.com/?pos=HCOM_US&locale=en_US";
    String WEB_DRIVER = "chrome";
    String PROPERTY_CHROM_DRIVER = "webdriver.chrome.driver";
    String PATH_TO_WEB_DRIVER = "src/main/resources/chromedriver/2.41/chromedriver.exe";

    String DATE_FORMAT = "MM/dd/yy";

    String TEST_CITY = "New York, New York, United States of America";
    int DAYS = 7;
    int CHECK_IN = 1;

    int TIME_OUT_WAIT = 10;
}

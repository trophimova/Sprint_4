package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @After
    public void after() {
        driver.quit();
    }

    @Before
    public void setUp() {
        driver = getWebDriver(Browser.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME: return new ChromeDriver();
            case FIREFOX: return new FirefoxDriver();
            default: throw new RuntimeException("unable to create a web driver");
        }
    }

    enum Browser {
        CHROME, FIREFOX
    }
}

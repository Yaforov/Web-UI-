package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.example.lesson6.DZ6.ViborKino;
import org.example.lesson7.AdditionalLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.lesson6.DZ6.MainYa;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DZT6 {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://yandex.ru/");
    }

    @Test
    @Feature("Фильм:")
    @TmsLink("Poisk")
    void yaPoistTest() throws InterruptedException {
        new MainYa(driver).poiskYa("комедии");
        new ViborKino(driver).proverkaVibora();

    }

    @AfterEach
    void killBrowser() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера:", log.getMessage());
        }
        driver.quit();
    }
}


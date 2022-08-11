package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.lesson6.DZ6.ViborKino;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.lesson6.DZ6.MainYa;
public class DZT6 {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
    }

    @Test
    void yaPoistTest() throws InterruptedException {
        new MainYa(driver).PoiskYa("комедии");
        new ViborKino(driver);
    }

    @AfterEach
    void killBrowser() {
        driver.quit();
    }
}


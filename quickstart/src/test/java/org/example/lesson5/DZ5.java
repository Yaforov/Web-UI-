package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DZ5 {

        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;

        private final static String YANDEX_POISK = "https://yandex.ru/";

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupBrowser() {
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
        }
    @Test
    void poiskYa() throws InterruptedException {
        driver.get(YANDEX_POISK);

        WebElement loginForm = driver.findElement(By.id("text"));
        loginForm.sendKeys("комедии");
        driver.findElement(By.className("search2__button")).click();
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//div[@class='popup2__content distr-popup__content']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
              "element.singleNodeValue.remove()");
        Thread.sleep(2000);
        webDriverWait
               .until(d -> d.findElements(
                       By.xpath("//div[@aria-label='Название - Затерянный город, 2022, мелодрама, боевик, Рейтинг Кинопоиска - 6.1 из 10']")).size() > 0);
        actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Название - Затерянный город, 2022, мелодрама, боевик, Рейтинг Кинопоиска - 6.1 из 10']")))
                .build()
                .perform();

        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='Polaroid']")).isDisplayed(), true);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
       }
}

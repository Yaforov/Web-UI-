package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications"); // не должны появляться нотификации сайта
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)"); // прикинулись гугл ботом
       // chromeOptions.addArguments("--headless"); // запуск браузера без визуальной составляющей

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(7000);

        driver.quit();
    }
}


package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        /**
// автоматическое скачивание драйверов для firefox и открытие браузера на вкладке яндекса
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://ya.ru");
**/
        Thread.sleep(5000);
        driver.quit(); // закрытие браузера
        //        firefoxDriver.quit();

    }
}

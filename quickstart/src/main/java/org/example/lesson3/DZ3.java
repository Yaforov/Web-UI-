package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DZ3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
        WebElement loginForm = driver.findElement(By.id("text"));
        loginForm.sendKeys("Шерлок Холмс");
        driver.findElement(By.className("search2__button")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//*[@id=\"f1i5os0e-O9eW8o6\"]/div/div[2]/div/div/div[2]/div[3]")).sendKeys("Шерлок Холмс");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"f1i5os0e-O9eW8o6\"]/div/div[2]/div/div/div[2]/div[3]")));
        driver.findElement(By.xpath("//*[@id=\"f1i5os0e-O9eW8o6\"]/div/div[2]/div/div/div[2]/div[3]")).click();

        Thread.sleep(4000);

        driver.quit();
    }
}

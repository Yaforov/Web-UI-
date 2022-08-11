package org.example.lesson6.DZ6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViborKino extends BasePage1 {
    public ViborKino(WebDriver driver) {
        super(driver);
    }
    private final String xpathFilmLocator = "//div[@aria-label='Название - Во всё тяжкое, 2019, драма, комедия, Рейтинг Кинопоиска - 7.2 из 10']";

    @FindBy(xpath = xpathFilmLocator)
    private WebElement viborKino;

    public void proverkaVibora () {
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//div[@class='popup2__content distr-popup__content']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        webDriverWait
                .until(d -> d.findElements(
                        By.xpath(xpathFilmLocator)).size() > 0);
        actions.moveToElement(driver.findElement(By.xpath(xpathFilmLocator)))
                .build()
                .perform();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='Polaroid']")).isDisplayed(), true);
    }
}

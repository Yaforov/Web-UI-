package org.example.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.lesson6.DZ6.BasePage1;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class ViborKino {
    private final String xpathFilmLocator = "//div[@aria-label='Название - Во всё тяжкое, 2019, драма, комедия, Рейтинг Кинопоиска - 7.2 из 10']";

    private SelenideElement poiskFilm = $(By.xpath(xpathFilmLocator));


    @Step("Навести курсор на фильм и Проверка появления окна с описанием фильма")
    public void proverkaVibora() {
        /**((JavascriptExecutor) poiskFilm).executeScript("let element = document.evaluate(\"//div[@class='popup2__content distr-popup__content']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()"); **/
        Configuration.timeout = 10000;
        poiskFilm.hover().shouldBe(Condition.text("Во всё тяжкое"));
    }
}

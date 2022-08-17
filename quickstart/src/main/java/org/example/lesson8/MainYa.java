package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.lesson6.DZ6.BasePage1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainYa {

    private SelenideElement textPoisk = $(By.id("text"));
    private SelenideElement poiskButton = $(By.xpath("//div[@class='search2__button']"));

    @Step("Ввод поиска по слову:")
    public void poiskYaText(String poiskText) {
        textPoisk.sendKeys(poiskText);
    }
    @Step("Клик на кнопку Найти")
    public void poiskYaKlik() {
        poiskButton.click();
    }

}


package org.example.lesson6.DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainYa extends BasePage1 {
    public MainYa(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "text")
    private WebElement textPoisk;

    @FindBy(xpath = "//div[@class='search2__button']")
    private WebElement poiskButton;

    public void PoiskYa(String poiskText) {
        textPoisk.sendKeys(poiskText);
        poiskButton.click();
    }
}


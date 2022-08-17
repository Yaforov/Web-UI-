import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.MainYa;
import org.example.lesson8.ViborKino;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Пользователь на стартовой странице Яндекса")
    public void пользовательНаСтартовойСтраницеЯндекса() {
        open("https://yandex.ru/");
    }

    @When("Вводим текст поиска Комедии")
    public void вводимТекстПоискаКомедии() {
        new MainYa().poiskYaText("Комедии");
    }

    @And("Клик по кнопке Найти")
    public void кликПоКнопкеНайти() {
     new MainYa().poiskYaKlik();
    }

    @Then("Наводим курсор на фильм Во всё тяжкое и Проверяем появилось окно с описанием фильма")
    public void наводимКурсорНаФильмВоВсёТяжкое() {
        new ViborKino().proverkaVibora();
    }
}

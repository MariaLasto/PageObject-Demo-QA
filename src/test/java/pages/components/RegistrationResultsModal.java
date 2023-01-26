package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void registrationResultAppears() { //проверяем, что модаока есть
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void modalTableResult(String key, String value) { //проверяем, что колонки с наименованием и значением друг напротив друга
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
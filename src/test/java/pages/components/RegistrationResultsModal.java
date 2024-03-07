package pages.components; // Объявление пакета pages.components

import static com.codeborne.selenide.Condition.appear; // Статический импорт метода appear из класса Condition из библиотеки Selenide
import static com.codeborne.selenide.Condition.text; // Статический импорт метода text из класса Condition из библиотеки Selenide
import static com.codeborne.selenide.Selectors.byText; // Статический импорт метода byText из класса Selectors из библиотеки Selenide
import static com.codeborne.selenide.Selenide.$; // Статический импорт метода $ из класса Selenide из библиотеки Selenide

public class RegistrationResultsModal { // Объявление класса RegistrationResultsModal

    public void verifyModalAppears() { // Объявление метода verifyModalAppears
        $(".modal-dialog").should(appear); // Проверка появления модального окна с классом "modal-dialog"
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // Проверка, что модальное окно содержит указанный текст "Thanks for submitting the form"
    }

    public void verifyResult(String key, String value) { // Объявление метода verifyResult с двумя параметрами key и value
        $(".table-responsive").$(byText(key)).parent() // Нахождение элемента таблицы по тексту key, а затем получение его родительского элемента
                .shouldHave(text(value)); // Проверка, что родительский элемент содержит текст value
    }
}
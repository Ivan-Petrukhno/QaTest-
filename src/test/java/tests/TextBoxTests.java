package tests; // Объявление пакета tests

import com.codeborne.selenide.Condition; // Импорт класса Condition из библиотеки Selenide
import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.BeforeAll; // Импорт аннотации BeforeAll из библиотеки JUnit Jupiter
import org.junit.jupiter.api.Test; // Импорт аннотации Test из библиотеки JUnit Jupiter

import static com.codeborne.selenide.Condition.text; // Статический импорт метода text из класса Condition из библиотеки Selenide
import static com.codeborne.selenide.Selenide.$; // Статический импорт метода $ из класса Selenide из библиотеки Selenide
import static com.codeborne.selenide.Selenide.open; // Статический импорт метода open из класса Selenide из библиотеки Selenide

public class TextBoxTests { // Объявление класса TextBoxTests

    @BeforeAll // Аннотация, указывающая на то, что метод beforeAll должен быть выполнен перед запуском всех тестов
    static void beforeAll() { // Объявление статического метода beforeAll
        Configuration.holdBrowserOpen = true; // Установка флага для удержания окна браузера открытым после завершения теста
        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера
        Configuration.baseUrl = "https://demoqa.com"; // Установка базового URL для тестирования
    }

    @Test // Аннотация, указывающая на то, что метод fillFormTest является тестовым
    void fillFormTest() { // Объявление метода fillFormTest
        String userName = "Egor"; // Объявление и инициализация строки userName

        open("/text-box"); // Открытие страницы по указанному URL

        $("#userName").setValue(userName); // Нахождение элемента по CSS селектору "#userName" и установка в него значения userName
        $("#userEmail").setValue("Egor@egor.com"); // То же самое для элемента с CSS селектором "#userEmail"
        $("#currentAddress").setValue("Some address 1"); // То же самое для элемента с CSS селектором "#currentAddress"
        $("#permanentAddress").setValue("Other address 1"); // То же самое для элемента с CSS селектором "#permanentAddress"
        $("#submit").click(); // Нахождение элемента по CSS селектору "#submit" и нажатие на него

        $("#output").shouldBe(Condition.visible); // Проверка видимости элемента с CSS селектором "#output"
        $("#output #name").shouldHave(text(userName)); // Проверка, что элемент с CSS селектором "#output #name" содержит текст userName
        $("#output #email").shouldHave(text("Egor@egor.com")); // Проверка, что элемент с CSS селектором "#output #email" содержит текст "Egor@egor.com"
        // todo check addresses // Планируемая проверка адресов
    }
}

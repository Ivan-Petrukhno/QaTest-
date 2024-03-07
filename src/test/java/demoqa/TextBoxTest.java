package demoqa; // Объявление пакета, к которому принадлежит данный класс

import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.BeforeAll; // Импорт аннотации BeforeAll из библиотеки JUnit
import org.junit.jupiter.api.Test; // Импорт аннотации Test из библиотеки JUnit

import static com.codeborne.selenide.Condition.text; // Импорт статического метода text из класса Condition
import static com.codeborne.selenide.Condition.visible; // Импорт статического метода visible из класса Condition
import static com.codeborne.selenide.Selenide.$; // Импорт статического метода для поиска элементов по селекторам
import static com.codeborne.selenide.Selenide.open; // Импорт статического метода для открытия URL

public class TextBoxTest { // Объявление класса TextBoxTest

    @BeforeAll // Аннотация указывает на то, что метод будет выполняться перед всеми тестами в классе
    static void beforeAll(){ // Объявление статического метода beforeAll
        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера
        Configuration.baseUrl =  "https://demoqa.com"; // Установка базового URL
    }

    @Test // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void fillFormTest(){ // Объявление метода fillFormTest

        String userName = "Ivan"; // Объявление переменной userName со значением "Ivan"

        open("https://demoqa.com/text-box"); // Открытие страницы по указанному URL
        $ (".text-center").shouldHave(text("Text Box")); // Проверка наличия текста "Text Box" в элементе с классом "text-center"
        $("#userName").setValue("Ivan"); // Ввод значения "Ivan" в поле с id "userName"
        $("#userEmail").setValue("mymail@bg.net"); // Ввод значения "mymail@bg.net" в поле с id "userEmail"
        $("#currentAddress").setValue("myAdres"); // Ввод значения "myAdres" в поле с id "currentAddress"
        $("#permanentAddress").setValue("myoemensadres"); // Ввод значения "myoemensadres" в поле с id "permanentAddress"
        $("#submit").click(); // Нажатие на кнопку с id "submit"

        $("#output").shouldBe(visible); // Проверка видимости элемента с id "output"
        $("#output").$("#name").shouldHave((text("Ivan"))); // Проверка наличия текста "Ivan" в элементе с id "name" внутри элемента с id "output"
        $("#output #email").shouldHave((text("mymail@bg.net"))); // Проверка наличия текста "mymail@bg.net" в элементе с id "email" внутри элемента с id "output"
    }
}

package tests; // Объявление пакета tests

import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.BeforeAll; // Импорт аннотации BeforeAll из библиотеки JUnit Jupiter
import pages.RegistrationPage; // Импорт класса RegistrationPage из пакета pages

public class TestBase { // Объявление класса TestBase

    RegistrationPage registrationPage = new RegistrationPage(); // Создание объекта registrationPage класса RegistrationPage

    @BeforeAll // Аннотация, указывающая на то, что метод beforeAll должен быть выполнен перед запуском всех тестов
    static void beforeAll() { // Объявление статического метода beforeAll
        Configuration.baseUrl = "https://demoqa.com"; // Установка базового URL для тестирования
        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера
    }
}

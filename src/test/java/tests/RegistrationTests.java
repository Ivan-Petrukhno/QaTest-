package tests; // Объявление пакета, к которому принадлежит данный класс

import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.BeforeAll; // Импорт аннотации BeforeAll из библиотеки JUnit
import org.junit.jupiter.api.Test; // Импорт аннотации Test из библиотеки JUnit

import static com.codeborne.selenide.Condition.appear; // Импорт статического метода appear из класса Condition
import static com.codeborne.selenide.Condition.text; // Импорт статического метода text из класса Condition
import static com.codeborne.selenide.Selectors.byText; // Импорт статического метода byText из класса Selectors
import static com.codeborne.selenide.Selenide.*; // Импорт статических методов из класса Selenide

public class RegistrationTests { // Объявление класса RegistrationTests

    @BeforeAll // Аннотация указывает на то, что метод должен быть выполнен перед всеми тестами в этом классе
    static void beforeAll() { // Объявление статического метода beforeAll
        Configuration.baseUrl = "https://demoqa.com"; // Установка базового URL для всех тестов
        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера для всех тестов
    }

    @Test // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void successfulRegistrationTest() { // Объявление метода successfulRegistrationTest

        String userName = "Alex"; // Инициализация переменной userName

        open("/automation-practice-form"); // Открытие страницы по указанному URL
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // Проверка наличия текста "Student Registration Form" на странице
        executeJavaScript("$('#fixedban').remove()"); // Выполнение JavaScript для удаления элемента с id "fixedban"
        executeJavaScript("$('footer').remove()"); // Выполнение JavaScript для удаления элемента "footer"

        $("#firstName").setValue(userName); // Ввод имени "Alex" в соответствующее поле
        $("#lastName").setValue("Egorov"); // Ввод фамилии "Egorov" в соответствующее поле
        $("#userEmail").setValue("alex@egorov.com"); // Ввод адреса электронной почты в соответствующее поле
        $("#genterWrapper").$(byText("Other")).click(); // Выбор значения "Other" в радиокнопке "Gender"
        $("#userNumber").setValue("1234567890"); // Ввод номера телефона в соответствующее поле

        // Установка даты рождения
        $("#dateOfBirthInput").click(); // Нажатие на поле выбора даты рождения
        $(".react-datepicker__month-select").selectOption("July"); // Выбор месяца "July"
        $(".react-datepicker__year-select").selectOption("2008"); // Выбор года "2008"
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); // Выбор 30-го числа месяца

        $("#subjectsInput").setValue("Math").pressEnter(); // Ввод значения "Math" в поле и нажатие клавиши Enter
        $("#hobbiesWrapper").$(byText("Sports")).click(); // Выбор значения "Sports" в чекбоксе "Hobbies"
        $("#uploadPicture").uploadFromClasspath("wp1908606.jpg"); // Загрузка изображения с заданным именем из ресурсов
        $("#currentAddress").setValue("Some address 1"); // Ввод текущего адреса

        // Выбор значения из выпадающего списка (State и City)
        $("#state").click(); // Нажатие на выпадающий список "State"
        $("#stateCity-wrapper").$(byText("NCR")).click(); // Выбор значения "NCR" в выпадающем списке "State"
        $("#city").click(); // Нажатие на выпадающий список "City"
        $("#stateCity-wrapper").$(byText("Delhi")).click(); // Выбор значения "Delhi" в выпадающем списке "City"

        $("#submit").click(); // Нажатие на кнопку "Submit"

        // Проверка успешного отправления формы
        $(".modal-dialog").should(appear); // Проверка появления модального диалога
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // Проверка наличия текста "Thanks for submitting the form" в модальном окне
        $(".table-responsive").shouldHave(text(userName), text("Egorov"),
                text("alex@egorov.com"), text("1234567890")); // Проверка наличия различной информации о пользователе в таблице
    }
}

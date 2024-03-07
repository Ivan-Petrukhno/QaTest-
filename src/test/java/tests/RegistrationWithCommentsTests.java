package tests; // Объявление пакета, к которому принадлежит класс

import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.BeforeAll; // Импорт аннотации BeforeAll из библиотеки JUnit
import org.junit.jupiter.api.Test; // Импорт аннотации Test из библиотеки JUnit

import static com.codeborne.selenide.Condition.appear; // Импорт статического метода appear из класса Condition
import static com.codeborne.selenide.Condition.text; // Импорт статического метода text из класса Condition
import static com.codeborne.selenide.Selectors.byText; // Импорт статического метода byText из класса Selectors
import static com.codeborne.selenide.Selenide.*; // Импорт статических методов из класса Selenide

public class RegistrationWithCommentsTests { // Объявление класса RegistrationWithCommentsTests

    @BeforeAll // Аннотация указывает на то, что метод должен быть выполнен перед всеми тестами в этом классе
    static void beforeAll() { // Объявление статического метода beforeAll
        Configuration.baseUrl = "https://demoqa.com"; // Установка базового URL для всех тестов
        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера для всех тестов
//        Configuration.holdBrowserOpen = true; // Закомментированная строка, которая, если раскомментировать, оставит браузер открытым после выполнения тестов
    }

    @Test
        // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void successfulRegistrationTest() { // Объявление метода successfulRegistrationTest

        String userName = "Alex"; // Инициализация переменной userName

        open("/automation-practice-form"); // Открытие страницы по указанному URL
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // Проверка наличия текста "Student Registration Form" на странице
        executeJavaScript("$('#fixedban').remove()"); // Выполнение JavaScript для удаления элемента с id "fixedban"
        executeJavaScript("$('footer').remove()"); // Выполнение JavaScript для удаления элемента "footer"

        $("#firstName").setValue(userName); // Ввод имени "Alex" в соответствующее поле
        $("#lastName").setValue("Egorov"); // Ввод фамилии "Egorov" в соответствующее поле
        $("#userEmail").setValue("alex@egorov.com"); // Ввод адреса электронной почты в соответствующее поле
//        $("#gender-radio-1").click(); // Клик по радиокнопке (ошибка)
//        $("#gender-radio-3").parent().click(); // Клик по родителю радиокнопки (правильно)
//        $(byText("Other")).click(); // Клик по тексту "Other" (не очень хорошо)
        $("#genterWrapper").$(byText("Other")).click(); // Клик по тексту "Other" (лучший вариант)
//        $("label[for=gender-radio-3]").click(); // Клик по метке радиокнопки (правильно)
        $("#userNumber").setValue("1234567890"); // Ввод номера телефона в соответствующее поле

        // Установка даты рождения
        $("#dateOfBirthInput").click(); // Нажатие на поле выбора даты рождения
        $(".react-datepicker__month-select").selectOption("July"); // Выбор месяца "July"
//        $(".react-datepicker__month-select").selectOptionByValue("6"); // Выбор месяца по значению (номер месяца)
        $(".react-datepicker__year-select").selectOption("2008"); // Выбор года "2008"
// <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
// <div class="react-datepicker__day--030"                                     >30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); // Выбор 30-го числа месяца

//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
        $("#subjectsInput").setValue("Math").pressEnter(); // Ввод значения "Math" в поле и нажатие клавиши Enter
        $("#hobbiesWrapper").$(byText("Sports")).click(); // Выбор значения "Sports" в чекбоксе "Hobbies"
        $("#uploadPicture").uploadFromClasspath("wp1908606.jpg"); // Загрузка изображения с заданным именем из ресурсов
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png")); // Загрузка файла с указанным путем
        $("#currentAddress").setValue("Some address 1"); // Ввод текущего адреса

        // Выбор значения из выпадающего списка (State и City)
        $("#state").click(); // Нажатие на выпадающий список "State"
        $("#stateCity-wrapper").$(byText("NCR")).click(); // Выбор значения "NCR" в выпадающем списке "State"
//        $("#react-select-3-option-0").click(); // Клик по элементу в выпадающем списке (по индексу)
        $("#city").click(); // Нажатие на выпадающий список "City"
        $("#stateCity-wrapper").$(byText("Delhi")).click(); // Выбор значения "Delhi" в выпадающем списке "City"
        $("#submit").click(); // Нажатие на кнопку отправки формы

        $(".modal-dialog").should(appear); // Проверка наличия модального диалога на странице
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // Проверка наличия указанного текста в модальном диалоге
        $(".table-responsive").shouldHave(text(userName), text("Egorov"), // Проверка наличия указанных текстов в таблице
                text("alex@egorov.com"), text("1234567890"));
    }
}

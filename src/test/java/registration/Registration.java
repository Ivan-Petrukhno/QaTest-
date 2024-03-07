package registration; // Объявление пакета, к которому принадлежит данный класс

import com.codeborne.selenide.Condition; // Импорт класса Condition из библиотеки Selenide
import com.codeborne.selenide.Configuration; // Импорт класса Configuration из библиотеки Selenide
import org.junit.jupiter.api.Test; // Импорт аннотации Test из библиотеки JUnit

import static com.codeborne.selenide.Selenide.$; // Импорт статического метода для поиска элементов по селекторам из Selenide
import static com.codeborne.selenide.Selenide.open; // Импорт статического метода для открытия URL из Selenide

public class Registration { // Объявление класса Registration

    @Test // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void rgistR() { // Объявление метода rgistR

        Configuration.browserSize = "1920x1080"; // Установка размера окна браузера
        open("https://demoqa.com/automation-practice-form"); // Открытие страницы по указанному URL

        $("#firstName").setValue("John"); // Ввод имени "John" в соответствующее поле
        $("#lastName").setValue("Doe"); // Ввод фамилии "Doe" в соответствующее поле
        $("#userEmail").setValue("johndoe@example.com"); // Ввод адреса электронной почты в соответствующее поле
        $(".custom-control-label").click(); // Нажатие на чекбокс с классом "custom-control-label"
        $("#userNumber").setValue("1234567890"); // Ввод номера телефона в соответствующее поле

        // Установка даты рождения
        $("#dateOfBirthInput").click(); // Нажатие на поле выбора даты рождения
        $(".react-datepicker__month-select").selectOption("June"); // Выбор месяца июня
        $(".react-datepicker__year-select").selectOption("1990"); // Выбор года 1990
        $(".react-datepicker__day--015").click(); // Выбор 15-го числа месяца

        $("#subjectsInput").setValue("Maths").pressEnter(); // Ввод значения "Maths" в поле и нажатие клавиши Enter
        $(".custom-control-label").click(); // Нажатие на чекбокс с классом "custom-control-label"
        $("#uploadPicture").uploadFromClasspath("wp1908606.jpg"); // Загрузка изображения с заданным именем из ресурсов
        $("#currentAddress").setValue("123 Street, City, Country"); // Ввод текущего адреса

        // Выбор значения из выпадающего списка (State и City)
        $("#react-select-3-input").setValue("NCR").pressEnter(); // Ввод значения "NCR" и нажатие клавиши Enter
        $("#react-select-4-input").setValue("Delhi").pressEnter(); // Ввод значения "Delhi" и нажатие клавиши Enter

        $("#submit").click(); // Нажатие на кнопку "Submit"

        // Проверка успешного отправления формы
        $(".modal-content").shouldHave(Condition.text("Thanks for submitting the form")); // Проверка наличия текста "Thanks for submitting the form" в модальном окне
    }
}
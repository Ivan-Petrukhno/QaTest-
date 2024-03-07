package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {   // Определение теста для успешной регистрации
        String userName = "Alex"; // Инициализация переменной userName

        registrationPage.openPage()  // Открытие страницы регистрации через объект registrationPage
                .setFirstName(userName)   // Установка имени пользователя
                .setLastName("Egorov")   // Установка фамилии пользователя
                .setEmail("alex@egorov.com")   // Установка адреса электронной почты
                .setGender("Other")   // Установка пола
                .setPhone("1234567890")   // Установка номера телефона
                .setBirthDate("30", "July", "2008");  // Установка даты рождения

        $("#subjectsInput").setValue("Math").pressEnter(); // Установка предмета и нажатие Enter
        $("#hobbiesWrapper").$(byText("Sports")).click();   // Выбор хобби
        $("#uploadPicture").uploadFromClasspath("wp1908606.jpg");   // Загрузка изображения
        $("#currentAddress").setValue("Some address 1");  // Установка текущего адреса
        $("#state").click();  // Нажатие на список штатов
        $("#stateCity-wrapper").$(byText("NCR")).click();   // Выбор штата NCR
        $("#city").click();  // Нажатие на список городов
        $("#stateCity-wrapper").$(byText("Delhi")).click(); // Выбор города Delhi
        $("#submit").click(); // Нажатие на кнопку отправки формы

        registrationPage.verifyResultsModalAppears()  // Проверка появления модального окна с результатами
                .verifyResult("Student Name", userName + " Egorov")  // Проверка имени студента
                .verifyResult("Student Email", "alex@egorov.com")
                .verifyResult("Gender", "Other")  // Проверка пола
                .verifyResult("Mobile", "1234567890") // Проверка номера телефона
                .verifyResult("Date of Birth", "30 July,2008");  // Проверка даты рождения
//        registrationPage.registrationResultsModal.verifyResult("Student Name", userName + " Egorov");
    }

    @Test
    void successfulRegistration1Test() {  // Определение второго теста для успешной регистрации
        String userName = "Alex";  // Инициализация переменной userName

        registrationPage.openPage(); // Открытие страницы регистрации через объект registrationPage


        registrationPage.setFirstName(userName); // Установка имени пользователя через объект registrationPage
        registrationPage.setLastName("Egorov"); // Установка фамилии пользователя через объект registrationPage
        registrationPage.setEmail("alex@egorov.com");  // Установка адреса электронной почты через объект registrationPage
        registrationPage.setGender("Other");   // Установка пола через объект registrationPage
        registrationPage.setPhone("1234567890");  // Установка номера телефона через объект registrationPage


        $("#dateOfBirthInput").click();  // Нажатие на поле выбора даты рождения
        // ...
    }

}
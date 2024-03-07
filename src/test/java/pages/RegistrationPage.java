package pages;

import com.codeborne.selenide.SelenideElement;      // Импорт класса SelenideElement из библиотеки Selenide
import pages.components.CalendarComponent;           // Импорт класса CalendarComponent из пакета pages.components
import pages.components.RegistrationResultsModal;    // Импорт класса RegistrationResultsModal из пакета pages.components

import static com.codeborne.selenide.Condition.text;    // Импорт статического метода text из класса Condition
import static com.codeborne.selenide.Selectors.byText;  // Импорт статического метода byText из класса Selectors
import static com.codeborne.selenide.Selenide.*;        // Импорт статических методов для работы с браузером из Selenide

public class RegistrationPage {                         // Объявление класса RegistrationPage
    private final String TITLE_TEXT = "Student Registration Form";   // Инициализация константы TITLE_TEXT с текстом "Student Registration Form"
    private CalendarComponent calendarComponent = new CalendarComponent();  // Создание экземпляра класса CalendarComponent
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();  // Создание экземпляра класса RegistrationResultsModal
    private SelenideElement                                                                     // Объявление элементов страницы с использованием CSS-селекторов
            firstNameInput = $("#firstName"),  // Поле ввода имени
            lastNameInput = $("#lastName"),  // Поле ввода фамилии
            dateOfBirthInput = $("#dateOfBirthInput");   // Поле ввода даты рождения

    public RegistrationPage openPage() {  // Метод для открытия страницы
        open("/automation-practice-form"); // Открытие страницы по указанному URL
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));  // Проверка, что на странице присутствует текст "Student Registration Form"
        executeJavaScript("$('#fixedban').remove()");  // Удаление элемента с id "fixedban" с помощью JavaScript
        executeJavaScript("$('footer').remove()");  // Удаление элемента "footer" с помощью JavaScript

        return this;  // Возврат текущего экземпляра класса
    }

    public RegistrationPage setFirstName(String value) {   // Метод для ввода имени
        firstNameInput.setValue(value); // Установка значения в поле ввода имени

        return this;  // Возврат текущего экземпляра класса
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);                     // Устанавливаем значение в поле "Фамилия" на странице регистрации.

        return this; // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear(); // Очищаем значение в поле "Фамилия" на странице регистрации.

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to Selenide elements  // Устанавливаем значение в поле "Email" на странице регистрации.

        return this;  // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements   // Устанавливаем значение пола на странице регистрации, выбирая его по тексту.

        return this; // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to Selenide elements    // Устанавливаем значение в поле "Телефон" на странице регистрации.

        return this; // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();                          // Кликаем по полю для выбора даты рождения.
        calendarComponent.setDate(day, month, year);       // Устанавливаем дату рождения на календарном компоненте.
        return this;  // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();  // Проверяем, что модальное окно с результатами появляется.

        return this; // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);  // Проверяем результаты регистрации по ключу и значению.

        return this;   // Возвращаем объект страницы регистрации для поддержки цепочек вызовов.
    }
    /*
    *** SELENIUM
    @FindBy(how = How.XPATH, xpath = ".//*[@class='submit']")
    public Button logoutBtn;

    *** SELENIDE
    public SelenideElement logoutBtn = $x(".//*[@class='submit]");
    public SelenideElement logoutBtn = $(".submit");
     */

}
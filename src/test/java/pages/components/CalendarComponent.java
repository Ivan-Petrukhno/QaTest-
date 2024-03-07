package pages.components; // Объявление пакета, к которому принадлежит данный класс

import static com.codeborne.selenide.Selenide.$; // Импорт статического метода для поиска элементов по селекторам из Selenide

public class CalendarComponent { // Объявление класса CalendarComponent

    public void setDate(String day, String month, String year) { // Объявление метода setDate с параметрами day, month и year

        // Выбор месяца в календаре по CSS-селектору ".react-datepicker__month-select" и установка выбранного значения
        $(".react-datepicker__month-select").selectOption(month);

        // Выбор года в календаре по CSS-селектору ".react-datepicker__year-select" и установка выбранного значения
        $(".react-datepicker__year-select").selectOption(year);

        // Клик по конкретной дате в календаре
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
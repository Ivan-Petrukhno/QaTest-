package locators; // Объявление пакета, к которому принадлежит данный класс

import static com.codeborne.selenide.Selectors.*; // Импорт статических методов для работы с CSS и XPath селекторами
import static com.codeborne.selenide.Selenide.$; // Импорт статического метода для поиска элементов по селекторам
import static com.codeborne.selenide.Selenide.$x; // Импорт статического метода для выполнения XPath-запросов

public class CssXpathExamples { // Объявление класса CssXpathExamples

    void cssXpathExamples() { // Объявление метода cssXpathExamples

        // Поиск элемента по атрибуту "data-testid" с значением "email" и установка значения "1"
        $("[data-testid=email]").setValue("1");
        // Альтернативный способ поиска элемента по атрибуту "data-testid" с помощью метода by и установка значения "1"
        $(by("data-testid", "email")).setValue("1");

        // Поиск элемента по id с значением "email" и установка значения "1"
        $("[id=email]").setValue("1");
        // Альтернативный способ поиска элемента по id и установка значения "1"
        $("#email").setValue("1");
        // Поиск элемента по XPath с атрибутом id и значением "email" и установка значения "1"
        $x("//*[@id=email]").setValue("1");

        // Поиск элемента по атрибуту name с значением "email" и установка значения "1"
        $("[name=email]").setValue("1");
        // Альтернативный способ поиска элемента по атрибуту name и установка значения "1"
        $(byName("email")).setValue("1");

        // Поиск элемента по атрибуту class с значением "login_form_input_box" и установка значения "1"
        $("[class=login_form_input_box]").setValue("1");
        // Поиск элемента по классу "login_form_input_box" и установка значения "1"
        $(".login_form_input_box").setValue("1");
        // Поиск элемента по классам "login_form_input_box" и "inputtext" и установка значения "1"
        $(".login_form_input_box.inputtext").setValue("1");
        // Поиск элемента по тегу input и классам "login_form_input_box" и "inputtext" и установка значения "1"
        $("input.login_form_input_box.inputtext").setValue("1");
        // Поиск элемента по XPath с классами "login_form_input_box" и "inputtext" и установка значения "1"
        $x("//input[@class='login_form_input_box'][@class='inputtext']").setValue("1");

        /*
           <div class="inputtext>
                <input type="email" class="login_form_input_box">
           </div>
         */
        // Поиск элемента с классом "login_form_input_box" и вложенным классом "inputtext" и установка значения "1"
        $(".login_form_input_box .inputtext").setValue("1");
        // Поиск элемента с классом "login_form_input_box" и вложенным элементом с классом "inputtext" и установка значения "1"
        $(".login_form_input_box").$(".inputtext").setValue("1");

        // Поиск элемента по тексту "Hello qa.guru" с помощью XPath
        $x("//div[text()='Hello qa.guru']");
        // Поиск элемента по тексту "Hello qa.guru" с помощью метода byText
        $(byText("Hello qa.guru"));
        // Поиск элемента по тексту, содержащему "lo qa.gu" с помощью метода withText
        $(withText("lo qa.gu"));

    }
    void css1XpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email>
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $x("//*[@id=email]").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(byName("email]")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".login_form_input_box.inputtext").setValue("1");
        $("input.login_form_input_box.inputtext").setValue("1");
        $x("//input[@class='login_form_input_box'][@class='inputtext']").setValue("1");

        /*
           <div class="inputtext>
                <input type="email" class="login_form_input_box">
           </div>
         */
        $(".login_form_input_box .inputtext").setValue("1");
        $(".login_form_input_box").$(".inputtext").setValue("1");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $(byText("Hello qa.guru"));
        $(withText("lo qa.gu"));

    }
}
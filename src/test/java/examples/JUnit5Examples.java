
package examples; // Объявление пакета, к которому принадлежит данный класс

import org.junit.jupiter.api.*; // Импорт необходимых классов из библиотеки JUnit 5

import static org.junit.jupiter.api.Assertions.assertFalse; // Импорт статического метода assertFalse из класса Assertions
import static org.junit.jupiter.api.Assertions.assertTrue; // Импорт статического метода assertTrue из класса Assertions

public class JUnit5Examples { // Объявление класса с названием JUnit5Examples

    @BeforeAll // Аннотация указывает на то, что метод будет выполняться перед всеми тестами в классе
    static void beforeAll() { // Объявление статического метода beforeAll
        System.out.println("### @BeforeAll !"); // Вывод строки "### @BeforeAll !" в консоль
    }

    @BeforeAll // Ещё один метод, который будет выполняться перед всеми тестами в классе
    static void beforeAll1() { // Объявление статического метода beforeAll1
        System.out.println("### @BeforeAll1 !"); // Вывод строки "### @BeforeAll1 !" в консоль
    }

    @AfterAll // Аннотация указывает на то, что метод будет выполняться после всех тестов в классе
    static void afterAll() { // Объявление статического метода afterAll
        System.out.println("### @AfterAll !"); // Вывод строки "### @AfterAll !" в консоль
    }

    @BeforeEach // Аннотация указывает на то, что метод будет выполняться перед каждым тестом в классе
    void beforeEach() { // Объявление метода beforeEach
        // open("google.com") // Закомментированная строка, возможно, предполагает вызов метода, открывающего определенную страницу в браузере
        System.out.println("###    @BeforeEach !"); // Вывод строки "###    @BeforeEach !" в консоль
    }

    @AfterEach // Аннотация указывает на то, что метод будет выполняться после каждого теста в классе
    void afterEach() { // Объявление метода afterEach
        System.out.println("###    @AfterEach !"); // Вывод строки "###    @AfterEach !" в консоль
    }

    @Test // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void fistTest() { // Объявление метода fistTest
        System.out.println("###       @Test fistTest() !"); // Вывод строки "###       @Test fistTest() !" в консоль
        assertTrue(3 > 2); // Проверка утверждения (3 больше чем 2) с использованием метода assertTrue
    }

    @Test // Ещё один метод, представляющий тестовый сценарий
    void secondTest() { // Объявление метода secondTest
        System.out.println("###       @Test secondTest() !"); // Вывод строки "###       @Test secondTest() !" в консоль
        assertFalse(3 > 2); // Проверка утверждения (3 больше чем 2) с использованием метода assertFalse
    }
}
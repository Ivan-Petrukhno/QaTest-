package junit; // Объявление пакета, к которому принадлежит данный класс

import org.junit.jupiter.api.*; // Импорт необходимых классов из библиотеки JUnit Jupiter

public class JunitTest1 { // Объявление класса JunitTest1

    @BeforeAll // Аннотация указывает на то, что метод будет выполняться перед всеми тестами в классе
    static void beforeAll(){ // Объявление статического метода beforeAll
        System.out.println("it`s a 0 method"); // Вывод строки "it`s a 0 method" в консоль
    }

    @BeforeEach // Аннотация указывает на то, что метод будет выполняться перед каждым тестом в классе
    void beforeEach(){ // Объявление метода beforeEach
        System.out.println("it`s a 1 method"); // Вывод строки "it`s a 1 method" в консоль
    }

    @AfterEach // Аннотация указывает на то, что метод будет выполняться после каждого теста в классе
    void afterEach(){ // Объявление метода afterEach
        System.out.println("it`s a 2 method"); // Вывод строки "it`s a 2 method" в консоль
    }

    @Test // Аннотация указывает на то, что метод представляет собой тестовый сценарий
    void junitTest1() { // Объявление метода junitTest1
        System.out.println("it`s a 3 Test"); // Вывод строки "it`s a 3 Test" в консоль
        Assertions.assertTrue(3 > 2); // Проверка утверждения (3 больше чем 2) с использованием метода assertTrue из класса Assertions
    }
}
package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcCalcTest {

    @BeforeAll
    public static void firstStart (){
        System.out.println("before all");
    }

    @BeforeEach
    public void eachStart(){
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll (){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }
    @Test
    @DisplayName("Проверка сложения")
    @Timeout(10)
    @Tag("summ")
    void summ() {
        CalcCalc calculator = new CalcCalc();
        int resultsumm = calculator.summ(1,6);
        Assertions.assertEquals(7, resultsumm, "не тот ответ" );

    }

    @Test
    @DisplayName("Проверка вычитания")
    @Timeout(10)
    @Tag("diff")
    void difference() {
        CalcCalc calculator = new CalcCalc();
        int resultdiff = calculator.difference(10,8);
        Assertions.assertEquals(2, resultdiff, "не тот ответ" );
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}")
    @CsvSource({"3, 4, 7", "-1, 5, 4", "0, 0, 0"})
    void param(int a, int b, int expectedResult) {
        CalcCalc calculator = new CalcCalc();
        int resultsumm = calculator.summ(a,b);
        Assertions.assertEquals(expectedResult, resultsumm, "не тот ответ" );
    }

}
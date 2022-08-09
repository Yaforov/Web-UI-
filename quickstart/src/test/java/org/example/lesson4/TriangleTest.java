package org.example.lesson4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.example.lesson4.FunctionsSTreugolnika.isSTreugolnika;

public class TriangleTest {

    @ParameterizedTest
   // @DisplayName("Проверка вычисления площиди треугольника, если одна из сторон "0"");
    @CsvSource({"2, 0, 2", "0, 1, 1"})
    void ravnoctoroniiSTreugolnik (int a, int b, int c) throws Exception {
        double result = isSTreugolnika(a, b, c);
        Assertions.assertEquals(0.0, result);
    }
    //("Проверка вычисления площиди треугольника, если одна из сторон отрицательная");
    /**
    @ParameterizedTest
    @CsvSource({"2, -5, 2", "-6, 8, 1"})
    void ravnoctoroniiSTreugolnik1 (int a, int b, int c) {
        double result = isSTreugolnika(a, b, c);
        Assertions.assertEquals(-0.0, result);
     **/

    @Test
    void triangleTest() throws Exception {
        Assertions.assertEquals(isSTreugolnika(2, 2, 2), 1.73205, 0.001);
    }

    @Test
    void triangleNegativeTest() {
        Assertions.assertThrows(Exception.class, () -> isSTreugolnika(-2, 2, 2));
    }


}


package org.example.lesson4;

public class FunctionsSTreugolnika {
        public static double isSTreugolnika(int a, int b, int c) {

                double p = (a + b + c) / 2;
                double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println("Площадь треугольника = " + s);
                if (a > 0 || b > 0 || c > 0) {
                        return s;
                }
                return 0;
        }
}
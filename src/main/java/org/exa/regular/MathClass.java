package org.exa.regular;

/**
 * Класс математических вычислений
 */
public class MathClass {
    /**
     * Метод для сложения 2-х чисел
     * @param a 1-е слагаемое
     * @param b 2-е слагаемое
     * @return сумма a и b
     */
    public static int sum(int a, int b){
        return a+b;
    }

    /**
     * Метод для вычитания 2-х чисел
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность a и b
     */
    public static int sub(int a, int b){
        return a-b;
    }

    /**
     * Метод для умножения чисел
     * @param a 1 множитель
     * @param b 2 множитель
     * @return произведение a и b
     */
    public static int mul(int a, int b){
        return a*b;
    }

    /**
     * Метод для деления чисел
     * @param a делимое
     * @param b делитель
     * @return частное a и b
     */
    public static int div(int a, int b){
        return a/b;
    }
}

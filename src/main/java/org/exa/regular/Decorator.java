package org.exa.regular;

/**
 * Класс декорирует результат вычисления
 */
public class Decorator {
    /**
     * Метод декорирует число
     * @param a параметр для декорации
     * @return строка дополненная числом
     */
    public static String decorator(int a){
        return String.format("результат вычисления = %d.", a);
    }
}

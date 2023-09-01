package org.exa.sample;

import org.exa.regular.Decorator;
import org.exa.regular.MathClass;

public class Main {
    /**
     * Точка входа в программу
     * @param args Входной параметр
     */
    public static void main(String[] args) {
        int result = MathClass.sum(2, 2);
        System.out.println(Decorator.decorator(result));
        result = MathClass.mul(2, 2);
        System.out.println(Decorator.decorator(result));
        result = MathClass.sub(2, 2);
        System.out.println(Decorator.decorator(result));
        result = MathClass.div(2, 2);
        System.out.println(Decorator.decorator(result));
    }
}